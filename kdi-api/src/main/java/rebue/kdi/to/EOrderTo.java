package rebue.kdi.to;

import lombok.Data;

/**
 * 电子面单接口的参数类型
 * 
 * @author zbz
 *
 */
@Data
public class EOrderTo {
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
	 * 运费支付方式: 1-现付，2-到付，3-月结，4-第三方付
	 */
	private Byte payType;
	/**
	 * 快递类型:1-标准快件 其余详细快递类型参考《快递公司快递业务类型.xlsx》
	 */
	private Byte expType;
	/**
	 * 订单ID
	 */
	private Long orderId;
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
	 * 发件省 (如广东省，不要缺少“省”; 如是直辖市，请直接传北京、上海等; 如是自治区，请直接传广西壮族自治区等)
	 */
	private String senderProvince;
	/**
	 * 发件市 (如深圳市，不要缺少“市”)
	 */
	private String senderCity;
	/**
	 * 发件区/县 (如福田区，不要缺少“区”或“县”)
	 */
	private String senderExpArea;
	/**
	 * 发件人详细地址
	 */
	private String senderAddress;
	/**
	 * 发件地邮编 (为 EMS、YZPY时必填)
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
	 * 收件省 (如广东省，不要缺少“省”; 如是直辖市，请直接传北京、上海等; 如是自治区，请直接传广西壮族自治区等)
	 */
	private String receiverProvince;
	/**
	 * 收件市 (如深圳市，不要缺少“市”)
	 */
	private String receiverCity;
	/**
	 * 收件区/县 (如福田区，不要缺少“区”或“县”)
	 */
	private String receiverExpArea;
	/**
	 * 收件人详细地址
	 */
	private String receiverAddress;
	/**
	 * 收件地邮编 (为 EMS、YZPY时必填)
	 */
	private String receiverPostCode;
	
	/**
	 * 电子面单客户号
	 */
	private String customerName;
	
	/**
	 *电子面单密码 
	 */
	private String customerPwd;
	
	/**
	 * 电子面单月结账号
	 * @return
	 */
//	private String monthCode;
	
	/**
	 * 电子面单sendsite
	 * @return
	 */
	
//	private String sendsite;
	
	/**
	 * 组织ID
	 */
	
    private Long orgId;

    /**
     *    录入类型  1:手动  2:自动
     *
     *    数据库字段: KDI_LOGISTIC.ENTRY_TYPE
     *
     *   
     */
    private Byte entryType;

	
    /**
     * 订单详情
     */
    private String orderDetail;

}
