package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Floor {
	
	static int findFloor(int[] arr, int target) {
		int lo = 0;
		int hi = arr.length-1;
		int mid = 0;
		while(lo <= hi) {
			mid = lo + ((hi-lo)/2);
			if(arr[mid] == target) {
				return arr[mid];
			} else if (arr[mid] > target) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		if(hi == -1) {
			return Integer.MIN_VALUE;
		}
		if(lo == arr.length) {
			return arr[arr.length-1];
		}
		return arr[hi];
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arraySize = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[arraySize];
		int index = 0;
		while (st.hasMoreElements()) {
			arr[index] = Integer.parseInt(st.nextToken());
			index++;
		}
		Arrays.sort(arr);
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCount = Integer.parseInt(br.readLine());
		while (testCaseCount > 0) {
			int target = Integer.parseInt(br.readLine());
			int result = findFloor(arr, target);
			output.write(result + "\n");
			testCaseCount--;
		}
		output.flush();
	}
}
