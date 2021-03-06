package rebue.kdi.ctrl;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rebue.kdi.mo.KdiCompanyMo;
import rebue.kdi.svc.KdiCompanySvc;
import rebue.kdi.ro.KdiCompanyRo;

/**
 * 快递公司
 * @author lbl
 *  
 *
 */
@RestController
public class KdiCompanyCtrl {

	private final static Logger _log = LoggerFactory.getLogger(KdiManageCtrl.class);
	
	@Resource
	private KdiCompanySvc svc;
	
	/**
	 * 查询所有快递公司信息
	 * 更新备注：原来的路径是/kdi/company/alllist，为了迎合新系统的格式将alllist去掉
	 * 
	 * @return
	 */
	@GetMapping("/kdi/company")
	List<KdiCompanyMo> kdiCompanyList( KdiCompanyMo mo) {
		_log.info("开始查询快递公司信息");
		List<KdiCompanyMo> list = svc.selectKdiCompanyInfo(mo);
		_log.info("查询到的快递公司信息为: " + String.valueOf(list));
		return list;
	}
	
	/**
	 * 查询所有快递公司名称和编码
	 * @return
	 */
	@GetMapping("/kdi/company/companynameandcode")
	List<KdiCompanyMo> selectKdiCompanyNameAndCode() {
		_log.info("开始查询快递公司名称和编码");
		return svc.selectKdiCompanyNameAndCode();
	}
	
    /**
     * 添加快递公司信息
     *  更新备注：原来的路径是/kdi/company/add，为了迎合新系统的格式将add去掉
     * 
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
     *
     * 
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
     * 删除快递公司信息
     *
     * 
     */
    @DeleteMapping("/kdi/company")
    KdiCompanyRo del(@RequestParam("id") java.lang.Long id) {
        _log.info("save KdiCompanyMo:" + id);
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
     *
     *
     */
    @GetMapping("/kdi/company/getbyid")
    KdiCompanyRo getById(@RequestParam("id") java.lang.Long id) {
        _log.info("get KdiCompanyMo by id: " + id);
        KdiCompanyMo result = svc.getById(id);
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
     * 
     *设置为默认快递公司
     * 
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