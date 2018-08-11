package rebue.kdi.svc;

import java.util.List;

import rebue.kdi.mo.KdiCompanyMo;
import rebue.robotech.svc.MybatisBaseSvc;

public interface KdiCompanySvc extends MybatisBaseSvc<KdiCompanyMo, java.lang.Long> {

	/**
	 * 添加快递公司
	 */
	int add(KdiCompanyMo mo);

	/**
	 * 查询所有快递公司名称和编码
	 * @return
	 */
	List<KdiCompanyMo> selectKdiCompanyNameAndCode();
	
	/**
	 * 根据快递公司条件查询递公司信息
	 */
	
	List<KdiCompanyMo> selectKdiCompanyInfo(KdiCompanyMo mo);
}
