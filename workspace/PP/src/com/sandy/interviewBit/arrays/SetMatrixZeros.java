package com.sandy.interviewBit.arrays;

import java.util.ArrayList;

public class SetMatrixZeros {

	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
		
		int fr = 1;
		int fc = 1;
		
		for(int i=0; i<a.get(0).size(); i++) {
			if(a.get(0).get(i) == 0) {
				fr = 0;
				break;
			}
		}
		
		for(int i = 0; i< a.size(); i++) {
			if(a.get(i).get(0) == 0) {
				fc = 0;
				break;
			}
		}
		
		for(int i = 1;i <a.size(); i++) {
			for(int j =1; j<a.get(0).size(); j++) {
				if(a.get(i).get(j) == 0) {
					a.get(i).set(0, 0);
					a.get(0).set(j, 0);
				}
			}
		}
		
		for(int i = 1;i <a.size(); i++) {
			for(int j =1; j<a.get(0).size(); j++) {
				if(a.get(0).get(j) == 0 || a.get(i).get(0) == 0) {
					a.get(i).set(j, 0);
				}
			}
		}
		
		if(fr == 0) {
			for(int i=0; i<a.get(0).size(); i++) {
				a.get(0).set(i,0);
			}
		}
		if(fc == 0) {
			for(int i = 0; i< a.size(); i++) {
				a.get(i).set(0,0);
			}
		}
	}
	
	public static void main(String[] args) {
		SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> r1 = new ArrayList<>();
		r1.add(1);
		r1.add(0);
		r1.add(1);

		ArrayList<Integer> r2 = new ArrayList<>();
		r2.add(1);
		r2.add(1);
		r2.add(1);
		
		ArrayList<Integer> r3 = new ArrayList<>();
		r3.add(1);
		r3.add(1);
		r3.add(1);
		
		a.add(r1);
		a.add(r2);
		a.add(r3);
		
		System.out.println(a);
		setMatrixZeros.setZeroes(a);
		System.out.println(a);
	}

}
