package com.oops.inheritence;
// Multi Level Inheritence

class Animal{
	public void walk() {
		System.out.println("Animal walks");
	}
	public void beep() {
		System.out.println("Animal beep");
	}
}
class Cat extends Animal{
	public void category() {
		System.out.println("Lion , tiger ,..............");
	}
}
class Lion extends Cat{
	@Override 
	public void beep() {
		System.out.println("Lion is roaring");
	}
	@Override
	public void walk() {
		System.out.println("Lion runs very fast");
	}
	public void type() {
		System.out.println("Lion is large cat in the family Felidae");
	}
	
	
}
public class MultilevelInher {
	public static void main(String[] args) {
	     Lion lion = new Lion();
	     lion.walk();
	     lion.beep();
	     lion.category();
	     lion.type();
	     
	    
    }
}
