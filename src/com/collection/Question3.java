package com.collection;

import java.util.ArrayList;
import java.util.List;

public class Question3 {
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
		int count=0;
		for(Integer i :list) {
			if(i>50) {
				count+=5;
			}
		}
		for(int i=0;i<list.size();i++) {
			list.set(i, list.get(i)+count);
		}
		System.out.println(list);
	}
}
