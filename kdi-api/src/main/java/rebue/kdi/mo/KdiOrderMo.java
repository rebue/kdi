package rebue.kdi.mo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class KdiOrderMo {
	/**
	 * 收货人姓名
	 */
	private String receivePeople;
	
	/**
	 * 收货人电话
	 */
	private String receivePhone;
	
	/**
	 * 收件省
	 */
	private String province;
	
	/**
	 * 收件市
	 */
	private String city;
	
	/**
	 * 收件区
	 */
	private String count;

	/**
	 * 收件详细地址
	 */
	private String receiveAddress;
	
	/**
	 * 发货标题
	 */
	private String receiveTitle;

}
