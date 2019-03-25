package rebue.kdi.to;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;


@JsonInclude(Include.NON_NULL)
@Data
public class DeliverCountTo {
	
		
		
		/**
		 * 组织id集合，这个是用来统计某些组织
		 */
		private ArrayList<Long> orgIds;
		
		/**
		 * 要查询的物流状态集合
		 */
		private ArrayList<Byte> logisticStatus;
		
	    /**
	     * 统计开始时间，也就是物流中的下单时间，物流中的下单时间并不是订单中的下单时间，而是录入改条物流记录时候的时间。
	     */
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	    private Date     orderTimeStart;
	    
	    /**
	     * 统计结束时间，也就是物流中的下单时间，物流中的下单时间并不是订单中的下单时间，而是录入改条物流记录时候的时间。
	     */
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	    private Date     orderTimeEnd;


	    
		
}
