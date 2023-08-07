package com.oops.finalclass;

final class Policy{
	
	public void socialMedia() {
		System.out.println("this is our socialMedia Policy which you have to follow");
	}
	public void nonDisclosure() {
		System.out.println("This is non-disclosure Agreement");
	}
	public void discipline() {
		System.out.println("You have to folloe this disciplines.");
	}
	
}
public class FinalClassMain {
    public static void main(String[] args) {
		Policy policy = new Policy();
	    policy.socialMedia();
	    policy.nonDisclosure();
	    policy.discipline();
    }
}
