package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PathsInMatrixDP {

	static int prime = 1000000007;
	static void countPaths (long[][] arr) {
		
		//System.out.println(Arrays.deepToString(arr));
		if (arr[0][0] == -1 || arr[arr.length-1][arr[0].length-1] == -1) {
			System.out.println(0);
			return;
		}
		
		for (int row = 0; row < arr.length; row ++) {
			for (int col = 0; col < arr[0].length; col++) {
				
				if (arr[row][col] != -1) {
					
					if (row == 0 && col == 0) {
						arr[row][col] = 1;
					} else if (row == 0) {
						if (arr[row][col-1] == 1) {
							arr[row][col] = 1;
						}
						
					} else if (col == 0) {
						if (arr[row-1][col] == 1) {
							arr[row][col] = 1;
						}
					} else {
						arr[row][col] = ((Math.max(arr[row-1][col], 0) + 
								Math.max(arr[row][col-1], 0))%prime + 
								Math.max(arr[row-1][col-1], 0))%prime;
					}
				}
				
			}
		}
		
		System.out.println(arr[arr.length-1][arr[0].length-1]);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCount = Integer.parseInt(br.readLine());
		while (testCaseCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int rowCount = Integer.parseInt(st.nextToken());
			int colCount = Integer.parseInt(st.nextToken());
			int forbiddenCount = Integer.parseInt(st.nextToken());
			long arr[][] = new long[rowCount][colCount];
			
			while (forbiddenCount > 0) {
				st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
				forbiddenCount--;
			}
			
			countPaths(arr);
			testCaseCount--;
		}
		output.flush();

	}
}
