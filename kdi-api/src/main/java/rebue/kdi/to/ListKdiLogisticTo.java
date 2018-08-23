package rebue.kdi.to;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 根据条件筛选物流订单显示结果参数
 * 
 * @author jjl
 *
 */
@ApiModel(value = "ListKdiLogisticTo", description = "物流信息信息")
@JsonInclude(Include.NON_NULL)
public class ListKdiLogisticTo implements Serializable {
	

	/**
	 * 收件人名称
	 */
	private String receiverName;
	/**
	 * 收件人手机
	 */
	private String receiverMobile;
	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	/**
	 * 发件人名称
	 */
	private String senderName;
	/**
	 * 发件人电话
	 */
	private String senderTel;

	/**
	 * 下单时间段 开始
	 */
    @ApiModelProperty(value = "申请时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date orderTimeStart;
	/**
	 * 下单时间段 结束
	 */
    @ApiModelProperty(value = "申请时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date orderTimeEnd;
	/**
	 * 物流状态
	 */
	private String logisticStatus;
	/**
	 * 物流订单号
	 */
	private String logisticCode;
	
	/**
	 * 组织ID
	 */
    @ApiModelProperty(value = "组织id")
	private Long organizeId;
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}



	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderTel() {
		return senderTel;
	}

	public void setSenderTel(String senderTel) {
		this.senderTel = senderTel;
	}
	


	

	public Date getOrderTimeStart() {
		return orderTimeStart;
	}

	public void setOrderTimeStart(Date orderTimeStart) {
		this.orderTimeStart = orderTimeStart;
	}

	public Date getOrderTimeEnd() {
		return orderTimeEnd;
	}

	public void setOrderTimeEnd(Date orderTimeEnd) {
		this.orderTimeEnd = orderTimeEnd;
	}

	public String getLogisticCode() {
		return logisticCode;
	}

	public void setLogisticCode(String logisticCode) {
		this.logisticCode = logisticCode;
	}

	public String getLogisticStatus() {
		return logisticStatus;
	}

	public void setLogisticStatus(String logisticStatus) {
		this.logisticStatus = logisticStatus;
	}



	public Long getOrganizeId() {
		return organizeId;
	}

	public void setOrganizeId(Long organizeId) {
		this.organizeId = organizeId;
	}
	
    private static final long serialVersionUID = 1L;


	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", receiverName=").append(receiverName);
        sb.append(", receiverMobile=").append(receiverMobile);
        sb.append(", senderName=").append(senderName);
        sb.append(", senderTel=").append(senderTel);
        sb.append(", organizeId=").append(organizeId);
        sb.append(", orderTimeStart=").append(orderTimeStart);
        sb.append(", orderTimeEnd=").append(orderTimeEnd);
        sb.append(", logisticStatus=").append(logisticStatus);
        sb.append(", logisticCode=").append(logisticCode);
        sb.append(", organizeId=").append(organizeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }


	
}
