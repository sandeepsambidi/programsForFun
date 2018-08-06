package com.sandy.interviewBit.arrays;

public class PowerTwoNumbers {

	int pow(int a, int b, int prime) {
		
		long res = 1;
		
		while(b>0) {
			if((b&1) != 0) {
				res = (res*a)%prime;
				b--;
			} else {
				a = (a*a)%prime;
				b=b/2;
			}
		}
		
		return (int)res;
	}
	
	public static void main(String[] args) {

		PowerTwoNumbers p = new PowerTwoNumbers();
		System.out.println(p.pow(2, 5, 0));
	}

}
