package rebue.kdi.kdniao.ctrl;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rebue.kdi.kdniao.ro.KdNiaoUpdateTraceRo;
import rebue.kdi.kdniao.svc.KdNiaoSvc;

@RestController
public class KdNiaoCtrl {

    private final static Logger _log = LoggerFactory.getLogger(KdNiaoCtrl.class);

    @Resource
    private KdNiaoSvc           svc;

    /**
     * 更新物流轨迹
     */
    @PostMapping("/kdi/kdniao/trace")
    KdNiaoUpdateTraceRo updateTrace(@RequestParam Map<String, Object> paramMap) {
        _log.info("update logistic trace : {}", paramMap);
        return svc.updateTrace(paramMap);
    }

}
