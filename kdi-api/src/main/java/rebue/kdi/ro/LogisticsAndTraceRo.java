package rebue.kdi.ro;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import rebue.kdi.mo.KdiTraceMo;

@JsonInclude(Include.NON_NULL)
@Data
public class LogisticsAndTraceRo {
	
    /**
     *    快递公司名称
     *
     *    数据库字段: KDI_LOGISTIC.SHIPPER_NAME
     *
     */
    private String shipperName;
    
    
    /**
     *    物流订单号
     *
     *    数据库字段: KDI_LOGISTIC.LOGISTIC_CODE
     *
     */
    private String logisticCode;
    
    
    private List<KdiTraceMo> kdiTrace;

}
