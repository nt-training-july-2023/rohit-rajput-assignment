package com.oops.encap;

import java.io.BufferedInputStream;

public class EncapsulationProgram {
   
	int id;
	String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	 
	@Override
	public String toString() {
		return "EncapsulationProgram [id=" + id + ", name=" + name + "]";
	}

	public static void main(String[] args) {
	EncapsulationProgram program = new EncapsulationProgram();
	program.setId(1);
	program.setName("Rocky");
	System.out.println(program);
	}

}
