package rebue.kdi.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import rebue.kdi.mo.KdiTraceMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface KdiTraceMapper extends MybatisBaseMapper<KdiTraceMo, Long> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(KdiTraceMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(KdiTraceMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    KdiTraceMo selectByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(KdiTraceMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(KdiTraceMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<KdiTraceMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<KdiTraceMo> selectSelective(KdiTraceMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(KdiTraceMo record);

    /**
     *  根据物流订单ID删除其所有轨迹
     *
     *  @param logisticId
     *             物流订单ID
     */
    @Delete("delete from KDI_TRACE where LOGISTIC_ID=#{logisticId}")
    void delByLogisticId(Long logisticId);
}
