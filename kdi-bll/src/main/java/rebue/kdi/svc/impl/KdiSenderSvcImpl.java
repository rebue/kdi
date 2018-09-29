package rebue.kdi.svc.impl;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.kdi.dic.ModifyDefaultSenderDic;
import rebue.kdi.mapper.KdiSenderMapper;
import rebue.kdi.mo.KdiSenderMo;
import rebue.kdi.ro.ModifyDefaultSenderRo;
import rebue.kdi.svc.KdiSenderSvc;
import rebue.robotech.svc.impl.MybatisBaseSvcImpl;

@Service
/**
 * <pre>
 * 在单独使用不带任何参数 的 @Transactional 注释时，
 * propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED，
 * 而且事务不会针对受控异常（checked exception）回滚。
 * 注意：
 * 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 * </pre>
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class KdiSenderSvcImpl extends MybatisBaseSvcImpl<KdiSenderMo, java.lang.Long, KdiSenderMapper> implements KdiSenderSvc {

    private static final Logger _log = LoggerFactory.getLogger(KdiSenderSvcImpl.class);

    /**
     *  添加发件人
     *
     *  @param mo
     *  @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(KdiSenderMo mo) {
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        // 设置不是默认发件人,默认当前时间录入
        mo.setIsDefault(false);
        mo.setEntryTime(new Date());
        _log.info("添加发件人的参数为: {}", mo);
        int result = super.add(mo);
        _log.info("添加发件人的返回值为: {}", result);
        if (result == 1) {
            _log.info("添加发件人成功");
            KdiSenderMo pm=new KdiSenderMo();
            pm.setOrgId(mo.getOrgId());
            List<KdiSenderMo> count=super.list(pm);
            _log.error("查询发件人的数量是: {}", count.size());
            if(count.size()==1) {
            	int i=_mapper.setDefaultSender(mo.getId());
                _log.error("将仅有一个的发件人设置默认发件人的结果: {}", i);
            }
            return 1;
        } else {
            _log.error("添加发件人失败, 返回值为: {}", result);
            return -1;
        }
    }

    /**
     *  设置默认发件人
     *
     *  @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ModifyDefaultSenderRo setDefaultSender(KdiSenderMo mo) {
    	ModifyDefaultSenderRo senderRo=new ModifyDefaultSenderRo();
        _log.info("修改默认发件人的参数为: {}", mo);
        int updateDefaultSenderResult = _mapper.setDefaultSender(mo.getId());
        _log.info("修改默认发件人的结果为: {}", updateDefaultSenderResult);
        if(updateDefaultSenderResult==1) {
        	KdiSenderMo pm=new KdiSenderMo();
        	pm.setOrgId(mo.getOrgId());
            _log.info("查询是否只有一个发件人的参数为: {}", pm);
            List<KdiSenderMo> coust=super.list(pm);
            if(coust.size()==1) {
            	senderRo.setMsg("修改默认发人成功");
                senderRo.setResult(ModifyDefaultSenderDic.SUCCESS);
                return senderRo;
            }else {
                _log.info("开始将不是该编号的发件人设置为不是默认: {}",mo.getId());
                int i=_mapper.setSender(mo.getId());
                _log.info("设置为不是默认发件人的结果为: {}", i);
                if(i>=1) {
                	senderRo.setMsg("修改默认发人成功");
                    senderRo.setResult(ModifyDefaultSenderDic.SUCCESS);
                    return senderRo;
                }else {
                	 throw new RuntimeException("修改失败");
                }
            }

        }
    	senderRo.setMsg("修改默认失败");
        senderRo.setResult(ModifyDefaultSenderDic.ERROR);
        return senderRo ;
    }

    @Override
    public KdiSenderMo getDefaultSender(Long orgId) {
        _log.info("获取默认发件人信息");
        return _mapper.getDefaultSender(orgId);
    }

    @Override
    public List<KdiSenderMo> listSenderByOrganizeId(Long organizeId) {
        _log.info("根据组织ID获取发件人信息");
        return _mapper.selectByOrganizeId(organizeId);
    }
}
