package com.sandy.interviewBit.arrays;

import java.util.Arrays;

import javax.swing.SpringLayout;

public class SpiralMatrix2 {
	public int[][] generateMatrix(int A) {
		
		int starti = 0;
		int startj = 0;
		int size = A;
		int looper = 0;
		int value = 1;
		int arr[][] = new int[A][A];
		if((size&1) == 0) {
			looper = (size/2)-1;
		} else {
			looper = (size/2);
		}
		
		while (looper >= 0) {
			int i = starti;
			int j = startj;
			
			while(j < size) {
				arr[i][j] = value++;
				j++;
			}
			j--;
			i++;
			while(i < size) {
				arr[i][j] = value++;
				i++;
			}
			j--;
			i--;
			while(j >= startj) {
				arr[i][j] = value++;
				j--;
			}
			j++;
			i--;
			while(i > starti) {
				arr[i][j] = value++;
				i--;
			}
			
			looper--;
			starti++;
			startj++;
			size--;
			
		}
		
		System.out.println(Arrays.deepToString(arr));
		return arr;
		
	}
	
	public static void main(String[] args) {
		SpiralMatrix2 spiralMatrix2 = new SpiralMatrix2();
		spiralMatrix2.generateMatrix(0);
	}
}
