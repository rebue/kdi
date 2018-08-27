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
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-07-21 15:20:45
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-07-21 15:20:45
     */
    int insert(KdiSenderMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-07-21 15:20:45
     */
    int insertSelective(KdiSenderMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-07-21 15:20:45
     */
    KdiSenderMo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-07-21 15:20:45
     */
    int updateByPrimaryKeySelective(KdiSenderMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-07-21 15:20:45
     */
    int updateByPrimaryKey(KdiSenderMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-07-21 15:20:45
     */
    List<KdiSenderMo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-07-21 15:20:45
     */
    List<KdiSenderMo> selectSelective(KdiSenderMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-07-21 15:20:45
     */
    boolean existByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-07-21 15:20:45
     */
    boolean existSelective(KdiSenderMo record);
    
    /**
     * 获取默认发件人信息
     * @return
     */
    @Select("SELECT * FROM KDI_SENDER WHERE IS_DEFAULT = 1")
    KdiSenderMo getDefaultSender();
    
    @Update("UPDATE KDI_SENDER SET IS_DEFAULT = 1 WHERE ID = #{id}")
    int setDefaultSender(@Param("id") Long id);
    
    List<KdiSenderMo> selectByOrganizeId(Long organizeId);
}


