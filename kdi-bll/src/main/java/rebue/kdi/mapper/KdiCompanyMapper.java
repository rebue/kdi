package rebue.kdi.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import rebue.kdi.mo.KdiCompanyMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface KdiCompanyMapper extends MybatisBaseMapper<KdiCompanyMo, Long> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(KdiCompanyMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(KdiCompanyMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    KdiCompanyMo selectByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(KdiCompanyMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(KdiCompanyMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<KdiCompanyMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<KdiCompanyMo> selectSelective(KdiCompanyMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(KdiCompanyMo record);

    /**
     *  查询所有快递公司名称和编码
     *
     *  @return
     */
    @Select("SELECT ID as id, COMPANY_NAME as companyName, COMPANY_CODE as companyCode FROM KDI_COMPANY ORDER BY ENTRY_TIME DESC")
    List<KdiCompanyMo> selectKdiCompanyNameAndCode();

    /**
     *  设置成默认发件人
     *
     *  @return
     */
    int setDefaultCompany(KdiCompanyMo record);

    /**
     *  设置不是默认发件人
     *
     *  @return
     */
    int setCompany(KdiCompanyMo record);
}
