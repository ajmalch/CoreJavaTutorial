package com.general.array;

public class Main {
	
	public static int getmidIndex(int[] array){
		int midindex=-1;
		int left_sum=0,right_sum=0;
		int left_index=0;
		int right_index=array.length-1;
		while(left_index!=right_index){
			if(right_sum<left_sum){
				right_sum=right_sum+array[right_index];
				right_index--;
			}
			else{
				left_sum=left_sum+array[left_index];
				left_index++;
			}
		}
		if(right_sum==left_sum) midindex=left_index+1;
		return midindex;
	}

	public static void main(String[] args) {
		int[] a={10,20,10,30};
		int[] b={15,23,34,354,38,34,23,15,300,50,4};
		System.out.println(getmidIndex(a));
		System.out.println(getmidIndex(b));
	}

}
