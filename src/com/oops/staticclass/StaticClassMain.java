package com.oops.staticclass;
class State{
	private String name;
	private static String capital;
	public void show() {
		System.out.println("non-static method of State class");
	}
	public static void show1() {
		System.out.println("static method of State class");
	}
	public State(String name,String capital) {
		this.name=name;
		this.capital=capital;
	}
	
	static class District {
		 String districtName;
//     we can't access not static member in static class 
//		 public void details() {
//			 show();
//			 show1();
//			 System.out.println("StateName="+name+" StateCode="+capital+" Districtname="+districtName);
//		 }
		 public District(String districtName) {
			 this.districtName=districtName;
		 }
		 public void details(State state) {
			state.show();
			 show1();
			 System.out.println("StateName="+state.name+" Capital="+capital+" Districtname="+districtName);
		 }
	}
}
public class StaticClassMain {
	public static void main(String[] args) {
		State  state = new State("MP","BHOPAL");
		State.District district = new State.District("Indore");
		district.details(state);
		
	}

}
