package rebue.kdi.to;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * 添加物流订单请求参数
 * 
 * @author lbl
 *
 */
@JsonInclude(Include.NON_NULL)
@Data
public class AddKdiLogisticTo {
	
	/**
	 * 物流id
	 */
	private Long  logisticId ;

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
	
	/**
	 * 录入类型 1:手动 2:自动
	 */
    private Byte entryType;
	




}
