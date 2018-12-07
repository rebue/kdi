package rebue.kdi.svc.impl;

import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.kdi.mapper.KdiCompanyMapper;
import rebue.kdi.mo.KdiCompanyMo;
import rebue.kdi.ro.CompanyRo;
import rebue.kdi.svc.KdiCompanySvc;
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
public class KdiCompanySvcImpl extends MybatisBaseSvcImpl<KdiCompanyMo, java.lang.Long, KdiCompanyMapper> implements KdiCompanySvc {

    private static final Logger _log = LoggerFactory.getLogger(KdiCompanySvcImpl.class);

    /**
     *  添加快递公司
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(KdiCompanyMo mo) {
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        mo.setIsDefault(false);
        mo.setEntryTime(new Date());
        _log.info("添加快递公司的参数为: {}", mo);
        int result = super.add(mo);
        if (result == 1) {
            KdiCompanyMo pm = new KdiCompanyMo();
            pm.setOrgId(mo.getOrgId());
            _log.info("查询是否只有一个快递公司的参数为: {}", pm);
            List<KdiCompanyMo> count = super.list(pm);
            _log.info("查询是否只有一个快递公司的结果数量为: {}", count.size());
            if (count.size() == 1) {
                int j = _mapper.setDefaultCompany(mo);
                _log.info("添加快递公司后将该快递公司设置为默认的结果为: {}", j);
            }
        }
        _log.info("添加快递公司的返回值为: {}", result);
        return result;
    }

    /**
     *  查询所有快递公司名称和编码
     *  @return
     */
    @Override
    public List<KdiCompanyMo> selectKdiCompanyNameAndCode() {
        return _mapper.selectKdiCompanyNameAndCode();
    }

    /**
     *  根据快递公司信息查询快递公司
     */
    @Override
    public List<CompanyRo> selectKdiCompanyInfo(KdiCompanyMo mo) {
        return _mapper.selectCompanyInfo(mo);
    }

    /**
     *  将传进来的目标快递公司改为默认，其他的改为不默认
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int setDefaultCompany(KdiCompanyMo mo) {
        _log.info("设置为默认快递公司的参数为: {}", mo);
        int i = _mapper.setDefaultCompany(mo);
        _log.info("设置为默认快递公司的返回值为: {}", i);
        if (i == 1) {
            KdiCompanyMo pm = new KdiCompanyMo();
            pm.setOrgId(mo.getOrgId());
            _log.info("查询是否只有一个快递公司的参数: {}", pm);
            List<KdiCompanyMo> result = super.list(pm);
            _log.info("查询是否只有一个快递公司的返回值长度是: {}", result.size());
            if (result.size() > 1) {
                int j = _mapper.setCompany(mo);
                if (j >= 1) {
                    i = 1;
                } else {
                    i = -1;
                    throw new RuntimeException("修改失败");
                }
            } else {
                i = 1;
            }
        }
        return i;
    }
    
    /**
     * 获取单个快递公司包括连查快递公司名字和编码。
     */
	@Override
	public CompanyRo getOneCompanyById(Long id) {
        _log.info("获取单个快递公司和快递公司名字和编码的参数为: {}", id);
        CompanyRo result=_mapper.getOneCompanyByPrimaryKey(id);
        _log.info("获取单个快递公司和快递公司名字和编码的结果为: {}", result);
        return result;
		
	}
}
