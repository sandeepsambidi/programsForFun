package com.sandy.interviewBit.arrays;

public class ExcelColumnTitle {

	String findTitle(int num) {
		StringBuilder sb = new StringBuilder();
		
		while(num>0) {
			int mod = (num%26);
			if(mod==0) {
				sb.append("Z");
				num = (num/26) - 1;
			} else {
				sb.append(String.valueOf((char)((mod-1) + 'A')));
				num = num/26;

			}
		}
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		ExcelColumnTitle obj = new ExcelColumnTitle();
		System.out.println(obj.findTitle(702));
	}

}
