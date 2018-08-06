package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BitonicSequenceN2DP {
	
	static int[] lis(int[] arr) {
		int[] dp = new int[arr.length];
		
		for (int i = 0; i< arr.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] >= arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		return dp;
	}
	
	static int[] lds(int[] arr) {
		int[] dp = new int[arr.length];
		
		for (int i = arr.length-1; i>=0; i--) {
			dp[i] = 1;
			for (int j = arr.length-1; j > i; j--) {
				if (arr[i] >= arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
		}
		return dp;
	}
	
	static int findLongestBitonicSeq(int[] arr) {
		int[] lis = lis(arr);
		int[] lds = lds(arr);
		
		int res = Integer.MIN_VALUE;
		
		for (int i=0; i< arr.length; i++) {
			if (lis[i] + lds[i] > res) {
				res = lis[i] + lds[i];
			}
		}
		
		return res-1;
	}
	 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCount = Integer.parseInt(br.readLine());

		while (testCaseCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arrCount = Integer.parseInt(st.nextToken());
			int[] arr = new int[arrCount];
			int i = 0;
			st = new StringTokenizer(br.readLine());
			while (i < arrCount) {
				arr[i] = Integer.parseInt(st.nextToken());
				i++;
			}
			
			output.write(Integer.toString(findLongestBitonicSeq(arr)));
			output.newLine();
			testCaseCount--;
		}
		output.flush();
	}
}
