package com.map;

import java.util.HashMap;
import java.util.Map;

public class Question6 {
public static void main(String[] args) {
	Map<String ,Integer> map = new HashMap<String , Integer>();
	map.put("Virat",34);
	map.put("Rohit", 32);
	map.put("shubman", 23);
	map.put("surya", 29);
	System.out.println(map.remove("Virat", 37));
	System.out.println(map.remove("Virat", 35));
	System.out.println(map.remove("Virat", 34));
	System.out.println(map);
}
}
