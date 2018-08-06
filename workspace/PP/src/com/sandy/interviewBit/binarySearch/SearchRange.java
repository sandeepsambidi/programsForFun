package com.sandy.interviewBit.binarySearch;

import java.util.ArrayList;
import java.util.List;

public class SearchRange {

	static int findLeft(List<Integer> arr, int num) {
		int lo = 0;
		int hi = arr.size()-1;
		int mid;
		int res = -1;
		
		while (lo <= hi) {
			mid = lo + ((hi-lo)/2);
			if (arr.get(mid) > num) {
				hi = mid-1;
			} else if (arr.get(mid) < num) {
				lo = mid + 1;
			} else {
				hi = mid-1;
				res = mid;
			}
		}
		List<Integer> a = new ArrayList<>();
		return res;
		
	}
	
	static int findRight(List<Integer> arr, int num) {
		int lo = 0;
		int hi = arr.size()-1;
		int mid;
		int res = -1;
		while (lo <= hi) {
			mid = lo + ((hi-lo)/2);
			if (arr.get(mid) > num) {
				hi = mid-1;
			} else if (arr.get(mid) < num) {
				lo = mid + 1;
			} else {
				lo = mid+1;
				res = mid;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(5);
		arr.add(7);
		arr.add(7);
		arr.add(8);
		arr.add(8);
		arr.add(10);
		int num = 8;
		int left = findLeft(arr, num);
		System.out.println("left = "+left);
		
		int right = findRight(arr, num);
		System.out.println("right = "+right);

	}

}
