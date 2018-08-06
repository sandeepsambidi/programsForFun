package com.sandy.interviewBit.twoPointer;

import java.util.ArrayList;

public class MergeSortedLists2 {

	public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
		int i = 0;
		int j = 0;
		
		while(i < a.size() && j < b.size()) {
			if (a.get(i) < b.get(j)) {
				i++;
			} else if (a.get(i) > b.get(j)) {
				a.add(i, b.get(j));
				j++;
				i++;
			} else {
				a.add(i,b.get(j));
				i++;
				j++;
			}
		}
		
		if (j < b.size()) {
			while(j < b.size()) {
				a.add(b.get(j));
				j++;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		ArrayList<Integer> b = new ArrayList<>();
		b.add(3);
		b.add(4);
		b.add(5);
		merge(a, b);
		System.out.println(a);

	}

}
