package com.oops.multipleinhe;

interface Animal {
    public void show();
}
interface Bird{
	public void fly();
}
interface Parrots extends Animal , Bird{
	public void colour();
}
public class AmazonParrots implements Parrots{

	@Override
	public void show() {
		System.out.println("Mainly shown in America ");
	}

	@Override
	public void fly() {
		System.out.println("AmazonParrots can fly in the range of 2000 to 5000 feet");
		
	}

	@Override
	public void colour() {
		System.out.println("AmazomParrot color is Green ");
	}
	public static void main(String[] args) {
		Parrots pAnimal = new AmazonParrots();
		pAnimal.show();
		pAnimal.colour();
		pAnimal.fly();
	}
}

