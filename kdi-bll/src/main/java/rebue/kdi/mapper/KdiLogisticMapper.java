package rebue.kdi.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.ro.LogisticReportRo;
import rebue.kdi.to.ListKdiLogisticTo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface KdiLogisticMapper extends MybatisBaseMapper<KdiLogisticMo, Long> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(KdiLogisticMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(KdiLogisticMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    KdiLogisticMo selectByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(KdiLogisticMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeyWithBLOBs(KdiLogisticMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(KdiLogisticMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<KdiLogisticMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<KdiLogisticMo> selectSelective(KdiLogisticMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(KdiLogisticMo record);

    /**
     *  根据参数获取订单信息
     *
     *  @param to
     *  @return
     */
    List<KdiLogisticMo> kdiLogisticList(ListKdiLogisticTo to);

    /**
     *  微信端查询快递信息
     *
     *  @param mo
     *  @return
     */
    List<KdiLogisticMo> kdiLogisticWx(KdiLogisticMo mo);

    /**
     *  根据更新时间查询该时间和前六天发单量
     *  @param mo
     *  @return
     */
    List<LogisticReportRo> listLogisticsReport(ListKdiLogisticTo mo);

    /**
     *  获取打印页面
     *  @param mo
     *  @return
     */
    List<KdiLogisticMo> getPrintPageByOrderId(KdiLogisticMo mo);
}
