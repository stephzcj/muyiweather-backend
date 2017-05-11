package muyi.weather.service;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import muyi.weather.util.MuyiConfig;
import muyi.weather.util.Utility;
@Component
public class HttpDataService {
	
	@Autowired
	private MuyiConfig muyiConfig;
	
	/**
	 * 访问和风天气API，获取免费版的全部天气信息
	 * @param String citySeries
	 * @return String jsonData
	 */
	public String getWeatherFromHttp(String citySeries){
		String url=muyiConfig.getApiUrl()+"?city="+citySeries+"&key="+muyiConfig.getUrlKey();
		HttpPost httpPost=new HttpPost(url);
		return Utility.postHttpRequest(httpPost);
	}
	
	/**
	 * 获取省的信息
	 * @param 
	 * @return String jsonData
	 */
	public String getProvincesFromHttp(){
		String address = muyiConfig.getQueryCitiesUrl();
		HttpGet httpGet=new HttpGet(address);
		return Utility.getHttpRequest(httpGet);
	}
	/**
	 * 获取城市的信息
	 * @param String provinceId
	 * @return String jsonData
	 */
	public String getCitiesFromHttp(String provinceId){
		String address = muyiConfig.getQueryCitiesUrl() + provinceId;
		HttpGet httpGet=new HttpGet(address);
		return Utility.getHttpRequest(httpGet);
	}
	/**
	 * 获取县级信息
	 * @param String CityId
	 * @return String jsonData
	 */
	public String getCountiesFromHttp(String provinceId,String cityId){
		String address = muyiConfig.getQueryCitiesUrl()+ provinceId + "/" + cityId;
		HttpGet httpGet=new HttpGet(address);
		return Utility.getHttpRequest(httpGet);
	}
	/**
	 * 获取背景图URL
	 * @param 
	 * @return String jsonData
	 */
	public String getBackgroundImgUrl(){
		String address=muyiConfig.getBackgroundImgUrl();
		HttpGet httpGet=new HttpGet(address);
		return Utility.getHttpRequest(httpGet);
	}
}
