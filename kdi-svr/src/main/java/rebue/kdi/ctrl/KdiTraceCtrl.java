package rebue.kdi.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import rebue.kdi.mo.KdiTraceMo;
import rebue.kdi.svc.KdiLogisticSvc;
import rebue.kdi.svc.KdiTraceSvc;


@RestController
public class KdiTraceCtrl {
	
	private final static Logger _log = LoggerFactory.getLogger(KdiLogisticCtrl.class);
	
	@Resource
	private KdiTraceSvc traceSvc;
	
	@Resource
	private KdiLogisticSvc svc;
	
	/**
	 * 根据快递订单号查找物流轨迹
	 */
	@PostMapping("/kdi/trace/getTrace")
	List<KdiTraceMo> getLogisticTrace(Long logisticId){
		_log.info("查询物流轨迹的快递单号为{}："+logisticId);
		return traceSvc.list(logisticId);
	}
	
	
}
