package com.sandy.interviewBit.stacksQueues;

import java.util.Stack;

public class MinStack {
	
	public MinStack() {
		stack.clear();
		helperStack.clear();
	}
	
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> helperStack = new Stack<>();

	public void push(int x) {
        if(stack.isEmpty()) {
        	stack.push(x);
        	helperStack.push(x);
        } else {
        	stack.push(x);
        	if(x <= helperStack.peek()) {
        		helperStack.push(x);
        	}
        }
    }

    public void pop() {
        if(stack.isEmpty() == false) {
        	int popped = stack.pop();
        	if(popped == helperStack.peek()) {
        		helperStack.pop();
        	}
        }
    }

    public int top() {
        if(stack.isEmpty()) {
        	return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if(helperStack.isEmpty()) {
        	return -1;
        }
        return helperStack.peek();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
