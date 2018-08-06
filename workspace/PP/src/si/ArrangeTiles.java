package si;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrangeTiles {

	static long[] count(int n) {
		long dp[] = new long[n+1];
		dp[1] = 1;
		dp[2] = 2;
		int prime = 1000000007;
		
		for (int i=3; i<= n; i++) {
			if (i -1 > 0) {
				dp[i] = (dp[i] + dp[i-1])%prime;
			}
			
			if (i -2 > 0) {
				dp[i] = (dp[i] + dp[i-2])%prime;
			}
			
			if (i == 5) {
				dp[i] = ((dp[i])*2);
			}
			
			if (i - 5 > 0) {
				dp[i] = (dp[i] + (((dp[i-5])*8)%prime))%prime;
			}
		}
		
		return dp;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcCount = Integer.parseInt(br.readLine());
		long result[] = count(1000000);
		while (tcCount > 0) {
			System.out.println(result[(Integer.parseInt(br.readLine()))]);
			tcCount--;
		}
	}

}
