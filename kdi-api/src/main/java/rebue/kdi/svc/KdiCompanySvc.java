package rebue.kdi.svc;

import java.util.List;

import rebue.kdi.mo.KdiCompanyMo;
import rebue.kdi.ro.AddkdiCompanyRo;
import rebue.robotech.svc.MybatisBaseSvc;

public interface KdiCompanySvc extends MybatisBaseSvc<KdiCompanyMo, java.lang.Long> {

	/**
	 * 添加快递公司
	 */
	AddkdiCompanyRo exAdd(KdiCompanyMo mo);

	/**
	 * 查询所有快递公司名称和编码
	 * @return
	 */
	List<KdiCompanyMo> selectKdiCompanyNameAndCode();

}
