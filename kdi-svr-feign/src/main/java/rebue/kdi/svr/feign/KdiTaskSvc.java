package rebue.kdi.svr.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import rebue.kdi.dic.KdiTaskTypeDic;
import rebue.robotech.dic.TaskExecuteStateDic;
import rebue.sbs.feign.FeignConfig;

@FeignClient(name = "kdi-svr", configuration = FeignConfig.class, contextId = "kdi-svr-task")
public interface KdiTaskSvc {

    /**
     * 获取未执行的任务
     * 
     * @return
     */
    @GetMapping("/kdi/tasks")
    List<Long> getTaskIdsThatShouldExecute(@RequestParam("executeState") TaskExecuteStateDic executeState,
            @RequestParam("taskType") KdiTaskTypeDic taskType);

    @PostMapping("/kdi/executeTask")
    void executeSubscribeTraceTask(@RequestParam("taskId") final Long taskId);
}
