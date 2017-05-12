package muyi.weather.controller.httpdata;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import muyi.weather.service.ResourceService;
import muyi.weather.util.MuyiConfig;
import muyi.weather.util.Utility;

@RestController
@RequestMapping(value="/resource")
public class ResourceController {
	@Autowired
	ResourceService resourceService;
	@Autowired
	MuyiConfig muyiConfig;
	@Autowired
	private Utility utility;
	@RequestMapping(value="/pic")
	public String getResourcePic(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse){
		String relativeUrl=resourceService.getWeatherPic(httpServletRequest.getParameter("weather"));
		return new Gson().toJson(utility.crossDomain(httpServletResponse,muyiConfig.getResourceUrl()+relativeUrl));
	}
}
