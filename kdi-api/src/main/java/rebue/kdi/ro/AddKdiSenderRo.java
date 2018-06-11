package rebue.kdi.ro;

import rebue.kdi.dic.AddKdiSenderDic;

/**
 * 添加发件人返回值
 * 
 * @author lbl
 *
 */
public class AddKdiSenderRo {

	/**
	 * 添加发件人返回值字典
	 */
	private AddKdiSenderDic result;

	/**
	 * 添加发件人返回值
	 */
	private String msg;

	public AddKdiSenderDic getResult() {
		return result;
	}

	public void setResult(AddKdiSenderDic result) {
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
		return "AddKdiSenderRo [result=" + result + ", msg=" + msg + "]";
	}

}
