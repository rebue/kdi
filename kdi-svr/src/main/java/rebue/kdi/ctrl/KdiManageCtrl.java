package rebue.kdi.ctrl;

import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import rebue.kdi.mo.KdiCompanyMo;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.ro.AddKdiLogisticRo;
import rebue.kdi.ro.AddkdiCompanyRo;
import rebue.kdi.svc.KdiCompanySvc;
import rebue.kdi.svc.KdiLogisticSvc;
import rebue.kdi.svc.KdiSenderSvc;
import rebue.kdi.to.AddKdiLogisticTo;
import rebue.kdi.to.ListKdiLogisticTo;

@RestController
public class KdiManageCtrl {

	/**
	 */
	private final static Logger _log = LoggerFactory.getLogger(KdiManageCtrl.class);

	/**
	 */
	@Resource
	private KdiLogisticSvc kdiLogisticSvc;

	@Resource
	private KdiCompanySvc kdiCompanySvc;

	@Resource
	private KdiSenderSvc kdiSenderSvc;

	/**
	 * 根据条件查询订单信息 Title: list Description:
	 * 
	 * @param mo
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @date 2018年3月28日 下午3:06:09
	 */
	@GetMapping("/kid/manage/logistic")
	List<KdiLogisticMo> kdiLogisticList(ListKdiLogisticTo to) {
		_log.info("list KdiLogisticMo:" + to);
		List<KdiLogisticMo> result = kdiLogisticSvc.kdiLogisticList(to);
		_log.info("result: " + result);
		return result;
	}

	/**
	 * 查询所有快递公司信息
	 * 
	 * @return
	 */
	@GetMapping("/kdi/company/alllist")
	List<KdiCompanyMo> kdiCompanyList() {
		_log.info("开始查询快递公司信息");
		List<KdiCompanyMo> list = kdiCompanySvc.listAll();
		_log.info("查询到的快递公司信息为: " + String.valueOf(list));
		return list;
	}

	/**
	 * 添加快递公司
	 * 
	 * @param mo
	 * @return
	 */
	@PostMapping("/kdi/company/add")
	AddkdiCompanyRo addkdiCompany(KdiCompanyMo mo) {
		_log.info("添加快递公司的参数为: {}", mo);
		return kdiCompanySvc.exAdd(mo);
	}

	/**
	 * 添加物流订单
	 * 
	 * @param to
	 * @return
	 */
	@PostMapping("/kdi/logistic/add")
	AddKdiLogisticRo addKdiLogistic(AddKdiLogisticTo to) {
		_log.info("添加物流订单的参数为: {}", to);
		return kdiLogisticSvc.addKdiLogistic(to);
	}
	
	
	@PostMapping("/kdi/excel")
	Map<String,Object> uploadExcel(@RequestParam(value="filename") MultipartFile file){
		
		
		
		return null;
	}
	
	
	
}
