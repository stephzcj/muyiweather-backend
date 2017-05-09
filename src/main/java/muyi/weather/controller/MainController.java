package muyi.weather.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import muyi.weather.util.MuyiConfig;
import muyi.weather.util.MuyiUtil;
import muyi.weather.util.Utility;
@ComponentScan(basePackages = "muyi.weather")
@Controller
@EnableAutoConfiguration
public class MainController {
	
	@Autowired
	private MuyiConfig muyiConfig;
	@Autowired
	private MuyiUtil muyiutil;
	
	@RequestMapping("/")
    @ResponseBody
    String home(HttpServletRequest request) {  	   	
    	String weatherdata=muyiutil.getWeatherFromHttp("CN101210103");   	 
        return Utility.jsonp(request,weatherdata);
    }
	
	@RequestMapping("/province")
    @ResponseBody
    String provinces(HttpServletRequest request) {  	   	
    	String weatherdata=muyiutil.getProvincesFromHttp();   	 
        return Utility.jsonp(request,weatherdata);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainController.class, args);
       
    }

}
