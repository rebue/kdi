package rebue.kdi.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import rebue.kdi.dic.KdiTaskTypeDic;
import rebue.kdi.mo.KdiTaskMo;
import rebue.kdi.svc.KdiTaskSvc;
import rebue.robotech.dic.TaskExecuteStateDic;

@Api(tags = "")
@RestController
public class KdiTaskCtrl {

    /**
     * @mbg.generated
     */
    private static final Logger _log = LoggerFactory.getLogger(KdiTaskCtrl.class);

    /**
     * @mbg.generated
     */
    @Resource
    private KdiTaskSvc svc;

    /**
     * @mbg.generated
     */
    @ApiOperation("添加")
    @PostMapping("/kdi/task")
    @ResponseBody
    Map<String, Object> add(KdiTaskMo vo) throws Exception {
        _log.info("add KdiTaskMo:" + vo);
        svc.add(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("id", vo.getId());
        _log.info("add KdiTaskMo success!");
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("修改")
    @PutMapping("/kdi/task")
    @ResponseBody
    Map<String, Object> modify(KdiTaskMo vo) throws Exception {
        _log.info("modify KdiTaskMo:" + vo);
        svc.modify(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("modify KdiTaskMo success!");
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("删除")
    @ApiImplicitParam(name = "id", value = "要删除的id", dataType = "long", paramType = "path", required = true)
    @DeleteMapping("/kdi/task/{id}")
    @ResponseBody
    Map<String, Object> del(@PathVariable("id") java.lang.Long id) {
        _log.info("save KdiTaskMo:" + id);
        svc.del(id);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("delete KdiTaskMo success!");
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("查询")
    @ApiImplicitParams({ //
            @ApiImplicitParam(name = "pageNum", value = "查询第几页", dataType = "int", paramType = "query", required = true),
            @ApiImplicitParam(name = "pageSize", value = "分页记录数", dataType = "int", paramType = "query", required = true) })
    @GetMapping("/kdi/task")
    @ResponseBody
    PageInfo<KdiTaskMo> list(KdiTaskMo qo, @RequestParam("pageNum") int pageNum,
            @RequestParam("pageSize") int pageSize) {
        _log.info("list KdiTaskMo:" + qo + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        PageInfo<KdiTaskMo> result = svc.list(qo, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("获取单个")
    @ApiImplicitParam(name = "id", value = "要获取的id", dataType = "long", paramType = "path", required = true)
    @GetMapping("/kdi/task/{id}")
    @ResponseBody
    KdiTaskMo get(@PathVariable("id") java.lang.Long id) {
        _log.info("get KdiTaskMo by id: " + id);
        KdiTaskMo result = svc.getById(id);
        _log.info("get: " + result);
        return result;
    }

    /**
     * 获取需要执行的任务
     * 
     * @param executeState
     * @param taskType
     * @return
     */
    @GetMapping(value = "/kdi/tasks")
    List<Long> getTaskIdsThatShouldExecute(@RequestParam("executeState") final TaskExecuteStateDic executeState,
            @RequestParam("taskType") final KdiTaskTypeDic taskType) {
        _log.info("查询订单任务数量的参数为：{}， {}", executeState, taskType);
        return svc.getTaskIdsThatShouldExecute(executeState, taskType);
    }

    @ApiOperation("执行订阅任务")
    @PostMapping("/kdi/executeTask")
    @ResponseBody
    void executeSubscribeTraceTask(@RequestParam("taskId") final Long taskId) {
        svc.executeSubscribeTraceTask(taskId);
    }

}
