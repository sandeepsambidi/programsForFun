package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;

public class PrimeFear {
	
	static int[] fearPrimeCount = new int[1000001];
	
	static void preComputefindPrimeFears() {
		int num = 1000000;
		boolean[] nonPrimes = new boolean[num+1];
		int resultCount = 0;
		int maxDivisor = (int)(Math.sqrt(num));
		nonPrimes[0] = true;
		nonPrimes[1] = true;
		for(int i=2; i<=maxDivisor; i++) {
			int curr = i;
			if(!nonPrimes[curr]) {
				curr = curr + i;
				while(curr < num) {
					nonPrimes[curr] = true;
					curr = curr+i;
				}
			}
		}
		System.out.println("prime array = "+nonPrimes[632647]);
		for (int i = 2; i < nonPrimes.length; i++) {
			if(!nonPrimes[i]) {
				if(isFeared(i, nonPrimes)) {
					//fearedPrimes.add(i);
					resultCount++;
				}
			}
			fearPrimeCount[i] = resultCount;
		}
	}
	
	static boolean isFeared(int num, boolean[] nonPrimes) {
		//System.out.println("In isFeared for: "+num);
		if(Integer.toString(num).contains("0")) {
			return false;
		}
		
		String numAsString = Integer.toString(num);
		int rightIndex = numAsString.length();
		int leftIndex = 1;
		while(leftIndex < rightIndex) {
			String subString = numAsString.substring(leftIndex);
			if(nonPrimes[Integer.parseInt(subString)])
				return false;
			leftIndex++;
		}
		return true;
	}

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int testCaseCount = Integer.parseInt(br.readLine());
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			preComputefindPrimeFears();
			while(testCaseCount>0) {
				int result = fearPrimeCount[Integer.parseInt(br.readLine())];
				bw.write(result+"\n");
				testCaseCount--;
			}
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
