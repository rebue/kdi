package rebue.kdi.svc.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.kdi.mapper.KdiCompanyMapper;
import rebue.kdi.mo.KdiCompanyMo;
import rebue.kdi.svc.KdiCompanySvc;
import rebue.robotech.svc.impl.MybatisBaseSvcImpl;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class KdiCompanySvcImpl extends MybatisBaseSvcImpl<KdiCompanyMo, java.lang.Long, KdiCompanyMapper> implements KdiCompanySvc {

}
