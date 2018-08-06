//https://www.hackerrank.com/contests/smart-interviews/challenges/si-express-as-a-power-b
package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ExpressNumberaPowerb {
	static long[][] powerArray;
	static int mod = 1000000007;
	
	static boolean isPowerPossible(int num) {
		int baseMax = (int)Math.sqrt(num);
		int baseMin = 2;
		boolean ans = false;
		while( baseMin<= baseMax) {
			ans = isPossibleWithBase(baseMin, num);
			if (ans) {
				return true;
				}
			baseMin++;
		}
		return false;
	}
	
	static boolean isPossibleWithBase(int base, int num) {
		int powerMin = 2;
		int powerMax = (int) (Math.log(num)/Math.log(2));
		
		while (powerMin <= powerMax) {
			int mid = powerMin + ((powerMax - powerMin)/2);
			if(powerArray[base][mid] == num) {
				return true;
			} else if (powerArray[base][mid] > num ) {
				powerMax = mid - 1;
			} else {
				powerMin = mid + 1;
			}
		}
		
		return false;
	}
	
	static void preComputePowerArray(int num) {
		
		int powerMax = (int) (Math.log(num)/Math.log(2));
		int baseMax = (int)Math.sqrt(num);
		powerArray = new long[baseMax+1][powerMax+1];
		for (int i = 0; i<= baseMax; i++) {
			for(int j=0; j<= powerMax; j++) {
				if(i==0) {
					powerArray[i][j] = 0;
				} else if (j==0) {
					powerArray[i][j] = 1;
				} else {
					powerArray[i][j] = ((powerArray[i][j-1])*i)%mod;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		preComputePowerArray(100000000);
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		while(testCaseCount > 0) {
			String result = isPowerPossible(Integer.parseInt(br.readLine()))? "Yes":"No";
			output.write(result + "\n");
			testCaseCount--;
		}
		output.flush();
	}

}
