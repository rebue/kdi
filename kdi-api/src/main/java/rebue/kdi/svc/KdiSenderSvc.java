package rebue.kdi.svc;

import rebue.kdi.mo.KdiSenderMo;
import rebue.kdi.ro.ModifyDefaultSenderRo;
import rebue.robotech.svc.MybatisBaseSvc;

public interface KdiSenderSvc extends MybatisBaseSvc<KdiSenderMo, java.lang.Long>{


	/**
	 * 修改默认发件人
	 * @param mo
	 * @return
	 */
	ModifyDefaultSenderRo setDefaultSender(KdiSenderMo mo);


	
	/**
	 * 查找默认发件人信息
	 * @param mo
	 * @return
	 */
	KdiSenderMo getDefaultSender();

}
