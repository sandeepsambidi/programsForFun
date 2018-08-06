package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class KanpsackDP {

	static int findMaxValue (int[] itemSize, int[] itemValue, int bagSize, int itemCount) {
		
		int[][] dp = new int[bagSize+1][itemCount+1];
		
		for (int size = 1; size <= bagSize; size++ ) {
			for (int itemNum = 1; itemNum <= itemCount; itemNum++ ) {
				dp[size][itemNum] = Math.max(dp[size][itemNum-1], 
						size-itemSize[itemNum] >= 0 ?dp[size-itemSize[itemNum]][itemNum-1] + itemValue[itemNum]: 0);
			}
		}
		return dp[bagSize][itemCount];
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCount = Integer.parseInt(br.readLine());
		while (testCaseCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int bagSize = Integer.parseInt(st.nextToken());
			int itemCount = Integer.parseInt(st.nextToken());

			int size[] = new int[itemCount+1];
			int value[] = new int[itemCount+1];
			int i = 1;
			while (i <= itemCount) {
				st = new StringTokenizer(br.readLine());
				size[i] = Integer.parseInt(st.nextToken());
				value[i] = Integer.parseInt(st.nextToken());
				i++;
			}
			output.write(Integer.toString(findMaxValue(size, value, bagSize, itemCount)));
			output.newLine();
			testCaseCount--;
		}
		output.flush();

	}

}
