package rebue.kdi.ctrl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rebue.kdi.mo.KdiTemplateDicMo;
import rebue.kdi.svc.KdiTemplateDicSvc;

@Api(tags = "模板字典")
@RestController
public class KdiTemplateDicCtrl {

    /**
     * @mbg.generated
     */
    private static final Logger _log = LoggerFactory.getLogger(KdiTemplateDicCtrl.class);

    /**
     * @mbg.generated
     */
    @Resource
    private KdiTemplateDicSvc svc;

    /**
     * @mbg.generated
     */
    @ApiOperation("添加模板字典")
    @PostMapping("/kdi/templatedic")
    @ResponseBody
    Map<String, Object> add(KdiTemplateDicMo vo) throws Exception {
        _log.info("add KdiTemplateDicMo:" + vo);
        svc.add(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("id", vo.getId());
        _log.info("add KdiTemplateDicMo success!");
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("修改模板字典")
    @PutMapping("/kdi/templatedic")
    @ResponseBody
    Map<String, Object> modify(KdiTemplateDicMo vo) throws Exception {
        _log.info("modify KdiTemplateDicMo:" + vo);
        svc.modify(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("modify KdiTemplateDicMo success!");
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("删除模板字典")
    @ApiImplicitParam(name = "id", value = "要删除的模板字典id", dataType = "long", paramType = "path", required = true)
    @DeleteMapping("/kdi/templatedic/{id}")
    @ResponseBody
    Map<String, Object> del(@PathVariable("id") java.lang.Long id) {
        _log.info("save KdiTemplateDicMo:" + id);
        svc.del(id);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("delete KdiTemplateDicMo success!");
        return result;
    }


    
    /**
     * 根据条件查询电子面单模板
     */
    @ApiOperation("根据条件查询电子面单模板")
    @GetMapping("/kdi/templatedic")
    List<KdiTemplateDicMo> list(KdiTemplateDicMo qo) {
        _log.info("list KdiTemplateDicMo " + qo);
        return svc.list(qo);
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("获取单个模板字典")
    @ApiImplicitParam(name = "id", value = "要获取模板字典的id", dataType = "long", paramType = "path", required = true)
    @GetMapping("/kdi/templatedic/{id}")
    @ResponseBody
    KdiTemplateDicMo get(@PathVariable("id") java.lang.Long id) {
        _log.info("get KdiTemplateDicMo by id: " + id);
        KdiTemplateDicMo result = svc.getById(id);
        _log.info("get: " + result);
        return result;
    }
}
