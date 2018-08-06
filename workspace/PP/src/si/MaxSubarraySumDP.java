package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaxSubarraySumDP {

	static void findMaxSumWithIndexes(int arr[]) {
		int resStart = 0;
		int resEnd = 0;
		int start = 0;
		int end = 0;
		int max = arr[0];
		int prevSum = arr[0];
		
		for (int i = 1; i< arr.length; i++) {
			int currSum = prevSum + arr[i];
			prevSum = currSum;

			if (currSum < arr[i]) {
				start = i;
				end = i;
				currSum = arr[i];
				prevSum = arr[i];
			} 
			
			if (currSum > max) {
				resStart = start;
				end = i;
				resEnd = end;
				max = currSum;
			}
		}
		
		System.out.println(max + " " + resStart + " " + resEnd);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCaseCount = Integer.parseInt(br.readLine());
		while (testCaseCount > 0) {
			int arraySize = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[arraySize];
			int index = 0;
			while (st.hasMoreElements()) {
				arr[index] = Integer.parseInt(st.nextToken());
				index++;
			}
			findMaxSumWithIndexes(arr);
			testCaseCount--;
		}
		output.flush();

	}

}
