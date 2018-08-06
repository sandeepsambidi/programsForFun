package com.sandy.interviewBit.arrays;

public class BinaryRepresentation {

	String binRep(int n) {
		if(n==0){
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		int i = 2;
		
		while(n>0) {
			if(n%2==0) {
				sb.append(0);
			} else {
				sb.append(1);
			}
			n  =n/2;
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		BinaryRepresentation br = new BinaryRepresentation();
		System.out.println(br.binRep(5));
	}

}
