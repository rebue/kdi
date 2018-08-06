package rebue.kdi.kdniao.svc;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import rebue.kdi.kdniao.ro.KdNiaoUpdateTraceRo;
import rebue.kdi.svc.KdiSvc;

public interface KdNiaoSvc extends KdiSvc {

    /**
     * 更新物流轨迹
     * 
     * @Description: 当物流轨迹有变时，用来接收快递鸟的推送通知
     * 
     * @param paramMap
     *            接收到的物流轨迹的信息
     */
    KdNiaoUpdateTraceRo updateTrace(Map<String, Object> paramMap);

    /**
     * 更新获取物流的轨迹
     * 
     * @Description: 接收到快递鸟的推送通知里面具体的一个物流单的轨迹信息
     * 
     * @param logistic
     *            接收到的物流的信息
     * @param updateTime
     *            更新时间
     */
    void updateTraceOfLogistic(Map<String, Object> logistic, Date updateTime) throws ParseException;

}