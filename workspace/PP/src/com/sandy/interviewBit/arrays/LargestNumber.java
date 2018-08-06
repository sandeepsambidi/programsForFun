package com.sandy.interviewBit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

	 public String largestNumber(final int[] A) {		 
		 ArrayList<Integer> list = new ArrayList<>();
		 for(int curr: A) {
			 list.add(curr);
		 }
		 
		 Collections.sort(list, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					String num1 = o1.toString()+o2.toString();
					String num2 = o2.toString()+o1.toString();
					if(num1.compareTo(num2) > 0) {
						return -1;
					} else if(num1.compareTo(num2) < 0) {
						return 1;
					}
					return 0;
				}
			});
		 StringBuilder sb = new StringBuilder();
		 if(list.get(0)==0) {
			 sb.append("0");
		 } else {
			 for(Integer curr: list) {
				 sb.append(Integer.toString(curr));
			 } 
		 }
		 
		 
		 return sb.toString();
	    }
	 
	public static void main(String[] args) {

		LargestNumber ln = new LargestNumber();
		//int[] arr = {3, 30, 34, 5, 9};
		int[] arr = {0, 0, 0, 0, 0};

		System.out.println(ln.largestNumber(arr));
	}

}
