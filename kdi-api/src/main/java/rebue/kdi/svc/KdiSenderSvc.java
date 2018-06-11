package rebue.kdi.svc;

import rebue.kdi.mo.KdiSenderMo;
import rebue.kdi.ro.AddKdiSenderRo;
import rebue.robotech.svc.MybatisBaseSvc;

public interface KdiSenderSvc extends MybatisBaseSvc<KdiSenderMo, java.lang.Long>{

	/**
	 * 添加发件人
	 * @param mo
	 * @return
	 */
	AddKdiSenderRo exAdd(KdiSenderMo mo);

}
