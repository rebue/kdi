package rebue.kdi.to;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 添加物流订单请求参数
 * 
 * @author lbl
 *
 */
public class AddKdiLogisticTo {

	/**
	 * 快递公司编码
	 */
	private String shipperCode;

	/**
	 * 快递公司ID
	 */
	private Long shipperId;

	/**
	 * 快递公司名称
	 */
	private String shipperName;

	/**
	 * 物流订单号
	 */
	private String logisticCode;

	/**
	 * 下单时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date orderTime;

	/**
	 * 更新时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;

	/**
	 * 订单ID
	 */
	private Long orderId;

	/**
	 * 订单标题
	 */
	private String orderTitle;

	/**
	 * 订单详情
	 */
	private String orderDetail;

	/**
	 * 发件人名称
	 */
	private String senderName;

	/**
	 * 发件人电话
	 */
	private String senderTel;

	/**
	 * 发件人手机
	 */
	private String senderMobile;

	/**
	 * 发件省
	 */
	private String senderProvince;

	/**
	 * 发件市
	 */
	private String senderCity;

	/**
	 * 发件区
	 */
	private String senderExpArea;

	/**
	 * 发件人详细地址
	 */
	private String senderAddress;

	/**
	 * 发件地邮编
	 */
	private String senderPostCode;

	/**
	 * 收件人名称
	 */
	private String receiverName;

	/**
	 * 收件人电话
	 */
	private String receiverTel;

	/**
	 * 收件人手机
	 */
	private String receiverMobile;

	/**
	 * 收件省份
	 */
	private String receiverProvince;

	/**
	 * 收件城市
	 */
	private String receiverCity;

	/**
	 * 收件区县
	 */
	private String receiverExpArea;

	/**
	 * 收件详细地址
	 */
	private String receiverAddress;

	/**
	 * 收件地址邮编
	 */
	private String receiverPostCode;

	/**
	 * 快递公司编码
	 */
	private String companyCode;

	/**
	 * 发件人ID
	 */
	private Long senderId;
	
	/**
	 * 组织ID
	 */
	private Long orgId;
	

	public String getShipperCode() {
		return shipperCode;
	}

	public void setShipperCode(String shipperCode) {
		this.shipperCode = shipperCode;
	}

	public Long getShipperId() {
		return shipperId;
	}

	public void setShipperId(Long shipperId) {
		this.shipperId = shipperId;
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public String getLogisticCode() {
		return logisticCode;
	}

	public void setLogisticCode(String logisticCode) {
		this.logisticCode = logisticCode;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderTitle() {
		return orderTitle;
	}

	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
	}

	public String getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(String orderDetail) {
		this.orderDetail = orderDetail;
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

	public String getSenderMobile() {
		return senderMobile;
	}

	public void setSenderMobile(String senderMobile) {
		this.senderMobile = senderMobile;
	}

	public String getSenderProvince() {
		return senderProvince;
	}

	public void setSenderProvince(String senderProvince) {
		this.senderProvince = senderProvince;
	}

	public String getSenderCity() {
		return senderCity;
	}

	public void setSenderCity(String senderCity) {
		this.senderCity = senderCity;
	}

	public String getSenderExpArea() {
		return senderExpArea;
	}

	public void setSenderExpArea(String senderExpArea) {
		this.senderExpArea = senderExpArea;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSenderPostCode() {
		return senderPostCode;
	}

	public void setSenderPostCode(String senderPostCode) {
		this.senderPostCode = senderPostCode;
	}

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

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getReceiverProvince() {
		return receiverProvince;
	}

	public void setReceiverProvince(String receiverProvince) {
		this.receiverProvince = receiverProvince;
	}

	public String getReceiverCity() {
		return receiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	public String getReceiverExpArea() {
		return receiverExpArea;
	}

	public void setReceiverExpArea(String receiverExpArea) {
		this.receiverExpArea = receiverExpArea;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getReceiverPostCode() {
		return receiverPostCode;
	}

	public void setReceiverPostCode(String receiverPostCode) {
		this.receiverPostCode = receiverPostCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	
	@Override
	public String toString() {
		return "AddKdiLogisticTo [shipperCode=" + shipperCode + ", shipperId=" + shipperId + ", shipperName="
				+ shipperName + ", logisticCode=" + logisticCode + ", orderTime=" + orderTime + ", updateTime="
				+ updateTime + ", orderId=" + orderId + ", orderTitle=" + orderTitle + ", orderDetail=" + orderDetail
				+ ", senderName=" + senderName + ", senderTel=" + senderTel + ", senderMobile=" + senderMobile
				+ ", senderProvince=" + senderProvince + ", senderCity=" + senderCity + ", senderExpArea="
				+ senderExpArea + ", senderAddress=" + senderAddress + ", senderPostCode=" + senderPostCode
				+ ", receiverName=" + receiverName + ", receiverTel=" + receiverTel + ", receiverMobile="
				+ receiverMobile + ", receiverProvince=" + receiverProvince + ", receiverCity=" + receiverCity
				+ ", receiverExpArea=" + receiverExpArea + ", receiverAddress=" + receiverAddress
				+ ", receiverPostCode=" + receiverPostCode + ", companyCode=" + companyCode + ", senderId=" + senderId+ ", orgId=" + orgId
				+ "]";
	}



}
