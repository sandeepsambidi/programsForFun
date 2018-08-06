package com.sandy.interviewBit.stacksQueues;

import java.util.Stack;

public class RainWaterTrapped {

	public int trap(final int[] A) {
		
		Stack<Integer> st = new Stack<Integer>();
		int water = 0;
		for (int current = 0; current < A.length; current++) {
			
			while (!st.empty() && A[current] > A[st.peek()]) {
	            int top = st.peek();
	            st.pop();
	            if (st.empty())
	                break;
	            int distance = current - st.peek() - 1;
	            int bounded_height = Math.min(A[current], A[st.peek()]) - A[top];
	            water += distance * bounded_height;
	        }
	        st.push(current);
		}
			
		return water;
		
	}
	public static void main(String[] args) {
		RainWaterTrapped rt = new RainWaterTrapped();
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(rt.trap(A));
	}

}
