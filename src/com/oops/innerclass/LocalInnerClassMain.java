package com.oops.innerclass;

class OuterClass{
	
	public void show(String name) {
		
		class LocalInnerClass{
			private String name;

			public String getName() {
				System.out.println("Getting the name from LocalInnerClass .....");
				return name;
			}

			public void setName(String name) {
				System.out.println("Setting the name property of LocalInnerClass");
				this.name = name;
			}
			
		}
		LocalInnerClass class1 = new LocalInnerClass();
		class1.setName(name);
		System.out.println(class1.getName());
		
		
	}
}

public class LocalInnerClassMain {
	public static void main(String[] args) {
		OuterClass outerClass = new OuterClass();
		outerClass.show("shyam");
				
	}

}
