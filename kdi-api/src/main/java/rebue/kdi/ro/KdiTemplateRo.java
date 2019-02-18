package rebue.kdi.ro;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import rebue.kdi.mo.KdiTemplateMo;
@JsonInclude(Include.NON_NULL)
@Data
public class KdiTemplateRo {
		
	
    /**
     *
     * 	返回值	1:成功  -1:失败
     *
     */
    private Byte result;

    /**
     *
     *	返回的结果
     *
     */
    private String msg;

    /**

     *
     *	返回的结果值
     */
    private KdiTemplateMo record;
}
