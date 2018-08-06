import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class PartitionStrings {
	
	static void findPar(String str, int digSize, int k) {
		if(str.length() == 1) {
			System.out.println(1);
			return;
		} 
		
		int dp[] = new int[str.length()];
		int firstTwoNum = Integer.parseInt(str.substring(0, 2));
		dp[0] = 1;
		if(firstTwoNum <= k ) {
			dp[1] = 2;
		} else {
			dp[1] = 1;
		}
		for(int i = 2; i< str.length(); i++) {
			int twoNum = Integer.parseInt(str.substring(i-1, i+1));
			int threeNum = Integer.parseInt(str.substring(i-2, i+1));
			
			if(twoNum <= k) {
				dp[i] = dp[i] + dp[i-2];
			}
			if(threeNum <= k) {
				if((i-3) < 0) {
					dp[i] = dp[i] +1;
				} else {
					dp[i] = dp[i] + dp[i-3];
				}
				
			}
			dp[i] = dp[i] + dp[i-1];
			
		}
		System.out.println(dp[str.length()-1]);
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			int index = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int stringSize = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int digitCount = 0;
			if(k <=99) {
				digitCount = 2;
			} else if(k <= 999) {
				digitCount = 3;
			}
			String str = br.readLine();
			
			findPar(str, digitCount, k);
			tc--;
		}
		bw.flush();

	}

}
