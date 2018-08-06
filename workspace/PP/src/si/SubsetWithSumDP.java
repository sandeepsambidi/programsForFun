package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SubsetWithSumDP {
	
	static String isSumAvailable(int[] arr, int sum) {
		int[][] dp= new int[sum+1][arr.length];
		if (sum == 0) {
			return "YES";
		}
		for (int currSum = 1; currSum <= sum; currSum++ ) {
			for (int itemNum = 1; itemNum < arr.length; itemNum++ ) {
				//consider current item
				if ( currSum - arr[itemNum] > 0) {
					if (dp[currSum - arr[itemNum]][itemNum-1] == 1) {
						dp[currSum][itemNum]  = 1;
					}
				} else if (currSum - arr[itemNum] == 0) {
					dp[currSum][itemNum]  = 1;
				}
				
				// dont consider current item
				if (dp[currSum][itemNum] == 0) {
					if (dp[currSum][itemNum-1] == 1) {
						dp[currSum][itemNum] = 1;
					}
				}
				
			}
		}
		return dp[sum][arr.length-1] == 0? "NO": "YES"; 
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCount = Integer.parseInt(br.readLine());

		while (testCaseCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arrCount = Integer.parseInt(st.nextToken());
			int sum = Integer.parseInt(st.nextToken());
			int[] arr = new int[arrCount+1];
			int i = 1;
			st = new StringTokenizer(br.readLine());
			while (i <= arrCount) {
				arr[i] = Integer.parseInt(st.nextToken());
				i++;
			}
			
			output.write(isSumAvailable(arr, sum));
			output.newLine();
			testCaseCount--;
		}
		output.flush();
	}
}
