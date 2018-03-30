package rebue.kdi.ro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import rebue.kdi.dic.SubscribeTraceResultDic;

/**
 * 订阅物流轨迹接口的返回值类型
 * 
 * @author zbz
 *
 */
@JsonInclude(Include.NON_NULL)
public class SubscribeTraceRo {
    /**
     * 返回结果
     */
    private SubscribeTraceResultDic result;

    /**
     * 失败原因
     */
    private String                  failReason;

    public SubscribeTraceResultDic getResult() {
        return result;
    }

    public void setResult(SubscribeTraceResultDic result) {
        this.result = result;
    }

    public String getFailReason() {
        return failReason;
    }

    public void setFailReason(String failReason) {
        this.failReason = failReason;
    }

    @Override
    public String toString() {
        return "SubscribeTraceRo [result=" + result + ", failReason=" + failReason + "]";
    }

}
