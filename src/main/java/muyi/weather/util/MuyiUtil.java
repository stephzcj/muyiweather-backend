package muyi.weather.util;


import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class MuyiUtil {
	
	@Autowired
	private MuyiConfig muyiConfig;
	
	public String getWeatherFromHttp(){
		CloseableHttpClient httpClient=HttpClients.createDefault();
		String url=muyiConfig.getApiUrl()+"?city="+"CN101210103"+"&key="+muyiConfig.getUrlKey();
		HttpPost httpPost=new HttpPost(url);
		try {
			CloseableHttpResponse response=httpClient.execute(httpPost);
			HttpEntity entity=response.getEntity();
			String jsonData=EntityUtils.toString(entity);
			System.out.println("结果为：====="+jsonData);
			return jsonData;
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				httpClient.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public static void main(String[] args){
		MuyiUtil aa=new MuyiUtil();
		aa.getWeatherFromHttp();
		//System.out.println(muyiConfig.getUrlKey());
	}
}
