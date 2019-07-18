package rebue.kdi.svc.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.dozermapper.core.Mapper;

import rebue.kdi.dic.KdiTaskTypeDic;
import rebue.kdi.kdniao.svc.KdNiaoSvc;
import rebue.kdi.mapper.KdiTaskMapper;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.mo.KdiTaskMo;
import rebue.kdi.ro.SubscribeTraceRo;
import rebue.kdi.svc.KdiLogisticSvc;
import rebue.kdi.svc.KdiTaskSvc;
import rebue.kdi.to.SubscribeTraceTo;
import rebue.robotech.dic.TaskExecuteStateDic;
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
public class KdiTaskSvcImpl extends MybatisBaseSvcImpl<KdiTaskMo, java.lang.Long, KdiTaskMapper> implements KdiTaskSvc {
    private static final Logger _log = LoggerFactory.getLogger(KdiTaskSvcImpl.class);

    /**
     * @mbg.generated
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(KdiTaskMo mo) {
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }

    @Resource
    private KdiLogisticSvc kdiLogisticSvc;

    @Resource
    private KdNiaoSvc kdNiaoSvc;

    @Resource
    private Mapper dozerMapper;

    @Override
    public List<Long> getTaskIdsThatShouldExecute(TaskExecuteStateDic executeState, KdiTaskTypeDic taskType) {
        // TODO Auto-generated method stub
        return _mapper.getTaskIdsThatShouldExecute((byte) executeState.getCode(), (byte) taskType.getCode());
    }

    @Override
    public void executeSubscribeTraceTask(Long taskId) {
        _log.info("获取任务的参数为：taskId-{}", taskId);
        KdiTaskMo kdiTaskResult = super.getById(taskId);
        _log.info("获取任务的结果为：kdiTaskResult-{}", kdiTaskResult);
        if (kdiTaskResult == null) {
            return;
        }
        _log.info("获取物流信息的参数为：logistics_id-{}", kdiTaskResult.getLogisticId());
        KdiLogisticMo result = kdiLogisticSvc.getById(kdiTaskResult.getLogisticId());
        _log.info("获取物流信息的结果为：result-{}", result);
        if (result == null) {
            return;
        }
        final SubscribeTraceTo subscribeTraceTo = dozerMapper.map(result, SubscribeTraceTo.class);
        subscribeTraceTo.setLogisticId(result.getId());
        SubscribeTraceRo subsctibeTraceResult = kdNiaoSvc.subscribeTrace(subscribeTraceTo);
        _log.info("订阅物流结果为：subsctibeTraceResult-{}", subsctibeTraceResult);
        if (subsctibeTraceResult.getResult().getCode() == 1) {
            KdiTaskMo modifyTaskStateMo = new KdiTaskMo();
            modifyTaskStateMo.setExecuteFactTime(new Date());
            modifyTaskStateMo.setExecuteState((byte) TaskExecuteStateDic.DONE.getCode());
            modifyTaskStateMo.setId(taskId);
            _log.info("修改任务状态的参数为 modifyTaskStateMo-{}", modifyTaskStateMo);
            super.modify(modifyTaskStateMo);
        }
    }

}
