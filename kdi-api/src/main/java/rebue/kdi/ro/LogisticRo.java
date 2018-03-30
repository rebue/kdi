package rebue.kdi.ro;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 识别快递单号的返回结果
 */
@JsonInclude(Include.NON_NULL)
public class LogisticRo {

    /**
     * 物流订单ID
     */
    private Long          id;

    /**
     * 物流状态
     * 1-已揽收
     * 2-在途中 201-到达派件城市 202-派件中 211-已放入快递柜或 驿站
     * 3-已签收 311-已取出快递柜或 驿站
     * 4-问题件 401-发货无信息 402-超时未签收 403-超时未更新 404-拒收(退件) 412-快递柜或驿站超 时未取
     */
    private String        logisticStatus;

    /**
     * 更新时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date          updateTime;

    /**
     * 预计到达时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date          estimatedArrivalTime;

    /**
     * 所在城市
     */
    private String        city;

    private List<TraceRo> traces;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogisticStatus() {
        return logisticStatus;
    }

    public void setLogisticStatus(String logisticStatus) {
        this.logisticStatus = logisticStatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    public void setEstimatedArrivalTime(Date estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<TraceRo> getTraces() {
        return traces;
    }

    public void setTraces(List<TraceRo> traces) {
        this.traces = traces;
    }

    @Override
    public String toString() {
        return "LogisticRo [id=" + id + ", logisticStatus=" + logisticStatus + ", updateTime=" + updateTime
                + ", estimatedArrivalTime=" + estimatedArrivalTime + ", city=" + city + ", traces=" + traces + "]";
    }

}
