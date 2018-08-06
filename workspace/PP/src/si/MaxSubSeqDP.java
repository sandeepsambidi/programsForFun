package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MaxSubSeqDP {
	
	static void findMaxSumSubSeq(int arr[]) {

		if (arr.length == 1) {
			System.out.println(arr[0]);
			return;
		}
		
		int dp[] = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		
		for (int i = 2; i< arr.length; i++) {
			dp[i] = Math.max(dp[i-2] + arr[i], arr[i]);
			dp[i] = Math.max(dp[i-1], dp[i]);
		}
		
		System.out.println(dp[arr.length-1]);
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
			findMaxSumSubSeq(arr);
			testCaseCount--;
		}
		output.flush();

	}
}
