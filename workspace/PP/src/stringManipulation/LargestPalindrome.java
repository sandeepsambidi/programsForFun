package stringManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class LargestPalindrome {

	static long p = 37;
	static long lp = 1000000007;
	static long[] primes;
	static long forwardHash[];
	static long reverseHash[];
	
	static int lengthOfLongestPrime(String text) {
		//System.out.println("String = "+text);
		int maxLength = 1;
		int length = text.length();
		forwardHash = calculateForwardHash(text);
		reverseHash = calculateReverseHash(text);
		if(forwardHash[0] == reverseHash[length-1] && reverseHash[0] == forwardHash[length-1]) {
			return length;
		}
		//System.out.println(isMatchForLength(5, text));
		int left = 0;
		int right = length-1; 
		while(left <= right) {
			int mid = left + ((right-left)/2);
			boolean midMatching = isMatchForLength(mid, text);
			boolean midNextMatching = isMatchForLength(mid+1, text);
			if(midMatching) {
				if(mid > maxLength) {
					maxLength = mid;
				}
				left = mid+1;
			} else if(midNextMatching) {
				if((mid+1) > maxLength) {
					maxLength = mid+1;
				}
				left = mid+2;
			}
			else {
				right = mid -1;
			}
			
		}
		return maxLength;
		
		
	}
	
	static boolean isMatchForLength(int windowSize, String text) {
		long fHash = 0;
		long rHash = 0;
		
		for (int i = 0; i <= text.length()-windowSize; i++) {
			int fStart = i;
			int rEnd = (text.length()-i -1);
			int rStart = rEnd - windowSize +1;
			
			if(i == 0) {
				fHash = forwardHash[i + windowSize -1];
			} else {
				fHash = (forwardHash[i + windowSize -1] - forwardHash[i-1] + lp*122)%lp;
				
			}
			if(i == text.length()-windowSize) {
				rHash = reverseHash[i];
			} else {
				rHash = (reverseHash[i] - reverseHash[i+windowSize] + lp*122)%lp; ;
			}
			
			if(fStart < rStart) {
				fHash = (fHash * primes[rStart-fStart])%lp;
			} else if (fStart > rStart) {
				rHash = (rHash * primes[fStart-rStart])%lp;
			}
			
			if(fHash == rHash) {
				//System.out.println("found = "+text.substring(fStart, fStart+windowSize));
				return true;
			}
		}
		return false;
	}
	
	static long[] calculateForwardHash(String str) {
		long forwardHash[] = new long[str.length()];
		forwardHash[0] = str.charAt(0);
		for (int i = 1; i < str.length(); i++) {
			forwardHash[i] = (forwardHash[i-1] + (str.charAt(i)*primes[i])%lp)%lp;
		}
		//System.out.println("forward hash = "+Arrays.toString(forwardHash));
		return forwardHash;
	}
	
	static long[] calculateReverseHash(String str) {
		long reverseHash[] = new long[str.length()];
		reverseHash[str.length()-1] = str.charAt(str.length()-1);
		for (int i = str.length()-2; i >= 0; i--) {
			reverseHash[i] = (reverseHash[i+1] + (str.charAt(i)*primes[str.length()-i -1])%lp)%lp;
		}
		//System.out.println("reverse hash = "+Arrays.toString(reverseHash));
		return reverseHash;
	}

	
	static void preComputePrimes(int length) {
		primes = new long[length];
		primes[0] = 1;
		for (int i = 1; i < length; i++) {
			primes[i] = (primes[i-1] * p)%lp;
		}
		//System.out.println("primes = "+Arrays.toString(primes));
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		preComputePrimes(1000);
		int testCount = Integer.parseInt(br.readLine());
		while(testCount > 0) {
			int strLength = Integer.parseInt(br.readLine());
			String str = br.readLine();
			System.out.println(lengthOfLongestPrime(str));
			testCount--;
		}
		bw.flush();
	}

}
