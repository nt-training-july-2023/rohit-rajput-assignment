package com.map;

import java.util.HashMap;
import java.util.Map;

public class Question4 {
	public static void main(String[] args) {
		Map<String ,Integer > map = new HashMap<String, Integer>();
		map.put("chair", 500);
		map.put("table",1500);
		map.put("bike",90000);
		System.out.println(map.containsKey("chair"));
		System.out.println(map.containsKey("car"));
		System.out.println(map.containsValue(500));
		System.out.println(map.containsValue(1500));
		System.out.println(map.containsValue(5000));
	}

}
