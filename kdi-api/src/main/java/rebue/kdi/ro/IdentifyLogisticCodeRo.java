package rebue.kdi.ro;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import rebue.kdi.dic.IdentifyLogisticCodeResultDic;

/**
 * 识别快递单号的返回结果
 */
@JsonInclude(Include.NON_NULL)
public class IdentifyLogisticCodeRo {

    /**
     * 返回结果
     */
    private IdentifyLogisticCodeResultDic result;

    /**
     * 失败原因
     */
    private String                     failReason;

    /**
     * 快递公司列表
     */
    private List<ShipperRo>            shippers;

    public IdentifyLogisticCodeResultDic getResult() {
        return result;
    }

    public void setResult(IdentifyLogisticCodeResultDic result) {
        this.result = result;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    public List<ShipperRo> getShippers() {
        return shippers;
    }

    public void setShippers(List<ShipperRo> shippers) {
        this.shippers = shippers;
    }

    @Override
    public String toString() {
        return "IdentifyLogisticCodeRo [result=" + result + ", failReason=" + failReason + ", shippers=" + shippers + "]";
    }

}
