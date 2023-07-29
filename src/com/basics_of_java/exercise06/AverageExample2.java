package com.basics_of_java.exercise06;

public class AverageExample2{
   public static void main(String args[]){
        int arr[] = new int[]{43,56,78,13,65,12};
		float sum=0;
		for(int i=0;i<arr.length;i++)
		     sum+=arr[i];
		System.out.println("Average :"+sum/arr.length);
		
   }
}