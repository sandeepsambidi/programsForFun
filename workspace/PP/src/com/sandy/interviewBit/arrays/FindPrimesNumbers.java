package com.sandy.interviewBit.arrays;

import java.util.Arrays;

public class FindPrimesNumbers {
	public int[] sieve(int A) {
		if(A <= 1) {
			return new int[]{};
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
		
		int primeCount = 0;
		for(int i = 2; i< res.length; i++) {
			if(res[i] == false) {
				primeCount++;
			}
		}
		
		int[] primes = new int[primeCount];
		//System.out.println("res count = "+resCount);
		int j = 0;
		for(int i = 2; i< res.length; i++) {
			if(res[i] == false ) {
				primes[j++] = i;

			}
		}
		System.out.println(Arrays.toString(primes));
		return primes;
    }
	
	public static void main(String[] args) {
		FindPrimesNumbers fp = new FindPrimesNumbers();
		fp.sieve(10);
	}
}
