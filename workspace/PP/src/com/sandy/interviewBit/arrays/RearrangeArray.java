package com.sandy.interviewBit.arrays;

import java.util.ArrayList;

public class RearrangeArray {

	public void arrange(ArrayList<Integer> a) {
		int size = a.size();
		
		for(int i=0; i< size; i++) {
			if(a.get(i) > i) {
				a.set(i, a.get(i) + a.get(a.get(i))*size);
			} else if(a.get(i) < i) {
				a.set(i, a.get(i) + (a.get(a.get(i))%size)*size);
			} else {
				a.set(i, a.get(i)*size);
			}
		}
		
		for(int i=0; i< size; i++) {
			a.set(i, a.get(i)/size);
		}
	}
	
	public static void main(String[] args) {
		RearrangeArray ra = new RearrangeArray();
		ArrayList<Integer> a = new ArrayList<>();
		a.add(0);
		//a.add(0);
		System.out.println(a);
		ra.arrange(a);
		System.out.println(a.toString());
	}

}
