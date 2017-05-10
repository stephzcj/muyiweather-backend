package muyi.weather.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/**
 * 外部配置文件对应的类，spring-boot会按变量名字自动set值
 * @author zhongchunjie
 */
@ConfigurationProperties(prefix = "muyi.weather")
@PropertySource("classpath:config/muyi-config.properties")
@Component
public class MuyiConfig {
	private String apiUrl;
	private String urlKey;
	private String queryCitiesUrl;
	private String crossDomainUrl;
	
	public String getCrossDomainUrl() {
		return crossDomainUrl;
	}
	public void setCrossDomainUrl(String crossDomainUrl) {
		this.crossDomainUrl = crossDomainUrl;
	}
	public String getQueryCitiesUrl() {
		return queryCitiesUrl;
	}
	public void setQueryCitiesUrl(String queryCitiesUrl) {
		this.queryCitiesUrl = queryCitiesUrl;
	}
	public String getApiUrl() {
		return apiUrl;
	}
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	public String getUrlKey() {
		return urlKey;
	}
	public void setUrlKey(String urlKey) {
		this.urlKey = urlKey;
	}
	

}
