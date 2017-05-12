package muyi.weather.controller.httpdata;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import muyi.weather.service.HttpDataService;
import muyi.weather.util.Utility;

@RestController
public class HttpDataController {
	@Autowired
	private Utility utility;
	@Autowired
	private HttpDataService httpDataService;
	
	/**
	 * HOME页面访问
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	@RequestMapping(value="/",method=RequestMethod.POST)
    @ResponseBody
    String home(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {  	   	
    	String weatherdata=httpDataService.getWeatherFromHttp(httpServletRequest.getParameter("cityId")); 
        return utility.crossDomain(httpServletResponse, weatherdata);
    }
	/**
	 * 获取省级数据
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	@RequestMapping(value="/province",method=RequestMethod.GET)
    String provinces(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {  	   	
    	String data=httpDataService.getProvincesFromHttp();   	 
        return utility.crossDomain(httpServletResponse,data);
    }
	/**
	 * 获取市级数据
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	@RequestMapping(value="/city",method=RequestMethod.POST)
    String cities(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {  	   	
    	String data=httpDataService.getCitiesFromHttp(httpServletRequest.getParameter("provinceId"));  	 
        return utility.crossDomain(httpServletResponse,data);
    }
	/**
	 * 获取县级数据
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	@RequestMapping(value="/county",method=RequestMethod.POST)
    String counties(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {  	   	
    	String data=httpDataService.getCountiesFromHttp(httpServletRequest.getParameter("provinceId"),httpServletRequest.getParameter("cityId"));   	 
        return utility.crossDomain(httpServletResponse,data);
    }
	/**
	 * 获取背景图URL
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	@RequestMapping(value="/bgUrl",method=RequestMethod.GET)
    String backgroundUrl(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {  	   	
    	String data=httpDataService.getBackgroundImgUrl();
        return new Gson().toJson(utility.crossDomain(httpServletResponse,data))  ;
    }
	
}
