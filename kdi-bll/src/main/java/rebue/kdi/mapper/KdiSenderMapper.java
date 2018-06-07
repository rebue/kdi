package rebue.kdi.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.kdi.mo.KdiSenderMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface KdiSenderMapper extends MybatisBaseMapper<KdiSenderMo, Long> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-06-07 15:01:36
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-06-07 15:01:36
     */
    int insert(KdiSenderMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-06-07 15:01:36
     */
    int insertSelective(KdiSenderMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-06-07 15:01:36
     */
    KdiSenderMo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-06-07 15:01:36
     */
    int updateByPrimaryKeySelective(KdiSenderMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-06-07 15:01:36
     */
    int updateByPrimaryKey(KdiSenderMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-06-07 15:01:36
     */
    List<KdiSenderMo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-06-07 15:01:36
     */
    List<KdiSenderMo> selectSelective(KdiSenderMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-06-07 15:01:36
     */
    boolean existByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_SENDER
     *
     * @mbg.generated 2018-06-07 15:01:36
     */
    boolean existSelective(KdiSenderMo record);
}