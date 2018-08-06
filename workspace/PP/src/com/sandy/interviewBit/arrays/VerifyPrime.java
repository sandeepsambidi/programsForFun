package com.sandy.interviewBit.arrays;

public class VerifyPrime {
	
	public int isPrime(int A) {
		if(A <= 1) {
			return 0;
		}
		boolean res[] = new boolean[A+1];
		int divisor = (int)Math.sqrt(A);
		int resCount = 0;
		for(int i = 2; i<= divisor; i++) {
			int curr = i;
			if(res[i] == false) {
				curr = curr+i;
				while( curr <= A) {
					resCount++;
					res[curr] = true;
					curr = curr+i;
				}
			}
		}
		return res[A]?0:1;
    }
	
	public static void main(String[] args) {
		VerifyPrime verifyPrime = new VerifyPrime();
		System.out.println(verifyPrime.isPrime(18));
	}
}
