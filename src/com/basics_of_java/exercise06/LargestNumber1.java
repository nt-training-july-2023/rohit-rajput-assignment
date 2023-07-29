package com.basics_of_java.exercise06;

public class LargestNumber1{
   public static void main(String args[]){
        int arr[] = new int[]{43,56,78,13,65,12};
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
			if(max<arr[i])
				max=arr[i];
		}
		System.out.println("Maximun in array :"+max);
   }
}