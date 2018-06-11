package rebue.kdi.svc.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.kdi.dic.AddKdiSenderDic;
import rebue.kdi.mapper.KdiSenderMapper;
import rebue.kdi.mo.KdiSenderMo;
import rebue.kdi.ro.AddKdiSenderRo;
import rebue.kdi.svc.KdiSenderSvc;
import rebue.robotech.svc.impl.MybatisBaseSvcImpl;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class KdiSenderSvcImpl extends MybatisBaseSvcImpl<KdiSenderMo, java.lang.Long, KdiSenderMapper>
		implements KdiSenderSvc {

	private final static Logger _log = LoggerFactory.getLogger(KdiSenderSvcImpl.class);

	/**
	 * 添加发件人
	 * @param mo
	 * @return
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public AddKdiSenderRo exAdd(KdiSenderMo mo) {
		// 如果id为空那么自动生成分布式id
		if (mo.getId() == null || mo.getId() == 0) {
			mo.setId(_idWorker.getId());
		}
		mo.setEntryTime(new Date());
		_log.info("添加发件人的参数为: {}", mo);
		int result = add(mo);
		_log.info("添加发件人的返回值为: {}", result);
		AddKdiSenderRo ro = new AddKdiSenderRo();
		if (result == 1) {
			_log.info("添加发件人成功");
			ro.setResult(AddKdiSenderDic.SUCCESS);
			ro.setMsg("添加成功");
		} else {
			_log.error("添加发件人失败");
			ro.setResult(AddKdiSenderDic.SUCCESS);
			ro.setMsg("添加失败");
		}
		return ro;
	}
}
