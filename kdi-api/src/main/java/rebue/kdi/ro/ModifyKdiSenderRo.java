package rebue.kdi.ro;

import rebue.kdi.dic.ModifyKdiSenderDic;

/**
 * 修改发件人信息返回值
 * 
 * @author lbl
 *
 */
public class ModifyKdiSenderRo {

	/**
	 * 修改发件人信息返回值字典
	 */
	private ModifyKdiSenderDic result;

	/**
	 * 修改发件人信息返回值
	 */
	private String msg;

	public ModifyKdiSenderDic getResult() {
		return result;
	}

	public void setResult(ModifyKdiSenderDic result) {
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
		return "ModifyKdiSenderRo [result=" + result + ", msg=" + msg + "]";
	}

}
