package com.sandy.interviewBit.twoPointer;

import java.util.ArrayList;
import java.util.Collections;

public class MinimizeAbsDifference {

	static int findAbsDiff(ArrayList<Integer> a,ArrayList<Integer> b, ArrayList<Integer> c ) {
		int ia = 0;
		int ib = 0;
		int ic = 0;
		int res = Integer.MAX_VALUE;
		Collections.sort(a);
		Collections.sort(b);
		Collections.sort(c);

		
		while (ia < a.size() && ib < b.size() && ic < c.size()) {
			if (a.get(ia) < b.get(ib)) {
				if (a.get(ia) < c.get(ic)) {
					int max = Math.max(b.get(ib), c.get(ic));
					int absDiff = Math.abs(max - a.get(ia));
					if(absDiff <  res ) {
						res = absDiff;
					}
					ia++;
				} else {
					int max = Math.max(a.get(ia), b.get(ib));
					int absDiff = Math.abs(max - c.get(ic));
					if(absDiff <  res ) {
						res = absDiff;
					}
					ic++;
				}
			} else {
				if (b.get(ib) < c.get(ic)) {
					int max = Math.max(a.get(ia), c.get(ic));
					int absDiff = Math.abs(max - b.get(ib));
					if(absDiff <  res ) {
						res = absDiff;
					}
					ib++;
				} else {
					int max = Math.max(b.get(ib), a.get(ia));
					int absDiff = Math.abs(max - c.get(ic));
					if(absDiff <  res ) {
						res = absDiff;
					}
					ic++;
				}
			}			
		}
		return res;
	}
	

	
	public static void main(String[] args) {
		//A : [ 1, 4, 5, 8, 10 ]
			//	B : [ 6, 9, 15 ]
				//C : [ 2, 3, 6, 6 ]
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(4);
		a.add(5);
		a.add(8);
		a.add(10);
		ArrayList<Integer> b = new ArrayList<>();
		b.add(6);
		b.add(9);
		b.add(15);
		ArrayList<Integer> c = new ArrayList<>();
		c.add(2);
		c.add(3);
		c.add(6);
		c.add(6);
		System.out.println(findAbsDiff(a, b, c));

		
	}

}
