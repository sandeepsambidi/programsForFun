package com.sandy.interviewBit.arrays;

public class HammingDistance {

	int findDistance(int[] a) {
		long res = 0;
		int prime = 1000000007;
		for(int i=0; i< 32; i++) {
			int c0 = 0;
			int c1 = 0;
			for(int j=0;j<a.length; j++) {
				if((a[j]&(1<<i))==0) {
					c0++;
				} else {
					c1++;
				}
			}
			long c = (c1*(a.length-c1))%prime;
			c = (2*c)%prime;
			res = (res + c)%prime;
		}
		return (int)res;
	}
	
	public static void main(String[] args) {
		HammingDistance hd = new HammingDistance();
		System.out.println(hd.findDistance(new int[]{2,4,6}));
	}

}
