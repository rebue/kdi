package rebue.kdi.ro;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class LogisticReportRo {

    /**
     * 更新时间
     */
    private String updateTime;

    /**
     * 每日发单总数
     */
    private Long   total;

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "LogisticReportRo [updateTime=" + updateTime + ", total=" + total + "]";
    }

}
