package com.exception.javadoc;

/**
 * The {@code Triangle} class represents functionalities of Triangle class. All
 * 
 * @author rohit rajput
 * @version 1.1
 */
public class Triangle {
	
	/**
     * Returns the {@code double} value of the
     * triangle area. 
     *
     * @param      base  the base of the {@code double} value.
     * @param      height  the height of the {@code double} value.
     * @return     the {@code double} value at the triangle area .
     */
	
	public double area(double base ,double height) {
		return (base*height)/2;
	}
	/**
     * Returns the {@code double} value of the
     * circle area. 
     *
     * @param      side1  the side1 of the {@code double} value.
     * @param      base  the base of the {@code double} value.
     * @param      side2  the side2 of the {@code double} value.
     * @return     the {@code double} value at the triangle perimeter .
     */
	public double perimwter(double side1 , double base ,double side2) {
		return side1+base+side2;
	}

}
