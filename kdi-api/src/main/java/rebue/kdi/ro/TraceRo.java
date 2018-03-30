package rebue.kdi.ro;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TraceRo {

    /**
     * 物流轨迹ID
     */
    private Long   id;

    /**
     * 轨迹描述
     */
    private String traceDesc;

    /**
     * 发生时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date   happenTime;

    /**
     * 物流状态
     * 1-已揽收
     * 2-在途中 201-到达派件城市 202-派件中 211-已放入快递柜或 驿站
     * 3-已签收 311-已取出快递柜或 驿站
     * 4-问题件 401-发货无信息 402-超时未签收 403-超时未更新 404-拒收(退件) 412-快递柜或驿站超 时未取
     */
    private String logisticStatus;

    /**
     * 所在城市
     */
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTraceDesc() {
        return traceDesc;
    }

    public void setTraceDesc(String traceDesc) {
        this.traceDesc = traceDesc;
    }

    public Date getHappenTime() {
        return happenTime;
    }

    public void setHappenTime(Date happenTime) {
        this.happenTime = happenTime;
    }

    public String getLogisticStatus() {
        return logisticStatus;
    }

    public void setLogisticStatus(String logisticStatus) {
        this.logisticStatus = logisticStatus;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "TraceRo [id=" + id + ", traceDesc=" + traceDesc + ", happenTime=" + happenTime + ", logisticStatus="
                + logisticStatus + ", city=" + city + "]";
    }

}
