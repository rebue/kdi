package rebue.kdi.svc;

import rebue.kdi.mo.KdiSenderMo;
import rebue.kdi.ro.AddKdiSenderRo;
import rebue.kdi.ro.ModifyDefaultSenderRo;
import rebue.kdi.ro.ModifyKdiSenderRo;
import rebue.robotech.svc.MybatisBaseSvc;

public interface KdiSenderSvc extends MybatisBaseSvc<KdiSenderMo, java.lang.Long>{

	/**
	 * 添加发件人
	 * @param mo
	 * @return
	 */
	AddKdiSenderRo exAdd(KdiSenderMo mo);

	/**
	 * 修改默认发件人
	 * @param mo
	 * @return
	 */
	ModifyDefaultSenderRo modifyDefaultSender(KdiSenderMo mo);

	/**
	 * 修改发件人信息
	 * @param mo
	 * @return
	 */
	ModifyKdiSenderRo modifyKdiSender(KdiSenderMo mo);

}
