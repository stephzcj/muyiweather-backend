package muyi.weather.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import muyi.weather.service.HttpDataService;
import muyi.weather.util.Utility;
@ComponentScan(basePackages = "muyi.weather")
@Controller
@EnableAutoConfiguration
public class MainController {
	
	@Autowired
	private Utility utility;
	@Autowired
	private HttpDataService httpDataService;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
    @ResponseBody
    String home(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) {  	   	
    	String weatherdata=httpDataService.getWeatherFromHttp(httpServletRequest.getParameter("cityId")); 
        return utility.crossDomain(httpServletResponse, weatherdata);
    }
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainController.class, args);
       
    }

}
