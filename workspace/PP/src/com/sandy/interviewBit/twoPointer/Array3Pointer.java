package com.sandy.interviewBit.twoPointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Array3Pointer {

	static public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
		int ia = 0;
		int ib = 0;
		int ic = 0;
		int res = Integer.MAX_VALUE;

		while (ia < a.size() && ib < b.size() && ic < c.size()) {
			int d1 = Math.abs(a.get(ia) - b.get(ib));
			int d2 = Math.abs(a.get(ia) - c.get(ic));
			int d3 = Math.abs(b.get(ib) - b.get(ib));
			
			int localRes = Math.max(Math.max(d1, d2), Math.max(d2, d3));
			if(localRes < res) {
				res = localRes;
			}
			
			if (a.get(ia) < b.get(ib)) {
				if (a.get(ia) < c.get(ic)) {
					ia++;
				} else {
					ic++;
				}
			} else {
				if (b.get(ib) < c.get(ic)) {
					ib++;
				} else {
					ic++;
				}
			}			
		}
		return res;
			
	}
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(4);
		a.add(10);

		ArrayList<Integer> b = new ArrayList<>();
		b.add(2);
		b.add(15);
		b.add(20);
		
		ArrayList<Integer> c = new ArrayList<>();
		c.add(10);
		c.add(12);
		
		System.out.println(minimize(a, b, c));

	}

}
