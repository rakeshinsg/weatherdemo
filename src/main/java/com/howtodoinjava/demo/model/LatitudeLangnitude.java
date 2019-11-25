package com.howtodoinjava.demo.model;

public class LatitudeLangnitude {
	String latitude;
	String longitude;
	String city;
	
	public LatitudeLangnitude(String latitude, String longitude, String city) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	

}
