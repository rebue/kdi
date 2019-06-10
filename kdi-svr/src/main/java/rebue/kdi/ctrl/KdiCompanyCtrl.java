package rebue.kdi.ctrl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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
import rebue.kdi.mo.KdiCompanyMo;
import rebue.kdi.ro.CompanyRo;
import rebue.kdi.ro.KdiCompanyRo;
import rebue.kdi.svc.KdiCompanySvc;
import rebue.kdi.svc.KdiTemplateSvc;

/**
 * 快递公司
 * @author lbl
 */
@Api(tags = "快递公司信息")
@RestController
public class KdiCompanyCtrl {

    @Resource
    private KdiCompanySvc svc;
    
    @Resource
    private KdiTemplateSvc kdiTemplateSvc;

    /**
     * @mbg.generated
     */
    @ApiOperation("获取单个快递公司信息")
    @ApiImplicitParam(name = "id", value = "要获取快递公司信息的id", dataType = "long", paramType = "path", required = true)
    @GetMapping("/kdi/company/{id}")
    @ResponseBody
    KdiCompanyMo get(@PathVariable("id") java.lang.Long id) {
        _log.info("get KdiCompanyMo by id: " + id);
        KdiCompanyMo result = svc.getById(id);
        _log.info("get: " + result);
        return result;
    }

    private static final Logger _log = LoggerFactory.getLogger(KdiManageCtrl.class);



    /**
     *  查询所有快递公司信息
     *  更新备注：原来的路径是/kdi/company/alllist，为了迎合新系统的格式将alllist去掉
     *
     *  @return
     */
    @GetMapping("/kdi/company")
    List<CompanyRo> kdiCompanyList(KdiCompanyMo mo) {
        _log.info("开始查询快递公司信息");
        List<CompanyRo> list = svc.selectKdiCompanyInfo(mo);
        _log.info("查询到的快递公司信息为: " + String.valueOf(list));
        return list;
    }

    /**
     *  查询所有快递公司名称和编码
     *  @return
     */
    @GetMapping("/kdi/company/companynameandcode")
    List<KdiCompanyMo> selectKdiCompanyNameAndCode() {
        _log.info("开始查询快递公司名称和编码");
        return svc.selectKdiCompanyNameAndCode();
    }

    /**
     * 添加快递公司信息
     *  更新备注：原来的路径是/kdi/company/add，为了迎合新系统的格式将add去掉
     */
    @PostMapping("/kdi/company")
    KdiCompanyRo add(@RequestBody KdiCompanyMo mo) throws Exception {
        _log.info("add KdiCompanyMo:" + mo);
        KdiCompanyRo ro = new KdiCompanyRo();
        int result = svc.add(mo);
        if (result == 1) {
            String msg = "添加成功";
            _log.info("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult((byte) 1);
            return ro;
        } else {
            String msg = "添加失败";
            _log.error("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult((byte) -1);
            return ro;
        }
    }

    /**
     * 修改快递公司信息
     */
    @PutMapping("/kdi/company")
    KdiCompanyRo modify(@RequestBody KdiCompanyMo mo) throws Exception {
        _log.info("modify KdiCompanyMo:" + mo);
        KdiCompanyRo ro = new KdiCompanyRo();
        int result = svc.modify(mo);
        if (result == 1) {
            String msg = "修改成功";
            _log.info("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult((byte) 1);
            return ro;
        } else {
            String msg = "修改失败";
            _log.error("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult((byte) -1);
            return ro;
        }
    }
    
    /**
     * 修改快递公司的默认使用店铺信息
     */
    @PutMapping("/kdi/company/modifyshopinfo")
    KdiCompanyRo modifyShopInfo(@RequestBody KdiCompanyMo mo) throws Exception {
        _log.info("modifyShopInfo KdiCompanyMo:" + mo);
        KdiCompanyRo ro = new KdiCompanyRo();
        int result = svc.updateShopInfoById(mo);
        if (result == 1) {
            String msg = "修改成功";
            _log.info("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult((byte) 1);
            return ro;
        } else {
            String msg = "修改失败";
            _log.error("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult((byte) -1);
            return ro;
        }
    }

    /**
     * 删除快递公司信息
     */
    @DeleteMapping("/kdi/company")
    KdiCompanyRo del(@RequestParam("id") java.lang.Long id) {
    	
        _log.info("先删除快递公司模板的参数为:" + id);
        int i=kdiTemplateSvc.deleteForCompanyId(id);
        _log.info("先删除快递公司模板的结果为:" + i);
        int result = svc.del(id);
        KdiCompanyRo ro = new KdiCompanyRo();
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
     * 获取单个快递公司信息
     */
    @GetMapping("/kdi/company/getbyid")
    KdiCompanyRo getById(@RequestParam("id") java.lang.Long id) {
        _log.info("get getOneCompanyById: " + id);
        CompanyRo result = svc.getOneCompanyById(id);
        _log.info("get: " + result);
        KdiCompanyRo ro = new KdiCompanyRo();
        if (result == null) {
            String msg = "获取失败，没有找到该条记录";
            _log.error("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult((byte) -1);
            return ro;
        } else {
            String msg = "获取成功";
            _log.info("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult((byte) 1);
            ro.setRecord(result);
            return ro;
        }
    }

    /**
     *设置为默认快递公司
     */
    @PutMapping("/kdi/company/default")
    KdiCompanyRo modifyDefuteCompany(@RequestBody KdiCompanyMo mo) throws Exception {
        _log.info("modify KdiCompanyMo:" + mo);
        KdiCompanyRo ro = new KdiCompanyRo();
        int result = svc.setDefaultCompany(mo);
        if (result == 1) {
            String msg = "设置默认成功";
            _log.info("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult((byte) 1);
            return ro;
        } else {
            String msg = "设置默认失败失败";
            _log.error("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult((byte) -1);
            return ro;
        }
    }
}
