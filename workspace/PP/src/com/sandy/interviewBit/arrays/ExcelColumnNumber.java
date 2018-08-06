package com.sandy.interviewBit.arrays;

public class ExcelColumnNumber {

	public int titleToNumber(String A) {
		int result = 0;
		int Base = 26;
		for(int i=0; i< A.length(); i++) {
			result = (result*Base) + (A.charAt(i)-'A' + 1) ;
		}
		return result;
    }
	
	public static void main(String[] args) {
		ExcelColumnNumber ecn = new ExcelColumnNumber();
		System.out.println(ecn.titleToNumber("Z"));
	}

}
