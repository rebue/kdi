package rebue.kdi.to;
import java.util.Date;
/**
 * 根据条件筛选物流订单显示结果参数
 * 
 * @author jjl
 *
 */
public class ListKdiLogisticTo {
	/**
	 * 收件人名称
	 */
	private String receiverName;
	/**
	 * 收件人电话
	 */
	private String receiverTel;
	/**
	 * 发件人名称
	 */
	private String senderName;
	/**
	 * 发件人电话
	 */
	private String senderTel;
	/**
	 * 下单时间
	 */
	private Date orderTime;
	/**
	 * 下单时间段 开始
	 */
	private String orderTimeStart;
	/**
	 * 下单时间段 结束
	 */
	private String orderTimeEnd;
	/**
	 * 物流状态
	 */
	private String logisticStatus;
	/**
	 * 物流订单号
	 */
	private String logisticCode;

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverTel() {
		return receiverTel;
	}

	public void setReceiverTel(String receiverTel) {
		this.receiverTel = receiverTel;
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
	


	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getOrderTimeStart() {
		return orderTimeStart;
	}

	public void setOrderTimeStart(String orderTimeStart) {
		this.orderTimeStart = orderTimeStart;
	}

	public String getOrderTimeEnd() {
		return orderTimeEnd;
	}

	public void setOrderTimeEnd(String orderTimeEnd) {
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

	@Override
	public String toString() {
		return "ListKdiLogisticTo [receiverName=" + receiverName + ", receiverTel=" + receiverTel + ", senderName="
				+ senderName + ", senderTel=" + senderTel + ", orderTimeStart=" + orderTimeStart + ", orderTimeEnd="
				+ orderTimeEnd + ", logisticStatus=" + logisticStatus + ", logisticCode=" + logisticCode + "]";
	}

	
}
