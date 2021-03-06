package muyi.weather.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class Utility {
	
	private static Logger logger=LogManager.getLogger(Utility.class);
	@Autowired
	private MuyiConfig muyiConfig;
	public static String postHttpRequest(HttpPost httpPost){
		CloseableHttpClient httpClient=HttpClients.createDefault();
		try {
			CloseableHttpResponse response=httpClient.execute(httpPost);
			HttpEntity entity=response.getEntity();
			String jsonData=EntityUtils.toString(entity);
			logger.info(jsonData);
			return jsonData;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String getHttpRequest(HttpGet httpget){
		CloseableHttpClient httpClient=HttpClients.createDefault();
		try {
			CloseableHttpResponse response=httpClient.execute(httpget);
			HttpEntity entity=response.getEntity();
			String jsonData=EntityUtils.toString(entity);
			logger.info(jsonData);
			return jsonData;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static String jsonp(HttpServletRequest request,String returnData){
		String callback=request.getParameter("callback");
		return callback+"("+returnData+")";
	}
	
	public  String crossDomain(HttpServletResponse httpServletResponse,String returnData){
		httpServletResponse.setHeader("Access-Control-Allow-Origin", muyiConfig.getCrossDomainUrl());
		return returnData;
	}

}
