package rebue.kdi;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rebue.wheel.OkhttpUtils;

public class KdiTests {
    private final static Logger _log     = LoggerFactory.getLogger(KdiTests.class);

//    private String              _hostUrl = "http://localhost:20080";
    private String _hostUrl = "http://192.168.1.201/kdi-svr";
//    private String _hostUrl = "http://120.79.251.116/kdi-svr";

    /**
     * 测试识别快递单号
     */
//    @Test
    public void test01() throws IOException {
        _log.info("测试识别快递单号");
        String url = _hostUrl + "/kdi/logisticcode/identify";
        _log.info("传入会识别失败的快递单号");
        Map<String, Object> paramsMap = new LinkedHashMap<>();
        paramsMap.put("logisticCode", "1234560");
        _log.info(OkhttpUtils.get(url, paramsMap));
        _log.info("传入会识别成功的快递单号");
        paramsMap = new LinkedHashMap<>();
        paramsMap.put("logisticCode", "1234561");
        _log.info(OkhttpUtils.get(url, paramsMap));
        _log.info("传入实际的快递单号");
        paramsMap = new LinkedHashMap<>();
        paramsMap.put("logisticCode", "9620153295343");
        _log.info(OkhttpUtils.get(url, paramsMap));
        paramsMap = new LinkedHashMap<>();
        paramsMap.put("logisticCode", "9620153295616");
        _log.info(OkhttpUtils.get(url, paramsMap));
        paramsMap = new LinkedHashMap<>();
        paramsMap.put("logisticCode", "9620153295597");
        _log.info(OkhttpUtils.get(url, paramsMap));
        paramsMap = new LinkedHashMap<>();
        paramsMap.put("logisticCode", "50867033106901");
        _log.info(OkhttpUtils.get(url, paramsMap));
    }

    /**
     * 测试电子面单
     */
//    @Test
    public void test02() throws IOException {
        _log.info("测试电子面单");
        String url = _hostUrl + "/kdi/eorder";
        Map<String, Object> paramsMap;

        _log.info("传入测试的快递公司编码");
        paramsMap = new LinkedHashMap<>();
        paramsMap.put("shipperCode", "ZTO");
        paramsMap.put("orderId", 460236198409928709L);
        paramsMap.put("orderTitle", "测试订单标题");
        paramsMap.put("senderName", "1255760");
        paramsMap.put("senderTel", "0755-0907283");
        paramsMap.put("senderMobile", "13700000000");
        paramsMap.put("senderProvince", "广东省");
        paramsMap.put("senderCity", "深圳市");
        paramsMap.put("senderExpArea", "福田区");
        paramsMap.put("senderAddress", "测试地址");
        paramsMap.put("senderPostCode", "435100");
        paramsMap.put("receiverName", "1255760");
        paramsMap.put("receiverTel", "0755-11111111");
        paramsMap.put("receiverMobile", "13800000123");
        paramsMap.put("receiverProvince", "广东省");
        paramsMap.put("receiverCity", "深圳市");
        paramsMap.put("receiverExpArea", "龙华新区");
        paramsMap.put("receiverAddress", "测试地址2");
        paramsMap.put("receiverPostCode", "435100");
        _log.info(URLDecoder.decode(OkhttpUtils.postByFormParams(url, paramsMap), "UTF-8"));

        paramsMap = new LinkedHashMap<>();
        paramsMap.put("shipperCode", "HTKY");
        paramsMap.put("orderId", 460248386608562179L);
        paramsMap.put("orderTitle", "鞋子");
        paramsMap.put("senderName", "Taylor");
        paramsMap.put("senderTel", "0755-0907283");
        paramsMap.put("senderMobile", "15018442396");
        paramsMap.put("senderProvince", "上海");
        paramsMap.put("senderCity", "上海市");
        paramsMap.put("senderExpArea", "青浦区");
        paramsMap.put("senderAddress", "明珠路");
        paramsMap.put("senderPostCode", "435100");
        paramsMap.put("receiverName", "Yann");
        paramsMap.put("receiverTel", "0755-11111111");
        paramsMap.put("receiverMobile", "15018442396");
        paramsMap.put("receiverProvince", "北京");
        paramsMap.put("receiverCity", "北京市");
        paramsMap.put("receiverExpArea", "朝阳区");
        paramsMap.put("receiverAddress", "三里屯街道");
        paramsMap.put("receiverPostCode", "435100");
        _log.info(URLDecoder.decode(OkhttpUtils.postByFormParams(url, paramsMap), "UTF-8"));

    }

    /**
     * 测试订阅物流轨迹
     */
    @Test
    public void test03() throws IOException {
        _log.info("测试订阅物流轨迹");
        String url = _hostUrl + "/kdi/trace/subscribe";
        Map<String, Object> paramsMap = new LinkedHashMap<>();
        _log.info("传入测试的快递公司编码和快递单号");
        paramsMap.put("shipperCode", "ZTO");
        paramsMap.put("logisticCode", "1234561");
        paramsMap.put("orderId", 460229887731433473L);
        paramsMap.put("isNotice", true);
        paramsMap.put("senderName", "1255760");
        paramsMap.put("senderTel", "0755-0907283");
        paramsMap.put("senderMobile", "13700000000");
        paramsMap.put("senderProvince", "广东省");
        paramsMap.put("senderCity", "深圳市");
        paramsMap.put("senderExpArea", "福田区");
        paramsMap.put("senderAddress", "测试地址");
        paramsMap.put("senderPostCode", "435100");
        paramsMap.put("receiverName", "1255760");
        paramsMap.put("receiverTel", "0755-11111111");
        paramsMap.put("receiverMobile", "13800000123");
        paramsMap.put("receiverProvince", "广东省");
        paramsMap.put("receiverCity", "深圳市");
        paramsMap.put("receiverExpArea", "龙华新区");
        paramsMap.put("receiverAddress", "测试地址2");
        paramsMap.put("receiverPostCode", "435100");
        _log.info(OkhttpUtils.postByFormParams(url, paramsMap));

        _log.info("传入真实的快递公司编码和快递单号");

        paramsMap.put("shipperCode", "YZPY");
        paramsMap.put("logisticCode", "9620153295343");
        paramsMap.put("orderId", 460233151109660675L);
        paramsMap.put("isNotice", false);
        paramsMap.put("senderName", "张柏子");
        paramsMap.put("senderMobile", "13277779867");
        paramsMap.put("senderProvince", "广西壮族自治区");
        paramsMap.put("senderCity", "南宁市");
        paramsMap.put("senderExpArea", "西乡塘区");
        paramsMap.put("senderAddress", "安吉华尔街工谷微薄利商超1楼");
        paramsMap.put("senderPostCode", "530000");
        paramsMap.put("receiverName", "李小姐");
        paramsMap.put("receiverMobile", "13510643846");
        paramsMap.put("receiverProvince", "广东省");
        paramsMap.put("receiverCity", "深圳市");
        paramsMap.put("receiverExpArea", "宝安区");
        paramsMap.put("receiverAddress", "固戍一路287号联昇商务大厦616");
        paramsMap.put("receiverPostCode", "518101");
        _log.info(OkhttpUtils.postByFormParams(url, paramsMap));

        paramsMap.put("shipperCode", "YZPY");
        paramsMap.put("logisticCode", "9620153295616");
        paramsMap.put("orderId", 460249400132763653L);
        paramsMap.put("isNotice", false);
        paramsMap.put("senderName", "微薄利");
        paramsMap.put("senderMobile", "13657882081");
        paramsMap.put("senderProvince", "广西壮族自治区");
        paramsMap.put("senderCity", "南宁市");
        paramsMap.put("senderExpArea", "西乡塘区");
        paramsMap.put("senderAddress", "安吉华尔街工谷微薄利商超1楼");
        paramsMap.put("senderPostCode", "530000");
        paramsMap.put("receiverName", "胡继峰");
        paramsMap.put("receiverMobile", "18389389368");
        paramsMap.put("receiverProvince", "广东省");
        paramsMap.put("receiverCity", "东莞市");
        paramsMap.put("receiverExpArea", "大朗镇");
        paramsMap.put("receiverAddress", "黄草朗东胜路24号");
        paramsMap.put("receiverPostCode", "523770");
        _log.info(OkhttpUtils.postByFormParams(url, paramsMap));

        paramsMap.put("shipperCode", "YZPY");
        paramsMap.put("logisticCode", "9620153295597");
        paramsMap.put("orderId", 458083806935515186L);
        paramsMap.put("isNotice", false);
        paramsMap.put("senderName", "微薄利");
        paramsMap.put("senderMobile", "13657882081");
        paramsMap.put("senderProvince", "广西壮族自治区");
        paramsMap.put("senderCity", "南宁市");
        paramsMap.put("senderExpArea", "西乡塘区");
        paramsMap.put("senderAddress", "安吉华尔街工谷微薄利商超1楼");
        paramsMap.put("senderPostCode", "530000");
        paramsMap.put("receiverName", "张吉林");
        paramsMap.put("receiverMobile", "13517371465");
        paramsMap.put("receiverProvince", "湖南省");
        paramsMap.put("receiverCity", "益阳市");
        paramsMap.put("receiverExpArea", "未填");
        paramsMap.put("receiverAddress", "资江机器有限公司");
        paramsMap.put("receiverPostCode", "413000");
        _log.info(OkhttpUtils.postByFormParams(url, paramsMap));

        paramsMap.put("shipperCode", "HTKY");
        paramsMap.put("logisticCode", "50867033106901");
        paramsMap.put("orderId", 454457106171428908L);
        paramsMap.put("isNotice", false);
        paramsMap.put("senderName", "微薄利");
        paramsMap.put("senderMobile", "13657882081");
        paramsMap.put("senderProvince", "广西壮族自治区");
        paramsMap.put("senderCity", "南宁市");
        paramsMap.put("senderExpArea", "西乡塘区");
        paramsMap.put("senderAddress", "安吉华尔街工谷微薄利商超1楼");
        paramsMap.put("senderPostCode", "530000");
        paramsMap.put("receiverName", "百合");
        paramsMap.put("receiverMobile", "13760439505");
        paramsMap.put("receiverProvince", "广东省");
        paramsMap.put("receiverCity", "深圳市");
        paramsMap.put("receiverExpArea", "南山区");
        paramsMap.put("receiverAddress", "卓越维港北区中心路2116号宜修国际（宁波银行旁边）");
        paramsMap.put("receiverPostCode", "518000");
        _log.info(OkhttpUtils.postByFormParams(url, paramsMap));
    }

    /**
     * 测试查询物流轨迹
     */
//    @Test
    public void test04() throws IOException {
        _log.info("测试查询物流轨迹");
        String url = _hostUrl + "/kdi/trace";
        Map<String, Object> paramsMap = new LinkedHashMap<>();
        _log.info("传入测试的快递公司编码和快递单号");
        paramsMap.put("shipperCode", "SF");
        paramsMap.put("logisticCode", "1234561");
        _log.info(OkhttpUtils.get(url, paramsMap));
    }

}
