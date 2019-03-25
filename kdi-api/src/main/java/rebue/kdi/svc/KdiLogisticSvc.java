package rebue.kdi.svc;

import java.util.List;

import com.github.pagehelper.PageInfo;

import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.ro.ExaddKdiLogisticRo;
import rebue.kdi.ro.ReportOrderCountRo;
import rebue.kdi.to.AddKdiLogisticTo;
import rebue.kdi.to.DeliverCountTo;
import rebue.kdi.to.ListKdiLogisticTo;
import rebue.kdi.to.OrderCountReportTo;
import rebue.robotech.svc.MybatisBaseSvc;

public interface KdiLogisticSvc extends MybatisBaseSvc<KdiLogisticMo, java.lang.Long> {

	/**
	 * 获取新的ID
	 */
	Long getNewId();

	/**
	 * 获取物流订单
	 * 
	 * @param to
	 * @return
	 */
	PageInfo<KdiLogisticMo> kdiLogisticList(ListKdiLogisticTo to, int pageNum, int pageSize);

	/**
	 * 录入订单
	 * 
	 * @param mo
	 * @return
	 */
	int entryLogistics(AddKdiLogisticTo mo);

	/**
	 * 后台调用电子面单接口
	 * 
	 * @param mo
	 * @return
	 */
	ExaddKdiLogisticRo exaddKdiLogistic(AddKdiLogisticTo mo);

	/*
	 * 根据快递公司编码和快递单号获取物流订单
	 * 
	 * @param shipperCode 快递公司编码
	 * 
	 * @param logisticCode 快递单号
	 */
	KdiLogisticMo getOne(String shipperCode, String logisticCode);

	/**
	 * 根据微信端的参数获取快递公司和快递单号
	 * 
	 * @param mo
	 * @return
	 */
	List<KdiLogisticMo> kdiLogisticWx(KdiLogisticMo mo);

	/**
	 * 统计本组织一段时间内的下单量
	 */
	List<ReportOrderCountRo> reportOrderCountInPeriod(OrderCountReportTo to);

	/**
	 * 获取打印页面
	 * 
	 * @param mo
	 * @return
	 */
	List<KdiLogisticMo> getPrintPageByOrderId(KdiLogisticMo mo);

	/**
	 * 根据收件人手机号码查询收件人信息
	 * 
	 * @param receiverMobile
	 * @return
	 */
	KdiLogisticMo getReceiverByReceiverMobile(String receiverMobile);
	
	/**
	 * 获取组织的发单量
	 * @param to
	 * @return
	 */
	 Long getDeliverCount(DeliverCountTo to);
}
