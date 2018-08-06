package com.sandy.interviewBit.strings;

public class LengthOfLastWord {

	static public int lengthOfLastWord(final String A) {
		String s = A.trim();
		if (s.length() == 0) {
			return 0;
		}
		int curr = 0;
		int start = 0;
		while(curr < s.length()) {
			if(s.charAt(curr) == ' ') {
				start = curr;
			}
			curr++;
		}
		
		if (start == 0) {
			return s.length();
		}
		return s.length() - start - 1;
    }
	
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hhg"));
	}

}
