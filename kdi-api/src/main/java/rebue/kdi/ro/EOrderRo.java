package rebue.kdi.ro;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import rebue.kdi.dic.EOrderResultDic;

/**
 * 电子面单接口的返回值类型
 * 
 * @author zbz
 *
 */
@JsonInclude(Include.NON_NULL)
@Data
public class EOrderRo {
    /**
     * 返回结果
     */
    private EOrderResultDic result;
    
    
    private String msg;

    /**
     * 物流订单ID
     * (下单成功才会返回)
     */
    private Long            logisticId;
    /**
     * 快递单号
     * (下单成功才会返回)
     */
    private String          logisticCode;

    /**
     * 打印页面
     * (下单成功才会返回)
     */
    private String          printPage;

    /**
     * 失败原因
     * (下单失败才会返回)
     */
    private String          failReason;


	
}
