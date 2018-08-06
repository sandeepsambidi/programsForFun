package com.sandy.interviewBit.strings;

import java.util.ArrayList;

public class LongestCommonPrefix {
	
	static String findLongestString(ArrayList<String> arr) {
		StringBuilder sb = new StringBuilder();
		int strIndex = 0;
		int charIndex = 0;
		char currChar = 0;

		while (true) {
			String currStr = arr.get(strIndex);
			
			if (charIndex >= currStr.length()) {
				break;
			}
			
			if(strIndex == 0) {
				currChar = currStr.charAt(charIndex);
			} else {
				if (currChar != currStr.charAt(charIndex)) {
					break;
				}
			}

			if(strIndex == (arr.size()-1)) {
				sb.append(currChar);
				strIndex = 0;
				charIndex++;
			} else {
				strIndex++;
			}
			
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ArrayList<String> strs= new ArrayList<String>();
		strs.add("");
		strs.add("a");
		strs.add("a");
		
		System.out.println(findLongestString(strs));

	}
}
