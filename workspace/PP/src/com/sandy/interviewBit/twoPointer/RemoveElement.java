package com.sandy.interviewBit.twoPointer;

import java.util.ArrayList;

public class RemoveElement {

	static public int removeElement(ArrayList<Integer> a, int b) {
		while(a.contains(b)) {
			a.remove(b);
		}
		return a.size();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
