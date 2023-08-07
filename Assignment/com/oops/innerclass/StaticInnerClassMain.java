package com.oops.innerclass;

class Car{
	private String companyName;
	static class Engine{
		private static String type;
		private static  String power;
		private static  String lifeCycle;
		public static String getPower() {
			return power;
		}
		public void setPower(String power) {
			Engine.power = power;
		}
		public String getLifeCycle() {
			return lifeCycle;
		}
		public void setLifeCycle(String lifeCycle) {
			Engine.lifeCycle = lifeCycle;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			Engine.type = type;
		}
		@Override
		public String toString() {
			return "Engine [type=" + type + ", power=" + power + ", lifeCycle=" + lifeCycle + "]";
		}
	}
	
	public Car() {
		super();
	}

	public Car(String companyName) {
		super();
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Car [companyName=" + companyName + " Engine :{type="+Engine.type+" power="+Engine.power+
				      " lifeCycle="+Engine.lifeCycle+"}]";
	}
	
}
public class StaticInnerClassMain {
	public static void main(String[] args) {
		Car.Engine engine = new Car.Engine();
		engine.setType("Diesel Engine");
		engine.setPower("252 to 1,006 horsepower");
		engine.setLifeCycle("30 years");
		System.out.println(engine);
		
		Car car = new Car("Thar");
		Car.Engine engine2 = new Car.Engine();
		engine2.setType("Petrol Engine");
		engine2.setPower("118 of power at 3500rpm ");
		engine2.setLifeCycle("35 years");
		System.out.println(car);
		
		
	}

}
