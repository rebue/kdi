package rebue.kdi.svc.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.dozermapper.core.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import rebue.kdi.dic.EOrderResultDic;
import rebue.kdi.dic.KdiTaskTypeDic;
import rebue.kdi.dic.SubscribeTraceResultDic;
import rebue.kdi.kdniao.svc.KdNiaoSvc;
import rebue.kdi.mapper.KdiLogisticMapper;
import rebue.kdi.mo.KdiCompanyDicMo;
import rebue.kdi.mo.KdiCompanyMo;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.mo.KdiOrderMo;
import rebue.kdi.mo.KdiSenderMo;
import rebue.kdi.mo.KdiTaskMo;
import rebue.kdi.ro.CompanyRo;
import rebue.kdi.ro.EOrderRo;
import rebue.kdi.ro.ExaddKdiLogisticRo;
import rebue.kdi.ro.KdiBatchOrderRo;
import rebue.kdi.ro.ReportOrderCountRo;
import rebue.kdi.ro.SubscribeTraceRo;
import rebue.kdi.svc.KdiCompanyDicSvc;
import rebue.kdi.svc.KdiCompanySvc;
import rebue.kdi.svc.KdiLogisticSvc;
import rebue.kdi.svc.KdiSenderSvc;
import rebue.kdi.svc.KdiSvc;
import rebue.kdi.svc.KdiTaskSvc;
import rebue.kdi.svc.KdiTraceSvc;
import rebue.kdi.to.AddKdiLogisticTo;
import rebue.kdi.to.BatchEnterTo;
import rebue.kdi.to.DeliverCountTo;
import rebue.kdi.to.EOrderTo;
import rebue.kdi.to.KdiBatchOrderTo;
import rebue.kdi.to.ListKdiLogisticTo;
import rebue.kdi.to.OrderCountReportTo;
import rebue.kdi.to.SubscribeTraceTo;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.dic.TaskExecuteStateDic;
import rebue.robotech.ro.Ro;
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

    /**
     * @mbg.generated
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(final KdiLogisticMo mo) {
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }

        return super.add(mo);
    }

    private static final Logger _log = LoggerFactory.getLogger(KdiLogisticSvcImpl.class);

    @Resource
    private KdiTraceSvc traceSvc;

    @Resource
    private KdiSenderSvc kdiSenderSvc;

    @Resource
    private KdNiaoSvc kdNiaoSvc;

    @Resource
    private KdiCompanySvc kdiCompanySvc;

    @Resource
    private Mapper dozerMapper;

    @Resource
    private KdiSvc kdiSvc;

    @Resource
    private KdiCompanyDicSvc kdiCompanyDicSvc;

    @Resource
    private KdiTaskSvc kdiTaskSvc;

    /**
     * 获取新的ID
     */
    @Override
    public Long getNewId() {
        return _idWorker.getId();
    }

    /*
     * 根据快递公司编码和快递单号获取物流订单
     * 
     * @param shipperCode 快递公司编码
     * 
     * @param logisticCode 快递单号
     */
    @Override
    public KdiLogisticMo getOne(final String shipperCode, final String logisticCode) {
        _log.info("根据快递公司编码和快递单号获取物流订单：{}，{}", shipperCode, logisticCode);
        final KdiLogisticMo condition = new KdiLogisticMo();
        condition.setShipperCode(shipperCode);
        condition.setLogisticCode(logisticCode);
        return getOne(condition);
    }

    /**
     * 后台调用电子面单接口
     *
     * @param mo
     * @return
     */
    @Override
    public ExaddKdiLogisticRo exaddKdiLogistic(final AddKdiLogisticTo mo) {
        _log.info("添加物流订单信息的参数为：｛｝", mo);
        ExaddKdiLogisticRo kdiLogisticRo = new ExaddKdiLogisticRo();
        if (StringUtils.isAnyBlank(mo.getOrderTitle(), mo.getReceiverName(), mo.getReceiverProvince(),
                mo.getReceiverCity(), mo.getReceiverExpArea(), mo.getReceiverAddress(), mo.getReceiverPostCode())
                || StringUtils.isAllBlank(mo.getReceiverTel(), mo.getReceiverMobile()) || mo.getOrderId() == null
                || mo.getShipperId() == null) {
            kdiLogisticRo.setResult(EOrderResultDic.PARAM_ERROR);
            kdiLogisticRo.setFailReason("参数有误");
            return kdiLogisticRo;
        }
        final KdiSenderMo kdiSenderMo = new KdiSenderMo();
        kdiSenderMo.setIsDefault(true);
        _log.info("添加物流订单信息查询默认发件人信息的参数为：｛｝", kdiSenderMo);
        // 查询默认发件人信息
        final List<KdiSenderMo> senderList = kdiSenderSvc.list(kdiSenderMo);
        _log.info("添加物流订单信息查询默认发件人信息的返回值为：｛｝", String.valueOf(senderList));
        if (senderList.size() == 0) {
            _log.error("添加物流订单信息查询默认发件人时发现默认发件人为空");
            kdiLogisticRo.setResult(EOrderResultDic.PARAM_ERROR);
            kdiLogisticRo.setFailReason("请先设置默认发件人");
            return kdiLogisticRo;
        }
        // 根据快递公司id获取快递公司信息
        final CompanyRo companyMo = kdiCompanySvc.getOneCompanyById(mo.getShipperId());
        mo.setSenderName(senderList.get(0).getSenderName());
        mo.setSenderTel(senderList.get(0).getSenderTel());
        mo.setSenderMobile(senderList.get(0).getSenderMobile());
        mo.setSenderProvince(senderList.get(0).getSenderProvince());
        mo.setSenderCity(senderList.get(0).getSenderCity());
        mo.setSenderExpArea(senderList.get(0).getSenderExpArea());
        mo.setSenderAddress(senderList.get(0).getSenderAddress());
        mo.setSenderPostCode(senderList.get(0).getSenderPostCode());
        final EOrderTo eOrderTo = dozerMapper.map(mo, EOrderTo.class);
        eOrderTo.setOrderRemark(mo.getOrderTitle());
        eOrderTo.setShipperCode(companyMo.getCompanyCode());
        eOrderTo.setShipperName(companyMo.getCompanyName());
        eOrderTo.setShipperId(companyMo.getId());
        _log.info("添加物流订单调用电子面单的参数为: {}", eOrderTo);
        // 调用电子面单
        final EOrderRo eorder = kdNiaoSvc.eorder(eOrderTo);
        _log.info("添加物流订单调用电子面单的返回值为: {}", eorder);
        if (eorder.getResult() != EOrderResultDic.SUCCESS) {
            _log.error("添加物流订单信息调用电子面单出错，订单编号为：｛｝", mo.getOrderId());
            return kdiLogisticRo;
        } else {
            _log.info("添加物流订单信息调用电子面单成功．订单编号为：｛｝", mo.getOrderId());
            kdiLogisticRo = dozerMapper.map(eorder, ExaddKdiLogisticRo.class);
            kdiLogisticRo.setShipperCode(companyMo.getCompanyCode());
            kdiLogisticRo.setShipperName(companyMo.getCompanyName());
            return kdiLogisticRo;
        }
    }

    /**
     * 添加物流订单记录
     *
     * @param mo
     * @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int entryLogistics(final AddKdiLogisticTo mo) {
        _log.info("录入订单的参数为: {}", mo);
        if (StringUtils.isAnyBlank(mo.getLogisticCode(), mo.getEntryType().toString(), mo.getShipperCode(),
                mo.getOrderTitle(), mo.getSenderName(), mo.getSenderProvince(), mo.getSenderCity(),
                mo.getSenderExpArea(), mo.getSenderAddress(), mo.getSenderPostCode(), mo.getReceiverName(),
                mo.getReceiverProvince(), mo.getReceiverCity(), mo.getReceiverExpArea(), mo.getReceiverAddress(),
                mo.getReceiverPostCode()) || StringUtils.isAllBlank(mo.getSenderTel(), mo.getSenderMobile())
                || StringUtils.isAllBlank(mo.getReceiverTel(), mo.getReceiverMobile())) {
            _log.info("录入订单的参数不正确，参数为: {}", mo);
            return -1;
        }
        final KdiLogisticMo kdiLogisticMo = dozerMapper.map(mo, KdiLogisticMo.class);
        final CompanyRo kdiCompanyResultRo = kdiCompanySvc.getOneCompanyById(kdiLogisticMo.getShipperId());
        final Date now = new Date();
        kdiLogisticMo.setShipperName(kdiCompanyResultRo.getCompanyName());
        if (mo.getOrderId() == null) {
            kdiLogisticMo.setOrderId(_idWorker.getId());
        }
        kdiLogisticMo.setOrderTime(now);
        kdiLogisticMo.setUpdateTime(now);

        _log.info("订阅订单物流轨迹并添加物流单");
        final SubscribeTraceTo subscribeTraceTo = dozerMapper.map(kdiLogisticMo, SubscribeTraceTo.class);
        subscribeTraceTo.setLogisticId(mo.getLogisticId());
        _log.info("订阅订单物流轨迹参数为: {}", subscribeTraceTo);
        final SubscribeTraceRo subscribeTraceRo = kdiSvc.subscribeTrace(subscribeTraceTo);
        if (SubscribeTraceResultDic.SUCCESS == subscribeTraceRo.getResult()) {
            _log.info("订阅订单物流轨迹成功" + kdiLogisticMo.getOrderId());
        } else if (SubscribeTraceResultDic.PARAM_ERROR == subscribeTraceRo.getResult()) {
            _log.info("订阅订单物流轨迹参数错误" + kdiLogisticMo.getOrderId());
        } else {
            _log.info("订阅订单物流轨迹失败" + kdiLogisticMo.getOrderId());
        }
        return 1;
    }

    /**
     * 查询物流订单信息
     */
    @Override
    public PageInfo<KdiLogisticMo> kdiLogisticList(final ListKdiLogisticTo to, final int pageNum, final int pageSize) {
        _log.info("获取物流订单的参数为: {}", to);
        _log.info("kdiLogisticList: ro-{}; pageNum-{}; pageSize-{}", to, pageNum, pageSize);
        return PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(() -> _mapper.kdiLogisticList(to));
    }

    /**
     * 根据快递单号查询物流轨迹
     */
    @Override
    public List<KdiLogisticMo> kdiLogisticWx(final KdiLogisticMo mo) {
        _log.info("获取快递公司和快递单号的参数为：", mo);
        return _mapper.kdiLogisticWx(mo);
    }

    /**
     * 统计本组织一段时间内的下单量
     */
    @Override
    public List<ReportOrderCountRo> reportOrderCountInPeriod(final OrderCountReportTo to) {
        _log.info("获取物流报表参数为：", to);
        to.setOrderTimeEndDate(new Date(to.getOrderTimeEndDate().getTime() + 24 * 3600 * 1000));
        final List<ReportOrderCountRo> result = _mapper.reportOrderCountInPeriod(to);
        _log.info("获取物流报表返回值为：", result);
        return result;
    }

    /**
     * 获取打印页面
     */
    @Override
    public List<KdiLogisticMo> getPrintPageByOrderId(final KdiLogisticMo mo) {
        _log.info("获取打印页面的参数为: {}", mo);
        final List<KdiLogisticMo> result = _mapper.getPrintPageByOrderId(mo);
        _log.info("获取打印页面的结果为: {}", result);
        return result;
    }

    /**
     * 根据收件人手机号码查询收件人信息
     * 
     * @param receiverMobile
     * @return
     */
    @Override
    public KdiLogisticMo getReceiverByReceiverMobile(final String receiverMobile) {
        return _mapper.selectReceiverByReceiverMobile(receiverMobile);
    }

    /**
     * 获取组织的发单量
     */
    @Override
    public Long getDeliverCount(DeliverCountTo to) {

        // 拼接的物流状态logisticStatus
        String logisticStatus = "";
        if (to.getLogisticStatus() != null && to.getLogisticStatus().size() > 0) {
            for (int i = 0; i < to.getLogisticStatus().size(); i++) {
                if (i != 0 && i < to.getLogisticStatus().size()) {
                    logisticStatus += ",'" + to.getLogisticStatus().get(i).byteValue() + "'";
                } else {
                    logisticStatus += "'" + to.getLogisticStatus().get(i).byteValue() + "'";
                }
            }
            _log.info("查询未添加和已经添加的组织的参数为: {}", logisticStatus);
        } else {
            logisticStatus = "-9";// 设置无效状态就可以查不出数据
        }

        // 拼接的组织id
        String orgIds = "";
        if (to.getOrgIds() != null && to.getOrgIds().size() > 0) {
            for (int i = 0; i < to.getOrgIds().size(); i++) {
                if (i != 0 && i < to.getOrgIds().size()) {
                    orgIds += ",'" + to.getOrgIds().get(i).longValue() + "'";
                } else {
                    orgIds += "'" + to.getOrgIds().get(i).longValue() + "'";
                }
            }
            _log.info("查询未添加和已经添加的组织的参数为: {}", orgIds);
        } else {
            orgIds = "-9";// 设置无效组织就可以查不出数据
        }

        return _mapper.getDeliverCount(orgIds, logisticStatus, to.getOrderTimeStart(), to.getOrderTimeEnd());
    }

    /**
     * 向快递公司批量下发订单并获取快递单号和打印模板
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public KdiBatchOrderRo KdiBatchOrder(KdiBatchOrderTo to) {
        final KdiBatchOrderRo kdiBatchOrderRo = new KdiBatchOrderRo();
        List<String> batchPrint = new ArrayList<String>();
        KdiOrderMo[] kdiOrdermo = to.getReceiver();

        for (KdiOrderMo mo : kdiOrdermo) {
            // 调用快递鸟打印电子面单
            final EOrderTo eorderTo = new EOrderTo();
            eorderTo.setShipperId(to.getShipperId());
            eorderTo.setShipperCode(to.getShipperCode());
            eorderTo.setOrderId(_idWorker.getId());
            eorderTo.setOrderDetail(mo.getReceiveTitle());
            eorderTo.setOrderTitle(mo.getReceiveTitle());
            eorderTo.setReceiverName(mo.getReceivePeople());
            eorderTo.setReceiverProvince(mo.getProvince());
            eorderTo.setReceiverCity(mo.getCity());
            eorderTo.setReceiverExpArea(mo.getCount());
            eorderTo.setReceiverAddress(mo.getReceiveAddress());
            eorderTo.setReceiverPostCode("000000");
            eorderTo.setReceiverTel(mo.getReceivePhone());
            eorderTo.setReceiverMobile(mo.getReceivePhone());
            eorderTo.setSenderName(to.getSenderName());
            eorderTo.setSenderMobile(to.getSenderMobile());
            eorderTo.setSenderTel(to.getSenderTel());
            eorderTo.setSenderProvince(to.getSenderProvince());
            eorderTo.setSenderCity(to.getSenderCity());
            eorderTo.setSenderAddress(to.getSenderAddress());
            eorderTo.setSenderExpArea(to.getSenderExpArea());
            eorderTo.setSenderPostCode(to.getSenderPostCode());
            eorderTo.setOrgId(to.getOrgId());
            _log.info("调用电子面单的参数为:{}", eorderTo);
            final EOrderRo eOrderRo = kdNiaoSvc.eorder(eorderTo);
            _log.info("调用电子面单的返回值为:{}", eOrderRo);
            if (eOrderRo.getResult().getCode() == -1) {
                _log.error("调用快递电子面单出现参数错误");
                throw new RuntimeException("调用快递电子面单参数错误");
            }
            if (eOrderRo.getResult().getCode() == -2) {
                _log.error("重复调用快递电子面单");
                throw new RuntimeException("该订单已发货");
            }
            if (eOrderRo.getResult().getCode() == -3) {
                _log.error("调用快递电子面单失败");
                throw new RuntimeException("调用快递电子面单失败");
            }
            _log.info("调用快递电子面单成功，返回值为：{}", eOrderRo);
            if (eOrderRo.getFailReason() == null) {
                batchPrint.add(eOrderRo.getPrintPage());
                kdiBatchOrderRo.setMsg("批量下单并成功获取电子面单");
                kdiBatchOrderRo.setResult(EOrderResultDic.SUCCESS);
            } else {
                return kdiBatchOrderRo;
            }
        }

        // 拼接快递鸟返回的打印页面
        String printPage = "";
        if (kdiBatchOrderRo.getResult() == EOrderResultDic.SUCCESS) {
            for (int i = 0; i < batchPrint.size(); i++) {
                if (i != 0) {
                    printPage += "<br><div style=\"page-break-after:always\"></div>\n\r";
                }
                printPage += batchPrint.get(i);
            }
            kdiBatchOrderRo.setPrintPage(printPage);
        }
        return kdiBatchOrderRo;
    }

    @Override
    public Ro batchEnter(BatchEnterTo to) {
        Ro ro = new Ro();
        _log.info("获取快递公司信息");
        KdiCompanyMo compamyResult = kdiCompanySvc.getById(to.getSelectCompany().getId());
        _log.info("获取快递公司信息结果compamyResult-{}", compamyResult);
        KdiCompanyDicMo companyDicResult = kdiCompanyDicSvc.getById(compamyResult.getCompanyDicId());
        _log.info("获取快递公司字典结果companyDicResult-{}", companyDicResult);
        for (KdiLogisticMo item : to.getReceiver()) {
            final KdiLogisticMo kdiLogisticMo = dozerMapper.map(item, KdiLogisticMo.class);
            if (kdiLogisticMo.getReceiverPostCode() == null) {
                kdiLogisticMo.setReceiverPostCode("000000");
            }
            if (kdiLogisticMo.getReceiverMobile() == null && kdiLogisticMo.getReceiverTel() != null) {
                kdiLogisticMo.setReceiverMobile(kdiLogisticMo.getReceiverTel());
            }

            kdiLogisticMo.setShipperCode(companyDicResult.getCompanyCode());
            kdiLogisticMo.setShipperId(compamyResult.getId());
            kdiLogisticMo.setShipperName(companyDicResult.getCompanyName());

            kdiLogisticMo.setSenderName(to.getSelectSend().getSenderName());
            kdiLogisticMo.setSenderMobile(to.getSelectSend().getSenderMobile());
            kdiLogisticMo.setSenderProvince(to.getSelectSend().getSenderProvince());
            kdiLogisticMo.setSenderCity(to.getSelectSend().getSenderCity());
            kdiLogisticMo.setSenderExpArea(to.getSelectSend().getSenderExpArea());
            kdiLogisticMo.setSenderPostCode(to.getSelectSend().getSenderPostCode());
            kdiLogisticMo.setReceiverAddress(to.getSelectSend().getSenderAddress());
            kdiLogisticMo.setUpdateTime(new Date());
            kdiLogisticMo.setEntryType((byte) 1);
            kdiLogisticMo.setOrgId(to.getOrgId());
            kdiLogisticMo.setOrderTime(new Date());
            kdiLogisticMo.setOrderId(_idWorker.getId());
            kdiLogisticMo.setLogisticStatus("0");
            kdiLogisticMo.setOrderTime(new Date());
            kdiLogisticMo.setId(_idWorker.getId());
            _log.info("添加新的物流参数为:{}", kdiLogisticMo);
            if (super.add(kdiLogisticMo) == 1) {
                // 添加订阅任务,五分钟后执行。
                final Calendar calendar = Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.MINUTE, 5);
                final Date executePlanTime = calendar.getTime();
                KdiTaskMo kdiTaskMo = new KdiTaskMo();
                kdiTaskMo.setExecuteState((byte) TaskExecuteStateDic.NONE.getCode());
                kdiTaskMo.setTaskType((byte) KdiTaskTypeDic.SUBSCRIBE_TRACE.getCode());
                kdiTaskMo.setLogisticId(kdiLogisticMo.getId());
                kdiTaskMo.setExecutePlanTime(executePlanTime);
                _log.info("添加订阅物流的参数为:{}", kdiTaskMo);
                if (kdiTaskSvc.add(kdiTaskMo) != 1) {
                    _log.error("录入失败");
                    throw new RuntimeException("录入失败");
                }
            } else {
                _log.error("录入失败");
                throw new RuntimeException("录入失败");
            }

        }

        ro.setMsg("批量录入成功");
        ro.setResult(ResultDic.SUCCESS);
        return ro;
    }

}
