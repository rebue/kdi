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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rebue.kdi.mo.KdiCompanyDicMo;
import rebue.kdi.svc.KdiCompanyDicSvc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags = "快递公司字典")
@RestController
public class KdiCompanyDicCtrl {
    /**
     * @mbg.generated
     */
    private final static Logger _log = LoggerFactory.getLogger(KdiCompanyDicCtrl.class);

    /**
     * @mbg.generated
     */
	@Resource
    private KdiCompanyDicSvc svc;

    /**
     * @mbg.generated
     */
    @ApiOperation("添加快递公司字典")
    @PostMapping("/kdi/companydic")
    @ResponseBody
    Map<String, Object> add(KdiCompanyDicMo vo) throws Exception {
        _log.info("add KdiCompanyDicMo:" + vo);
        svc.add(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("id", vo.getId());
        _log.info("add KdiCompanyDicMo success!");
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("修改快递公司字典")
    @PutMapping("/kdi/companydic")
    @ResponseBody
    Map<String, Object> modify(KdiCompanyDicMo vo) throws Exception {
        _log.info("modify KdiCompanyDicMo:" + vo);
        svc.modify(vo);
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("modify KdiCompanyDicMo success!");
        return result;
    }

    /**
     * @mbg.generated
     */
    @ApiOperation("删除快递公司字典")
    @ApiImplicitParam(name = "id", value = "要删除的快递公司字典id", dataType = "long", paramType = "path", required = true)	
    @DeleteMapping("/kdi/companydic/{id}")
    @ResponseBody
    Map<String, Object> del(@PathVariable("id") java.lang.Long id) {
        _log.info("save KdiCompanyDicMo:" + id);
        svc.del(id);		
        Map<String, Object> result = new HashMap<>();
        result.put("success", true);
        _log.info("delete KdiCompanyDicMo success!");
        return result;
    }


    
    /**
     *  查询所有快递公司字典信息
     *
     *  @return
     */
    @GetMapping("/kdi/companydic")
    List<KdiCompanyDicMo> list(KdiCompanyDicMo mo) {
        _log.info("开始查询快递公司信息");
        List<KdiCompanyDicMo> list = svc.list(mo);
        _log.info("查询到的快递公司信息为: " + String.valueOf(list));
        return list;
    }
    
    

    /**
     * @mbg.generated
     */
    @ApiOperation("获取单个快递公司字典")
    @ApiImplicitParam(name = "id", value = "要获取快递公司字典的id", dataType = "long", paramType = "path", required = true)
    @GetMapping("/kdi/companydic/{id}")
    @ResponseBody
    KdiCompanyDicMo get(@PathVariable("id") java.lang.Long id) {
        _log.info("get KdiCompanyDicMo by id: " + id);
        KdiCompanyDicMo result = svc.getById(id);
        _log.info("get: " + result);
        return result;
    }

}
