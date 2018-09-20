package rebue.kdi.svc;

import com.github.pagehelper.PageInfo;
import java.util.List;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.ro.ExaddKdiLogisticRo;
import rebue.kdi.ro.LogisticReportRo;
import rebue.kdi.to.AddKdiLogisticTo;
import rebue.kdi.to.ListKdiLogisticTo;
import rebue.robotech.svc.MybatisBaseSvc;

public interface KdiLogisticSvc extends MybatisBaseSvc<KdiLogisticMo, java.lang.Long> {

    /**
     * 获取新的ID
     */
    Long getNewId();

    /**
     *  获取物流订单
     *  @param to
     *  @return
     */
    PageInfo<KdiLogisticMo> kdiLogisticList(ListKdiLogisticTo to, int pageNum, int pageSize);

    /**
     *  录入订单
     *  @param mo
     *  @return
     */
    int entryLogistics(AddKdiLogisticTo mo);

    /**
     *  后台调用电子面单接口
     *  @param mo
     *  @return
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
     *  根据微信端的参数获取快递公司和快递单号
     *  @param mo
     *  @return
     */
    List<KdiLogisticMo> kdiLogisticWx(KdiLogisticMo mo);

    /**
     *  查询两个时间段之间的发单量
     *  @param to
     *  @return
     */
    List<LogisticReportRo> listLogisticsReport(ListKdiLogisticTo to);

    /**
     *  获取打印页面
     *  @param mo
     *  @return
     */
    List<KdiLogisticMo> getPrintPageByOrderId(KdiLogisticMo mo);
}
