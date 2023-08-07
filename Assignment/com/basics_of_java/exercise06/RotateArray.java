package com.basics_of_java.exercise06;

import java.util.Scanner;
public class RotateArray{
	public static void main(String arrs[]){
		int[] arr= {1,2,3,4,5,6};
		Scanner sc = new Scanner(System.in);
		System.out.print("Value of Rotation :");
		int k=sc.nextInt();
		reverse(arr,0,arr.length-1-k);
		reverse(arr,arr.length-k,arr.length-1);
		reverse(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		
	}
	static void reverse(int[] arr,int start,int end){
		while(start<end){
			int temp = arr[start];
			arr[start]=arr[end];
			arr[end]=temp;
			start++;end--;
		}
	}
}