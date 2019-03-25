package rebue.kdi.ro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import rebue.kdi.dic.EOrderResultDic;

@Data
@JsonInclude(Include.NON_NULL)
public class KdiBatchOrderRo {
	/**
	 * 返回结果
	 */
	private EOrderResultDic result;
	/** 确认发货返回值 **/
	private String msg;

	/**
	 * 打印页面 (下单成功才会返回)
	 */
	private String printPage;
}
