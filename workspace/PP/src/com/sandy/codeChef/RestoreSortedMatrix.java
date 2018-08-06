package com.sandy.codeChef;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class RestoreSortedMatrix {
	
	static void fillArray(int arr[][]) {
		//System.out.println(Arrays.deepToString(arr));
		int rowSize = arr.length;
		int colSize = arr[0].length;
		int res = 0;
		StringBuilder sb = new StringBuilder();
		for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
			
			if(res == -1) {
				break;
			}
			for ( int colIndex = 0; colIndex < colSize; colIndex++) {
				if (arr[rowIndex][colIndex] == -1) {
					
					if(rowIndex == 0 && colIndex ==0) {
						arr[rowIndex][colIndex] = 1;
					}
					else if(rowIndex == 0) {
						arr[rowIndex][colIndex] = arr[rowIndex][colIndex-1];
					} else if (colIndex == 0) {
						arr[rowIndex][colIndex] = arr[rowIndex-1][colIndex];
					} else {
						arr[rowIndex][colIndex] = Math.max(arr[rowIndex-1][colIndex], arr[rowIndex][colIndex-1]);
					}
					
				} else {
					if (isValidValue(arr, rowIndex, colIndex) == false) {
						res = -1;
					}
				}
				sb.append(Integer.toString(arr[rowIndex][colIndex]));
				sb.append(" ");
			}
			sb.append("\n");
			
		}
		
		if(res == -1) {
			System.out.println(-1);
		} else {
			System.out.println(sb.toString());
		}
	}
	
	static boolean isValidValue(int[][] arr, int row, int col) {
		int rowSize = arr.length;
		int colSize = arr[0].length;
		int r = row-1;
		int c = col;
		
		if(r >=0 ) {
			if(arr[r][c] != -1 && arr[row][col] < arr[r][c]) {
				return false;
			} 
		}
		
		r = row;
		c = col-1;
		
		if (c >= 0) {
			if (arr[r][c] != -1 && arr[row][col] < arr[r][c]) {
				return false;
			}
		}
		
		r = row + 1;
		c = col;
		
		if (r < rowSize) {
			if (arr[r][c] != -1 && arr[row][col] > arr[r][c]) {
				return false;
			}
		}
		
		r = row;
		c = col + 1;
		
		if (c < colSize) {
			if (arr[r][c] != -1 && arr[row][col] > arr[r][c]) {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCount = Integer.parseInt(br.readLine());
		while (testCaseCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int rowSize = Integer.parseInt(st.nextToken());
			int colSize = Integer.parseInt(st.nextToken());
			int arr[][] = new int[rowSize][colSize];
			int index = 0;
			while (index < rowSize) {
				StringTokenizer rowData = new StringTokenizer(br.readLine());
				int colNum = 0;
				while (rowData.hasMoreElements()) {
					arr[index][colNum++] = Integer.parseInt(rowData.nextToken());
				}
				index++;
			}
			fillArray(arr);
			
			testCaseCount--;
		}
		output.flush();

	}

}
