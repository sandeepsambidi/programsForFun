package si;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DiceRollsCountForGivenSum {
	
	static int[] buildAnsFor10000() {
		int[] res = new int[100001];
		res[0] = 0;
		res[1] = 1;
		
		for (int i=2; i<100001; i++) {
			int k = 1;
			
			while (k <=6 && (i - k)>=0) {
				res[i] = (res[i] + res[i-k])%1000000007;
				k++;
			}
			
			if (i > 0 && i <=6) {
				res[i] = res[i]+1;
			}
		}
		
		return res;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcCount = Integer.parseInt(br.readLine());
		int[] res = buildAnsFor10000();
		while (tcCount > 0) {
			System.out.println(res[Integer.parseInt(br.readLine())]);
			tcCount--;
		}
	}
}
