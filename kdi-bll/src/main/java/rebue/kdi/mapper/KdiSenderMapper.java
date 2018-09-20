package rebue.kdi.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import rebue.kdi.mo.KdiSenderMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface KdiSenderMapper extends MybatisBaseMapper<KdiSenderMo, Long> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(KdiSenderMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(KdiSenderMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    KdiSenderMo selectByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(KdiSenderMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(KdiSenderMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<KdiSenderMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<KdiSenderMo> selectSelective(KdiSenderMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(KdiSenderMo record);

    /**
     *  获取默认发件人信息
     *
     *  @return
     */
    @Select("SELECT * FROM KDI_SENDER WHERE IS_DEFAULT = 1 AND ORG_ID = #{orgId}")
    KdiSenderMo getDefaultSender(Long orgId);

    /**
     *  设置默认发件人
     *
     *  @param id
     *  @return
     */
    @Update("UPDATE KDI_SENDER SET IS_DEFAULT = 1 WHERE ID = #{id}")
    int setDefaultSender(@Param("id") Long id);

    /**
     *  根据组织ID获取发件人
     *
     *  @param orgId
     *  @return
     */
    @Select("SELECT * FROM KDI_SENDER WHERE ORG_ID = #{orgId}")
    List<KdiSenderMo> selectByOrganizeId(Long orgId);
}
