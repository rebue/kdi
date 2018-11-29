package rebue.kdi.to;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 订阅物流轨迹接口的参数类型
 * 
 * @author zbz
 *
 */
@Data
public class SubscribeTraceTo {
	
	/**
	 * 快递Id
	 */
    private Long    logisticId;
    /**
     * 快递公司编码
     */
    private String  shipperCode;
    /**
     * 快递单号
     */
    private String  logisticCode;
    /**
     * 订单ID
     */
    private Long    orderId;
    /**
     * 是否通知快递员上门揽件
     * (true-通知;false-不通知。不填则默认false)
     */
    private Boolean isNotice;
    /**
     * 发件人名称
     */
    private String  senderName;
    /**
     * 发件人电话
     */
    private String  senderTel;
    /**
     * 发件人手机
     */
    private String  senderMobile;
    /**
     * 发件省
     * (如广东省，不要缺少“省”; 如是直辖市，请直接传北京、 上海等; 如是自治区，请直接传广西 壮族自治区等)
     */
    private String  senderProvince;
    /**
     * 发件市
     * (如深圳市，不要缺少 “市”)
     */
    private String  senderCity;
    /**
     * 发件区/县
     * (如福田区，不要缺 少“区”或“县”)
     */
    private String  senderExpArea;
    /**
     * 发件人详细地址
     */
    private String  senderAddress;
    /**
     * 发件地邮编
     * (为 EMS、YZPY 时必填)
     */
    private String  senderPostCode;
    /**
     * 收件人名称
     */
    private String  receiverName;
    /**
     * 收件人电话
     */
    private String  receiverTel;
    /**
     * 收件人手机
     */
    private String  receiverMobile;
    /**
     * 收件省
     * (如广东省，不要缺少“省”; 如是直辖市，请直接传北京、 上海等; 如是自治区，请直接传广西 壮族自治区等)
     */
    private String  receiverProvince;
    /**
     * 收件市
     * (如深圳市，不要缺少 “市”)
     */
    private String  receiverCity;
    /**
     * 收件区/县
     * (如福田区，不要缺 少“区”或“县”)
     */
    private String  receiverExpArea;
    /**
     * 收件人详细地址
     */
    private String  receiverAddress;
    /**
     * 收件地邮编
     * (为 EMS、YZPY 时必填)
     */
    private String  receiverPostCode;
    
    /**
     * 快递公司ID 
     */
    private Long    shipperId;
    
    /**
     *    组织id
     */
    private Long orgId;

    /**
     *    录入类型  1:手动  2:自动
     */
    private Byte entryType;
    
    /**
     * 快递公司名称
     */
    private String  shipperName;
    
    /**
     *    下单时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orderTime;

    /**
     *    更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    
    /**
     * 定单标题
     */
    private String orderTitle;

}
