package rebue.kdi.svc;

import java.util.List;

import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.ro.AddKdiLogisticRo;
import rebue.kdi.ro.EntryLogisticsRo;
import rebue.kdi.ro.ExaddKdiLogisticRo;
import rebue.kdi.to.AddKdiLogisticTo;
import rebue.kdi.to.ListKdiLogisticTo;
import rebue.robotech.svc.MybatisBaseSvc;

public interface KdiLogisticSvc extends MybatisBaseSvc<KdiLogisticMo, java.lang.Long> {

    /**
     * 获取新的ID
     */
    Long getNewId();

    /**
     * 添加物流订单
     * @param to
     * @return
     */
	AddKdiLogisticRo addKdiLogistic(AddKdiLogisticTo mo);
	
	/**
	 * 获取物流订单
	 * @param to
	 * @return
	 */
	List<KdiLogisticMo>  kdiLogisticList (ListKdiLogisticTo to);

	/**
	 * 录入订单
	 * @param mo
	 * @return
	 */
	EntryLogisticsRo entryLogistics(AddKdiLogisticTo mo);

	/**
	 * 后台调用电子面单接口
	 * @param mo
	 * @return
	 */
	ExaddKdiLogisticRo exaddKdiLogistic(AddKdiLogisticTo mo);

	/* 根据快递公司编码和快递单号获取物流订单
	 * 
	 * @param shipperCode
	 *            快递公司编码
	 * @param logisticCode
	 *            快递单号
	 */
	KdiLogisticMo getOne(String shipperCode, String logisticCode); 
	
	/**
	 * 根据微信端的参数获取快递公司和快递单号
	 * @param mo
	 * @return
	 */
	List<KdiLogisticMo> kdiLogisticWx(KdiLogisticMo mo); 

}