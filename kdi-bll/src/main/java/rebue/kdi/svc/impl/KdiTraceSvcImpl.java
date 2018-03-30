package rebue.kdi.svc.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.kdi.mapper.KdiTraceMapper;
import rebue.kdi.mo.KdiTraceMo;
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
public class KdiTraceSvcImpl extends MybatisBaseSvcImpl<KdiTraceMo, java.lang.Long, KdiTraceMapper>
        implements KdiTraceSvc {

    private final static Logger _log = LoggerFactory.getLogger(KdiTraceSvcImpl.class);

    /**
     * @mbg.generated
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(KdiTraceMo mo) {
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }

    /**
     * 根据物流订单ID删除其所有轨迹
     * 
     * @param logisticId
     *            物流订单ID
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delByLogisticId(Long logisticId) {
        _log.info("根据物流订单ID删除其所有轨迹：{}", logisticId);
        _mapper.delByLogisticId(logisticId);
    }

    /**
     * 根据物流订单ID查询其所有轨迹
     * 
     * @param logisticId
     *            物流订单ID
     */
    @Override
    public List<KdiTraceMo> list(Long logisticId) {
        _log.info("根据物流订单ID查询其所有轨迹：{}", logisticId);
        KdiTraceMo condition = new KdiTraceMo();
        condition.setLogisticId(logisticId);
        return list(condition);
    }

}
