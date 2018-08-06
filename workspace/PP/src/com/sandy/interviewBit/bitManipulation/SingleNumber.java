package com.sandy.interviewBit.bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {

	public static int singleNumber(final List<Integer> A) {
		int missing = 0;
        for(int i=0; i< A.size(); i++) {
        	missing = missing^A.get(i);
        }
        return missing;
    }
	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>();
		A.add(5);
		A.add(2);
		A.add(3);
		A.add(2);
		A.add(3);
		System.out.println(singleNumber(A));
	}

}
