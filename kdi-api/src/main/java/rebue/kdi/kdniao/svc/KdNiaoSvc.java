package rebue.kdi.kdniao.svc;

import java.util.Map;

import rebue.kdi.kdniao.ro.KdNiaoUpdateTraceRo;
import rebue.kdi.svc.KdiSvc;

public interface KdNiaoSvc extends KdiSvc {

    /**
     * 更新物流轨迹
     */
    KdNiaoUpdateTraceRo updateTrace(Map<String, Object> paramMap);

}