package rebue.kdi.ctrl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.mo.KdiTraceMo;
import rebue.kdi.ro.ExaddKdiLogisticRo;
import rebue.kdi.ro.KdiLogisticRo;
import rebue.kdi.ro.LogisticsAndTraceRo;
import rebue.kdi.ro.ReportOrderCountRo;
import rebue.kdi.svc.KdiLogisticSvc;
import rebue.kdi.svc.KdiTraceSvc;
import rebue.kdi.to.AddKdiLogisticTo;
import rebue.kdi.to.BatchEnterTo;
import rebue.kdi.to.DeliverCountTo;
import rebue.kdi.to.ListKdiLogisticTo;
import rebue.kdi.to.OrderCountReportTo;
import rebue.robotech.ro.Ro;

@RestController
public class KdiLogisticCtrl {

    private final static Logger _log = LoggerFactory.getLogger(KdiLogisticCtrl.class);

    @Resource
    private KdiLogisticSvc svc;

    @Resource
    private KdiTraceSvc traceSvc;

    /**
     * 添加物流订单记录
     * 
     * @param to
     * @return
     */
    @PostMapping("/kdi/logistic/entry")
    KdiLogisticRo entryLogistics(@RequestBody AddKdiLogisticTo to) throws Exception {
        _log.info("add AddKdiLogisticTo: {}" + to);
        KdiLogisticRo ro = new KdiLogisticRo();
        int result = svc.entryLogistics(to);
        if (result == 1) {
            String msg = "添加成功";
            _log.info("{}: to-{}", msg, to);
            ro.setMsg(msg);
            ro.setResult((byte) 1);
            return ro;
        } else {
            String msg = "添加失败";
            _log.error("{}: to-{}", msg, to);
            ro.setMsg(msg);
            ro.setResult((byte) -1);
            return ro;
        }
    }

    /**
     * 修改物流信息
     *
     * 
     */
    @PutMapping("/kdi/logistic")
    KdiLogisticRo modify(@RequestBody KdiLogisticMo mo) throws Exception {
        _log.info("modify KdiLogisticMo:" + mo);
        KdiLogisticRo ro = new KdiLogisticRo();
        int result = svc.modify(mo);
        if (result == 1) {
            String msg = "修改成功";
            _log.info("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult((byte) 1);
            return ro;
        } else {
            String msg = "修改失败";
            _log.error("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult((byte) -1);
            return ro;
        }

    }

    /**
     * 后台调用电子面单接口
     * 
     * @param mo
     * @return
     */
    @PostMapping("/kdi/logistic/exaddkdilogistic")
    ExaddKdiLogisticRo exaddKdiLogistic(@RequestBody AddKdiLogisticTo mo) {
        _log.info("后台调用电子面单接口的参数为：{}", mo);
        return svc.exaddKdiLogistic(mo);
    }

    /**
     * 根据微信端的条件查询快递公司和订单号
     * 
     * @param mo
     * @return
     */
    @PostMapping("/kdi/logistic/wx")
    List<KdiLogisticMo> listLogisticWx(KdiLogisticMo mo) {
        _log.info("微信端口查询快递公司和快递单号 {}", mo);
        return svc.kdiLogisticWx(mo);
    }

    /**
     * 更新备注，这个方法原来是在KdiManageCtrl（已被删除，原因是暂时还用不到这么这个可以省略的控制器），
     * 且原来的路径是/kid/manage/logistic，为了迎合新框架的格式改为/kdi/logistic,原来的是不分页的，
     * 
     * @param to
     * @return
     */
    @GetMapping("/kdi/logistic")
    PageInfo<KdiLogisticMo> list(ListKdiLogisticTo to, @RequestParam("pageNum") int pageNum,
            @RequestParam("pageSize") int pageSize) {
        _log.info("list OrdOrderMo:" + to + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        PageInfo<KdiLogisticMo> result = svc.kdiLogisticList(to, pageNum, pageSize);
        _log.info("result: " + result);
        return result;

    }

    /**
     * 统计本组织一段时间内的下单量
     */
    @GetMapping("/kdi/logistic/report/ordercountinperiod")
    List<ReportOrderCountRo> reportOrderCountInPeriod(OrderCountReportTo to) {
        _log.info("查询物流报表的参数为 {}", to);
        List<ReportOrderCountRo> result = svc.reportOrderCountInPeriod(to);
        _log.info("查询物流报表的返回值为 {}", result);
        return result;
    }

    /**
     * 获取打印页面
     * 
     * @param mo
     * @return
     */
    @GetMapping("/kdi/logistic/printpage")
    List<KdiLogisticMo> getPrintPageByOrderId(KdiLogisticMo mo) {
        _log.info("查询打印页面参数为 {}", mo);
        return svc.getPrintPageByOrderId(mo);
    }

    /**
     * 根据传入参数单个物流信息
     * 
     * @param mo
     * @return
     */
    @GetMapping("/kdi/logistic/getLogisticInfo")
    KdiLogisticMo getLogisticInfo(KdiLogisticMo mo) {
        _log.info("查询订单物流参数为 {}", mo);
        return svc.getOne(mo);
    }

    /**
     * 获取单个物流信息
     *
     *
     */
    @GetMapping("/kdi/logistic/getbyid")
    KdiLogisticRo getById(@RequestParam("id") java.lang.Long id) {
        _log.info("get Kdilogistic by id: " + id);
        KdiLogisticMo result = svc.getById(id);
        _log.info("get: " + result);
        KdiLogisticRo ro = new KdiLogisticRo();
        if (result == null) {
            String msg = "获取失败，没有找到该条记录";
            _log.error("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult((byte) -1);
            return ro;
        } else {
            String msg = "获取成功";
            _log.info("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult((byte) 1);
            ro.setRecord(result);
            return ro;
        }
    }

    /**
     * 查询物流信息和物流轨迹
     * 
     * @param mo
     * @return
     */
    @GetMapping("/kdi/logistic/list")
    List<LogisticsAndTraceRo> KdiLogisticList(KdiLogisticMo mo) {
        List<LogisticsAndTraceRo> result = new ArrayList<LogisticsAndTraceRo>();
        _log.info("查询物流信息的参数为: {}", mo);
        // 区分页面是开始进去页面使用orderId查询还是后面的点击使用id查询
        if (mo.getOrderId() == null) {
            KdiLogisticMo kdiLogisticMo = svc.getById(mo.getId());
            _log.info("查询物流信息的返回值为: {}", kdiLogisticMo);
            if (kdiLogisticMo != null) {
                List<KdiLogisticMo> klm = new ArrayList<KdiLogisticMo>();
                klm.add(kdiLogisticMo);
                LogisticsAndTraceRo logisticsAndTraceRo = new LogisticsAndTraceRo();
                logisticsAndTraceRo.setKdiLogistic(klm);
                KdiTraceMo kdiTracemo = new KdiTraceMo();
                kdiTracemo.setLogisticId(kdiLogisticMo.getId());
                _log.info("查询物流轨迹信息的参数为: {}", kdiTracemo);
                List<KdiTraceMo> KdiTraceList = traceSvc.list(kdiTracemo);
                _log.info("查询物流信息的返回值为: {}", KdiTraceList);
                if (KdiTraceList != null && KdiTraceList.size() > 0) {
                    logisticsAndTraceRo.setKdiTrace(KdiTraceList);
                }
                result.add(logisticsAndTraceRo);
            }
        } else {
            List<KdiLogisticMo> kdiLogisticMo = svc.list(mo);
            _log.info("查询物流信息的返回值为: {}", kdiLogisticMo);
            if (kdiLogisticMo != null && kdiLogisticMo.size() > 0) {
                LogisticsAndTraceRo logisticsAndTraceRo = new LogisticsAndTraceRo();
                logisticsAndTraceRo.setKdiLogistic(kdiLogisticMo);
                KdiTraceMo kdiTracemo = new KdiTraceMo();
                kdiTracemo.setLogisticId(kdiLogisticMo.get(0).getId());
                _log.info("查询物流轨迹信息的参数为: {}", kdiTracemo);
                List<KdiTraceMo> KdiTraceList = traceSvc.list(kdiTracemo);
                _log.info("查询物流信息的返回值为: {}", KdiTraceList);
                if (KdiTraceList != null && KdiTraceList.size() > 0) {
                    logisticsAndTraceRo.setKdiTrace(KdiTraceList);
                }
                result.add(logisticsAndTraceRo);
            }
        }

        return result;
    }

    /**
     * 根据收货人手机号码查询收货人信息
     * 
     * @param receiverMobile
     * @return
     */
    @GetMapping("/kdi/logistic/receiver")
    KdiLogisticMo getReceiverByReceiverMobile(@RequestParam("receiverMobile") String receiverMobile) {
        _log.info("根据收件人手机号码查询收件人信息的参数为：{}", receiverMobile);
        KdiLogisticMo mo = new KdiLogisticMo();
        if (receiverMobile == null || receiverMobile.equals("") || receiverMobile.equals("null")) {
            _log.error("根据收件人手机号码查询收件人信息时发现用户未输入手机号码");
            return mo;
        }
        return svc.getReceiverByReceiverMobile(receiverMobile);
    }

    @GetMapping("/kdi/logistic/getDeliverCount")
    Long getDeliverCount(@RequestBody DeliverCountTo to) {
        _log.info("获取组织发货量的参数为：{}", to);
        return svc.getDeliverCount(to);
    }

    @PostMapping("/kdi/logistic/batch-enter")
    public Ro batchEnter(@RequestBody BatchEnterTo to) {
        _log.info("批量录入的参数为：{}", to);
        return svc.batchEnter(to);
    }

}
