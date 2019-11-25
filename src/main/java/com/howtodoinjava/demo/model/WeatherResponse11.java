package com.howtodoinjava.demo.model;

public class WeatherResponse11 {
	String latitude;
	String longitude;
	String timezone;
	
	
	public WeatherResponse11() {
	}


	public WeatherResponse11(String latitude, String longitude, String timezone) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.timezone = timezone;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getTimezone() {
		return timezone;
	}


	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	
	
	
	

}
