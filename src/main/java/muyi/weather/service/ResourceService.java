package muyi.weather.service;

import org.springframework.stereotype.Service;

import muyi.weather.util.WeatherPic;

@Service
public class ResourceService {
	public String getWeatherPic(String weather){
		if(weather.contains("雨")){
			return WeatherPic.RAINY.getResourceUrl();		
		}
		
		return "";
	}
	
	
}
