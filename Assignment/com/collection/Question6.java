package com.collection;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Question6 {
public static void main(String[] args) {
	Set<String> set = new LinkedHashSet<String>();
	set.add("Rohit");
	set.add("Mohit");
	set.add("shyam");
	set.add("Mohan");
	set.add("gita");
	set.add("Sunita");
	set.add("Sumit");
	set.add("Sunny");
	set.add("Muskan");
	set.add("Mona");
	set.add("Satyam");
	set.add("Yash");
	set.add("Anuja");
	set.add("Anuj");
	set.add("harsh");
	set.add("Lalit");
	set.add("nabi");
	set.add("Aakash");
	set.add("Yogesh");
	set.add("Naveen");
	System.out.println(set);
	System.out.println(set.contains("Mohan"));
	System.out.println(set.contains("mohan"));
	Iterator<String> it= set.iterator();
	while(it.hasNext()) {
		System.out.println(it.next());
	}
	System.out.println(set.size());
}
}
