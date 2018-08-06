package com.sandy.interviewBit.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class AddOneToNumber {
	
	int[] addOne(int[] a) {
		int start = 0;
		for(int i=0;i<a.length;i++) {
			if(a[i]!=0) {
				start = i;
				break;
			}
		}
		int newA[] = new int[(a.length-start)+1];
		int carry = 0;
		int newAend = newA.length-1;
		if(a[a.length-1]+1 > 9) {
			newA[newAend--] = 0;
			carry = 1;
		} else {
			newA[newAend--] = a[a.length-1]+1;
		}
		
		for(int i=a.length-2; i>=start; i--) {
			if(a[i]+carry>9) {
				newA[newAend--] = 0;
				carry = 1;
			} else {
				newA[newAend--] = a[i]+carry;
				carry = 0;
			}
		}
		if(carry==1) {
			newA[0] = 1;
		}
		if(newA[0]==0) {
			return Arrays.copyOfRange(newA, 1, newA.length);
		}
		return newA;
	}
	public static void main(String[] args) {
		AddOneToNumber obj = new AddOneToNumber();
		System.out.println(Arrays.toString(obj.addOne(new int[]{0})));
	}
}
