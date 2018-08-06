package com.sandy.interviewBit.binarySearch;

public class PowerFunction {

	public int pow(int x, int n, int d) {
		if(x==0) {
			return 0;
		}
		long result = 1;
		long localRes = x%d;//Math.floorMod(x,d);
		while (n >= 1) {
			if((n&(1)) > 0) {
				result = (result * localRes)%d;
				n = n-1;
			} else {
				localRes = (localRes * localRes)%d;
				n = n/2;
			}
		}
		return (int)result;
	}
	public static void main(String[] args) {

		PowerFunction pf = new PowerFunction();
		System.out.println(pf.pow(-500, 1, 100));
	}

}
