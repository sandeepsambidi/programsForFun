package com.sandy.interviewBit.arrays;

public class PalindromeInteger {
	
	int isPalindrom(int a) {
		int reverseNum = 0;
		int num = a;
		while(num > 0) {
			reverseNum = (reverseNum*10) + (num%10);
			num = num/10;
		}
//		System.out.println("org num = "+a);
//		System.out.println("rev num = "+reverseNum);

		if(a == reverseNum) {
			return 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		PalindromeInteger palindromeInteger = new PalindromeInteger();
		System.out.println(palindromeInteger.isPalindrom(212));
	}

}
