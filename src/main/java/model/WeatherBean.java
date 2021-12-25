package model;

public class WeatherBean {

	private String cityStr;
	private String countryStr;

	private String cloudsStr;
	
	
	private String description;

	private String temperatureStr;
	private int tempC;
	
	private String precipitation;
	
	//Because icons are emoji's, stores the icon directly as a string.
	private String icon;

	public WeatherBean(String cityStr, String countryStr) {

		this.cityStr = cityStr;
		this.countryStr = countryStr;

	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public String getTemperature() {
		return temperatureStr;
	}

	public void setTemperature(String temperatureStr) {
		this.temperatureStr = temperatureStr;
		tempConvertKtoC(temperatureStr);
	}
	
	public String getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(String precipitation) {
		this.precipitation = precipitation;
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
		return icon;
	}

	public void setIcon(String icon) {	
		this.icon = icon;
	}

	
	public void generateIcon (String iconID) {
		//☀️🌞☁️⛅🌤️🌥️🌦️🌧️🌨️⛈️🌩️❄️
		switch(iconID) {
		case "01d": this.icon="🌞";
			break;
		case "01n": this.icon="🌝";
			break;
		case "02d": this.icon="⛅";
			break;
		case "02n": this.icon="🌚";
			break;
		case "04d": 
		case "04n":
			this.icon="☁️";
			break;
		case "09d":
		case "09n":
			this.icon="🌧️";
			break;
		case "10d":
		case "10n":
			this.icon="🌦️";
			break;
		case "11d":
		case "11n":
			if (precipitation.equals("no")) {
				this.icon="🌩️";
			} else {
				this.icon="⛈️";
			}
			break;
		case "13d":
		case "13n":
			this.icon="❄️";
			break;
		case "50d":
		case "50n":
			this.icon="🌫️";
			break;
		}
	}

}
