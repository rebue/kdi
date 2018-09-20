package rebue.kdi.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 物流轨迹
 *
 * 数据库表: KDI_TRACE
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class KdiTraceMo implements Serializable {

    /**
     *    物流轨迹ID
     *
     *    数据库字段: KDI_TRACE.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    物流ID
     *
     *    数据库字段: KDI_TRACE.LOGISTIC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long logisticId;

    /**
     *    轨迹描述
     *
     *    数据库字段: KDI_TRACE.TRACE_DESC
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String traceDesc;

    /**
     *    发生时间
     *
     *    数据库字段: KDI_TRACE.HAPPEN_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date happenTime;

    /**
     *    物流状态
     *                1-已揽收
     *                2-在途中 201-到达派件城市 202-派件中 211-已放入快递柜或 驿站
     *                3-已签收 311-已取出快递柜或 驿站
     *                4-问题件 401-发货无信息 402-超时未签收 403-超时未更新 404-拒收(退件) 412-快递柜或驿站超 时未取
     *
     *    数据库字段: KDI_TRACE.LOGISTIC_STATUS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String logisticStatus;

    /**
     *    所在城市
     *
     *    数据库字段: KDI_TRACE.CITY
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String city;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    物流轨迹ID
     *
     *    数据库字段: KDI_TRACE.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    物流轨迹ID
     *
     *    数据库字段: KDI_TRACE.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    物流ID
     *
     *    数据库字段: KDI_TRACE.LOGISTIC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getLogisticId() {
        return logisticId;
    }

    /**
     *    物流ID
     *
     *    数据库字段: KDI_TRACE.LOGISTIC_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setLogisticId(Long logisticId) {
        this.logisticId = logisticId;
    }

    /**
     *    轨迹描述
     *
     *    数据库字段: KDI_TRACE.TRACE_DESC
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getTraceDesc() {
        return traceDesc;
    }

    /**
     *    轨迹描述
     *
     *    数据库字段: KDI_TRACE.TRACE_DESC
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setTraceDesc(String traceDesc) {
        this.traceDesc = traceDesc;
    }

    /**
     *    发生时间
     *
     *    数据库字段: KDI_TRACE.HAPPEN_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Date getHappenTime() {
        return happenTime;
    }

    /**
     *    发生时间
     *
     *    数据库字段: KDI_TRACE.HAPPEN_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setHappenTime(Date happenTime) {
        this.happenTime = happenTime;
    }

    /**
     *    物流状态
     *                1-已揽收
     *                2-在途中 201-到达派件城市 202-派件中 211-已放入快递柜或 驿站
     *                3-已签收 311-已取出快递柜或 驿站
     *                4-问题件 401-发货无信息 402-超时未签收 403-超时未更新 404-拒收(退件) 412-快递柜或驿站超 时未取
     *
     *    数据库字段: KDI_TRACE.LOGISTIC_STATUS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getLogisticStatus() {
        return logisticStatus;
    }

    /**
     *    物流状态
     *                1-已揽收
     *                2-在途中 201-到达派件城市 202-派件中 211-已放入快递柜或 驿站
     *                3-已签收 311-已取出快递柜或 驿站
     *                4-问题件 401-发货无信息 402-超时未签收 403-超时未更新 404-拒收(退件) 412-快递柜或驿站超 时未取
     *
     *    数据库字段: KDI_TRACE.LOGISTIC_STATUS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setLogisticStatus(String logisticStatus) {
        this.logisticStatus = logisticStatus;
    }

    /**
     *    所在城市
     *
     *    数据库字段: KDI_TRACE.CITY
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getCity() {
        return city;
    }

    /**
     *    所在城市
     *
     *    数据库字段: KDI_TRACE.CITY
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
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
     *    @mbg.generated 自动生成，如需修改，请删除本行
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
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}
