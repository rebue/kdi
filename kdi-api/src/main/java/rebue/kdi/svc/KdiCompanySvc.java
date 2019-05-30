package rebue.kdi.svc;

import java.util.List;
import rebue.kdi.mo.KdiCompanyMo;
import rebue.kdi.ro.CompanyRo;
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
    
    
    List<CompanyRo> selectKdiCompanyInfo(KdiCompanyMo mo);
    
    /**
     * 获取单个快递公司信息,包括连查快递公司的名字和编码
     * 
     */
    CompanyRo	getOneCompanyById(Long id);
    
    /**
     *  根据店铺id修改店铺名字
     */
    int updateShopNameByShopId(Long shopId,String shopName);
}
