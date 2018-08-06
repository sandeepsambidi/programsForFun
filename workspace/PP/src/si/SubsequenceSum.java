package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SubsequenceSum {
	
	static long countSubsequences(int[] arr1, int[] arr2, int leftRange, int rightRange) {
		
		long count = 0;
		long[] subSeqArr1 = null;
		long[] subSeqArr2 = null;
		

		subSeqArr1 = new long[1<< arr1.length];
		buildSubSeqArray(arr1, subSeqArr1);


		subSeqArr2 = new long[1<< arr2.length];
		buildSubSeqArray(arr2, subSeqArr2);

		
		Arrays.sort(subSeqArr2);
		int index = 0;
		while(index < subSeqArr1.length) {
			long num = subSeqArr1[index];
			long floor = floor(subSeqArr2, rightRange-num);
			long ceil = ceil(subSeqArr2, leftRange- num);
			if(floor != -1 && ceil != subSeqArr2.length) {
				count = count + floor-ceil+1;
			}
			index++;
		}

		return count;
	
	}
	
	static long ceil(long[] arr, long num) {
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		
		while(start < end) {
			mid = start + ((end-start)/2);
			if(num > arr[mid]) {
				start = mid+1;
			} else {
				end = mid;
			}
			
		}
		if(arr[start] < num) {
			return arr.length;
		} 
		return start;
	}
	
	static long floor(long[] arr, long num) {
		int start = 0;
		int end = arr.length-1;
		int mid = 0;
		
		while(start < end) {
			mid = start + ((end-start + 1)/2);
			if(num >= arr[mid]) {
				start = mid;
			} else {
				end = mid-1;
			}
		}
		if(arr[start] > num) {
			return -1;
		}
		return start;
		
	}
	
	static int buildSubSeqSumArray(int[] arr, long[] result, int arrIndex, int resultIndex, long sum) {
		if(arrIndex >= arr.length) {
			return 0;
		}
		if(arrIndex == arr.length-1) {
			result[resultIndex] = sum;
			result[resultIndex+1] = sum + arr[arrIndex];
			return resultIndex+1;
		}
		int prevIndex = buildSubSeqSumArray(arr, result, arrIndex+1, resultIndex, sum);
		prevIndex = buildSubSeqSumArray(arr, result, arrIndex+1, prevIndex+1, sum+arr[arrIndex]);
		return prevIndex;
	}
	
	static void buildSubSeqArray(int[] arr, long[] result) {
		
		for(int i = 0;i < result.length; i++) {
			long sum = 0;
			for (int j = 0; j< arr.length; j++) {
				if((i & (1<<j)) > 0) {
					sum = sum + arr[j];
				}
			}
			result[i] = sum;
		}
		
	}
	
	static int resultByBrut(long[] arr, int leftRange, int rightRange){
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] >= leftRange && arr[i] <= rightRange) {
				count++;
			}
		}
		return count;
	}
 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCount = Integer.parseInt(br.readLine());
		while(testCaseCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arraySize = Integer.parseInt(st.nextToken());
			boolean isEven  = ((arraySize & 1) == 0)? true: false;
			int arr1Size;
			int arr2Size;
			if(isEven) {
				arr1Size = arraySize/2;
				arr2Size = arr1Size;
			} else {
				arr1Size = arraySize/2;
				arr2Size = arr1Size + 1;
			}
			int arr1[] = new int[arr1Size];
			int arr2[] = new int[arr2Size];
			int leftRange = Integer.parseInt(st.nextToken());
			int rightRange = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int index = 0;
			while (index < arr1Size) {
				arr1[index] = Integer.parseInt(st.nextToken());
				index++;
			}
			index = 0;
			while (index < arr2Size) {
				arr2[index] = Integer.parseInt(st.nextToken());
				index++;
			}
			long result = countSubsequences(arr1,arr2, leftRange, rightRange);
			output.write(Long.toString(result) + "\n");
//			int[] arr = new int[arraySize];
//			index = 0;
//			while(index < arraySize) {
//				for (int i = 0; i < arr1.length; i++) {
//					arr[index++] = arr1[i];
//				}
//				for (int i = 0; i < arr2.length; i++) {
//					arr[index++] = arr2[i];
//				}
//			}
//			long[] resultByBrut = new long[(1<<arraySize)];
//			buildSubSeqArray(arr, resultByBrut);
//			int resultByBrutForce = resultByBrut(resultByBrut, leftRange, rightRange);
//			System.out.println("brut result = "+resultByBrutForce);
			testCaseCount--;
		}
		output.flush();


	}

}

//2
//3 -1 2
//1 -2 3
