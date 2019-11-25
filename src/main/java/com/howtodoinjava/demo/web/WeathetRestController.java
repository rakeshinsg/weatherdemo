package com.howtodoinjava.demo.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.dbs.json.model.WeatherResponse;
import com.dbs.util.MapBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.LatitudeLangnitude;
import com.howtodoinjava.demo.service.EmployeeService;

@RequestMapping("/weather")
@Controller
public class WeathetRestController 
{
	final String  KEY ="21f2581528c075976044306c74d30c6c";
	String BASE_URI="https://api.darksky.net/forecast/"+KEY;
	
	Map<String, LatitudeLangnitude> map = null;
	
	//@Autowired
	RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	EmployeeService service;

	
	@RequestMapping(path = "/weatherdetails")
	public String getWeatherDetails(Model model) 
							throws RecordNotFoundException 
	{
		map  = MapBuilder.build();
		List<WeatherResponse> list = new ArrayList<>();
		
		for (Entry<String, LatitudeLangnitude> mapEntry : map.entrySet()) {
			String weather_uri = BASE_URI+"/"+mapEntry.getValue().getLatitude()+","+mapEntry.getValue().getLongitude();
		System.out.println(restTemplate.getForEntity(weather_uri,String.class).getBody());
		//System.out.println(restTemplate.getForEntity(weather_uri,String.class).toString().replaceAll("\\", ""));
			//list.add(covertJsonToResponseObj(restTemplate.getForEntity(weather_uri,String.class).toString().replaceAll("\\\\", "")));
			list.add(covertJsonToResponseObj(restTemplate.getForEntity(weather_uri,String.class)));
		}
		
		model.addAttribute("weatherdetails", list);
		return "weather-details";
	}
	
	public WeatherResponse covertJsonToResponseObj(ResponseEntity<String> response) {
		ObjectMapper mapper = new ObjectMapper();
		WeatherResponse obj=null;
		try {
			obj = mapper.readValue(response.getBody(), WeatherResponse.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	
	@GetMapping(path = "/details")
	public List<String> getWeatherInfoAPI() 
			throws RecordNotFoundException 
	{
		map  = MapBuilder.build();
		List<String> list = new ArrayList<>();
		
		for (Entry<String, LatitudeLangnitude> mapEntry : map.entrySet()) {
			String weather_uri = BASE_URI+"/"+mapEntry.getValue().getLatitude()+","+mapEntry.getValue().getLongitude();
//			System.out.println(restTemplate.getForEntity(weather_uri,String.class).toString().replaceAll("\\", ""));
			
			list.add(restTemplate.getForEntity(weather_uri,String.class).toString().replaceAll("\\\\", ""));
		}
		
		return list;
	}
	

	@GetMapping(path = {"{latitude},{longitude}"})
	public ResponseEntity<String> getWeatherInfoAPI(@PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude) 
							throws RecordNotFoundException 
	{
		
		System.out.println( latitude +" : "+ longitude);
		String weather_uri = BASE_URI+"/"+latitude+","+longitude;
		return restTemplate.getForEntity(weather_uri,String.class);
	}
	
	
}
