package com.sandy.interviewBit.arrays;

public class MaxAbsDifference {
	
	int maxDiff(int[] a) {
		
		int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
 
        for (int i = 0; i < a.length; i++)
        {
 
            // Updating max and min variables
            // as described in algorithm.
            max1 = Math.max(max1, a[i] + i);
            min1 = Math.min(min1, a[i] + i);
            max2 = Math.max(max2, a[i] - i);
            min2 = Math.min(min2, a[i] - i);
        }
 
        // Calculating maximum absolute difference.
        return Math.max(max1 - min1, max2 - min2);
 
	}
	
	public static void main(String[] args) {
		MaxAbsDifference obj = new MaxAbsDifference();
		System.out.println(obj.maxDiff(new int[]{1,3,-1}));
	}
}
