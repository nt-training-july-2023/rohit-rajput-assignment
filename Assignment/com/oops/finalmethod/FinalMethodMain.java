package com.oops.finalmethod;
class Laptop{
	private String brand;
	private int RAM;
	private int price;
	public final void motherBoard() {
		System.out.println("MotherBoard is very important part,keep it safe ");
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getRAM() {
		return RAM;
	}
	public void setRAM(int rAM) {
		RAM = rAM;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Laptop(String brand, int rAM, int price) {
		super();
		this.brand = brand;
		RAM = rAM;
		this.price = price;
	}
	public Laptop() {
	}
}
public class FinalMethodMain {
     public static void main(String[] args) {
		Laptop laptop = new Laptop("HP",8,87654);
		System.out.println(laptop.getBrand());
		System.out.println(laptop.getPrice());
		System.out.println(laptop.getRAM());
		laptop.motherBoard();
	}
}
