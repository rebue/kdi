package rebue.kdi.to;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import rebue.kdi.mo.KdiCompanyMo;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.mo.KdiSenderMo;

/**
 * 批量录入请求类
 * 
 * @author jjl
 *
 */
@JsonInclude(Include.NON_NULL)
@Data
public class BatchEnterTo {

    /**
     * 组织id
     */
    private Long orgId;

    /**
     * 收件人
     */
    private List<KdiLogisticMo> receiver;

    /**
     * 快递公司
     */
    private KdiCompanyMo selectCompany;

    /**
     * 发件人
     */
    private KdiSenderMo selectSend;
}
