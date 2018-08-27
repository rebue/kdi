package rebue.kdi.svc.impl;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.kdi.mapper.KdiCompanyMapper;
import rebue.kdi.mo.KdiCompanyMo;
import rebue.kdi.svc.KdiCompanySvc;
import rebue.robotech.svc.impl.MybatisBaseSvcImpl;

@Service
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class KdiCompanySvcImpl extends MybatisBaseSvcImpl<KdiCompanyMo, java.lang.Long, KdiCompanyMapper>
		implements KdiCompanySvc {

	private final static Logger _log = LoggerFactory.getLogger(KdiCompanySvcImpl.class);
	
	/**
	 * 添加快递公司
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public int add(KdiCompanyMo mo) {
		// 如果id为空那么自动生成分布式id
		if (mo.getId() == null || mo.getId() == 0) {
			mo.setId(_idWorker.getId());
		}
		mo.setEntryTime(new Date());
		_log.info("添加快递公司的参数为: {}", mo);
		int result = super.add(mo);
		_log.info("添加快递公司的返回值为: {}", result);
		if (result == 1) {
			_log.info("添加快递公司成功");
			return 1;
		} else {
			_log.error("添加快递公司失败, 返回值为: {}", result);
			return -1;
		}
		
	}
	
	/**
	 * 查询所有快递公司名称和编码
	 * @return
	 */
	@Override
	public List<KdiCompanyMo> selectKdiCompanyNameAndCode() {
		return _mapper.selectKdiCompanyNameAndCode();
	}

	/**
	 * 根据快递公司信息查询快递公司
	 */
	@Override
	public List<KdiCompanyMo> selectKdiCompanyInfo(KdiCompanyMo mo) {
		return _mapper.selectSelective(mo);
	}
	
	/**
	 * 设置为默认快递公司
	 */
	@Override
	public int setDefaultCompany(KdiCompanyMo mo) {
		_log.info("设置为默认快递公司的参数为: {}", mo);
		int i=_mapper.setDefaultCompany(mo);
		_log.info("设置为默认快递公司的返回值为: {}", i);
		if(i==1) {
			int j=setCompany(mo);
			if(j>1) {
				i=1;
			}else {
				i=-1;
			}
		}
		return i;
	}
	
	/**
	 * 设置不是默认快递公司
	 */
	@Override
	public int setCompany(KdiCompanyMo mo) {
		_log.info("设置不是默认快递公司的参数为: {}", mo);
		return _mapper.setCompany(mo);

	}
}
