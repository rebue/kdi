package rebue.kdi.kdniao.ro;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;


/**
 * 识别快递单号的返回结果
 */
@JsonInclude(Include.NON_NULL)
@Data
public class KdNiaoUpdateTraceRo {
    /**
     * 用户ID
     */
    private String  EBusinessID;

    /**
     * 更新时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date    UpdateTime;

    /**
     * 成功与否(true/false)
     */
    private Boolean Success;

    /**
     * 失败原因
     */
    private String  Reason;




}
