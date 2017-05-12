package muyi.weather.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "muyi.weather")
@EnableAutoConfiguration
public class AppStarter {	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppStarter.class, args); 
    }
}
