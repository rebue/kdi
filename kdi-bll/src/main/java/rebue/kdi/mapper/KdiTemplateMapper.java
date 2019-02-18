package rebue.kdi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import rebue.kdi.mo.KdiTemplateMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface KdiTemplateMapper extends MybatisBaseMapper<KdiTemplateMo, Long> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(KdiTemplateMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(KdiTemplateMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    KdiTemplateMo selectByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(KdiTemplateMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(KdiTemplateMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<KdiTemplateMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<KdiTemplateMo> selectSelective(KdiTemplateMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(KdiTemplateMo record);
    
    /**
     * 根据快递公司id删除模板
     * @param companyId
     * @return
     */
    @Delete("DELETE FROM KDI_TEMPLATE WHERE COMPANY_ID=#{companyId,jdbcType=BIGINT}")
    int deleteForCompanyId(@Param("companyId") Long companyId );
}
