package rebue.kdi.scheduler.task;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import rebue.kdi.dic.KdiTaskTypeDic;
import rebue.kdi.svr.feign.KdiTaskSvc;
import rebue.robotech.dic.TaskExecuteStateDic;

/**
 * 订单启动结算的任务
 */
@Component
public class SubscribeTraceTaks {

    private final static Logger _log = LoggerFactory.getLogger(SubscribeTraceTaks.class);

    @Resource
    private KdiTaskSvc kdiTaskSvc;

    // startSettleFixedDelay:结算启动任务执行的间隔(毫秒)，默认5分钟检查一次
    @Scheduled(fixedDelayString = "${kdi.scheduler.subscribeTrace:30000}")
    public void executeTasks() throws InterruptedException {
        _log.info("定时执行需要订阅物流轨迹的任务");
        try {
            _log.info("获取所有需要执行订阅物流轨迹的任务列表");
            final List<Long> taskIds = kdiTaskSvc.getTaskIdsThatShouldExecute(TaskExecuteStateDic.NONE,
                    KdiTaskTypeDic.SUBSCRIBE_TRACE);
            _log.info("获取到所有需要执行订阅物流轨迹的任务的列表为：{}", taskIds);
            for (final Long taskId : taskIds) {
                _log.info("当前任务id-{}", taskId);
                try {
                    kdiTaskSvc.executeSubscribeTraceTask(taskId);
                    Thread.sleep(1000);
                } catch (final RuntimeException e) {
                    _log.error("执行订阅物流轨迹的任务失败", e);
                }
            }
        } catch (final RuntimeException e) {
            _log.info("获取需要执行订阅物流轨迹任务时出现异常", e);
        }
    }
}
