package rebue.kdi.ctrl;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.svc.KdiLogisticSvc;

@RestController
public class KdiManageCtrl {
	
	/**
	 */
	private final static Logger _log = LoggerFactory.getLogger(KdiManageCtrl.class);

	/**
	 */
	@Resource
	private KdiLogisticSvc svc;
	
	
	/**
	 * 根据条件查询订单信息 Title: list Description:
	 * 
	 * @param mo
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @date 2018年3月28日 下午3:06:09
	 */
	@GetMapping("/kid/manage")
	   List<KdiLogisticMo> list(KdiLogisticMo mo) {
		_log.info("list KdiLogisticMo:" + mo );
	
	    List<KdiLogisticMo> result = svc.list(mo);
		_log.info("result: " + result);
		return result;
	}

	
	
	

}
