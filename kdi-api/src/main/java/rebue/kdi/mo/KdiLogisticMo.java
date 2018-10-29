package rebue.kdi.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

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
@Data
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
     *    录入类型  1:手动  2:自动
     *
     *    数据库字段: KDI_LOGISTIC.ENTRY_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte entryType;

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
   
}
