package com.sandy.interviewBit.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedArraySearch {

	static int search(List<Integer> arr, int req) {
		int lo = 0;
		int hi = arr.size() -1;
		
		while (lo <= hi) {
			int mid = lo + ((hi-lo)/2);
			
			if (arr.get(mid) == req) {
				return mid;
			}
			//left sorted
			if (arr.get(lo) < arr.get(mid)) {
				if (req >= arr.get(lo) && req <= arr.get(mid)) {
					hi = mid - 1;
				} else {
					lo = mid +1;
				}
			} 
			//left not sorted -> right sorted
			else {
				if (req >= arr.get(mid) && req <= arr.get(hi)) {
					lo = mid + 1;
				} else {
					hi = mid -1;
				}
			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		Integer[] arr1 = {19, 20, 21, 22, 28, 29, 32, 36, 39, 40, 41, 42, 43, 45, 48, 49, 51, 54, 55, 56, 58, 60, 61, 62, 65, 67, 69, 71, 72, 74, 75, 78, 81, 84, 85, 87, 89, 92, 94, 95, 96, 97, 98, 99, 100, 105, 107, 108, 109, 110, 112, 113, 115, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 128, 130, 131, 133, 134, 135, 136, 137, 138, 139, 141, 142, 144, 146, 147, 148, 149, 150, 153, 155, 157, 159, 161, 163, 164, 169, 170, 175, 176, 179, 180, 185, 187, 188, 189, 192, 196, 199, 201, 203, 205, 3, 7, 9, 10, 12, 13, 17};
		
		List<Integer> arr = Arrays.asList(arr1);//new ArrayList<Integer>();
//		arr.add(4);
//		arr.add(5);
//		arr.add(6);
//		arr.add(7);
//		arr.add(0);
//		arr.add(1);
//		arr.add(2);
		
		System.out.println(search(arr, 6));
		
	}

}
