package com.test.sort;

public class TestSort {
	public static void main(String[] args) {
		int a[] = new int[] {5,4,9,8,7,6,0,1,2,3};
		TestSort.insertSort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.print("\n");
	}
	
	public static void selectSort(int a[]) {
		for(int i=0; i<a.length; i++) {
			int tempMin = a[i];
			int minPos = i;
			for(int j=i+1; j<a.length; j++) {//insert by swapping, worst O(n)
				if(a[j]<tempMin) {
					minPos = j;
					tempMin = a[j];
				}
			}
			a[minPos] = a[i];
			a[i] = tempMin;
		}
	}
	
	public static void insertSort(int a[]) {
		for(int i=1; i<a.length; i++) {
			for(int s=i-1; s>=0; s--) {
				if(a[s+1]<a[s]) {
					int temp = a[s];
					a[s] = a[s+1];
					a[s+1] = temp;
				}else {
					break;
				}
			}
		}
	}
	
	public static void bubbleSort(int a[]) {
		for(int i=0; i<a.length; i++) {
			for(int j=a.length-1; j>i; j--) {
				if(a[j]<a[j-1]) {
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
				}
			}
		}
	}
}
