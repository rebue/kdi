package rebue.kdi.svc;

import java.util.List;
import rebue.kdi.mo.KdiCompanyMo;
import rebue.robotech.svc.MybatisBaseSvc;

public interface KdiCompanySvc extends MybatisBaseSvc<KdiCompanyMo, java.lang.Long> {

    /**
     *  添加快递公司
     */
    int add(KdiCompanyMo mo);

    /**
     *  设置默认快递公司
     */
    int setDefaultCompany(KdiCompanyMo mo);

    /**
     *  查询所有快递公司名称和编码
     *  @return
     */
    List<KdiCompanyMo> selectKdiCompanyNameAndCode();

    List<KdiCompanyMo> selectKdiCompanyInfo(KdiCompanyMo mo);
}
