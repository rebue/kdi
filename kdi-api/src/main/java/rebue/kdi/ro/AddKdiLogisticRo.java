package rebue.kdi.ro;

import rebue.kdi.dic.AddKdiLogisticDic;

/**
 * 添加物流订单返回值
 * 
 * @author lbl
 *
 */
public class AddKdiLogisticRo {

	/**
	 * 添加物流订单返回值字典
	 */
	private AddKdiLogisticDic result;

	/**
	 * 打印页面
	 */
	private String printPage;

	/**
	 * 添加物流订单返回值
	 */
	private String msg;

	public AddKdiLogisticDic getResult() {
		return result;
	}

	public void setResult(AddKdiLogisticDic result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public String getPrintPage() {
		return printPage;
	}

	public void setPrintPage(String printPage) {
		this.printPage = printPage;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "AddKdiLogisticRo [result=" + result + ", printPage=" + printPage + ", msg=" + msg + "]";
	}

}
