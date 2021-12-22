package model;

public class WeatherBean {

	private String cityStr;

	private String countryStr;

	private String cloudsStr;
	
	//Because icons are emoji's, stores the icon directly.
	private String icon;
	
	private String weatherStr;

	private String temperatureStr;
	private int tempC;
	
	public String getTemperature() {
		return temperatureStr;
	}

	public void setTemperature(String temperatureStr) {
		this.temperatureStr = temperatureStr;
		tempConvertKtoC(temperatureStr);
	}
	
	public void tempConvertKtoC(String temperatureStr) {
		double celsius = Double.parseDouble(temperatureStr) - 273.15;
		System.out.println(celsius);
		int resultTemp = (int) Math.round(celsius);
		setTempC(resultTemp);
	}
	
	public double getTempC() {
		return tempC;
	}

	public void setTempC(int tempC) {
		this.tempC = tempC;
	}
	
	

	public WeatherBean(String cityStr, String countryStr) {

		this.cityStr = cityStr;
		this.countryStr = countryStr;

	}
	
	public String getCityStr() {
		return cityStr;
	}

	public String getCountryStr() {
		return countryStr;
	}

	public String getCloudsStr() {
		return cloudsStr;
	}

	public void setCloudsStr(String cloudsStr) {
		this.cloudsStr = cloudsStr;
	}
//
	public String getIcon() {
		this.icon = "🌧️";
		return icon;
	}

	public void setIcon(String icon) {	
		this.icon = icon;
	}

	
	private void generateIcon () {
		//☀️🌞☁️⛅⛈️🌤️🌥️🌦️🌧️🌨️🌩️
		switch(this.weatherStr) {
			case "Rain":  this.icon = "🌧️";
	        break;
		}
		
	
	}

}
