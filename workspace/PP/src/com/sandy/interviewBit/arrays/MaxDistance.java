package com.sandy.interviewBit.arrays;

import java.util.Arrays;

public class MaxDistance {

	int find(int[] a) {
		//System.out.println(Arrays.toString(a));
		int leftMin[] = new int[a.length];
		int rightMax[] = new int[a.length];
		if(a.length==1) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i<a.length; i++) {
			if(a[i] < min) {
				leftMin[i] = a[i];
				min = a[i];
			} else {
				leftMin[i] = min;
			}
		}
		
		for(int i=a.length-1; i >=0; i--) {
			if(a[i] > max) {
				rightMax[i] = a[i];
				max = a[i];
			} else {
				rightMax[i] = max;
			}
		}
		int res = -1;
		//System.out.println("left min = "+Arrays.toString(leftMin));
		//System.out.println("right max = "+Arrays.toString(rightMax));
		int i = 0; int j=0;
		
		while(i<a.length && j<a.length) {
			if(leftMin[i]<= rightMax[j]) {
				j++;
				res = Math.max(res, j-i-1);
			} else if(leftMin[i] > rightMax[j]) {
				i++;
			}
		}
		return res;
	}
	public static void main(String[] args) {

		MaxDistance md = new MaxDistance();
		System.out.println(md.find(new int[]{100, 100, 100, 100, 100}));
	}

}
