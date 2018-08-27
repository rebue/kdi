package rebue.kdi.ctrl;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rebue.kdi.dic.ModifyDefaultSenderDic;
import rebue.kdi.mo.KdiSenderMo;
import rebue.kdi.ro.KdiSenderRo;
import rebue.kdi.ro.ModifyDefaultSenderRo;
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
	 * 获取默认发件人信息
	 * 
	 * @return
	 */
	@GetMapping("/kdi/sender/default")
	KdiSenderMo getDefaultSender() {
		_log.info("开始查询默认发件人信息");
		KdiSenderMo mo = svc.getDefaultSender();
		_log.info("查询到的发件人信息为: {}", String.valueOf(mo));
		return mo;
	}


	
	/*
	 * 更新备注:原来的路径是/kdi/sender/add，为了迎合新框架的格式改为/kdi/sender
	 */
    @PostMapping("/kdi/sender")
    KdiSenderRo add(@RequestBody KdiSenderMo mo) throws Exception {
        _log.info("add KdiSenderMo:" + mo);
        KdiSenderRo ro = new KdiSenderRo();
        int result = svc.add(mo);
        if (result == 1) {
            String msg = "添加成功";
            _log.info("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult((byte) 1);
            return ro;
        } else {
            String msg = "添加失败";
            _log.error("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult((byte) -1);
            return ro;
        }
    }
    
	/**
	 * 修改发件人信息
	 * 
	 * @param mo
	 * @return
	 */
    @PutMapping("/kdi/sender")
    KdiSenderRo modify(@RequestBody KdiSenderMo mo) throws Exception {
        _log.info("modify KdiSenderMo:" + mo);
        KdiSenderRo ro = new KdiSenderRo();
        int result = svc.modify(mo);
        if (result == 1) {
            String msg = "修改成功";
            _log.info("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult((byte) 1);
            return ro;
        } else {
            String msg = "修改失败";
            _log.error("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult((byte) -1);
            return ro;
        }

    }
    
    /**
     * 删除发件人
     *
     * 
     */
    @DeleteMapping("/kdi/sender")
    KdiSenderRo del(@RequestParam("id") java.lang.Long id) {
        _log.info("del 发件人:" + id);
        int result = svc.del(id);
        KdiSenderRo ro = new KdiSenderRo();
        if (result == 1) {
            String msg = "删除成功";
            _log.info("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult((byte) 1);
            return ro;
        } else {
            String msg = "删除失败，找不到该记录";
            _log.error("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult((byte) -1);
            return ro;
        }
    }
    
    /**
     *
     *获取单个发件人
     */
    @GetMapping("/kdi/sender/getbyid")
    KdiSenderRo getById(@RequestParam("id") java.lang.Long id) {
        _log.info("get KdiSenderMo by id: " + id);
        KdiSenderMo result = svc.getById(id);
        _log.info("get: " + result);
        KdiSenderRo ro = new KdiSenderRo();
        if (result == null) {
            String msg = "获取失败，没有找到该条记录";
            _log.error("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult((byte) -1);
            return ro;
        } else {
            String msg = "获取成功";
            _log.info("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult((byte) 1);
            ro.setRecord(result);
            return ro;
        }
    }
    

	/**
	 * 查询发件人信息
	 * 
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
	 * 修改默认发件人
	 * 
	 * @param mo
	 * @return
	 */
	@PutMapping("/kdi/sender/default")
	ModifyDefaultSenderRo setDefaultSender(@RequestBody KdiSenderMo mo) {
		_log.info("修改默认发件人的参数为: {}", mo);
		ModifyDefaultSenderRo senderRo = new ModifyDefaultSenderRo();
		try {
			senderRo =svc.setDefaultSender(mo);
			return senderRo;
		}catch(Exception e ) {
			_log.error("修改默认发件人时出错, 发件人编号为: {}", mo.getId());
			senderRo.setResult(ModifyDefaultSenderDic.ERROR);
			senderRo.setMsg("修改失败");
			return senderRo;
		}
	}
	
	/**
	 * 根据组织Id获取寄件人
	 * 
	 * @return
	 */
	@GetMapping("/kdi/sender/listByOrganizeId")
	List<KdiSenderMo> listSenderByOrganizeId(Long organizeId) {
		_log.info("开始根据组织ID查询发件人信息");
		List<KdiSenderMo> list = svc.listSenderByOrganizeId(organizeId);
		_log.info("查询到的发件人信息为: {}", String.valueOf(list));
		return list;
	}

}
