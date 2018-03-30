package rebue.kdi.ro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import rebue.kdi.dic.EOrderResultDic;

/**
 * 电子面单接口的返回值类型
 * 
 * @author zbz
 *
 */
@JsonInclude(Include.NON_NULL)
public class EOrderRo {
    /**
     * 返回结果
     */
    private EOrderResultDic result;

    /**
     * 物流订单ID
     * (下单成功才会返回)
     */
    private Long            logisticId;
    /**
     * 快递单号
     * (下单成功才会返回)
     */
    private String          logisticCode;

    /**
     * 打印页面
     * (下单成功才会返回)
     */
    private String          printPage;

    /**
     * 失败原因
     * (下单失败才会返回)
     */
    private String          failReason;

    public EOrderResultDic getResult() {
        return result;
    }

    public void setResult(EOrderResultDic result) {
        this.result = result;
    }

    public Long getLogisticId() {
        return logisticId;
    }

    public void setLogisticId(Long logisticId) {
        this.logisticId = logisticId;
    }

    public String getLogisticCode() {
        return logisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }

    public String getPrintPage() {
        return printPage;
    }

    public void setPrintPage(String printPage) {
        this.printPage = printPage;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    @Override
    public String toString() {
        return "EOrderRo [result=" + result + ", logisticId=" + logisticId + ", logisticCode=" + logisticCode
                + ", printPage=" + printPage + ", failReason=" + failReason + "]";
    }

}
