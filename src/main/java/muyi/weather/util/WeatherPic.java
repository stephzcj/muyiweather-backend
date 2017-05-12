package muyi.weather.util;

public enum WeatherPic {
   CLOUDY("img/cloudy.jpeg")
   ,FROGGY("img/froggy.jpeg")
   ,RAINY("img/rainy.jpeg")
   ,SANDY("img/sandy.jpeg")
   ,SNOWY("img/snowy.jpeg")
   ,SUNNY("img/sunny.jpeg");
	
	
	private String resourceUrl;	
	private WeatherPic(String resourceUrl){
		this.resourceUrl=resourceUrl;
	}
	public String getResourceUrl() {
		return resourceUrl;
	}
	@Override
    public String toString() {
        return String.valueOf (this.resourceUrl);
    }
	
}
