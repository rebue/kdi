package rebue.kdi.svc;

import org.springframework.web.bind.annotation.RequestBody;

import rebue.kdi.ro.EOrderRo;
import rebue.kdi.ro.IdentifyLogisticCodeRo;
import rebue.kdi.ro.KdiBatchOrderRo;
import rebue.kdi.ro.LogisticRo;
import rebue.kdi.ro.SubscribeTraceRo;
import rebue.kdi.to.EOrderTo;
import rebue.kdi.to.KdiBatchOrderTo;
import rebue.kdi.to.SubscribeTraceTo;

public interface KdiSvc {

    /**
     * 识别快递单号
     * 
     * @Description: 根据快递单号智能识别是哪个快递公司（不能保证100%识别，可能多个，也可能识别不出来）
     * 
     * @param logisticCode
     *            快递单号
     */
    IdentifyLogisticCodeRo identifyLogisticCode(String logisticCode);

    /**
     * 订阅物流轨迹
     * 
     * @Description: 向物流平台（快递鸟）订阅物流轨迹信息，当产生轨迹或有变动时，物流平台会向本系统的轨迹推送接口发出消息通知。
     *               支持的快递公司:除顺丰、天天、申通外，其他主流快递公司都支持。
     */
    SubscribeTraceRo subscribeTrace(SubscribeTraceTo to);

    /**
     * 查询物流轨迹
     * 
     * @Description: 根据快递公司编码和快递单号查询物流轨迹
     * 
     * @param shipperCode
     *            快递公司编码
     * @param logisticCode
     *            快递单号
     */
    LogisticRo getTraces(String shipperCode, String logisticCode);

    /**
     * 电子面单
     * 
     * @Description: 此接口用于向快递公司下发订单并获取快递单号和打印模板
     */
    EOrderRo eorder(EOrderTo to);
    
    /**
     * 向快递公司批量下发订单并获取快递单号和打印模板
     * 
     * @param to
     */
    KdiBatchOrderRo KdiBatchOrder( KdiBatchOrderTo to);

}