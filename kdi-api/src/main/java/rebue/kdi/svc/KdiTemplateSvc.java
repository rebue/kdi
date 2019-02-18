package rebue.kdi.svc;
import rebue.kdi.mo.KdiTemplateMo;
import rebue.robotech.svc.MybatisBaseSvc;

public interface KdiTemplateSvc extends MybatisBaseSvc<KdiTemplateMo, java.lang.Long> {
	
    /**
     * 根据快递公司id删除模板
     * 
     */
    int	deleteForCompanyId(Long id);
}
