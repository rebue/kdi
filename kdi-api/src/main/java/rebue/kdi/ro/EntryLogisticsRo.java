package rebue.kdi.ro;

import rebue.kdi.dic.EntryLogisticsDic;

/**
 * 录入订单返回值
 * 
 * @author lbl
 *
 */
public class EntryLogisticsRo {

	/**
	 * 录入订单返回值字典
	 */
	private EntryLogisticsDic result;

	/**
	 * 录入订单返回值
	 */
	private String msg;

	public EntryLogisticsDic getResult() {
		return result;
	}

	public void setResult(EntryLogisticsDic result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "EntryLogisticsRo [result=" + result + ", msg=" + msg + "]";
	}

}
