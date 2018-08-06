package stringManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RabinKarp {
	
	static long lp = 1000000007;
	static long sp1 = 17;
	static long sp2 = 37; 
	static long[] primes1;
	static long[] primes2;


	static long findOccurancesCount(String pattern, String text) {
		int count = 0;
		long patternHash1 = findHash(pattern, primes1);
		long patternHash2 = findHash(pattern, primes2);
		int length = pattern.length();
		long prevWindowHash1 = findHash(text.substring(0,length), primes1);
		long prevWindowHash2 = findHash(text.substring(0,length), primes2);

		if(prevWindowHash1 == patternHash1 && prevWindowHash2 == patternHash2) {
			count++;
		}
		for(int i=1; i<= text.length()-length; i++) {		
			long currWindowHash1 = ((prevWindowHash1*primes1[0])%lp + ((text.charAt(i+length-1)*primes1[0]) - (((text.charAt(i-1)*primes1[length-1])%lp)*primes1[0])%lp + lp*122)%lp)%lp;
			long currWindowHash2 = ((prevWindowHash2*primes2[0])%lp + ((text.charAt(i+length-1)*primes2[0]) - (((text.charAt(i-1)*primes2[length-1])%lp)*primes2[0])%lp + lp*122)%lp)%lp;
			if(currWindowHash1 == patternHash1 && currWindowHash2 == patternHash2) {
				count++;
			}

			prevWindowHash1 = currWindowHash1;
			prevWindowHash2 = currWindowHash2;

		}
		return count;
	}
	
	static long findHash(String str, long[] primes) {
		long hash = 0;
		int length = str.length();
		for (int i = 0; i < str.length(); i++) {
			long currentHash = (str.charAt(i) * primes[length - (i+1)])%lp;
			hash = (hash + currentHash)%lp;
		}
		return hash;
	}
	
	static void preComputePrimes1(int length) {
		primes1 = new long[length];
		primes1[0] = sp1;
		for (int i = 1; i < length; i++) {
			primes1[i] = (primes1[i-1]*sp1)%lp;
		}
	}
	
	static void preComputePrimes2(int length) {
		primes2 = new long[length];
		primes2[0] = sp2;
		for (int i = 1; i < length; i++) {
			primes2[i] = (primes2[i-1]*sp2)%lp;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCount = Integer.parseInt(br.readLine());
		while(testCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String pattern = st.nextToken();
			preComputePrimes1(pattern.length());
			preComputePrimes2(pattern.length());

			String text = st.nextToken();
			long count = findOccurancesCount(pattern, text);
			System.out.println(count);
			testCount--;
		}
		bw.flush();
	}

}
