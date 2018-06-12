package rebue.kdi.svc.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.kdi.dic.AddKdiSenderDic;
import rebue.kdi.dic.ModifyDefaultSenderDic;
import rebue.kdi.dic.ModifyKdiSenderDic;
import rebue.kdi.mapper.KdiSenderMapper;
import rebue.kdi.mo.KdiSenderMo;
import rebue.kdi.ro.AddKdiSenderRo;
import rebue.kdi.ro.ModifyDefaultSenderRo;
import rebue.kdi.ro.ModifyKdiSenderRo;
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
		if (mo.getIsDefault()) {
			KdiSenderMo senderMo = new KdiSenderMo();
			senderMo.setIsDefault(true);
			List<KdiSenderMo> senderList = list(senderMo);
			_log.info("添加发件人查询默认发件人的返回值为: {}", String.valueOf(senderList));
			if (senderList.size() != 0) {
				for (KdiSenderMo kdiSenderMo : senderList) {
					senderMo = new KdiSenderMo();
					senderMo.setId(kdiSenderMo.getId());
					senderMo.setIsDefault(false);
					_mapper.updateByPrimaryKeySelective(senderMo);
				}
			}
		}
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
	
	/**
	 * 修改发件人信息
	 * @param mo
	 * @return
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public ModifyKdiSenderRo modifyKdiSender(KdiSenderMo mo) {
		_log.info("修改发件人信息的参数为: {}", mo);
		ModifyKdiSenderRo modifyKdiSenderRo = new ModifyKdiSenderRo();
		if (mo.getIsDefault()) {
			_log.info("修改发件人信息修改默认发件人的参数为: {}", mo);
			ModifyDefaultSenderRo modifyDefaultSenderResult = modifyDefaultSender(mo);
			_log.info("修改发件人信息修改默认发件人的返回值为: {}", modifyDefaultSenderResult);
			if (modifyDefaultSenderResult.getResult() == ModifyDefaultSenderDic.SUCCESS) {
				modifyKdiSenderRo.setResult(ModifyKdiSenderDic.SUCCESS);
				modifyKdiSenderRo.setMsg(modifyDefaultSenderResult.getMsg());
				return modifyKdiSenderRo;
			} else {
				_log.error("修改发件人信息修改默认发件人失败, 发件人编号为: ", mo.getId());
				modifyKdiSenderRo.setResult(ModifyKdiSenderDic.ERROR);
				modifyKdiSenderRo.setMsg(modifyDefaultSenderResult.getMsg());
				return modifyKdiSenderRo;
			}
		} else {
			int updateByPrimaryKeySelectiveResult = _mapper.updateByPrimaryKeySelective(mo);
			_log.info("修改发件人信息的返回值为: {}", updateByPrimaryKeySelectiveResult);
			if (updateByPrimaryKeySelectiveResult != 1) {
				_log.error("修改发件人信息失败, 发件人编号为: ", mo.getId());
				modifyKdiSenderRo.setResult(ModifyKdiSenderDic.ERROR);
				modifyKdiSenderRo.setMsg("修改失败");
				return modifyKdiSenderRo;
			}
			modifyKdiSenderRo.setResult(ModifyKdiSenderDic.SUCCESS);
			modifyKdiSenderRo.setMsg("修改成功");
			return modifyKdiSenderRo;
		}
	}
	
	/**
	 * 修改默认发件人
	 * @return
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public ModifyDefaultSenderRo modifyDefaultSender(KdiSenderMo mo) {
		_log.info("修改默认发件人的请求参数为: {}", mo);
		ModifyDefaultSenderRo senderRo = new ModifyDefaultSenderRo();
		KdiSenderMo senderMo = new KdiSenderMo();
		senderMo.setIsDefault(true);
		_log.info("修改默认发件人查询默认发件人信息的参数为: {}", senderMo);
		List<KdiSenderMo> senderList = list(senderMo);
		_log.info("修改默认发件人查询默认发件人信息的返回值为: {}", String.valueOf(senderList));
		if (senderList.size() != 0) {
			for (KdiSenderMo kdiSenderMo : senderList) {
				senderMo = new KdiSenderMo();
				senderMo.setIsDefault(false);
				senderMo.setId(kdiSenderMo.getId());
				_log.info("修改默认发件人修改原默认发件人的参数为: {}", senderMo);
				int updateByPrimaryKeySelectiveResult = _mapper.updateByPrimaryKeySelective(senderMo);
				_log.info("修改默认发件人修改原默认发件人的返回值为: {}", updateByPrimaryKeySelectiveResult);
				if (updateByPrimaryKeySelectiveResult != 1) {
					_log.error("修改默认发件人修改原默认发件人时出错, 原默认发件人编号为: {}", kdiSenderMo.getId());
					senderRo.setResult(ModifyDefaultSenderDic.ERROR);
					senderRo.setMsg("修改原默认发件人失败");
					return senderRo;
				}
			}
		}
		_log.info("修改默认发件人的参数为: {}", mo);
		int updateDefaultSenderResult = _mapper.updateByPrimaryKeySelective(mo);
		if (updateDefaultSenderResult != 1) {
			_log.error("修改默认发件人时出错, 发件人编号为: {}", mo.getId());
			senderRo.setResult(ModifyDefaultSenderDic.ERROR);
			senderRo.setMsg("修改失败");
			return senderRo;
		}
		_log.info("修改默认发件人成功, 发件人编号为: {}", mo.getId());
		senderRo.setResult(ModifyDefaultSenderDic.SUCCESS);
		senderRo.setMsg("修改成功");
		return senderRo;
	}
}
