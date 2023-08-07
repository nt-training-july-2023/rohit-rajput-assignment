package com.oops.innerclass;

class Outer{
	private String name;
	class Inner{
		private String contactNo;
		public void setContactNo(String contactNo) {
			this.contactNo=contactNo;
		}
		public String getContactNo() {
			return contactNo;
		}
		void show() {
			System.out.println("name : "+name+" contactNo :"+contactNo);
		}
		
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
}
public class InstanceInnerClassMain {
     public static void main(String[] args) {
	      Outer outer = new Outer();
	      Outer.Inner inner = outer.new Inner();
	      outer.setName("Ricky");
	      inner.setContactNo("1234567890");
	      inner.show();
    }
}
