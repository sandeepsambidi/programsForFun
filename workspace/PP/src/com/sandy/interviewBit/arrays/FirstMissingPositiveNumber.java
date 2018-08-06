package com.sandy.interviewBit.arrays;

public class FirstMissingPositiveNumber {

	int findNum(int[] a) {
		int replaceNonPos = a.length+2;
		int modNum = a.length+1;
		
		for(int i = 0; i< a.length; i++) {
			if(a[i]<=0) {
				a[i] = replaceNonPos;
			}
		}
		
		for(int i = 0; i< a.length; i++) {
			if(a[i] < 0) {
				int actualVal = (-1)*(a[i]/modNum);
				if(actualVal != 0 && actualVal <= a.length) {
					a[actualVal-1] = (-1)*(a[actualVal-1]*modNum + (actualVal-1)); 
				} 
			} else {
				if(a[i]!= 0 && a[i]<=a.length) {
					a[a[i]-1] = (-1)*((a[a[i]-1]*modNum) + (i-1));
				}
			}
		}
		int res=a.length+1;
		for(int i=0; i<a.length; i++) {
			if(a[i] >= 0) {
				res = i+1;
				break;
			}
		}
		
		return res;
	}
	
	int find(int[] a) {
		int res = a.length+1;
		for(int i=0; i< a.length; i++) {
			if(a[i]>a.length || a[i]<0) {
				a[i] = 0;
			}
		}
		
		int curr = 0;
		while(curr < a.length) {
			if(a[curr] > 0) {
				int index = a[curr]-1;
				if(a[index] >= 0) {
					a[curr] = a[index];
					
				} else {
					a[curr]=0;
				}
				a[index] = -1;
			} else {
				curr++;
			}
		}
		
		for(int i=0; i<a.length;i++) {
			if(a[i]==0) {
				res = i+1;
				break;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		FirstMissingPositiveNumber obj = new FirstMissingPositiveNumber();
		System.out.println(obj.find(new int[]{-8, -7, -6}));
	}

}
