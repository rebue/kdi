package rebue.kdi.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import rebue.kdi.mo.KdiCompanyMo;
import rebue.kdi.svc.KdiCompanySvc;

/**
 * 快递公司
 * @author lbl
 *
 */
@RestController
public class KdiCompanyCtrl {

	private final static Logger _log = LoggerFactory.getLogger(KdiManageCtrl.class);
	
	@Resource
	private KdiCompanySvc svc;
	
	/**
	 * 查询所有快递公司信息
	 * 
	 * @return
	 */
	@GetMapping("/kdi/company/alllist")
	List<KdiCompanyMo> kdiCompanyList() {
		_log.info("开始查询快递公司信息");
		List<KdiCompanyMo> list = svc.listAll();
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
}
