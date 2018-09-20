package rebue.kdi.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 物流订单
 *
 * 数据库表: KDI_LOGISTIC
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class KdiLogisticMo implements Serializable {

    /**
     *    物流订单ID
     *
     *    数据库字段: KDI_LOGISTIC.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    快递公司ID
     *
     *    数据库字段: KDI_LOGISTIC.SHIPPER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long shipperId;

    /**
     *    快递公司编码
     *
     *    数据库字段: KDI_LOGISTIC.SHIPPER_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String shipperCode;

    /**
     *    快递公司名称
     *
     *    数据库字段: KDI_LOGISTIC.SHIPPER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String shipperName;

    /**
     *    物流订单号
     *
     *    数据库字段: KDI_LOGISTIC.LOGISTIC_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String logisticCode;

    /**
     *    物流订单状态
     *                0-无轨迹
     *                1-已揽收
     *                2-在途中 201-到达派件城市 202-派件中 211-已放入快递柜或驿站
     *                3-已签收 311-已取出快递柜或驿站
     *                4-问题件 401-发货无信息 402-超时未签收 403-超时未更新 404-拒收(退件) 412-快递柜或驿站超时未取
     *
     *    数据库字段: KDI_LOGISTIC.LOGISTIC_STATUS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String logisticStatus;

    /**
     *    下单时间
     *
     *    数据库字段: KDI_LOGISTIC.ORDER_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderTime;

    /**
     *    更新时间
     *
     *    数据库字段: KDI_LOGISTIC.UPDATE_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     *    预计到达时间
     *
     *    数据库字段: KDI_LOGISTIC.ESTIMATED_ARRIVAL_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date estimatedArrivalTime;

    /**
     *    所在城市
     *
     *    数据库字段: KDI_LOGISTIC.CITY
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String city;

    /**
     *    支付类型
     *                运费支付方式:
     *                1-现付
     *                2-到付
     *                3-月结
     *                4-第三方付
     *
     *    数据库字段: KDI_LOGISTIC.PAY_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte payType;

    /**
     *    快递类型
     *                1-标准快件
     *
     *                详细快递类型参考《快递公司快递业务类型.xlsx》
     *
     *    数据库字段: KDI_LOGISTIC.EXP_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte expType;

    /**
     *    订单ID
     *
     *    数据库字段: KDI_LOGISTIC.ORDER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long orderId;

    /**
     *    订单标题
     *
     *    数据库字段: KDI_LOGISTIC.ORDER_TITLE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String orderTitle;

    /**
     *    订单详情
     *
     *    数据库字段: KDI_LOGISTIC.ORDER_DETAIL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String orderDetail;

    /**
     *    发件人名称
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderName;

    /**
     *    发件人电话
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_TEL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderTel;

    /**
     *    发件人手机
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_MOBILE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderMobile;

    /**
     *    发件省
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_PROVINCE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderProvince;

    /**
     *    发件市
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_CITY
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderCity;

    /**
     *    发件区
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_EXP_AREA
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderExpArea;

    /**
     *    发件人详细地址
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_ADDRESS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderAddress;

    /**
     *    发件地邮编
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_POST_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String senderPostCode;

    /**
     *    收件人名称
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String receiverName;

    /**
     *    收件人电话
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_TEL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String receiverTel;

    /**
     *    收件人手机
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_MOBILE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String receiverMobile;

    /**
     *    收件省
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_PROVINCE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String receiverProvince;

    /**
     *    收件市
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_CITY
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String receiverCity;

    /**
     *    收件区
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_EXP_AREA
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String receiverExpArea;

    /**
     *    收件人详细地址
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_ADDRESS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String receiverAddress;

    /**
     *    收件地邮编
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_POST_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String receiverPostCode;

    /**
     *    组织id
     *
     *    数据库字段: KDI_LOGISTIC.ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long orgId;

    /**
     *    打印页面
     *
     *    数据库字段: KDI_LOGISTIC.PRINT_PAGE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String printPage;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    物流订单ID
     *
     *    数据库字段: KDI_LOGISTIC.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    物流订单ID
     *
     *    数据库字段: KDI_LOGISTIC.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    快递公司ID
     *
     *    数据库字段: KDI_LOGISTIC.SHIPPER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getShipperId() {
        return shipperId;
    }

    /**
     *    快递公司ID
     *
     *    数据库字段: KDI_LOGISTIC.SHIPPER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setShipperId(Long shipperId) {
        this.shipperId = shipperId;
    }

    /**
     *    快递公司编码
     *
     *    数据库字段: KDI_LOGISTIC.SHIPPER_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getShipperCode() {
        return shipperCode;
    }

    /**
     *    快递公司编码
     *
     *    数据库字段: KDI_LOGISTIC.SHIPPER_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setShipperCode(String shipperCode) {
        this.shipperCode = shipperCode;
    }

    /**
     *    快递公司名称
     *
     *    数据库字段: KDI_LOGISTIC.SHIPPER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getShipperName() {
        return shipperName;
    }

    /**
     *    快递公司名称
     *
     *    数据库字段: KDI_LOGISTIC.SHIPPER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setShipperName(String shipperName) {
        this.shipperName = shipperName;
    }

    /**
     *    物流订单号
     *
     *    数据库字段: KDI_LOGISTIC.LOGISTIC_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getLogisticCode() {
        return logisticCode;
    }

    /**
     *    物流订单号
     *
     *    数据库字段: KDI_LOGISTIC.LOGISTIC_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setLogisticCode(String logisticCode) {
        this.logisticCode = logisticCode;
    }

    /**
     *    物流订单状态
     *                0-无轨迹
     *                1-已揽收
     *                2-在途中 201-到达派件城市 202-派件中 211-已放入快递柜或驿站
     *                3-已签收 311-已取出快递柜或驿站
     *                4-问题件 401-发货无信息 402-超时未签收 403-超时未更新 404-拒收(退件) 412-快递柜或驿站超时未取
     *
     *    数据库字段: KDI_LOGISTIC.LOGISTIC_STATUS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getLogisticStatus() {
        return logisticStatus;
    }

    /**
     *    物流订单状态
     *                0-无轨迹
     *                1-已揽收
     *                2-在途中 201-到达派件城市 202-派件中 211-已放入快递柜或驿站
     *                3-已签收 311-已取出快递柜或驿站
     *                4-问题件 401-发货无信息 402-超时未签收 403-超时未更新 404-拒收(退件) 412-快递柜或驿站超时未取
     *
     *    数据库字段: KDI_LOGISTIC.LOGISTIC_STATUS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setLogisticStatus(String logisticStatus) {
        this.logisticStatus = logisticStatus;
    }

    /**
     *    下单时间
     *
     *    数据库字段: KDI_LOGISTIC.ORDER_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     *    下单时间
     *
     *    数据库字段: KDI_LOGISTIC.ORDER_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     *    更新时间
     *
     *    数据库字段: KDI_LOGISTIC.UPDATE_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *    更新时间
     *
     *    数据库字段: KDI_LOGISTIC.UPDATE_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     *    预计到达时间
     *
     *    数据库字段: KDI_LOGISTIC.ESTIMATED_ARRIVAL_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Date getEstimatedArrivalTime() {
        return estimatedArrivalTime;
    }

    /**
     *    预计到达时间
     *
     *    数据库字段: KDI_LOGISTIC.ESTIMATED_ARRIVAL_TIME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setEstimatedArrivalTime(Date estimatedArrivalTime) {
        this.estimatedArrivalTime = estimatedArrivalTime;
    }

    /**
     *    所在城市
     *
     *    数据库字段: KDI_LOGISTIC.CITY
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getCity() {
        return city;
    }

    /**
     *    所在城市
     *
     *    数据库字段: KDI_LOGISTIC.CITY
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *    支付类型
     *                运费支付方式:
     *                1-现付
     *                2-到付
     *                3-月结
     *                4-第三方付
     *
     *    数据库字段: KDI_LOGISTIC.PAY_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Byte getPayType() {
        return payType;
    }

    /**
     *    支付类型
     *                运费支付方式:
     *                1-现付
     *                2-到付
     *                3-月结
     *                4-第三方付
     *
     *    数据库字段: KDI_LOGISTIC.PAY_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    /**
     *    快递类型
     *                1-标准快件
     *
     *                详细快递类型参考《快递公司快递业务类型.xlsx》
     *
     *    数据库字段: KDI_LOGISTIC.EXP_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Byte getExpType() {
        return expType;
    }

    /**
     *    快递类型
     *                1-标准快件
     *
     *                详细快递类型参考《快递公司快递业务类型.xlsx》
     *
     *    数据库字段: KDI_LOGISTIC.EXP_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setExpType(Byte expType) {
        this.expType = expType;
    }

    /**
     *    订单ID
     *
     *    数据库字段: KDI_LOGISTIC.ORDER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     *    订单ID
     *
     *    数据库字段: KDI_LOGISTIC.ORDER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     *    订单标题
     *
     *    数据库字段: KDI_LOGISTIC.ORDER_TITLE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getOrderTitle() {
        return orderTitle;
    }

    /**
     *    订单标题
     *
     *    数据库字段: KDI_LOGISTIC.ORDER_TITLE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle;
    }

    /**
     *    订单详情
     *
     *    数据库字段: KDI_LOGISTIC.ORDER_DETAIL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getOrderDetail() {
        return orderDetail;
    }

    /**
     *    订单详情
     *
     *    数据库字段: KDI_LOGISTIC.ORDER_DETAIL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    /**
     *    发件人名称
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     *    发件人名称
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    /**
     *    发件人电话
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_TEL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderTel() {
        return senderTel;
    }

    /**
     *    发件人电话
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_TEL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderTel(String senderTel) {
        this.senderTel = senderTel;
    }

    /**
     *    发件人手机
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_MOBILE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderMobile() {
        return senderMobile;
    }

    /**
     *    发件人手机
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_MOBILE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderMobile(String senderMobile) {
        this.senderMobile = senderMobile;
    }

    /**
     *    发件省
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_PROVINCE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderProvince() {
        return senderProvince;
    }

    /**
     *    发件省
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_PROVINCE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderProvince(String senderProvince) {
        this.senderProvince = senderProvince;
    }

    /**
     *    发件市
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_CITY
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderCity() {
        return senderCity;
    }

    /**
     *    发件市
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_CITY
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderCity(String senderCity) {
        this.senderCity = senderCity;
    }

    /**
     *    发件区
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_EXP_AREA
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderExpArea() {
        return senderExpArea;
    }

    /**
     *    发件区
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_EXP_AREA
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderExpArea(String senderExpArea) {
        this.senderExpArea = senderExpArea;
    }

    /**
     *    发件人详细地址
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_ADDRESS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderAddress() {
        return senderAddress;
    }

    /**
     *    发件人详细地址
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_ADDRESS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    /**
     *    发件地邮编
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_POST_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getSenderPostCode() {
        return senderPostCode;
    }

    /**
     *    发件地邮编
     *
     *    数据库字段: KDI_LOGISTIC.SENDER_POST_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setSenderPostCode(String senderPostCode) {
        this.senderPostCode = senderPostCode;
    }

    /**
     *    收件人名称
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     *    收件人名称
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_NAME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     *    收件人电话
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_TEL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getReceiverTel() {
        return receiverTel;
    }

    /**
     *    收件人电话
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_TEL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setReceiverTel(String receiverTel) {
        this.receiverTel = receiverTel;
    }

    /**
     *    收件人手机
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_MOBILE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getReceiverMobile() {
        return receiverMobile;
    }

    /**
     *    收件人手机
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_MOBILE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    /**
     *    收件省
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_PROVINCE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getReceiverProvince() {
        return receiverProvince;
    }

    /**
     *    收件省
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_PROVINCE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    /**
     *    收件市
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_CITY
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getReceiverCity() {
        return receiverCity;
    }

    /**
     *    收件市
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_CITY
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    /**
     *    收件区
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_EXP_AREA
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getReceiverExpArea() {
        return receiverExpArea;
    }

    /**
     *    收件区
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_EXP_AREA
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setReceiverExpArea(String receiverExpArea) {
        this.receiverExpArea = receiverExpArea;
    }

    /**
     *    收件人详细地址
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_ADDRESS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getReceiverAddress() {
        return receiverAddress;
    }

    /**
     *    收件人详细地址
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_ADDRESS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    /**
     *    收件地邮编
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_POST_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getReceiverPostCode() {
        return receiverPostCode;
    }

    /**
     *    收件地邮编
     *
     *    数据库字段: KDI_LOGISTIC.RECEIVER_POST_CODE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setReceiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
    }

    /**
     *    组织id
     *
     *    数据库字段: KDI_LOGISTIC.ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     *    组织id
     *
     *    数据库字段: KDI_LOGISTIC.ORG_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     *    打印页面
     *
     *    数据库字段: KDI_LOGISTIC.PRINT_PAGE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getPrintPage() {
        return printPage;
    }

    /**
     *    打印页面
     *
     *    数据库字段: KDI_LOGISTIC.PRINT_PAGE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setPrintPage(String printPage) {
        this.printPage = printPage;
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
        sb.append(", shipperId=").append(shipperId);
        sb.append(", shipperCode=").append(shipperCode);
        sb.append(", shipperName=").append(shipperName);
        sb.append(", logisticCode=").append(logisticCode);
        sb.append(", logisticStatus=").append(logisticStatus);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", estimatedArrivalTime=").append(estimatedArrivalTime);
        sb.append(", city=").append(city);
        sb.append(", payType=").append(payType);
        sb.append(", expType=").append(expType);
        sb.append(", orderId=").append(orderId);
        sb.append(", orderTitle=").append(orderTitle);
        sb.append(", orderDetail=").append(orderDetail);
        sb.append(", senderName=").append(senderName);
        sb.append(", senderTel=").append(senderTel);
        sb.append(", senderMobile=").append(senderMobile);
        sb.append(", senderProvince=").append(senderProvince);
        sb.append(", senderCity=").append(senderCity);
        sb.append(", senderExpArea=").append(senderExpArea);
        sb.append(", senderAddress=").append(senderAddress);
        sb.append(", senderPostCode=").append(senderPostCode);
        sb.append(", receiverName=").append(receiverName);
        sb.append(", receiverTel=").append(receiverTel);
        sb.append(", receiverMobile=").append(receiverMobile);
        sb.append(", receiverProvince=").append(receiverProvince);
        sb.append(", receiverCity=").append(receiverCity);
        sb.append(", receiverExpArea=").append(receiverExpArea);
        sb.append(", receiverAddress=").append(receiverAddress);
        sb.append(", receiverPostCode=").append(receiverPostCode);
        sb.append(", orgId=").append(orgId);
        sb.append(", printPage=").append(printPage);
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
        KdiLogisticMo other = (KdiLogisticMo) that;
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
