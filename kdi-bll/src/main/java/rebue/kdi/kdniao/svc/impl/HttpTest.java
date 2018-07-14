package rebue.kdi.kdniao.svc.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpTest {

	private final static Logger _log = LoggerFactory.getLogger(HttpTest.class);
	private static ObjectMapper _objejctMapper = new ObjectMapper();

	public static String httpRequest(String requestUrl, String requestMethod, Map outputMap) {
		StringBuffer buffer = null;
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestMethod(requestMethod);
			conn.setRequestProperty("Content-Type",  "application/json"); 
			conn.connect();
			// 往服务器端写内容 也就是发起http请求需要带的参数
			if (null != outputMap) {
				OutputStream os = conn.getOutputStream();
				String jsonObject = _objejctMapper.writeValueAsString(outputMap);
				_log.info("解析后的jason参数：{}", jsonObject);
				os.write(jsonObject.getBytes("utf-8"));
				os.close();
			}

			// 读取服务器端返回的内容
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			buffer = new StringBuffer();
			String line = null;
			while ((line = br.readLine()) != null) {
				buffer.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		_log.info("收到的数据为：{}",buffer.toString());
		return buffer.toString();
	}
}
