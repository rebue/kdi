package rebue.kdi.svc;

import java.util.List;

import rebue.kdi.mo.KdiTraceMo;
import rebue.robotech.svc.MybatisBaseSvc;

public interface KdiTraceSvc extends MybatisBaseSvc<KdiTraceMo, java.lang.Long> {

    /**
     * 根据物流订单ID删除其所有轨迹
     * 
     * @param logisticId
     *            物流订单ID
     */
    void delByLogisticId(Long logisticId);

    /**
     * 根据物流订单ID查询其所有轨迹
     * 
     * @param logisticId
     *            物流订单ID
     */
    List<KdiTraceMo> list(Long logisticId);
    
}