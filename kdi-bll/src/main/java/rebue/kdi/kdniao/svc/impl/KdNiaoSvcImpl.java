package rebue.kdi.kdniao.svc.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.json.JsonParser;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.kdi.dic.EOrderResultDic;
import rebue.kdi.dic.IdentifyLogisticCodeResultDic;
import rebue.kdi.dic.PayTypeDic;
import rebue.kdi.dic.SubscribeTraceResultDic;
import rebue.kdi.kdniao.ro.KdNiaoUpdateTraceRo;
import rebue.kdi.kdniao.svc.KdNiaoSvc;
import rebue.kdi.kdniao.util.KdNiaoSignUtils;
import rebue.kdi.mo.KdiCompanyMo;
import rebue.kdi.mo.KdiLogisticMo;
import rebue.kdi.mo.KdiTraceMo;
import rebue.kdi.ro.EOrderRo;
import rebue.kdi.ro.IdentifyLogisticCodeRo;
import rebue.kdi.ro.LogisticRo;
import rebue.kdi.ro.ShipperRo;
import rebue.kdi.ro.SubscribeTraceRo;
import rebue.kdi.ro.TraceRo;
import rebue.kdi.svc.KdiCompanySvc;
import rebue.kdi.svc.KdiLogisticSvc;
import rebue.kdi.svc.KdiTraceSvc;
import rebue.kdi.to.EOrderTo;
import rebue.kdi.to.SubscribeTraceTo;
import rebue.wheel.HttpClientUtils;
import rebue.wheel.MapUtils;
import rebue.wheel.OkhttpUtils;

@Service
/**
 * <pre>
 * 在单独使用不带任何参数 的 @Transactional 注释时，
 * propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED，
 * 而且事务不会针对受控异常（checked exception）回滚。
 * 注意：
 * 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 * </pre>
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@ConfigurationProperties(prefix = "kdi") // 让yml配置文件中的map类的节点自动注入本bean中相应的属性
public class KdNiaoSvcImpl implements KdNiaoSvc {
	private final static Logger _log = LoggerFactory.getLogger(KdNiaoSvcImpl.class);

	@Value("${kdi.issandbox:false}")
	private Boolean _isSandBox;

	@Value("${kdi.kdniao.ebusinessid}")
	private String _ebusinessid;
	@Value("${kdi.kdniao.apikey}")
	private String _apikey;

	/**
	 * 读取yml配置文件中的属性
	 */
	private Map<String, Object> shippers;

	public Map<String, Object> getShippers() {
		return shippers;
	}

	public void setShippers(Map<String, Object> shippers) {
		this.shippers = shippers;
	}

	@Resource
	private KdNiaoSvc selfSvc;
	@Resource
	private KdiLogisticSvc logisticSvc;
	@Resource
	private KdiTraceSvc traceSvc;
	@Resource
	private KdiCompanySvc kdiCompanySvc;
	@Resource
	private JsonParser jsonParser;
	@Resource
	private Mapper dozerMapper;

	/**
	 * 识别快递单号的url
	 */
	private final static String IDENTIFY_ORDER_CODE_URL = "https://api.kdniao.com/Ebusiness/EbusinessOrderHandle.aspx";
	private final static String IDENTIFY_ORDER_CODE_URL_SANDBOX = "http://testapi.kdniao.cc:8081/Ebusiness/EbusinessOrderHandle.aspx";

	/**
	 * 电子面单的url
	 */
	private final static String EORDER_URL = "http://api.kdniao.cc/api/EOrderService";
	private final static String EORDER_URL_SANDBOX = "http://testapi.kdniao.cc:8081/api/eorderservice";
	// private final static String EORDER_URL_SANDBOX =
	// "http://sandboxapi.kdniao.cc:8080/kdniaosandbox/gateway/exterfaceInvoke.json";
	/**
	 * 订阅物流轨迹的url
	 */
	private final static String SUBCRIBE_TRACE_URL = "https://api.kdniao.com/api/dist";
	private final static String SUBCRIBE_TRACE_URL_SANDBOX = "http://testapi.kdniao.cc:8081/api/dist";

	/**
	 * 识别快递单号
	 * 
	 * @Description: 根据快递单号智能识别是哪个快递公司（不能保证100%识别，可能多个，也可能识别不出来）
	 * 
	 * @param logisticCode
	 *            快递单号
	 */
	@Override
	public IdentifyLogisticCodeRo identifyLogisticCode(String logisticCode) {
		_log.info("识别快递单号：{}", logisticCode);
		IdentifyLogisticCodeRo ro = new IdentifyLogisticCodeRo();

		_log.info("检验参数是否正确");
		if (StringUtils.isBlank(logisticCode)) {
			_log.warn("没有填写快递单号");
			ro.setResult(IdentifyLogisticCodeResultDic.PARAM_ERROR);
			return ro;
		}

		_log.info("组织请求要传递的参数");
		Map<String, Object> requestMap = new LinkedHashMap<>();
		try {
			// 应用级参数
			String requestData = "{\"LogisticCode\":\"" + logisticCode + "\"}";
			requestMap.put("RequestData", URLEncoder.encode(requestData, "UTF-8"));
			// 系统级参数
			requestMap.put("EBusinessID", _ebusinessid);
			requestMap.put("RequestType", "2002");
			requestMap.put("DataSign", URLEncoder.encode(KdNiaoSignUtils.sign(requestData, _apikey, "UTF-8"), "UTF-8"));
			requestMap.put("DataType", "2");
		} catch (IOException e) {
			_log.warn("商户号/AppKey/快递单号等参数错误：{},{},{}", _ebusinessid, _apikey, logisticCode);
			ro.setResult(IdentifyLogisticCodeResultDic.PARAM_ERROR);
			return ro;
		}

		try {
			String url = IDENTIFY_ORDER_CODE_URL;
			if (_isSandBox)
				url = IDENTIFY_ORDER_CODE_URL_SANDBOX;
			_log.info("向快递鸟服务器发出请求识别快递单号：{}", url);
			Map<String, Object> resultMap = jsonParser.parseMap(OkhttpUtils.postByFormParams(url, requestMap));
			if ((boolean) resultMap.get("Success")) {
				_log.info("识别快递单号的请求返回成功");
				@SuppressWarnings("unchecked")
				List<Map<String, String>> shippers = (List<Map<String, String>>) resultMap.get("Shippers");
				if (shippers.size() == 0) {
					ro.setResult(IdentifyLogisticCodeResultDic.FAILT);
					ro.setFailReason("没有返回快递公司列表");
					return ro;
				}
				ro.setResult(IdentifyLogisticCodeResultDic.SUCCESS);
				List<ShipperRo> list = new LinkedList<>();
				for (Map<String, String> item : shippers) {
					ShipperRo shipper = new ShipperRo();
					shipper.setShipperCode(item.get("ShipperCode"));
					shipper.setShipperName(item.get("ShipperName"));
					list.add(shipper);
				}
				ro.setShippers(list);
				return ro;
			} else {
				_log.info("识别快递单号的请求返回失败");
				ro.setResult(IdentifyLogisticCodeResultDic.FAILT);
				ro.setFailReason((String) resultMap.get("Reason"));
				return ro;
			}
		} catch (IOException e) {
			_log.error("请求快递鸟API服务器失败", e);
			ro.setResult(IdentifyLogisticCodeResultDic.FAILT);
			ro.setFailReason("请求快递鸟API服务器失败");
			return ro;
		}
	}

	/**
	 * 电子面单
	 * 
	 * @Description: 此接口用于向快递公司下发订单并获取快递单号和打印模板
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public EOrderRo eorder(EOrderTo to) {
		_log.info("快递鸟电子面单：{}", to);
		EOrderRo ro = new EOrderRo();
		_log.info("检验参数是否正确");
		if (to.getOrderId() == null || to.getOrgId() == null
				|| StringUtils.isAnyBlank(to.getShipperCode(), to.getOrderTitle(), to.getSenderName(),
						to.getSenderProvince(), to.getSenderCity(), to.getSenderExpArea(), to.getSenderAddress(),
						to.getReceiverName(), to.getReceiverProvince(), to.getReceiverCity(), to.getReceiverExpArea(),
						to.getReceiverAddress())
				|| StringUtils.isAllBlank(to.getSenderTel(), to.getSenderMobile())
				|| StringUtils.isAllBlank(to.getReceiverTel(), to.getReceiverMobile())) {
			_log.warn("没有填写必要的参数:{}", to);
			ro.setResult(EOrderResultDic.PARAM_ERROR);
			return ro;
		}
//		_log.info("检查是否重复的订单号");
//		KdiLogisticMo condition = new KdiLogisticMo();
//		condition.setOrderId(to.getOrderId());
//		if (logisticSvc.existSelective(condition)) {
//			String msg = "重复下单: {}" + to.getOrderId();
//			_log.warn(msg);
//			ro.setResult(EOrderResultDic.REPEAT);
//			ro.setFailReason(msg);
//			return ro;
//		}
		// 根据快递公司id获取选中的快递公司编码
		_log.info("查询快递公司账号密码");
		KdiCompanyMo kdiMo = new KdiCompanyMo();
		_log.info("查询快递公司信息的参数为: {}", to.getShipperId());
		kdiMo.setId(to.getShipperId());
		KdiCompanyMo mo = kdiCompanySvc.getById(to.getShipperId());

		if (mo == null) {
			_log.info("快递公司在数据库中不存在");
			ro.setResult(EOrderResultDic.FAILT);
			ro.setFailReason("快递公司不存在");
			return ro;
		}
		_log.info("查询到快递公司信息为: {}", mo);
		to.setCustomerName(mo.getCompanyAccount());
		to.setCustomerPwd(mo.getCompanyPwd());
		to.setPayType(mo.getPayType());
		to.setOrderRemark(to.getOrderTitle());
		to.setShipperName(mo.getCompanyName());
		to.setShipperCode(mo.getCompanyCode());
		// to.setMonthCode(mo.getMonthCode());
		// to.setSendsite(sendsite);

		_log.info("组织要传递的参数");
		Map<String, Object> requestMap = new LinkedHashMap<>();
		try {
			// 应用级参数
			String requestData = "{";
			requestData += "\"ShipperCode\":\"" + to.getShipperCode() + "\","; // 快递公司编码
			requestData += "\"CustomerName\":\"" + to.getCustomerName() + "\",";// 电子面单客户号
			if (to.getCustomerPwd() != null && to.getCustomerPwd() != "") {
				requestData += "\"CustomerPwd\":\"" + to.getCustomerPwd() + "\",";// 电子面单密码/密钥
			}
			if (mo.getMonthCode() != null && mo.getMonthCode() != "") {
				requestData += "\"MonthCode\":\"" + mo.getMonthCode() + "\",";// 电子面单密码/密钥
			}
			if (mo.getSendSite() != null && mo.getSendSite() != "") {
				requestData += "\"SendSite\":\"" + mo.getSendSite() + "\",";
			}

			// 运费支付方式: 1-现付，2-到付，3-月结，4-第三方付
			Byte payType = to.getPayType();
			if (payType == null) {

				payType = (byte) PayTypeDic.ON_THE_SPOT.getCode(); // 默认现付
			}
			requestData += "\"PayType\":" + payType + ","; // 运费支付方式: 1-现付，2-到付，3-月结，4-第三方付
			// 快递类型 1-标准快件
			Byte expType = to.getExpType();
			if (expType == null) {
				expType = 1;
			}
			requestData += "\"ExpType\":" + expType + ","; // 快递类型
			// 是否返回打印页面
			String isReturnPrintPage = "1";
			requestData += "\"IsReturnPrintTemplate\":\"" + isReturnPrintPage + "\","; // 是否返回打印页面(0-不需要，1-需要)
			// 订单ID
			requestData += "\"OrderCode\":\"" + to.getOrderId() + "\","; // 订单编号(自定义，不可重复)
			// 商品名称
			requestData += "\"Commodity\":[{";
			// requestData += "\"GoodsName\":\"" + to.getOrderTitle() + "\""; // 商品名称
			requestData += "\"GoodsName\":\"" + "需要替换的标题" + "\""; // 商品名称
			requestData += "}],";
			// 订单备注
			String remark = to.getOrderRemark();
			if (StringUtils.isBlank(remark))
				requestData += "\"Remark\":" + remark + ","; // 备注
			// 发件人
			requestData += "\"Sender\":{"; // 发件人
			requestData += "\"Name\":\"" + to.getSenderName() + "\","; // 发件人名称
			requestData += "\"Tel\":\"" + to.getSenderTel() + "\","; // 发件人电话
			requestData += "\"Mobile\":\"" + to.getSenderMobile() + "\","; // 发件人手机
			requestData += "\"ProvinceName\":\"" + to.getSenderProvince() + "\","; // 发件省
			requestData += "\"CityName\":\"" + to.getSenderCity() + "\","; // 发件市
			requestData += "\"ExpAreaName\":\"" + to.getSenderExpArea() + "\","; // 发件区/县
			requestData += "\"Address\":\"" + to.getSenderAddress() + "\","; // 发件人详细地址
			requestData += "\"PostCode\":\"" + to.getSenderPostCode() + "\""; // 发件地邮编
			requestData += "},";
			// 收件人
			requestData += "\"Receiver\":{"; // 收件人
			requestData += "\"Name\":\"" + to.getReceiverName() + "\","; // 收件人名称
			requestData += "\"Tel\":\"" + to.getReceiverTel() + "\","; // 收件人电话
			requestData += "\"Mobile\":\"" + to.getReceiverMobile() + "\","; // 收件人手机
			requestData += "\"PostCode\":\"" + to.getReceiverPostCode() + "\","; // 收件省
			requestData += "\"ProvinceName\":\"" + to.getReceiverProvince() + "\","; // 收件市
			requestData += "\"CityName\":\"" + to.getReceiverCity() + "\","; // 收件区/县
			requestData += "\"ExpAreaName\":\"" + to.getReceiverExpArea() + "\","; // 收件人详细地址
			requestData += "\"Address\":\"" + to.getReceiverAddress() + "\""; // 收件地邮编
			requestData += "}";
			requestData += "}";

			requestMap.put("RequestData", URLEncoder.encode(requestData, "UTF-8"));

			// 系统级参数
			requestMap.put("EBusinessID", _ebusinessid);
			requestMap.put("RequestType", "1007");
			requestMap.put("DataSign", URLEncoder.encode(KdNiaoSignUtils.sign(requestData, _apikey, "UTF-8"), "UTF-8"));
			requestMap.put("DataType", "2");// 2-json
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("not arrival");
		}
		_log.info("请求电子面单报文：{}", requestMap);
		try {
			String url = EORDER_URL;
			if (_isSandBox)
				url = EORDER_URL_SANDBOX;
			_log.info("向快递鸟服务器发出请求-电子面单：{}", url);
			// Map<String, Object> resultMap
			// =jsonParser.parseMap(OkhttpUtils.postByFormParams(url, requestMap));
			Map<String, Object> resultMap = jsonParser.parseMap(HttpClientUtils.postByJsonParams(url, requestMap));
			// Map<String, Object> resultMap
			// =jsonParser.parseMap(HttpTest.httpRequest(url,"POST",requestMap));
			if ((boolean) resultMap.get("Success")) {
				_log.info("电子面单的请求返回成功");
				@SuppressWarnings("unchecked")
				Map<String, Object> orderMap = (Map<String, Object>) resultMap.get("Order");
				String logisticCode = (String) orderMap.get("LogisticCode");
				String printPage = String.valueOf(resultMap.get("PrintTemplate"));
				_log.info("返回的打印模板：{}", printPage);
				if (to.getShipperCode().equals("HTKY")) {
					printPage = printPage.replaceAll("<td class=\"f11\">", "<td class=\"b f11\">");
					printPage = printPage.replaceAll("<td class=\"f8\">", "<td class=\"b f11\">");
					printPage = printPage.replaceAll("数量：1&nbsp;&nbsp;重量：1kg&nbsp;&nbsp;", " ");
					printPage = printPage.replace("<td width=\"90\" rowspan=\"2\" class=\"xx10 vt\">",
							"<td width=\"1\" rowspan=\"2\" class=\"xx10 vt\">");
					printPage = printPage.replace("<tr height=\"44\">", "<tr height=\"70\">");
					printPage = printPage.replace("width: 375px;", "width: 450px;");
					printPage = printPage.replace("<img class=\"mb-3\" width=\"270\"",
							"<img class=\"mb-3\" width=\"370\"");
					printPage = printPage.replace("<table class=\"print_paper\" height=\"74\">",
							"<table class=\"print_paper\" height=\"100\">");
					printPage = printPage.replace("<td width=\"77\" class=\"tc\">", "<td width=\"1\" class=\"tc\">");
					printPage = printPage.replace("<td width=\"157\" class=\"f7\">", "<td width=\"257\" class=\"f7\">");
					printPage = printPage.replace("<img class=\"mb-3\" width=\"176\"",
							"<img class=\"mb-3\" width=\"250\"");
					printPage = printPage.replace("<td class=\"tc f14 b\">",
							"<td class=\"tc f18 b\" style=\"line-height: 1;letter-spacing: 8px;\">");
					printPage = printPage.replace("<div class=\"f8\">", "<div class=\"b f11\">");
				} else if (to.getShipperCode().equals("YZPY")) {
					printPage = printPage.replace("width: 375px;", "width: 450px;");
					printPage = printPage.replaceAll("<td class=\"f11 vt\">", "<td class=\"f11 b vt\">");
					printPage = printPage.replaceAll("<td class=\"f9 lh14 vt\" rowspan=\"2\" width=\"92\">",
							"<td class=\"f9 lh14 vt\" rowspan=\"2\" width=\"1\">");
					printPage = printPage.replaceAll("<td class=\"f9 vt\">", "<td class=\"f11 b vt\">");
					printPage = printPage.replaceAll("<img width=\"270\"", "<img width=\"330\"");
					printPage = printPage.replaceAll("<td class=\"tc f15 lh14 b fam\">",
							"<td class=\"tc f15 lh14 b fam\" style = \"letter-spacing: 10px;\">");
					printPage = printPage.replaceAll("<td class=\"tc\" width=\"74\">", "<td class=\"tc\" width=\"1\">");
					printPage = printPage.replaceAll("<td class=\"f8\" width=\"166\">",
							"<td class=\"f8\" width=\"200\">");
					printPage = printPage.replaceAll("<img width=\"176\" height=\"30\"",
							"<img width=\"220\" height=\"30\"");
					printPage = printPage.replaceAll("数量：1&nbsp;&nbsp;重量：1kg&nbsp;&nbsp;", " ");
					printPage = printPage.replaceAll("服务</div>", "</div>");
					printPage = printPage.replaceAll("付款方式：寄付月结", "");
					printPage = printPage.replaceAll("<tr height=\"48\">", "<tr height=\"70\">");
					printPage = printPage.replaceAll("<tr height=\"37\">", "<tr height=\"60\">");
					printPage = printPage.replaceAll("已检视", "客户号：80000010128574");
					printPage = printPage.replaceAll("<div class=\"abs\" style=\"top: 85px;right: 5px;\">",
							"<div class=\"abs b\" style=\"top: 85px;right: 5px;\">");
				}

				// 替换备注内容。
				String goodName = "<div class=\"b f11\">" + to.getOrderTitle() + "</div> <div ";
				printPage = printPage.replaceAll("<div class=\"b f11\"> 需要替换的标题</div>", goodName);
				_log.info("替换后的paga是: {}", printPage);

				Date now = new Date();
				// 添加新的物流订单
				KdiLogisticMo logisticMo = dozerMapper.map(to, KdiLogisticMo.class);
				logisticMo.setLogisticCode(logisticCode);
				logisticMo.setPrintPage(printPage);
				logisticMo.setUpdateTime(now);
				logisticMo.setOrderTime(now);
				logisticMo.setOrgId(to.getOrgId());
		        //如果录入类型为空那么设置录入类型为自动  1：手动 2：自动
		        if(logisticMo.getEntryType()==null || logisticMo.getEntryType() ==0) {
		        	logisticMo.setEntryType((byte)2);
		        }
				_log.info("电子面单添加新的物流订单的参数为：{}", logisticMo);
				logisticSvc.add(logisticMo);
				ro.setResult(EOrderResultDic.SUCCESS);
				ro.setLogisticId(logisticMo.getId());
				ro.setLogisticCode(logisticCode);
				// ro.setPrintPage(URLEncoder.encode(printPage, "UTF-8"));
				ro.setPrintPage(printPage);
				return ro;
			} else {
				// 取出请求失败的原因
				String failReason = (String) resultMap.get("Reason");
				String resultCode = (String) resultMap.get("ResultCode");
				_log.warn("电子面单的请求返回失败：{}-{}", resultCode, failReason);
				ro.setResult(EOrderResultDic.FAILT);
				ro.setFailReason(resultCode + "-" + failReason);
				return ro;
			}
		} catch (IOException e) {
			_log.error("请求快递鸟API服务器失败", e);
			ro.setResult(EOrderResultDic.FAILT);
			ro.setFailReason("请求快递鸟API服务器失败:" + e.getMessage());
			return ro;
		} catch (DuplicateKeyException e) {
			String msg = "重复下单: {}" + to.getOrderId();
			_log.warn(msg);
			ro.setResult(EOrderResultDic.REPEAT);
			ro.setFailReason(msg);
			return ro;
		}
	}

	/**
	 * 订阅物流轨迹
	 * 
	 * @Description: 向物流平台（快递鸟）订阅物流轨迹信息，当产生轨迹或有变动时，物流平台会向本系统的轨迹推送接口发出消息通知。
	 *               支持的快递公司:除顺丰、天天、申通外，其他主流快递公司都支持。
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public SubscribeTraceRo subscribeTrace(SubscribeTraceTo to) {
		_log.info("快递鸟订阅物流轨迹：{}", to);
		SubscribeTraceRo ro = new SubscribeTraceRo();

		// 检验参数是否正确
		if (to.getOrderId() == null
				|| StringUtils.isAnyBlank(to.getShipperCode(), to.getLogisticCode(), to.getSenderName(),
						to.getSenderProvince(), to.getSenderCity(), to.getSenderExpArea(), to.getSenderAddress(),
						to.getReceiverName(), to.getReceiverProvince(), to.getReceiverCity(), to.getReceiverExpArea(),
						to.getReceiverAddress())
				|| StringUtils.isAllBlank(to.getSenderTel(), to.getSenderMobile())
				|| StringUtils.isAllBlank(to.getReceiverTel(), to.getReceiverMobile())) {
			_log.warn("没有填写必要的参数:{}", to);
			ro.setResult(SubscribeTraceResultDic.PARAM_ERROR);
			return ro;
		}

		// 组织要传递的参数
		Map<String, Object> requestMap = new LinkedHashMap<>();
		try {
			// 应用级参数
			String requestData = "{";
			requestData += "\"ShipperCode\":\"" + to.getShipperCode() + "\","; // 快递公司编码
			requestData += "\"LogisticCode\":\"" + to.getLogisticCode() + "\","; // 快递单号
			int iIsNotice = to.getIsNotice() == null || !to.getIsNotice() ? 1 : 0; // 是否通知快递员上门揽件
			requestData += "\"IsNotice\":" + iIsNotice + ",";
			// 发件人
			requestData += "\"Sender\":{"; // 发件人
			requestData += "\"Name\":\"" + to.getSenderName() + "\","; // 发件人名称
			requestData += "\"Tel\":\"" + to.getSenderTel() + "\","; // 发件人电话
			requestData += "\"Mobile\":\"" + to.getSenderMobile() + "\","; // 发件人手机
			requestData += "\"ProvinceName\":\"" + to.getSenderProvince() + "\","; // 发件省
			requestData += "\"CityName\":\"" + to.getSenderCity() + "\","; // 发件市
			requestData += "\"ExpAreaName\":\"" + to.getSenderExpArea() + "\","; // 发件区/县
			requestData += "\"Address\":\"" + to.getSenderAddress() + "\","; // 发件人详细地址
			requestData += "\"PostCode\":\"" + to.getSenderPostCode() + "\""; // 发件地邮编
			requestData += "},";
			// 收件人
			requestData += "\"Receiver\":{"; // 收件人
			requestData += "\"Name\":\"" + to.getReceiverName() + "\","; // 收件人名称
			requestData += "\"Tel\":\"" + to.getReceiverTel() + "\","; // 收件人电话
			requestData += "\"Mobile\":\"" + to.getReceiverMobile() + "\","; // 收件人手机
			requestData += "\"PostCode\":\"" + to.getReceiverPostCode() + "\","; // 收件省
			requestData += "\"ProvinceName\":\"" + to.getReceiverProvince() + "\","; // 收件市
			requestData += "\"CityName\":\"" + to.getReceiverCity() + "\","; // 收件区/县
			requestData += "\"ExpAreaName\":\"" + to.getReceiverExpArea() + "\","; // 收件人详细地址
			requestData += "\"Address\":\"" + to.getReceiverAddress() + "\""; // 收件地邮编
			requestData += "}";
			requestData += "}";
			requestMap.put("RequestData", URLEncoder.encode(requestData, "UTF-8"));
			// 系统级参数
			requestMap.put("EBusinessID", _ebusinessid);
			requestMap.put("RequestType", "1008");
			requestMap.put("DataSign", URLEncoder.encode(KdNiaoSignUtils.sign(requestData, _apikey, "UTF-8"), "UTF-8"));
			requestMap.put("DataType", "2");// 2-json
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("not arrival");
		}

		try {
			String url = SUBCRIBE_TRACE_URL;
			if (_isSandBox)
				url = SUBCRIBE_TRACE_URL_SANDBOX;
			_log.info("向快递鸟服务器发出请求-订阅物流轨迹：{}", url);
			Map<String, Object> resultMap = jsonParser.parseMap(OkhttpUtils.postByFormParams(url, requestMap));
			if ((boolean) resultMap.get("Success")) {
				_log.info("订阅物流轨迹的请求返回成功");
				try {
					// 添加新的物流订单
					KdiLogisticMo logisticMo = dozerMapper.map(to, KdiLogisticMo.class);
					logisticMo.setUpdateTime(new Date());
					logisticSvc.add(logisticMo);
				} catch (DuplicateKeyException e) {
					String failReason = "订阅成功，但是该物流公司已经存在相同的物流单号";
					_log.warn(failReason, e);
					ro.setFailReason(failReason);
				}
				ro.setResult(SubscribeTraceResultDic.SUCCESS);
				return ro;
			} else {
				String failReason = (String) resultMap.get("Reason");
				_log.warn("订阅物流轨迹的请求返回失败：{}", failReason);
				ro.setResult(SubscribeTraceResultDic.FAILT);
				ro.setFailReason(failReason);
				return ro;
			}
		} catch (IOException e) {
			_log.error("请求快递鸟API服务器失败", e);
			ro.setResult(SubscribeTraceResultDic.FAILT);
			ro.setFailReason("请求快递鸟API服务器失败");
			return ro;
		}
	}

	/**
	 * 更新物流轨迹
	 * 
	 * @Description: 当物流轨迹有变时，用来接收快递鸟的推送通知
	 * 
	 * @param paramMap
	 *            接收到的物流轨迹的信息
	 * 
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
	public KdNiaoUpdateTraceRo updateTrace(Map<String, Object> paramMap) {
		_log.info("快递鸟更新物流轨迹：{}", paramMap);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// 取出requestData
		String sRequestData = (String) paramMap.get("RequestData");

		_log.debug("验证签名");
		if (!paramMap.get("DataSign").equals(KdNiaoSignUtils.sign(sRequestData, _apikey, "UTF-8"))) {
			_log.warn("验证签名错误：{}", paramMap);
			return null;
		}
		_log.debug("验证签名成功");

		try {
			_log.debug("解析物流的json字符串");
			Map<String, Object> requestData = jsonParser.parseMap(sRequestData);
			Date updateTime = sdf.parse((String) requestData.get("PushTime"));
			_log.debug("遍历物流订单数据");
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> logistices = (List<Map<String, Object>>) requestData.get("Data"); // 物流订单
			for (Map<String, Object> logistic : logistices) {
				try {
					selfSvc.updateTraceOfLogistic(logistic, updateTime);
				} catch (Exception e) {
					_log.error("更新物流轨迹出现异常:" + logistic, e);
				}
			}

			KdNiaoUpdateTraceRo ro = new KdNiaoUpdateTraceRo();
			ro.setEBusinessID(_ebusinessid);
			ro.setSuccess(true);
			ro.setUpdateTime(updateTime);
			return ro;
		} catch (ParseException e) {
			e.printStackTrace();
			_log.error("解析日期错误：" + sRequestData);
			return null;
		}
	}

	/**
	 * 查询物流轨迹
	 * 
	 * @Description:根据快递公司编码和快递单号查询物流轨迹
	 * 
	 * @param shipperCode
	 *            快递公司编码
	 * @param logisticCode
	 *            快递单号
	 */
	@Override
	public LogisticRo getTraces(String shipperCode, String logisticCode) {
		KdiLogisticMo logisticMo = logisticSvc.getOne(shipperCode, logisticCode);
		if (logisticMo == null) {
			_log.info("根据快递公司编码和快递单号没有查询到相应的物流订单:{},{}", shipperCode, logisticCode);
			return null;
		}
		LogisticRo ro = dozerMapper.map(logisticMo, LogisticRo.class);
		List<KdiTraceMo> list = traceSvc.list(logisticMo.getId());
		List<TraceRo> traces = new LinkedList<>();
		for (KdiTraceMo kdiTraceMo : list) {
			traces.add(dozerMapper.map(kdiTraceMo, TraceRo.class));
		}
		ro.setTraces(traces);
		return ro;
	}

	/**
	 * 更新获取物流的轨迹
	 * 
	 * @Description: 接收到快递鸟的推送通知里面具体的一个物流单的轨迹信息
	 * 
	 * @param logistic
	 *            接收到的物流的信息
	 * @param updateTime
	 *            更新时间
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void updateTraceOfLogistic(Map<String, Object> logistic, Date updateTime) throws ParseException {
		Boolean success = (Boolean) logistic.get("Success"); // 是否成功
		if (success == null || !success) {
			String Reason = (String) logistic.get("Reason"); // 失败原因
			_log.error("接收到返回错误的物流单信息-{}:{}", Reason, MapUtils.map2Str(logistic));
			return;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String shipperCode = (String) logistic.get("ShipperCode"); // 快递公司编码
		String logisticCode = (String) logistic.get("LogisticCode"); // 快递单号
		KdiLogisticMo logisticMo = logisticSvc.getOne(shipperCode, logisticCode);
		if (logisticMo == null) {
			_log.warn("收到未有订阅的物流轨迹，可能是丢失了之前电子下单或订阅的数据", logistic);
			logisticMo = new KdiLogisticMo();
			logisticMo.setShipperCode(shipperCode); // 快递公司编码
			logisticMo.setLogisticCode(logisticCode); // 快递单号
			logisticMo.setUpdateTime(updateTime); // 更新时间
			logisticMo.setLogisticStatus((String) logistic.get("State")); // 物流状态
			String sEstimatedArrivalTime = (String) logistic.get("EstimatedDeliveryTime"); // 预计到达时间
			logisticMo.setEstimatedArrivalTime(sEstimatedArrivalTime == null ? null : sdf.parse(sEstimatedArrivalTime));
			logisticMo.setCity((String) logistic.get("Location")); // 所在城市
			logisticSvc.add(logisticMo);
		} else {
			logisticMo.setShipperCode(shipperCode); // 快递公司编码
			logisticMo.setLogisticCode(logisticCode); // 快递单号
			logisticMo.setUpdateTime(updateTime); // 更新时间
			logisticMo.setLogisticStatus((String) logistic.get("State")); // 物流状态
			String sEstimatedArrivalTime = (String) logistic.get("EstimatedDeliveryTime"); // 预计到达时间
			logisticMo.setEstimatedArrivalTime(sEstimatedArrivalTime == null ? null : sdf.parse(sEstimatedArrivalTime));
			logisticMo.setCity((String) logistic.get("Location")); // 所在城市
			logisticSvc.modify(logisticMo);

			// 删除之前的轨迹
			traceSvc.delByLogisticId(logisticMo.getId());
		}

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> traces = (List<Map<String, Object>>) logistic.get("Traces"); // 轨迹
		for (Map<String, Object> trace : traces) {
			KdiTraceMo traceMo = new KdiTraceMo();
			traceMo.setLogisticId(logisticMo.getId()); // 物流ID
			traceMo.setTraceDesc((String) trace.get("AcceptStation")); // 轨迹描述
			traceMo.setHappenTime(sdf.parse((String) trace.get("AcceptTime"))); // 发生时间
			traceMo.setLogisticStatus((String) trace.get("Action")); // 物流状态
			traceMo.setCity((String) trace.get("Location")); // 所在城市
			traceSvc.add(traceMo);
		}

	}

}