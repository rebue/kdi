package rebue.kdi.ctrl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rebue.kdi.dic.EOrderResultDic;
import rebue.kdi.ro.EOrderRo;
import rebue.kdi.ro.IdentifyLogisticCodeRo;
import rebue.kdi.ro.KdiBatchOrderRo;
import rebue.kdi.ro.LogisticRo;
import rebue.kdi.ro.SubscribeTraceRo;
import rebue.kdi.svc.KdiSvc;
import rebue.kdi.to.EOrderTo;
import rebue.kdi.to.KdiBatchOrderTo;
import rebue.kdi.to.SubscribeTraceTo;

/**
 * 快递API
 * 
 * @author zbz
 *
 */
@RestController
public class KdiCtrl {
	private final static Logger _log = LoggerFactory.getLogger(KdiCtrl.class);

	@Resource
	private KdiSvc svc;

	/**
	 * 识别快递单号
	 * 
	 * @Description: 根据快递单号智能识别是哪个快递公司（不能保证100%识别，可能多个，也可能识别不出来）
	 * 
	 * @param logisticCode 快递单号
	 */
	@GetMapping("/kdi/logisticcode/identify")
	IdentifyLogisticCodeRo identifyLogisticCode(@RequestParam("logisticCode") String logisticCode) {
		_log.info("identirfy logistic code: {}", logisticCode);
		return svc.identifyLogisticCode(logisticCode);
	}

	/**
	 * 电子面单
	 * 
	 * @Description: 此接口用于向快递公司下发订单并获取快递单号和打印模板
	 */
	@PostMapping("/kdi/eorder")
	EOrderRo eorder(@RequestBody EOrderTo to) {
		_log.info("eorder: {}", to);
		return svc.eorder(to);
	}

	/**
	 * 订阅物流轨迹
	 * 
	 * @Description: 向物流平台（快递鸟）订阅物流轨迹信息，当产生轨迹或有变动时，物流平台会向本系统的轨迹推送接口发出消息通知。
	 *               支持的快递公司:除顺丰、天天、申通外，其他主流快递公司都支持。
	 */
	@PostMapping("/kdi/trace/subscribe")
	SubscribeTraceRo subscribeTrace(@RequestBody SubscribeTraceTo to) {
		_log.info("subscribe trace: {}", to);
		return svc.subscribeTrace(to);
	}

	/**
	 * 查询物流轨迹
	 * 
	 * @Description: 根据快递公司编码和快递单号查询物流轨迹
	 * 
	 * @param shipperCode  快递公司编码
	 * @param logisticCode 快递单号
	 */
	@GetMapping("/kdi/trace")
	LogisticRo getTraces(@RequestParam("shipperCode") String shipperCode,
			@RequestParam("logisticCode") String logisticCode) {
		_log.info("get trances: {},{}", shipperCode, logisticCode);
		return svc.getTraces(shipperCode, logisticCode);
	}

	/**
	 * 批量下单调用快递鸟接口获取电子面单
	 * 
	 * @param to
	 * @return
	 */
	@SuppressWarnings("finally")
	@PostMapping("/kdi/batchOrder")
	KdiBatchOrderRo KdiBatchOrder(@RequestBody KdiBatchOrderTo to) {
		_log.info("KdiBatchOrderTo: {}", to);
		KdiBatchOrderRo kdiBatchOrderRo = new KdiBatchOrderRo();
		try {
			kdiBatchOrderRo = svc.KdiBatchOrder(to);
			_log.info("批量下单的返回值为:{}", kdiBatchOrderRo);
		} catch (final RuntimeException e) {
			final String msg = e.getMessage();
			if (msg.equals("调用快递电子面单参数错误")) {
				kdiBatchOrderRo.setResult(EOrderResultDic.PARAM_ERROR);
				kdiBatchOrderRo.setMsg(msg);
				_log.error(msg);
			} else if (msg.equals("该订单已发货")) {
				kdiBatchOrderRo.setResult(EOrderResultDic.REPEAT);
				kdiBatchOrderRo.setMsg(msg);
				_log.error(msg);
			} else if (msg.equals("调用快递电子面单失败")) {
				kdiBatchOrderRo.setResult(EOrderResultDic.FAILT);
				kdiBatchOrderRo.setMsg(msg);
				_log.error(msg);
			}
		} finally {
			return kdiBatchOrderRo;
		}
	}

}
