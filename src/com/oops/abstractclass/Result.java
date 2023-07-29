package com.oops.abstractclass;
abstract class Student{
	private String rollNo;
	private String name;
	public Student(String rollNo , String name) {
		this.rollNo=rollNo;
		this.name=name;
	}
	public String getRollNo() {
		return rollNo;
	}
	public String getName() {
		return name;
	}
	abstract String isPassed();
}
public class Result extends Student{
	private String status;
	public Result(String rollNo,String name,String status) {
		super(rollNo,name);
		this.status=status;
	}
	@Override
	String isPassed() {
		return status;
	}
	public static void main(String[] args) {
		Student student1 = new Result("DS1234","Virat", "pass");
		Student student2 = new Result( "DS2345","Ishant", "fail");
		
		System.out.println("RollNo :" +student1.getRollNo()+" Name :"+ student1.getName()+
				            " Status :"+student1.isPassed());
		System.out.println("RollNo :" +student2.getRollNo()+" Name :"+ student2.getName()+
	                       " Status :"+student2.isPassed());

		
	}
	

}
