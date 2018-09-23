package rebue.kdi.ro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
@Data
public class ReportOrderCountRo {

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 每日发单总数
     */
    private Long   total;

}
