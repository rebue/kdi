package rebue.kdi.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import rebue.kdi.mo.KdiSenderMo;
import rebue.kdi.ro.AddKdiSenderRo;
import rebue.kdi.ro.ModifyDefaultSenderRo;
import rebue.kdi.ro.ModifyKdiSenderRo;
import rebue.kdi.svc.KdiSenderSvc;

@RestController
public class KdiSenderCtrl {

	private final static Logger _log = LoggerFactory.getLogger(KdiSenderCtrl.class);
	
	@Resource
	private KdiSenderSvc svc;

	/**
	 * 获取所有发件人信息
	 * 
	 * @return
	 */
	@GetMapping("/kdi/sender/alllist")
	List<KdiSenderMo> kdiSenderList() {
		_log.info("开始查询发件人信息");
		List<KdiSenderMo> list = svc.listAll();
		_log.info("查询到的发件人信息为: {}", String.valueOf(list));
		return list;
	}

	/**
	 * 添加发件人
	 * 
	 * @param mo
	 * @return
	 */
	@PostMapping("/kdi/sender/add")
	AddKdiSenderRo addKdiSender(KdiSenderMo mo) {
		_log.info("添加发件人的参数为: {}", mo);
		return svc.exAdd(mo);
	}
	
	/**
	 * 查询发件人信息
	 * @param mo
	 * @return
	 */
	@GetMapping("/kdi/sender")
	List<KdiSenderMo> list(KdiSenderMo mo) {
		_log.info("查询发件人信息的参数为: {}", mo);
		List<KdiSenderMo> list = svc.list(mo);
		_log.info("查询发件人信息的返回值为: {}", String.valueOf(list));
		return list;
	}
	
	/**
	 * 修改发件人信息
	 * @param mo
	 * @return
	 */
	@PutMapping("/kdi/sender")
	ModifyKdiSenderRo modifyKdiSender(KdiSenderMo mo) {
		_log.info("修改发件人信息的参数为: {}", mo);
		return svc.modifyKdiSender(mo);
	}
	
	/**
	 * 修改默认发件人
	 * @param mo
	 * @return
	 */
	@PutMapping("/kdi/sender/default")
	ModifyDefaultSenderRo modifyDefaultSender(KdiSenderMo mo) {
		_log.info("修改默认发件人的参数为: {}", mo);
		return svc.modifyDefaultSender(mo);
	}
}
