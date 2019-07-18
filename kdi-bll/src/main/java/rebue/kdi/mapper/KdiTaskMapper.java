package rebue.kdi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import rebue.kdi.mo.KdiTaskMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface KdiTaskMapper extends MybatisBaseMapper<KdiTaskMo, Long> {
    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insert(KdiTaskMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insertSelective(KdiTaskMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    KdiTaskMo selectByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKeySelective(KdiTaskMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKey(KdiTaskMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<KdiTaskMo> selectAll();

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<KdiTaskMo> selectSelective(KdiTaskMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    boolean existByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    boolean existSelective(KdiTaskMo record);

    @Select("select ID from KDI_TASK where EXECUTE_STATE= #{executeState} and EXECUTE_PLAN_TIME<=SYSDATE() and TASK_TYPE=#{taskType}")
    List<Long> getTaskIdsThatShouldExecute(@Param("executeState") Byte executeState, @Param("taskType") Byte taskType);
}