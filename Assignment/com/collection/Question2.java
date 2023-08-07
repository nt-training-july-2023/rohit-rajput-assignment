package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(18);
		list.add(11);
		list.add(9);
		list.add(45);
		list.add(32);

		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);

	}

}
