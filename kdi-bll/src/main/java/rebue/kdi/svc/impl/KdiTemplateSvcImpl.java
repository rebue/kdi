package rebue.kdi.svc.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.kdi.mapper.KdiTemplateMapper;
import rebue.kdi.mo.KdiTemplateMo;
import rebue.kdi.svc.KdiTemplateSvc;
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
public class KdiTemplateSvcImpl extends MybatisBaseSvcImpl<KdiTemplateMo, java.lang.Long, KdiTemplateMapper> implements KdiTemplateSvc {
  
	private static final Logger _log = LoggerFactory.getLogger(KdiCompanySvcImpl.class);

    /**
     * @mbg.generated
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(KdiTemplateMo mo) {
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }
   
    /**
     * 根据快递公司id删除模板
     */
    
	@Override
	public int deleteForCompanyId(Long companyId) {
        _log.info(": 根据快递公司id删除模板的参数为{}", companyId);
		return _mapper.deleteForCompanyId(companyId);
	}
}
