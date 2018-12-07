package rebue.kdi.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.kdi.mo.KdiCompanyDicMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface KdiCompanyDicMapper extends MybatisBaseMapper<KdiCompanyDicMo, Long> {
    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(KdiCompanyDicMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(KdiCompanyDicMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    KdiCompanyDicMo selectByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(KdiCompanyDicMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(KdiCompanyDicMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<KdiCompanyDicMo> selectAll();

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<KdiCompanyDicMo> selectSelective(KdiCompanyDicMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(KdiCompanyDicMo record);
}