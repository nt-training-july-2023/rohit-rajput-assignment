package com.basics_of_java.exercise06;

public class AddingMatrix{
   public static void main(String args[]){
        int arr1[][] = new int[][]{{1,2,3,},{4,5,6},{7,8,9}};
        int arr2[][] = new int[][]{{1,2,3,},{4,5,6},{7,8,9}};
		int sum[][] = new int[3][3];
	    for(int i=0;i<arr1[0].length;i++){
		   for(int j=0;j<arr1.length;j++){
			   sum[i][j]=arr1[i][j]+arr2[i][j];
		   }
	    }
	    for(int i=0;i<arr1[0].length;i++){
			for(int j=0;j<arr1.length;j++){
				System.out.print(sum[i][j]+" ");
			}
			System.out.println();
		}
   }
}