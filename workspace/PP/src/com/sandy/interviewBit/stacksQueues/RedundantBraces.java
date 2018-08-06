package com.sandy.interviewBit.stacksQueues;

import java.util.Stack;

public class RedundantBraces {

	public int braces(String A) {
		Stack<Character> stack = new Stack<Character>();
		int index = 0;
		while (index < A.length()) {
			char currChar = A.charAt(index);
			if (currChar == ')') {
				int count = 0;
				while (stack.isEmpty() == false) {
					if (stack.pop() == '('){
						break;
					}
					count++;
				}
				if (count == 1) {
					return 1;
				}
			} 
			index++;
			stack.push(currChar);
		}
		return 0;
	}
	
	public static void main(String[] args) {
		RedundantBraces rb = new RedundantBraces();
		System.out.println(rb.braces("()"));
	}

}
