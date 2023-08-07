package com.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Question5 {
	public static void main(String[] args) {
		Map<String ,Integer> map = new HashMap<String , Integer>();
		map.put("Virat",34);
		map.put("Rohit", 32);
		map.put("shubman", 23);
		map.put("surya", 29);
		for(String name:map.keySet()) {
			System.out.println(name);
		}
		for(Integer age:map.values()) {
			System.out.println(age);
		}
	}

}
