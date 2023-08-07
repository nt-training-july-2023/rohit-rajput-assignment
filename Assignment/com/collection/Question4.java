package com.collection;

import java.util.ArrayList;
import java.util.List;

public class Question4 {
	public static void main(String[] args) {
	List<Integer> list = new ArrayList<Integer>();
	list.add(12);
	list.add(18);
	list.add(67);
	list.add(11);
	list.add(9);
	list.add(45);
	list.add(55);
	list.add(32);
	for(Integer i :list) {
		if(i<60) {
			System.out.println(i);
		}
	}
  }
}
