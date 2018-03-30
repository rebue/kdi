package rebue.kdi.to;

/**
 * 电子面单接口的参数类型
 * 
 * @author zbz
 *
 */
public class EOrderTo {
    /**
     * 快递公司编码
     */
    private String shipperCode;
    /**
     * 运费支付方式: 1-现付，2-到付，3-月结，4-第三方付
     */
    private Byte   payType;
    /**
     * 快递类型:1-标准快件
     * 其余详细快递类型参考《快递公司快递业务类型.xlsx》
     */
    private Byte   expType;
    /**
     * 订单ID
     */
    private Long   orderId;
    /**
     * 订单标题
     */
    private String orderTitle;
    /**
     * 订单备注
     */
    private String orderRemark;
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
     * (如广东省，不要缺少“省”; 如是直辖市，请直接传北京、上海等; 如是自治区，请直接传广西壮族自治区等)
     */
    private String senderProvince;
    /**
     * 发件市
     * (如深圳市，不要缺少“市”)
     */
    private String senderCity;
    /**
     * 发件区/县
     * (如福田区，不要缺少“区”或“县”)
     */
    private String senderExpArea;
    /**
     * 发件人详细地址
     */
    private String senderAddress;
    /**
     * 发件地邮编
     * (为 EMS、YZPY时必填)
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
     * 收件省
     * (如广东省，不要缺少“省”; 如是直辖市，请直接传北京、上海等; 如是自治区，请直接传广西壮族自治区等)
     */
    private String receiverProvince;
    /**
     * 收件市
     * (如深圳市，不要缺少“市”)
     */
    private String receiverCity;
    /**
     * 收件区/县
     * (如福田区，不要缺少“区”或“县”)
     */
    private String receiverExpArea;
    /**
     * 收件人详细地址
     */
    private String receiverAddress;
    /**
     * 收件地邮编
     * (为 EMS、YZPY时必填)
     */
    private String receiverPostCode;

    public String getShipperCode() {
        return shipperCode;
    }

    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public Byte getExpType() {
        return expType;
    }

    public void setExpType(Byte expType) {
        this.expType = expType;
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

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
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

    @Override
    public String toString() {
        return "EOrderTo [shipperCode=" + shipperCode + ", payType=" + payType + ", expType=" + expType + ", orderId=" + orderId + ", orderTitle=" + orderTitle + ", orderRemark="
                + orderRemark + ", senderName=" + senderName + ", senderTel=" + senderTel + ", senderMobile=" + senderMobile + ", senderProvince=" + senderProvince
                + ", senderCity=" + senderCity + ", senderExpArea=" + senderExpArea + ", senderAddress=" + senderAddress + ", senderPostCode=" + senderPostCode + ", receiverName="
                + receiverName + ", receiverTel=" + receiverTel + ", receiverMobile=" + receiverMobile + ", receiverProvince=" + receiverProvince + ", receiverCity=" + receiverCity
                + ", receiverExpArea=" + receiverExpArea + ", receiverAddress=" + receiverAddress + ", receiverPostCode=" + receiverPostCode + "]";
    }

}
