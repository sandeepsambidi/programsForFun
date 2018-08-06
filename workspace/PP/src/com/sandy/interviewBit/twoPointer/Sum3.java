package com.sandy.interviewBit.twoPointer;

import java.util.ArrayList;
import java.util.Collections;

public class Sum3 {

	static public int threeSumClosest(ArrayList<Integer> A, int B) {
		int diff = Integer.MAX_VALUE;
		int res = 0;
		
		int i1 = 0;
		Collections.sort(A);
		while(i1< (A.size()-2) && A.get(i1) <= B) {
			int a = A.get(i1);
			int i2 = i1+1;
			int i3 = A.size()-1;
			
			while(i2< i3) {
				int b = A.get(i2);
				int c = A.get(i3);
				
				int sum = a+b+c;
				int localDiff = Math.abs(sum-B);
				if(localDiff < diff) {
					diff = localDiff;
					res = sum;
					if(diff == 0) {
						return sum;
					}
				}
				
				if (sum > B) {
					i3--;
				} else {
					i2++;
				}
			}
			i1++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(2);
		list.add(1);
		list.add(4);
		list.add(3);


		System.out.println(threeSumClosest(list, 7));
	}

}
