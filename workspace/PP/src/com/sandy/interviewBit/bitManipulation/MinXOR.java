package com.sandy.interviewBit.bitManipulation;

import java.util.ArrayList;
import java.util.Collections;

public class MinXOR {
	public static int findMinXor(ArrayList<Integer> A) {
        Collections.sort(A);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i< A.size(); i++) {
            int xor = A.get(i-1)^A.get(i);
            if(xor < min) {
                min = xor;
            }
        }
        return min;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
