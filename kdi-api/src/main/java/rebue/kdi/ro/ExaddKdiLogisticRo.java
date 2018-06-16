package rebue.kdi.ro;

import rebue.kdi.dic.EOrderResultDic;

/**
 * 后台调用电子面单接口返回值
 * 
 * @author lbl
 *
 */
public class ExaddKdiLogisticRo {

	/**
	 * 返回结果
	 */
	private EOrderResultDic result;

	/**
	 * 物流订单ID (下单成功才会返回)
	 */
	private Long logisticId;
	/**
	 * 快递单号 (下单成功才会返回)
	 */
	private String logisticCode;

	/**
	 * 打印页面 (下单成功才会返回)
	 */
	private String printPage;

	/**
	 * 快递公司编码
	 */
	private String shipperCode;

	/**
	 * 快递公司名称
	 */
	private String shipperName;

	/**
	 * 失败原因 (下单失败才会返回)
	 */
	private String failReason;

	public EOrderResultDic getResult() {
		return result;
	}

	public void setResult(EOrderResultDic result) {
		this.result = result;
	}

	public Long getLogisticId() {
		return logisticId;
	}

	public void setLogisticId(Long logisticId) {
		this.logisticId = logisticId;
	}

	public String getLogisticCode() {
		return logisticCode;
	}

	public void setLogisticCode(String logisticCode) {
		this.logisticCode = logisticCode;
	}

	public String getPrintPage() {
		return printPage;
	}

	public void setPrintPage(String printPage) {
		this.printPage = printPage;
	}

	public String getShipperCode() {
		return shipperCode;
	}

	public void setShipperCode(String shipperCode) {
		this.shipperCode = shipperCode;
	}

	public String getShipperName() {
		return shipperName;
	}

	public void setShipperName(String shipperName) {
		this.shipperName = shipperName;
	}

	public String getFailReason() {
		return failReason;
	}

	public void setFailReason(String failReason) {
		this.failReason = failReason;
	}

	@Override
	public String toString() {
		return "ExaddKdiLogisticRo [result=" + result + ", logisticId=" + logisticId + ", logisticCode=" + logisticCode
				+ ", printPage=" + printPage + ", shipperCode=" + shipperCode + ", shipperName=" + shipperName
				+ ", failReason=" + failReason + "]";
	}

}
