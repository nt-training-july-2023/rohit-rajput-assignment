package com.exception.javadoc;
/**
 *  The {@code Circle} class represents functionalities of Circle class. All
 * @author rohit rajput
 * @version 1.1
 */
class Circle {
	/**
     * The identifier of the encoding used to encode the float in
     * {@code value}. The supported values in this implementation are
     */
	public final float pi=3.14f;
	 
	/**
     * Returns the {@code double} value of the
     * circle area. 
     *
     * @param      radius  the radius of the {@code double} value.
     * @return     the {@code double} value at the circle area .
     */
     
	public double area(double radius) {
    	 return pi*radius*radius;
     }
	
	/**
     * Returns the {@code double} value of the
     * circle perimeter. 
     *
     * @param      radius  the radius of the {@code double} value.
     * @return     the {@code double} value at the circle perimeter.
     */
	public double perimeter(double radius) {
		return 2*pi*radius;
	}
	
}

