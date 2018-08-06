package si;
//https://www.hackerrank.com/contests/smart-interviews/challenges/si-sum-of-subarrays

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumOfSubarrays {
	
	static long findSum(long[] arr, int left, int right) {
		if (left == 0) {
			return arr[right];
		}
		return arr[right] - arr[left-1];
	}
	
	private static void replaceArrayWithPrefixSum(long[] arr) {
		for(int currentIndex = 1; currentIndex < arr.length; currentIndex++) {
			arr[currentIndex] = arr[currentIndex] + arr[currentIndex-1];
		}
	}
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

			int arraySize = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int currentArrayIndex = 0;
			long arr[] = new long[arraySize];
			
			while(currentArrayIndex < arraySize) {
				arr[currentArrayIndex] = Integer.parseInt(st.nextToken());
				currentArrayIndex++;
			}	
			//System.out.println("original array = "+Arrays.toString(arr));
			replaceArrayWithPrefixSum(arr);
			//System.out.println("prefix sum array = "+Arrays.toString(arr));
			
			int testCaseCount = Integer.parseInt(br.readLine());
			while(testCaseCount>0) {
				String indexes = br.readLine();
				StringTokenizer indexTokenizer = new StringTokenizer(indexes);
				int left = Integer.parseInt(indexTokenizer.nextToken());
				int right = Integer.parseInt(indexTokenizer.nextToken());
				
				long result = SumOfSubarrays.findSum(arr, left, right);
				output.write(Long.toString(result)+"\n");
				testCaseCount--;
			}
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
