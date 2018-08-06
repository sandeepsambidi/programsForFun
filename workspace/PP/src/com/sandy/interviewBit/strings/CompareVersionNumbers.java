package com.sandy.interviewBit.strings;

public class CompareVersionNumbers {

	static int compare(String ver1, String ver2) {
		int v1 = 0;
		int v2 = 0;
		
		while (v1 < ver1.length() || v2 < ver2.length()) {
			String v1Curr = "";
			String v2Curr = "";
			
			while(v1 < ver1.length() && ver1.charAt(v1) != '.' && ver1.charAt(v1) == '0') {
				v1++;
			}
			
			while (v1 < ver1.length() && ver1.charAt(v1) != '.') {
				
					v1Curr = v1Curr+ver1.charAt(v1);
				
				v1++;
			}
			
			while(v2 < ver2.length() && ver2.charAt(v2) != '.' && ver2.charAt(v2) == '0') {
				v2++;
			}
			
			while (v2 < ver2.length() && ver2.charAt(v2) != '.') {
					v2Curr = v2Curr+ver2.charAt(v2);
				
				v2++;
			}
			if(v1Curr.length() < v2Curr.length()) {
				return -1;
			} else if (v1Curr.length() > v2Curr.length()) {
				return 1;
			} 
			int comp = v1Curr.compareTo(v2Curr);
			
			if (comp != 0) {
				if(comp < 0)
					return -1;
				return 1;
			}
			v1++;
			v2++;
		}
		
		if (v1 <= ver1.length()) {
			return 1;
		} else if (v2 <= ver2.length()) {
			return -1;
		}
		return 0;
	}
	public static void main(String[] args) {
		System.out.println(compare("1.13", "1.13.4"));
	}

}
