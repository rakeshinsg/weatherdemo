package com.dbs.util;

import java.util.HashMap;
import java.util.Map;

import com.howtodoinjava.demo.model.LatitudeLangnitude;

public class MapBuilder {
	
	public static Map<String, LatitudeLangnitude> build() {
		Map<String, LatitudeLangnitude> map = new HashMap<String, LatitudeLangnitude>();
		map.put("Jakartha", new LatitudeLangnitude("-6.21462","106.84513","Jakartha"));
		map.put("Nara Japan", new LatitudeLangnitude("34.68505","135.80485","Nara Japan"));
		map.put("Austin TX", new LatitudeLangnitude("30.26715","-97.74306","Austin TX"));
		map.put("Omaha", new LatitudeLangnitude("41.25861","-95.93779","Omaha"));
		
		return map;
		
	}

}
