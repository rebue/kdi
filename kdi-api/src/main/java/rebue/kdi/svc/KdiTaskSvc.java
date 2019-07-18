package rebue.kdi.svc;

import java.util.List;

import rebue.kdi.dic.KdiTaskTypeDic;
import rebue.kdi.mo.KdiTaskMo;
import rebue.robotech.dic.TaskExecuteStateDic;
import rebue.robotech.svc.MybatisBaseSvc;

public interface KdiTaskSvc extends MybatisBaseSvc<KdiTaskMo, java.lang.Long> {

    List<Long> getTaskIdsThatShouldExecute(TaskExecuteStateDic executeState, KdiTaskTypeDic taskType);

    void executeSubscribeTraceTask(Long taskId);
}
