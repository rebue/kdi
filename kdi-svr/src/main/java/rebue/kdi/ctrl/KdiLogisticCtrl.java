package rebue.kdi.ctrl;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.ro.AddKdiLogisticRo;
import rebue.kdi.ro.EntryLogisticsRo;
import rebue.kdi.ro.ExaddKdiLogisticRo;
import rebue.kdi.svc.KdiLogisticSvc;
import rebue.kdi.to.AddKdiLogisticTo;

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
	AddKdiLogisticRo addKdiLogistic(AddKdiLogisticTo mo) {
		_log.info("添加物流订单的参数为: {}", mo);
		return svc.addKdiLogistic(mo);
	}
	
	/**
	 * 录入订单
	 * @param mo
	 * @return
	 */
	@PostMapping("/kdi/logistic/entry")
	EntryLogisticsRo entryLogistics(AddKdiLogisticTo mo) {
		_log.info("录入订单的参数为: {}", mo);
		return svc.entryLogistics(mo);
	}
	
	/**
	 * 后台调用电子面单接口
	 * @param mo
	 * @return
	 */
	@PostMapping("/kdi/logistic/exaddkdilogistic")
	ExaddKdiLogisticRo exaddKdiLogistic(@RequestBody AddKdiLogisticTo mo) {
		_log.info("后台调用电子面单接口的参数为：{}", mo);
		return svc.exaddKdiLogistic(mo);
	}
	
	/**
	 * 根据微信端的条件查询快递公司和订单号
	 * @param mo
	 * @return
	 */
	@PostMapping("/kid/logistic/wx")
	List<KdiLogisticMo> listLogisticWx(KdiLogisticMo mo) {
		_log.info("微信端口查询快递公司和快递单号", mo);
		return svc.kdiLogisticWx(mo);
	}
	
}
