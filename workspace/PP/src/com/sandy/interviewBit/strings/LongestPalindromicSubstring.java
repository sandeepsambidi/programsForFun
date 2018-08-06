package com.sandy.interviewBit.strings;

public class LongestPalindromicSubstring {

	int maxLen = 0;
	
	static String findPal(String str) {
		String res = "";

		for (int i = 0; i < str.length(); i++) {
			String withCent = expandAroundCenter(str, i, i);
			
			if(withCent.length() > res.length()) {
				res = withCent;
			}
			
			String withoutCent = expandAroundCenter(str, i, i+1);
			
			if(withoutCent.length() > res.length()) {
				res = withoutCent;
			}
		}
		return res;
	}
	
	static String expandAroundCenter(String str, int l, int r) {

		String res = String.valueOf(str.charAt(l));
		while (l>=0 && r< str.length() && str.charAt(l)==str.charAt(r)) {
			res = str.substring(l, r+1);
			l--;
			r++;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println("answer = "+findPal("a"));
	}

}
