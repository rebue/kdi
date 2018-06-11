package rebue.kdi.to;

/**
 * 添加物流订单请求参数
 * 
 * @author lbl
 *
 */
public class AddKdiLogisticTo {

	/**
	 * 订单标题
	 */
	private String orderTitle;

	/**
	 * 订单详情
	 */
	private String orderDetail;

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

	@Override
	public String toString() {
		return "AddKdiLogisticTo [orderTitle=" + orderTitle + ", orderDetail=" + orderDetail + ", receiverName="
				+ receiverName + ", receiverTel=" + receiverTel + ", receiverMobile=" + receiverMobile
				+ ", receiverProvince=" + receiverProvince + ", receiverCity=" + receiverCity + ", receiverExpArea="
				+ receiverExpArea + ", receiverAddress=" + receiverAddress + ", receiverPostCode=" + receiverPostCode
				+ ", companyCode=" + companyCode + ", senderId=" + senderId + "]";
	}

}
