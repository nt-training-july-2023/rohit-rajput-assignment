package com.map;

import java.util.HashMap;
import java.util.Map;

public class Question2 {
   public static void main(String[] args) {
	Map<Integer, String> map1 = new HashMap<Integer, String>();
	Map<String, String> map2 = new HashMap<String, String>();
	Map<String,Integer> map3 = new HashMap<String, Integer>();
	//add operation
	map1.put(1, "Rohit");
	map1.put(2, "Mohit");
	map2.put("Bajaj", "Pulsar");
	map2.put("Hero", "HF Delux");
	map3.put("Pulsar", 120000);
	map3.put("HF Delux", 90000);
	
	System.out.println(map1);
	System.out.println(map2);
	System.out.println(map3);
	
	
	//update operation
	map1.replace(1, "Roshan");
	map2.replace("Hero", "HF Delux", "Splinder");
	map3.replace("HF Delux", 90000, 85000);
	
	System.out.println("After updation........");
	System.out.println(map1);
	System.out.println(map2);
	System.out.println(map3);
	
	
	// remove operation
	map1.remove(1);
	map2.remove("Hero");
	map3.remove("HF Delux");
	
	System.out.println("After remove");
	System.out.println(map1);
	System.out.println(map2);
	System.out.println(map3);
	
	//get operation
	
	for(Map.Entry<Integer, String> entry :map1.entrySet()) {
		System.out.println("ID :"+entry.getKey());
		System.out.println("Name :"+entry.getValue());
	}
	for(Map.Entry<String, String> entry :map2.entrySet()) {
		System.out.println("ID :"+entry.getKey());
		System.out.println("Name :"+entry.getValue());
	}
	for(Map.Entry<String, Integer> entry :map3.entrySet()) {
		System.out.println("ID :"+entry.getKey());
		System.out.println("Name :"+entry.getValue());
	}
	
  }
}
