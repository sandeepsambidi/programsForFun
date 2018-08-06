package com.sandy.interviewBit.binarySearch;

import java.util.ArrayList;

public class PainterPartition {

	int findMinTime(ArrayList<Integer> arr, int k, int t) {
		long max = 0;
		long min = Integer.MIN_VALUE;
		for (int i = 0; i < arr.size(); i++) {
			max = max + arr.get(i);
			if(arr.get(i) > min) {
				min = arr.get(i);
			}
		}
		
		while (min < max) {
			long mid = min + ((max-min)/2);
			long remainingTime = mid;
			int currPainters = 1;
			for (int i = 0; i < arr.size(); i++) {
				if(arr.get(i) <= remainingTime) {
					remainingTime = remainingTime - arr.get(i);
				} else {
					remainingTime = mid;
					currPainters++;
					remainingTime = remainingTime - arr.get(i);
				}
			} 
			
			if(currPainters < k) {
				max = mid-1;
			} else if (currPainters > k) {
				min = mid+1;
			} else {
				max = mid;
			}
		}
		
		return (int) ((min*t)%10000003);
	}
	
	public static void main(String[] args) {
		PainterPartition pp = new PainterPartition();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(10);
//		arr.add(300);
//		arr.add(400);
//		arr.add(500);
//		arr.add(600);
//		arr.add(700);
//		arr.add(800);
//		arr.add(900);
		System.out.println(pp.findMinTime(arr, 2, 5));
	}

}
