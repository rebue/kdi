package rebue.kdi.ctrl;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.ro.ExaddKdiLogisticRo;
import rebue.kdi.ro.KdiLogisticRo;
import rebue.kdi.svc.KdiLogisticSvc;
import rebue.kdi.svc.KdiTraceSvc;
import rebue.kdi.to.AddKdiLogisticTo;

@RestController
public class KdiLogisticCtrl {

	private final static Logger _log = LoggerFactory.getLogger(KdiLogisticCtrl.class);
	
	@Resource
	private KdiLogisticSvc svc;
	
	@Resource
	private KdiTraceSvc traceSvc;
	
	/**
	 * 添加物流订单记录
	 * @param to
	 * @return
	 */
	@PostMapping("/kdi/logistic/entry")
	KdiLogisticRo entryLogistics(@RequestBody AddKdiLogisticTo to) throws Exception {
        _log.info("add AddKdiLogisticTo:" + to);
        KdiLogisticRo ro = new KdiLogisticRo();
        int result = svc.entryLogistics(to);
        if (result == 1) {
            String msg = "添加成功";
            _log.info("{}: to-{}", msg, to);
            ro.setMsg(msg);
            ro.setResult((byte) 1);
            return ro;
        } else {
            String msg = "添加失败";
            _log.error("{}: to-{}", msg, to);
            ro.setMsg(msg);
            ro.setResult((byte) -1);
            return ro;
        }
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
