package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import graph.CountConnectedComponents.GraphUndirected;

public class CountIslands {
	
	static int rowCount = 0;
	static int colCount = 0;
	
	static void count(int[][] arr) {
		
		int islandCount = 0;
		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				if(arr[i][j] == 1) {
					dfs(i, j, arr);
					islandCount++;
				}
			}
		}
		System.out.println(islandCount);
	}
	
	static void dfs(int i, int j, int[][] arr) {
		if(i < 0|| j<0 ||i >= rowCount || j >= colCount) {
			return;
		}
		if(arr[i][j] != 1) {
			return;
		}
		arr[i][j] = 2;
		
			int p = -1;
			int q = -1;
			dfs(i+p, j+q, arr);
			p = -1;
			q = 0;
			dfs(i+p, j+q, arr);
			p = -1;
			q = 1;
			dfs(i+p, j+q, arr);
			p = 0;
			q = -1;
			dfs(i+p, j+q, arr);
			p = 0;
			q = 1;
			dfs(i+p, j+q, arr);
			p = 1;
			q = -1;
			dfs(i+p, j+q, arr);
			p = 1;
			q = 0;
			dfs(i+p, j+q, arr);
			p = 1;
			q = 1;
			dfs(i+p, j+q, arr);
			

		arr[i][j] = 3;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int testCount = 1;
		
		while (testCount <= tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			rowCount = Integer.parseInt(st.nextToken());
			colCount = Integer.parseInt(st.nextToken());
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
			count(arr);
			testCount++;
		}
		
	}
}
