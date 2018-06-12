package rebue.kdi.ro;

import rebue.kdi.dic.ModifyDefaultSenderDic;

/**
 * 修改默认发件人返回值
 * 
 * @author lbl
 *
 */
public class ModifyDefaultSenderRo {

	/**
	 * 修改默认发件人返回值字典
	 */
	private ModifyDefaultSenderDic result;

	/**
	 * 修改默认发件人返回值
	 */
	private String msg;

	public ModifyDefaultSenderDic getResult() {
		return result;
	}

	public void setResult(ModifyDefaultSenderDic result) {
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
		return "ModifyDefaultSenderRo [result=" + result + ", msg=" + msg + "]";
	}

}
