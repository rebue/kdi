package rebue.kdi.ro;

import rebue.kdi.dic.AddkdiCompanyDic;

/**
 * 添加快递公司返回值
 * 
 * @author lbl
 *
 */
public class AddkdiCompanyRo {

	/**
	 * 添加快递公司返回值字典
	 */
	private AddkdiCompanyDic result;

	/**
	 * 添加快递公司返回值
	 */
	private String msg;

	public AddkdiCompanyDic getResult() {
		return result;
	}

	public void setResult(AddkdiCompanyDic result) {
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
		return "AddkdiCompanyRo [result=" + result + ", msg=" + msg + "]";
	}

}
