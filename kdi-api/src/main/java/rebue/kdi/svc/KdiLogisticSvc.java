package rebue.kdi.svc;

import rebue.kdi.mo.KdiLogisticMo;
import rebue.robotech.svc.MybatisBaseSvc;

public interface KdiLogisticSvc extends MybatisBaseSvc<KdiLogisticMo, java.lang.Long> {

    /**
     * 根据快递公司编码和快递单号获取物流订单
     * 
     * @param shipperCode
     *            快递公司编码
     * @param logisticCode
     *            快递单号
     */
    KdiLogisticMo getOne(String shipperCode, String logisticCode);

    /**
     * 获取新的ID
     */
    Long getNewId();

}