package com.sandy.interviewBit.arrays;

public class GridUniquePaths {

	public int uniquePaths(int A, int B) {
		int dp[][] = new int[A][B];
		
		for(int i=0;i< B; i++) {
			dp[0][i] = 1;
		}
		
		for(int i=0;i<A;i++) {
			dp[i][0] = 1;
		}
		
		for(int i=1;i<A;i++) {
			for(int j=1; j<B; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		return dp[A-1][B-1];
		
	}
	public static void main(String[] args) {
		GridUniquePaths obj = new GridUniquePaths();
		System.out.println(obj.uniquePaths(2, 2));
	}

}
