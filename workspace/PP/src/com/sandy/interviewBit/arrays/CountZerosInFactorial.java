package com.sandy.interviewBit.arrays;

public class CountZerosInFactorial {

	int countZeros(int a) {
		int i = 5;
		int count5 = 0;
		int b = a;
		while(i<=b) {
			count5 = count5 + (b/i);
			i=i*5;
		}
		
		return count5;
	}
	public static void main(String[] args) {
		CountZerosInFactorial obj = new CountZerosInFactorial();
		System.out.println(obj.countZeros(4));
	}

}
