package rebue.kdi.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import rebue.kdi.mo.KdiOrderMo;

@Data
@JsonInclude(Include.NON_NULL)
public class KdiBatchOrderTo {
	/**
	 * 收货人信息
	 */
	private KdiOrderMo[] receiver;
	
	/**
	 * 物流订单号
	 */
	private Long expressNumber;
	/**
	 * 快递公司ID
	 */
	private Long shipperId;
	
	/**
	 * 快递公司编码
	 */
	private String shipperCode;

	/**
	 * 发货操作人
	 */
	private Long sendOpId;
	

    @ApiModelProperty(value = "发件人名称")
    private String senderName;


    @ApiModelProperty(value = "发件人电话")
    private String senderTel;


    @ApiModelProperty(value = "发件人手机")
    private String senderMobile;


    @ApiModelProperty(value = "发件省")
    private String senderProvince;


    @ApiModelProperty(value = "发件市")
    private String senderCity;


    @ApiModelProperty(value = "发件区")
    private String senderExpArea;


    @ApiModelProperty(value = "发件人详细地址")
    private String senderAddress;


    @ApiModelProperty(value = "发件地邮编")
    private String senderPostCode;
	
	/**
	 * 组织ID
	 */
    @ApiModelProperty(value = "组织id")
	private Long orgId;

}
