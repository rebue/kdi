package rebue.kdi.ctrl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rebue.kdi.mo.KdiTemplateMo;
import rebue.kdi.ro.KdiTemplateRo;
import rebue.kdi.svc.KdiTemplateSvc;

@Api(tags = "电子面单模板")
@RestController
public class KdiTemplateCtrl {

    /**
     * @mbg.generated
     */
    private static final Logger _log = LoggerFactory.getLogger(KdiTemplateCtrl.class);

    /**
     * @mbg.generated
     */
    @Resource
    private KdiTemplateSvc svc;

    /**
     * @mbg.generated
     */
    @ApiOperation("添加电子面单模板")
    @PostMapping("/kdi/template")
    @ResponseBody
    Map<String, Object> add(@RequestBody KdiTemplateMo vo) throws Exception {
        _log.info("add KdiTemplateMo:" + vo);
        svc.add(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "添加成功");
        result.put("result", 1);
        result.put("id", vo.getId());
        _log.info("add KdiTemplateMo success!");
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("修改电子面单模板")
    @PutMapping("/kdi/template")
    @ResponseBody
    Map<String, Object> modify(@RequestBody KdiTemplateMo vo) throws Exception {
        _log.info("modify KdiTemplateMo:" + vo);
        svc.modify(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("msg", "修改成功");
        result.put("success", true);
        result.put("result", 1);
        _log.info("modify KdiTemplateMo success!");
        return result;
    }


    
    /**
     * 删除模板信息
     */
    @DeleteMapping("/kdi/template")
    KdiTemplateRo del(@RequestParam("id") java.lang.Long id) {
        _log.info("save KdiCompanyMo:" + id);
        int result = svc.del(id);
        KdiTemplateRo ro = new KdiTemplateRo();
        if (result == 1) {
            String msg = "删除成功";
            _log.info("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult((byte) 1);
            return ro;
        } else {
            String msg = "删除失败，找不到该记录";
            _log.error("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult((byte) -1);
            return ro;
        }
    }



    /**
     * @mbg.generated
     */
    @ApiOperation("获取单个电子面单模板")
    @ApiImplicitParam(name = "id", value = "要获取电子面单模板的id", dataType = "long", paramType = "path", required = true)
    @GetMapping("/kdi/template/getbyid/{id}")
    @ResponseBody
    KdiTemplateMo get(@PathVariable("id") java.lang.Long id) {
        _log.info("get KdiTemplateMo by id: " + id);
        KdiTemplateMo result = svc.getById(id);
        _log.info("get: " + result);
        return result;
    }
    

    
}
