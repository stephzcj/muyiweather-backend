package muyi.weather.controller.httpdata;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import muyi.weather.service.HttpDataService;
import muyi.weather.util.MuyiConfig;
import muyi.weather.util.Utility;

@RestController
public class HttpDataController {
	@Autowired
	private MuyiConfig muyiConfig;
	@Autowired
	private Utility utility;
	@Autowired
	private HttpDataService httpDataService;
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
	
}
