package rebue.kdi.ctrl;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rebue.kdi.mo.KdiTemplateMo;
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
    Map<String, Object> add(KdiTemplateMo vo) throws Exception {
        _log.info("add KdiTemplateMo:" + vo);
        svc.add(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
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
    Map<String, Object> modify(KdiTemplateMo vo) throws Exception {
        _log.info("modify KdiTemplateMo:" + vo);
        svc.modify(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("modify KdiTemplateMo success!");
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("删除电子面单模板")
    @ApiImplicitParam(name = "id", value = "要删除的电子面单模板id", dataType = "long", paramType = "path", required = true)
    @DeleteMapping("/kdi/template/{id}")
    @ResponseBody
    Map<String, Object> del(@PathVariable("id") java.lang.Long id) {
        _log.info("save KdiTemplateMo:" + id);
        svc.del(id);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("delete KdiTemplateMo success!");
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("查询电子面单模板")
    @ApiImplicitParams({ // 
    @ApiImplicitParam(name = "pageNum", value = "查询第几页", dataType = "int", paramType = "query", required = true), @ApiImplicitParam(name = "pageSize", value = "分页记录数", dataType = "int", paramType = "query", required = true) })
    @GetMapping("/kdi/template")
    @ResponseBody
    PageInfo<KdiTemplateMo> list(KdiTemplateMo qo, @RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        _log.info("list KdiTemplateMo:" + qo + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        PageInfo<KdiTemplateMo> result = svc.list(qo, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("获取单个电子面单模板")
    @ApiImplicitParam(name = "id", value = "要获取电子面单模板的id", dataType = "long", paramType = "path", required = true)
    @GetMapping("/kdi/template/{id}")
    @ResponseBody
    KdiTemplateMo get(@PathVariable("id") java.lang.Long id) {
        _log.info("get KdiTemplateMo by id: " + id);
        KdiTemplateMo result = svc.getById(id);
        _log.info("get: " + result);
        return result;
    }
}
