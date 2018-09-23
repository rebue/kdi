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
public class ListKdiLogisticTo {

    /**
     * 收件人名称
     */
    private String receiverName;
    /**
     * 收件人手机
     */
    private String receiverMobile;

    /**
     * 发件人名称
     */
    private String senderName;
    /**
     * 发件人电话
     */
    private String senderTel;

    /**
     * 下单时间段 开始
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date   orderTimeStart;
    /**
     * 下单时间段 结束
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date   orderTimeEnd;
    /**
     * 物流状态
     */
    private String logisticStatus;
    /**
     * 物流订单号
     */
    private String logisticCode;

    /**
     * 组织ID
     */
    private Long   orgId;

}
