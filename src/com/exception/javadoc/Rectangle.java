package com.exception.javadoc;

/**
 * The {@code Rectangle} class represents functionalities of Rectangle class. All
 * 
 * @author rohit rajput
 * @version 1.1
 */
public class Rectangle {
	/**
	 * Returns the {@code double} value of the rectangle area.
	 *
	 * @param width  the width of the {@code double} value.
	 * @param length the length of the {@code double} value.
	 * 
	 * @return the {@code double} value at the rectangle area.
	 */
     public double area(double width, double length) {
		return width * length;
	}
     /**
 	 * Returns the {@code double} value of the rectangle perimeter.
 	 *
 	 * @param width  the width of the {@code double} value.
 	 * @param length the length of the {@code double} value.
 	 * 
 	 * @return the {@code double} value at the rectangle perimeter.
 	 */
     public double perimeter(double length ,double width) {
    	 return 2*(length +width);
     }
}
