package com.sandy.interviewBit.bitManipulation;

public class Divide {

	static public int divide(int A, int B) {
		long div = Math.abs(A);
		long divd = Math.abs(B);
		int c = 0;
		int res = 0;
		
		while (divd <= div) {
			long tempDivd = divd;
			c = 0;
			while (tempDivd <= div) {
				tempDivd = (tempDivd << 1);
				c = c+1;
			}
			
			res = res + (1<<(c-1));
			div = div - (divd<< (c-1));
		}
		
		if (A < 0 && B<0) {
			return res;
		} else if (A>0 && B>0) {
			return res;
		} else {
			return res*(-1);
		}
    }
	
	public static void main(String[] args) {

		System.out.println(divide(-2147483648, 1));
	}

}
