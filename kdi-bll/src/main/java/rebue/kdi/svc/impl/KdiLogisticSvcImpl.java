package rebue.kdi.svc.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.kdi.mapper.KdiLogisticMapper;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.svc.KdiLogisticSvc;
import rebue.kdi.svc.KdiTraceSvc;
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
public class KdiLogisticSvcImpl extends MybatisBaseSvcImpl<KdiLogisticMo, java.lang.Long, KdiLogisticMapper>
        implements KdiLogisticSvc {
    private final static Logger _log = LoggerFactory.getLogger(KdiLogisticSvcImpl.class);

    @Resource
    private KdiTraceSvc         traceSvc;

    /**
     * @mbg.generated
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(KdiLogisticMo mo) {
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }

    /**
     * 获取新的ID
     */
    @Override
    public Long getNewId() {
        return _idWorker.getId();
    }

    /**
     * 根据快递公司编码和快递单号获取物流订单
     * 
     * @param shipperCode
     *            快递公司编码
     * @param logisticCode
     *            快递单号
     */
    @Override
    public KdiLogisticMo getOne(String shipperCode, String logisticCode) {
        _log.info("根据快递公司编码和快递单号获取物流订单：{}，{}", shipperCode, logisticCode);
        KdiLogisticMo condition = new KdiLogisticMo();
        condition.setShipperCode(shipperCode);
        condition.setLogisticCode(logisticCode);
        return getOne(condition);
    }

}
