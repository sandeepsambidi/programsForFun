package com.sandy.interviewBit.strings;

public class ReverseString {

	static String reverse(String str) {
		String revStr = reverseString(str.trim());
		StringBuilder sb = new StringBuilder();
		int start = 0;
		int end = revStr.length()-1;
		
		while (start <= end) {
			int currStart = start;
			int currEnd = start;
			while(currStart <= end && revStr.charAt(currStart) != ' ') {
				currEnd ++;
				currStart++;
			}
			sb.append(reverseString(revStr.substring(start, currEnd)) + " ");
			currEnd++;
			start = currEnd;
		}
		return sb.toString().trim();
 	}
	
	static String reverseString(String str) {
		str = str.trim();
		int end = str.length()-1;
		StringBuilder sb = new StringBuilder();
		while(end >= 0) {
			sb.append(str.charAt(end));
			end--;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(reverse("the  "));
	}

}
