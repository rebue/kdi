package rebue.kdi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.ro.ReportOrderCountRo;
import rebue.kdi.to.ListKdiLogisticTo;
import rebue.kdi.to.OrderCountReportTo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface KdiLogisticMapper extends MybatisBaseMapper<KdiLogisticMo, Long> {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insert(KdiLogisticMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insertSelective(KdiLogisticMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    KdiLogisticMo selectByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKeySelective(KdiLogisticMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeyWithBLOBs(KdiLogisticMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKey(KdiLogisticMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<KdiLogisticMo> selectAll();

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<KdiLogisticMo> selectSelective(KdiLogisticMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    boolean existByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
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
     */
    List<KdiLogisticMo> kdiLogisticWx(KdiLogisticMo mo);

    /**
     * 统计本组织一段时间内的下单量
     */
    List<ReportOrderCountRo> reportOrderCountInPeriod(OrderCountReportTo to);

    /**
     * 获取打印页面
     */
    List<KdiLogisticMo> getPrintPageByOrderId(KdiLogisticMo mo);
    
    /**
     * 根据收件人手机号码查询收件人信息
     * @param receiverMobile
     * @return
     */
    KdiLogisticMo selectReceiverByReceiverMobile(@Param("receiverMobile") String receiverMobile);
}
