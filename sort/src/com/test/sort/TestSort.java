package com.test.sort;

public class TestSort {
	public static void main(String[] args) {
		int a[] = new int[] {5,4,9,8,7,6,0,1,2,3};
		TestSort.shellSort(a);
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.print("\n");
		int a1[] = new int[] {1,3,5,6,2,4,7,8};
		TestSort.quickSort(a1, 0, a1.length);
		for(int i=0; i<a1.length; i++) {
			System.out.print(a1[i]+" ");
		}
		System.out.print("\n");
	}
	//Ñ¡ÔñÅÅÐò
	public static void selectSort(int a[]) {
		for(int i=0; i<a.length; i++) {
			int tempMin = a[i];
			int minPos = i;
			for(int j=i+1; j<a.length; j++) {
				if(a[j]<tempMin) {
					minPos = j;
					tempMin = a[j];
				}
			}
			a[minPos] = a[i];
			a[i] = tempMin;
		}
	}
	//²åÈëÅÅÐò
	public static void insertSort(int a[]) {
		for(int i=1; i<a.length; i++) {
			for(int s=i-1; s>=0; s--) {//insert by swapping, worst O(n)
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
	//Ã°ÅÝÅÅÐò
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
	//¹é²¢ÅÅÐò
	public static void mergeSort(int a[], int s, int t) {
		if(s<t-1) {
			int q = (s+t)/2;
			mergeSort(a, s, q);
			mergeSort(a, q, t);
			merge(a, s, q, t);
		}
	}
	public static void merge(int a[], int s, int q, int t) {
		int[] a1 = new int[q-s];
		int[] a2 = new int[t-q];
		for(int i=0; s+i<q; i++) {
			a1[i] = a[s+i];
		}
		for(int i=0; q+i<t; i++) {
			a2[i] = a[q+i];
		}
		int i = 0;
		int j = 0;
		while(s+i<q&&q+j<t) {
			if(a1[i]<a2[j]) {
				a[s+i+j] = a1[i];
				i++;
			}else {
				a[s+i+j] = a2[j];
				j++;
			}
		}
		for(;s+i<q; i++) {
			a[s+i+j] = a1[i];
		}
		for(;q+j<t; j++) {
			a[s+i+j] = a2[j];
		}
	}
	//¿ìËÙÅÅÐò
	public static void quickSort(int a[], int s, int t) {
		if(s>=t-1)
			return;
		else {
			int i = s;
			int j = t-1;
			int index = a[i];
			while(i<j) {
				while(i<j&&a[j]>index)
					j--;
				if(i<j)
					a[i++] = a[j];
				while(i<j&&a[i]<index)
					i++;
				if(i<j)
					a[j--] = a[i];
			}
			a[i] = index;
			quickSort(a, s, i);
			quickSort(a, i+1, t);
		}
	}
	//Ï£¶ûÅÅÐò
	public static void shellSort(int a[]) {
		int length = a.length;
		for(int h = length/2; h>0; h = h/2) {
			for(int i=h; i<length; i++) {
				for(int j=i; j>=h; j = j-h) {
					if(a[j-h]>a[j]) {
						int temp = a[j];
						a[j] = a[j-h];
						a[j-h] = temp;
					}else 
						break;
				}
			}
		}
	}
}
