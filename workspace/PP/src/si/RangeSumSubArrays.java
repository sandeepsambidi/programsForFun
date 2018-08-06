package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RangeSumSubArrays {

	static int[] prefixSum;
	
	static int count(int[] arr, int leftRange, int rightRange) {
		int count = 0;
		calculatePrefix(arr);
		//System.out.println("range = "+leftRange+", "+rightRange);
		for(int startIndex = 0; startIndex<arr.length; startIndex++) {
			for(int endIndex = startIndex; endIndex< arr.length; endIndex++) {
				if(isInRange(leftRange, rightRange, startIndex, endIndex, arr)) {
					count++;
				}
			}
		}
		return count;
	}
	
	private static void calculatePrefix(int[] arr) {
		prefixSum = new int[arr.length];
		prefixSum[0] = arr[0];
		for(int i = 1; i<arr.length; i++) {
			prefixSum[i] = arr[i] + prefixSum[i-1];
		}
		//System.out.println(Arrays.toString(prefixSum));
	}
	
	static boolean isInRange(int rLeft, int rRight, int leftIndex, int rightIndex, int[] arr) {
		
		int rangeSum = prefixSum[rightIndex] - prefixSum[leftIndex] + arr[leftIndex];
		
		if(rLeft <= rangeSum && rRight >= rangeSum) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCount = Integer.parseInt(br.readLine());
		while (testCaseCount > 0) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int arraySize = Integer.parseInt(st1.nextToken());
			int left = Integer.parseInt(st1.nextToken());
			int right = Integer.parseInt(st1.nextToken());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[arraySize];
			int index = 0;
			while (st.hasMoreElements()) {
				arr[index] = Integer.parseInt(st.nextToken());
				index++;
			}
			//System.out.println(Arrays.toString(arr));
			int result = count(arr,left, right);
			output.write(result + "\n");
			testCaseCount--;
		}
		output.flush();
	}

}
