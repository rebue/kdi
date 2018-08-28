package rebue.kdi.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.robotech.mapper.MybatisBaseMapper;
import rebue.kdi.to.ListKdiLogisticTo;

@Mapper
public interface KdiLogisticMapper
		extends
			MybatisBaseMapper<KdiLogisticMo, Long> {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table KDI_LOGISTIC
	 *
	 * @mbg.generated 2018-08-27 17:03:33
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table KDI_LOGISTIC
	 *
	 * @mbg.generated 2018-08-27 17:03:33
	 */
	int insert(KdiLogisticMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table KDI_LOGISTIC
	 *
	 * @mbg.generated 2018-08-27 17:03:33
	 */
	int insertSelective(KdiLogisticMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table KDI_LOGISTIC
	 *
	 * @mbg.generated 2018-08-27 17:03:33
	 */
	KdiLogisticMo selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table KDI_LOGISTIC
	 *
	 * @mbg.generated 2018-08-27 17:03:33
	 */
	int updateByPrimaryKeySelective(KdiLogisticMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table KDI_LOGISTIC
	 *
	 * @mbg.generated 2018-08-27 17:03:33
	 */
	int updateByPrimaryKeyWithBLOBs(KdiLogisticMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table KDI_LOGISTIC
	 *
	 * @mbg.generated 2018-08-27 17:03:33
	 */
	int updateByPrimaryKey(KdiLogisticMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table KDI_LOGISTIC
	 *
	 * @mbg.generated 2018-08-27 17:03:33
	 */
	List<KdiLogisticMo> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table KDI_LOGISTIC
	 *
	 * @mbg.generated 2018-08-27 17:03:33
	 */
	List<KdiLogisticMo> selectSelective(KdiLogisticMo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table KDI_LOGISTIC
	 *
	 * @mbg.generated 2018-08-27 17:03:33
	 */
	boolean existByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table KDI_LOGISTIC
	 *
	 * @mbg.generated 2018-08-27 17:03:33
	 */
	boolean existSelective(KdiLogisticMo record);

	/**
	 * 根据参数获取订单信息
	 * 
	 * @param to
	 * @return
	 */
	List<KdiLogisticMo> kdiLogisticList(ListKdiLogisticTo to);

	/**
	 * 微信端查询快递信息
	 * 
	 * @param mo
	 * @return
	 */
	List<KdiLogisticMo> kdiLogisticWx(KdiLogisticMo mo);
}