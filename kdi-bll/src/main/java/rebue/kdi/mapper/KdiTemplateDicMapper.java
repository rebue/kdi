package rebue.kdi.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.kdi.mo.KdiTemplateDicMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface KdiTemplateDicMapper extends MybatisBaseMapper<KdiTemplateDicMo, Long> {
    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(KdiTemplateDicMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(KdiTemplateDicMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    KdiTemplateDicMo selectByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(KdiTemplateDicMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(KdiTemplateDicMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<KdiTemplateDicMo> selectAll();

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<KdiTemplateDicMo> selectSelective(KdiTemplateDicMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(KdiTemplateDicMo record);
}