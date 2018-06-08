package rebue.kdi.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface KdiLogisticMapper extends MybatisBaseMapper<KdiLogisticMo, Long> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_LOGISTIC
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_LOGISTIC
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    int insert(KdiLogisticMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_LOGISTIC
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    int insertSelective(KdiLogisticMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_LOGISTIC
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    KdiLogisticMo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_LOGISTIC
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    int updateByPrimaryKeySelective(KdiLogisticMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_LOGISTIC
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    int updateByPrimaryKeyWithBLOBs(KdiLogisticMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_LOGISTIC
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    int updateByPrimaryKey(KdiLogisticMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_LOGISTIC
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    List<KdiLogisticMo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_LOGISTIC
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    List<KdiLogisticMo> selectSelective(KdiLogisticMo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_LOGISTIC
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    boolean existByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table KDI_LOGISTIC
     *
     * @mbg.generated 2018-06-08 09:50:07
     */
    boolean existSelective(KdiLogisticMo record);
}