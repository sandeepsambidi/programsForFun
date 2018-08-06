package com.sandy.interviewBit.strings;

public class RomanToInteger {

	int findNum(String str) {
		int index = 0;
		int res = 0;
		while (index < str.length()) {
			int s1 = value(str.charAt(index));
			if((index + 1) < str.length()) {
				int s2 = value(str.charAt(index + 1));
				if (s1 < s2) {
					res = res + s2 -s1;
					index ++;
				} else {
					res = res + s1;
				}
			} else {
				res = res + s1;
			}
			index++;
		}
		return res;
	}
	
	int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }
	
	public static void main(String[] args) {
		RomanToInteger romanToInteger = new RomanToInteger();
		System.out.println(romanToInteger.findNum("M"));

	}

}
