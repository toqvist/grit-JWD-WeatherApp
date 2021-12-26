package model;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class WeatherBean {

	private String city;
	private String country;

	private String clouds;
	private String description;
	private String precipitation;

	private String temperatureStr;
	private int tempC;
	
	//Because icons are emoji's, stores the icon directly as a string.
	private String icon;

	private String date;
	
	public WeatherBean(String city, String country) {

		this.city = city;
		this.country = country;
		this.date=java.time.LocalDate.now().toString();
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
	
	//Convert value from kelvin to celsius
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
	
	
	
	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getClouds() {
		return clouds;
	}

	public void setClouds(String clouds) {
		this.clouds = clouds;
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
