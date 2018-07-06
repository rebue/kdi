package rebue.kdi.svr.feign;
import java.util.List;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import rebue.kdi.mo.KdiCompanyMo;
import rebue.kdi.mo.KdiSenderMo;
import rebue.kdi.ro.EOrderRo;
import rebue.kdi.ro.IdentifyLogisticCodeRo;
import rebue.kdi.ro.LogisticRo;
import rebue.kdi.ro.SubscribeTraceRo;
import rebue.kdi.to.EOrderTo;
import rebue.kdi.to.SubscribeTraceTo;
import rebue.sbs.feign.FeignConfig;

/**
 * 快递API
 * 
 */
@FeignClient(name = "kdi-svr", configuration = FeignConfig.class)
public interface KdiSvc {
	/**
	 * 识别快递单号
	 * 
	 * @Description: 根据快递单号智能识别是哪个快递公司（不能保证100%识别，可能多个，也可能识别不出来）
	 * 
	 * @param logisticCode
	 *            快递单号
	 */
	@GetMapping("/kdi/logisticcode/identify")
	IdentifyLogisticCodeRo identifyLogisticCode(@RequestParam("logisticCode") String logisticCode);

	/**
	 * 电子面单
	 * 
	 * @Description: 此接口用于向快递公司下发订单并获取快递单号和打印模板
	 */
	@PostMapping("/kdi/eorder")
	EOrderRo eorder(@RequestBody EOrderTo to);

	/**
	 * 订阅物流轨迹
	 * 
	 * @Description: 向物流平台（快递鸟）订阅物流轨迹信息，当产生轨迹或有变动时，物流平台会向本系统的轨迹推送接口发出消息通知。
	 *               支持的快递公司:除顺丰、天天、申通外，其他主流快递公司都支持。
	 */
	@PostMapping("/kdi/trace/subscribe")
	SubscribeTraceRo subscribeTrace(@RequestBody SubscribeTraceTo to);

	/**
	 * 查询物流轨迹
	 * 
	 * @Description: 根据快递公司编码和快递单号查询物流轨迹
	 * 
	 * @param shipperCode
	 *            快递公司编码
	 * @param logisticCode
	 *            快递单号
	 */
	@GetMapping("/kdi/trace")
	LogisticRo getTraces(@RequestParam("shipperCode") String shipperCode,
			@RequestParam("logisticCode") String logisticCode);
	
	/**
	 * 查询发件人信息
	 */
	@GetMapping("/kdi/sender")
	List<KdiSenderMo> getSenderInfo(@RequestParam Map<String, Object> map);
	
	/**
	 * 查询所有快递公司信息
	 * @return
	 */
	@GetMapping("/kdi/company/alllist")
	List<KdiCompanyMo> kdiCompanyList();
	
	
}
