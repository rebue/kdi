package rebue.kdi.kdniao.ro;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 识别快递单号的返回结果
 */
@JsonInclude(Include.NON_NULL)
public class KdNiaoUpdateTraceRo {
    /**
     * 用户ID
     */
    private String  EBusinessID;

    /**
     * 更新时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date    updateTime;

    /**
     * 成功与否(true/false)
     */
    private Boolean success;

    /**
     * 失败原因
     */
    private String  reason;

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String eBusinessID) {
        EBusinessID = eBusinessID;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "KdNiaoUpdateTraceRo [EBusinessID=" + EBusinessID + ", updateTime=" + updateTime + ", success=" + success
                + ", reason=" + reason + "]";
    }

}
