package rebue.kdi.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.ro.AddKdiLogisticRo;
import rebue.kdi.ro.EntryLogisticsRo;
import rebue.kdi.svc.KdiLogisticSvc;

@RestController
public class KdiLogisticCtrl {

	private final static Logger _log = LoggerFactory.getLogger(KdiLogisticCtrl.class);
	
	@Resource
	private KdiLogisticSvc svc;
	
	/**
	 * 添加物流订单
	 * 
	 * @param to
	 * @return
	 */
	@PostMapping("/kdi/logistic/add")
	AddKdiLogisticRo addKdiLogistic(KdiLogisticMo mo) {
		_log.info("添加物流订单的参数为: {}", mo);
		return svc.addKdiLogistic(mo);
	}
	
	/**
	 * 录入订单
	 * @param mo
	 * @return
	 */
	@PostMapping("/kdi/logistic/entry")
	EntryLogisticsRo entryLogistics(KdiLogisticMo mo) {
		_log.info("录入订单的参数为: {}", mo);
		return svc.entryLogistics(mo);
	}
}
