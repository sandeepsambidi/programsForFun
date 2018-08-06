package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PrimesCountInRange {

	static int num = 1000000;
	static int primeCount[] = new int[num + 1];
	static boolean[] nonPrimes = new boolean[num+1];
	
	static void preComputePrimes() {
		
		int maxDivisor = (int)(Math.sqrt(num));
		nonPrimes[0] = true;
		nonPrimes[1] = true;
		primeCount[0] = 0;
		primeCount[0] = 0;
		primeCount[1] = 0;
		int count = 0;
		for(int i=2; i<=maxDivisor; i++) {
			int curr = i;
			if(!nonPrimes[curr]) {
				curr = curr + i;
				while(curr <= num) {
					nonPrimes[curr] = true;
					curr = curr+i;
				}
			}
		}
		for (int i = 2; i < nonPrimes.length; i++) {
			if(!nonPrimes[i]) {
				count++;
			} 
			primeCount[i] = count;
		}
//		System.out.println(Arrays.toString(nonPrimes));
//		System.out.println(Arrays.toString(primeCount));
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCount = Integer.parseInt(br.readLine());
		preComputePrimes();

		while(testCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			int result = 0;
			if(nonPrimes[left]) {
				result = primeCount[right] - primeCount[left];
			} else {
				result = primeCount[right] - primeCount[left]+1;
			}
			bw.write(Integer.toString(result)+"\n");
			testCount--;
		}
		bw.flush();
	}

}
