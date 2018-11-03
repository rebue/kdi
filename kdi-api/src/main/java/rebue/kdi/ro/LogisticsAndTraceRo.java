package rebue.kdi.ro;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.mo.KdiTraceMo;

@JsonInclude(Include.NON_NULL)
@Data
public class LogisticsAndTraceRo {
	

    
    
    private List<KdiTraceMo> kdiTrace;
    
    private  List<KdiLogisticMo> KdiLogistic;

}
