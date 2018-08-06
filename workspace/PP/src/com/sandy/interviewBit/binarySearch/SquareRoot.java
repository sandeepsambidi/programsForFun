package com.sandy.interviewBit.binarySearch;

public class SquareRoot {
	
	static int findSqRoot(int num) {
		if (num == 0) {
			return 0;
		}
		if (num <= 3) {
			return 1;
		}
		
		long l = 0;
		long r = num;
		
		long mid = 0;
		while (r > l) {
			mid = l + ((r - l +1) / 2);
			if ((mid*mid) > num) {
				r = mid-1;
			} else if ((mid*mid) < num) {
				l = mid;
			} else {
				return (int)mid;
			}
		}
		return (int)l;
	}

	public static void main(String[] args) {
		System.out.println(findSqRoot(2147483647));
		
	}

}
