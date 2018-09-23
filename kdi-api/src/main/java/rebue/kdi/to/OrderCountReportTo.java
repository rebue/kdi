package rebue.kdi.to;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * 根据条件筛选物流订单显示结果参数
 * 
 * @author jjl
 *
 */
@JsonInclude(Include.NON_NULL)
@Data
public class OrderCountReportTo {

    /**
     * 组织ID
     */
    private Long orgId;

    /**
     * 搜索下单时间开始日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date orderTimeStartDate;
    /**
     * 搜索下单时间结束日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date orderTimeEndDate;

}
