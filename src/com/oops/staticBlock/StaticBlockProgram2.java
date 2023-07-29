package com.oops.staticBlock;


class A{
	static {
		System.out.println("class A 1'st static block");
	}
	{
		System.out.println("class A instancee  block");
	}
	static {
		System.out.println("class A 2nd static block");
	}
	public A() {
		System.out.println("class A constructor");
	}
	static {
		System.out.println("class A 3rd static block");
	}
}
class B extends A{
	static {
		System.out.println("class B static block");
	}
	public B() {
		System.out.println("class B connstructor");
	}
	{
		
		System.out.println("class B instance block");
	}
}

public class StaticBlockProgram2 {
    public static void main(String[] args) {
	B b = new B();
   }
}
