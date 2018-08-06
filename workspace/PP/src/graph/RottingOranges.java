package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;

public class RottingOranges {
	
	static int arr[][];
	static class Index {
		int rowIndex;
		int colIndex;
		
		
		Index(int row, int col) {
			this.rowIndex = row;
			this.colIndex = col;
		}
	}
	
	static int rowCount;
	static int colCount;
	
	static void countDays() {
		int days = bfs();
		
		for (int i = 0; i < rowCount; i++) {
			for ( int j = 0; j < colCount; j++) {
				if(arr[i][j] == 1) {
					days = -1;
					break;
					}
				}
			if(days == -1){
				break;
			}
			}
		
		System.out.println(days);
	}
	
	static int bfs() {
		Queue<Index> queue = new LinkedList<Index>();
		int count = 0;
		for (int i = 0; i < rowCount; i++) {
			for ( int j = 0; j < colCount; j++) {
				if(arr[i][j] == 2) {
					queue.add(new Index(i, j));
					count++;
					arr[i][j] = 3;
				}
			}
		}
				
		int height = 0;
		
		while(!queue.isEmpty()) {
			int localCount = 0;
			while( count > 0) {
				Index curr = queue.remove();
				
				int nRow = curr.rowIndex -1;
				int nCol = curr.colIndex;
				if(nRow < arr.length && nRow >= 0 && nCol < arr.length && nCol >=0) {
					if(arr[nRow][nCol] == 1) {
						queue.add(new Index(nRow, nCol));
						arr[nRow][nCol] = 3;
						localCount++;
					}
					
				}
				
				nRow = curr.rowIndex;
				nCol = curr.colIndex + 1;
				if(nRow < arr.length && nRow >= 0 && nCol < arr.length && nCol >=0) {
					if(arr[nRow][nCol] == 1) {
						queue.add(new Index(nRow, nCol));
						arr[nRow][nCol] = 3;
						localCount++;
					}
				}
				
				nRow = curr.rowIndex + 1;
				nCol = curr.colIndex;
				if(nRow < arr.length && nRow >= 0 && nCol < arr.length && nCol >=0) {
					if(arr[nRow][nCol] == 1) {
						queue.add(new Index(nRow, nCol));
						arr[nRow][nCol] = 3;
						localCount++;
					}
				}
				
				nRow = curr.rowIndex;
				nCol = curr.colIndex - 1;
				if(nRow < arr.length && nRow >= 0 && nCol < arr.length && nCol >=0) {
					if(arr[nRow][nCol] == 1) {
						queue.add(new Index(nRow, nCol));
						arr[nRow][nCol] = 3;
						localCount++;
					}
				}
				
				count--;
			}
			count = localCount;
			height++;
		}
		return height-1;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int testCount = 1;
		
		while (testCount <= tc) {
			rowCount = Integer.parseInt(br.readLine());
			colCount = rowCount;
			int arr[][] = new int[rowCount][colCount];
			int rowIndex = 0;
			int colIndex = 0;
			while (rowIndex < rowCount) {
				char[] curArr = br.readLine().toString().toCharArray();
				colIndex = 0;
				while (colIndex < colCount) {
					arr[rowIndex][colIndex] = Integer.parseInt(String.valueOf(curArr[colIndex]));
					colIndex++;
				}
				rowIndex++;
			}
			RottingOranges.arr = arr;
			countDays();
			testCount++;
		}
		
	}
}
