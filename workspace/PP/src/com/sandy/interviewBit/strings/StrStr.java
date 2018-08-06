package com.sandy.interviewBit.strings;

public class StrStr {

	 public static int strStr(final String haystack, final String needle) {
		 if(haystack == null || needle == null) {
			 return -1;
		 }
		 int hayLength = haystack.length();
		 int needleLength = needle.length();
		 
		 if (hayLength == 0 || needleLength == 0) {
			 return -1;
		 }
		 
		 for (int i = 0; i <= hayLength-needleLength ; i++) {
			
			 int len = 0;
			 while (len < needleLength) {
				 if (haystack.charAt(i+len) == needle.charAt(len)) {
					 len++;
				 } else {
					 break;
				 }
			 }
			 if (len == needleLength) {
				 return i;
			 }
		}
		 return -1;
	 }
	
	 public static void main(String[] args) {
		 System.out.println(strStr("adbdsfk", "k"));
	}

}
