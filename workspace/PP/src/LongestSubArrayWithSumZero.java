import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class LongestSubArrayWithSumZero {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCount = Integer.parseInt(br.readLine());
		while(testCount > 0) {
			int arrSize = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = 0;
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			int sum = 0;
			int res = 0;
			while(index < arrSize) {
				int currElement = Integer.parseInt(st.nextToken());
				sum = sum + currElement;
				int localRes = 0;
				if(res == 0 && currElement == 0) {
					localRes = 1;
				}
				if(sum == 0) {
					localRes = index + 1;
				}
				if(hm.containsKey(sum)) {
					localRes = Math.max(localRes, index - hm.get(sum));
					
				}
				else {
					hm.put(sum, index);
				}
				if(localRes > res) {
					res = localRes;
				}
				index++;
			}
			System.out.println(res);
			testCount--;
		}

	}
	
	static int getLongestBalancedChromosome(String c) {
        int arrSize = c.length();
        StringTokenizer st = new StringTokenizer(c);
			int index = 0;
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			int sum = 0;
			int res = 0;
			while(index < arrSize) {
				int currElement = Integer.parseInt(Character.toString(c.charAt(index)));
                if(currElement == 0) {
                    currElement = -1;
                }
				sum = sum + currElement;
				int localRes = 0;
				if(res == 0 && currElement == 0) {
					localRes = 1;
				}
				if(sum == 0) {
					localRes = index + 1;
				}
				if(hm.containsKey(sum)) {
					localRes = Math.max(localRes, index - hm.get(sum));
					
				}
				else {
					hm.put(sum, index);
				}
				if(localRes > res) {
					res = localRes;
				}
				index++;
			}
			//System.out.println(res);
        return res;
    }
	
	static int getLazyEscalations(int k, int[] escalations) {
		 
	    int dp[][] = new int[k+1][escalations.length];
	 
	 
	    int including,excluding;
	 
	    for(int j=0;j<escalations.length;j++)
	    {
	        dp[0][j]=1;
	    }
		for(int i=1;i<=k;i++)
	    {
	        for(int j=0;j<escalations.length;j++)
	        {
	            if(i>=escalations[j])
	            {
	                including=dp[i-escalations[j]][j];
	            }
	 
	            else
	                including=0;
	 
	            if(j>=1)
	                excluding=dp[i][j-1];
	 
	            else
	                excluding=0;
	 
	            dp[i][j]=Math.min(including,excluding);
	        }
	    }
	 
	    return dp[k][escalations.length-1];
    }


}
