package rebue.kdi.svc.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.kdi.dic.AddKdiLogisticDic;
import rebue.kdi.dic.EOrderResultDic;
import rebue.kdi.kdniao.svc.KdNiaoSvc;
import rebue.kdi.mapper.KdiLogisticMapper;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.mo.KdiSenderMo;
import rebue.kdi.ro.AddKdiLogisticRo;
import rebue.kdi.ro.EOrderRo;
import rebue.kdi.svc.KdiLogisticSvc;
import rebue.kdi.svc.KdiSenderSvc;
import rebue.kdi.svc.KdiTraceSvc;
import rebue.kdi.to.AddKdiLogisticTo;
import rebue.kdi.to.EOrderTo;
import rebue.kdi.to.ListKdiLogisticTo;
import rebue.robotech.svc.impl.MybatisBaseSvcImpl;

@Service
/**
 * <pre>
 * 在单独使用不带任何参数 的 @Transactional 注释时，
 * propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED，
 * 而且事务不会针对受控异常（checked exception）回滚。
 * 注意：
 * 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 * </pre>
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class KdiLogisticSvcImpl extends MybatisBaseSvcImpl<KdiLogisticMo, java.lang.Long, KdiLogisticMapper>
		implements KdiLogisticSvc {
	private final static Logger _log = LoggerFactory.getLogger(KdiLogisticSvcImpl.class);

	@Resource
	private KdiTraceSvc traceSvc;
	
	@Resource
	private KdiSenderSvc kdiSenderSvc;
	
	@Resource
	private KdNiaoSvc kdNiaoSvc;

	/**
	 * @mbg.generated
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public int add(KdiLogisticMo mo) {
		// 如果id为空那么自动生成分布式id
		if (mo.getId() == null || mo.getId() == 0) {
			mo.setId(_idWorker.getId());
		}
		return super.add(mo);
	}

	/**
	 * 获取新的ID
	 */
	@Override
	public Long getNewId() {
		return _idWorker.getId();
	}

	/**
	 * 根据快递公司编码和快递单号获取物流订单
	 * 
	 * @param shipperCode
	 *            快递公司编码
	 * @param logisticCode
	 *            快递单号
	 */
	@Override
	public KdiLogisticMo getOne(String shipperCode, String logisticCode) {
		_log.info("根据快递公司编码和快递单号获取物流订单：{}，{}", shipperCode, logisticCode);
		KdiLogisticMo condition = new KdiLogisticMo();
		condition.setShipperCode(shipperCode);
		condition.setLogisticCode(logisticCode);
		return getOne(condition);
	}

	/**
	 * 添加物流订单
	 * @param to
	 * @return
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public AddKdiLogisticRo addKdiLogistic(AddKdiLogisticTo to) {
		_log.info("添加物流订单的参数为: {}", to);
		AddKdiLogisticRo addKdiLogisticRo = new AddKdiLogisticRo();
		if (StringUtils.isAnyBlank(to.getOrderTitle(), to.getOrderDetail(), to.getCompanyCode(), to.getReceiverName(),
				to.getReceiverProvince(), to.getReceiverCity(), to.getReceiverExpArea(), to.getReceiverAddress(),
				to.getReceiverPostCode()) || to.getSenderId() == null) {
			addKdiLogisticRo.setResult(AddKdiLogisticDic.INCORRECT_PARAMETER);
			addKdiLogisticRo.setMsg("参数不正确");
			return addKdiLogisticRo;
		}
		
		if (to.getReceiverTel() == null || to.getReceiverMobile() == null) {
			_log.info("添加物流订单时出现收件人联系方式为空");
			addKdiLogisticRo.setResult(AddKdiLogisticDic.INCORRECT_PARAMETER);
			addKdiLogisticRo.setMsg("参数不正确");
			return addKdiLogisticRo;
		}
		
		KdiSenderMo senderMo = new KdiSenderMo();
		senderMo.setId(to.getSenderId());
		_log.info("添加物流订单查询发件人信息的参数为: {}", senderMo);
		// 查询发件人信息
		List<KdiSenderMo> senderList = kdiSenderSvc.list(senderMo);
		_log.info("添加物流订单查询发件人信息的返回值为: {}", String.valueOf(senderList));
		if (senderList.size() == 0) {
			addKdiLogisticRo.setResult(AddKdiLogisticDic.NOT_THIS_SENDER);
			addKdiLogisticRo.setMsg("没有此发件人");
			return addKdiLogisticRo;
		}
		
		EOrderTo eOrderTo = new EOrderTo();
		eOrderTo.setShipperCode(to.getCompanyCode());
		eOrderTo.setOrderId(_idWorker.getId());
		eOrderTo.setOrderTitle(to.getOrderTitle());
		eOrderTo.setOrderRemark(to.getOrderDetail());
		eOrderTo.setSenderName(senderList.get(0).getSenderName());
		eOrderTo.setSenderTel(senderList.get(0).getSenderTel());
		eOrderTo.setSenderMobile(senderList.get(0).getSenderMobile());
		eOrderTo.setSenderProvince(senderList.get(0).getSenderProvince());
		eOrderTo.setSenderCity(senderList.get(0).getSenderCity());
		eOrderTo.setSenderExpArea(senderList.get(0).getSenderExpArea());
		eOrderTo.setSenderAddress(senderList.get(0).getSenderAddress());
		eOrderTo.setSenderPostCode(senderList.get(0).getSenderPostCode());
		eOrderTo.setReceiverName(to.getReceiverName());
		eOrderTo.setReceiverTel(to.getReceiverTel());
		eOrderTo.setReceiverMobile(to.getReceiverMobile());
		eOrderTo.setReceiverProvince(to.getReceiverProvince());
		eOrderTo.setReceiverCity(to.getReceiverCity());
		eOrderTo.setReceiverExpArea(to.getReceiverExpArea());
		eOrderTo.setReceiverAddress(to.getReceiverAddress());
		eOrderTo.setReceiverPostCode(to.getReceiverPostCode());
		_log.info("添加物流订单调用电子面单的参数为: {}", eOrderTo);
		// 调用电子面单
		EOrderRo eorder = kdNiaoSvc.eorder(eOrderTo);
		_log.info("添加物流订单调用电子面单的返回值为: {}", eorder);
		if (eorder.getResult() != EOrderResultDic.SUCCESS) {
			_log.error("添加物流订单调用电子面单出错, 返回值为: {}", eorder);
			addKdiLogisticRo.setResult(AddKdiLogisticDic.ERROR);
			addKdiLogisticRo.setMsg(eorder.getFailReason());
			return addKdiLogisticRo;
		}
		_log.info("添加物流订单调用电子面单成功, 返回值为: {}", eorder);
		addKdiLogisticRo.setMsg("添加成功");
		addKdiLogisticRo.setPrintPage(eorder.getPrintPage());
		addKdiLogisticRo.setResult(AddKdiLogisticDic.SUCCESS);
		return addKdiLogisticRo;
	}

	@Override
	public List<KdiLogisticMo> kdiLogisticList(ListKdiLogisticTo to) {
		_log.info("获取物流订单的参数为: {}", to);
		return _mapper.kdiLogisticList(to);
	}
}
