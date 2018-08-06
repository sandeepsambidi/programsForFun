package com.sandy.interviewBit.stacksQueues;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestNum {

	public int[] prevSmaller(int[] A) {
		Stack<Integer> stack = new Stack<>();
		int res[] = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			
			int top = -1;
			while(stack.isEmpty() == false)  {
				top = stack.peek();
				if(top >= A[i]) {
					stack.pop();
				} else {
					break;
				}
			}
			if(stack.isEmpty() ) {
				res[i] = -1;
			} else {
				res[i] = stack.peek();
			}
			stack.push(A[i]);
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		NearestSmallestNum nearestSmallestNum = new NearestSmallestNum();
		int A[] = {3, 3, 3};//{4, 5, 2, 10, 8};
		System.out.println(Arrays.toString(nearestSmallestNum.prevSmaller(A)));
	}

}
