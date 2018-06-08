package rebue.kdi.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Database Table Remarks:
 *   物流轨迹
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table KDI_TRACE
 *
 * @mbg.generated do_not_delete_during_merge 2018-06-08 09:50:07
 */
@ApiModel(value = "KdiTraceMo", description = "物流轨迹")
@JsonInclude(Include.NON_NULL)
public class KdiTraceMo implements Serializable {
    /**
     * Database Column Remarks:
     *   物流轨迹ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_TRACE.ID
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @ApiModelProperty(value = "物流轨迹ID")
    private Long id;

    /**
     * Database Column Remarks:
     *   物流ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_TRACE.LOGISTIC_ID
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @ApiModelProperty(value = "物流ID")
    private Long logisticId;

    /**
     * Database Column Remarks:
     *   轨迹描述
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_TRACE.TRACE_DESC
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @ApiModelProperty(value = "轨迹描述")
    private String traceDesc;

    /**
     * Database Column Remarks:
     *   发生时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_TRACE.HAPPEN_TIME
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @ApiModelProperty(value = "发生时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date happenTime;

    /**
     * Database Column Remarks:
     *   物流状态
     *               1-已揽收
     *               2-在途中 201-到达派件城市 202-派件中 211-已放入快递柜或 驿站
     *               3-已签收 311-已取出快递柜或 驿站
     *               4-问题件 401-发货无信息 402-超时未签收 403-超时未更新 404-拒收(退件) 412-快递柜或驿站超 时未取
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_TRACE.LOGISTIC_STATUS
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @ApiModelProperty(value = "物流状态\n"
             +"            1-已揽收\n"
             +"            2-在途中 201-到达派件城市 202-派件中 211-已放入快递柜或 驿站\n"
             +"            3-已签收 311-已取出快递柜或 驿站\n"
             +"            4-问题件 401-发货无信息 402-超时未签收 403-超时未更新 404-拒收(退件) 412-快递柜或驿站超 时未取")
    private String logisticStatus;

    /**
     * Database Column Remarks:
     *   所在城市
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column KDI_TRACE.CITY
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @ApiModelProperty(value = "所在城市")
    private String city;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table KDI_TRACE
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_TRACE.ID
     *
     * @return the value of KDI_TRACE.ID
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_TRACE.ID
     *
     * @param id the value for KDI_TRACE.ID
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_TRACE.LOGISTIC_ID
     *
     * @return the value of KDI_TRACE.LOGISTIC_ID
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public Long getLogisticId() {
        return logisticId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_TRACE.LOGISTIC_ID
     *
     * @param logisticId the value for KDI_TRACE.LOGISTIC_ID
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public void setLogisticId(Long logisticId) {
        this.logisticId = logisticId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_TRACE.TRACE_DESC
     *
     * @return the value of KDI_TRACE.TRACE_DESC
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public String getTraceDesc() {
        return traceDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_TRACE.TRACE_DESC
     *
     * @param traceDesc the value for KDI_TRACE.TRACE_DESC
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public void setTraceDesc(String traceDesc) {
        this.traceDesc = traceDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_TRACE.HAPPEN_TIME
     *
     * @return the value of KDI_TRACE.HAPPEN_TIME
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public Date getHappenTime() {
        return happenTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_TRACE.HAPPEN_TIME
     *
     * @param happenTime the value for KDI_TRACE.HAPPEN_TIME
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public void setHappenTime(Date happenTime) {
        this.happenTime = happenTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_TRACE.LOGISTIC_STATUS
     *
     * @return the value of KDI_TRACE.LOGISTIC_STATUS
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public String getLogisticStatus() {
        return logisticStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_TRACE.LOGISTIC_STATUS
     *
     * @param logisticStatus the value for KDI_TRACE.LOGISTIC_STATUS
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public void setLogisticStatus(String logisticStatus) {
        this.logisticStatus = logisticStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column KDI_TRACE.CITY
     *
     * @return the value of KDI_TRACE.CITY
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column KDI_TRACE.CITY
     *
     * @param city the value for KDI_TRACE.CITY
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_TRACE
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", logisticId=").append(logisticId);
        sb.append(", traceDesc=").append(traceDesc);
        sb.append(", happenTime=").append(happenTime);
        sb.append(", logisticStatus=").append(logisticStatus);
        sb.append(", city=").append(city);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_TRACE
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        KdiTraceMo other = (KdiTraceMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_TRACE
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}