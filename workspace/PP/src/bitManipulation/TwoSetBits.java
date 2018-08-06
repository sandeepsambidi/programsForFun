package bitManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class TwoSetBits {

	
	static long findQuadriaticSol(long c) {
		return (long)((-1 + (Math.sqrt(1 + (4*c))))/2);
	}

	static long power(long base, long power, long prime)
	{
	    long res = 1;      // Initialize result
	 
	    base = base % prime;  // Update x if it is more than or 
	                // equal to p
	 
	    while (power > 0)
	    {
	        // If y is odd, multiply x with result
	        if ((power & 1)==1)
	            res = (res*base) % prime;
	 
	        // y must be even now
	        power = power>>1; // y = y/2
	        base = (base*base) % prime;  
	    }
	    return res;
	}
	
	static long findNum(long num) {
		long prime = 1000000007;
		if(num == 1)
			return 3;
		
		long firstBitPos = findQuadriaticSol((2*(num-1)))+1;
		long maxNumInTheBracket = firstBitPos*(firstBitPos+1)/2;
		long secondBitPos = firstBitPos - (maxNumInTheBracket-num)-1;

		
		long num1 = power(2, firstBitPos, prime);
		long num2 = power(2, secondBitPos, prime);
	
		return ((num1 + num2)%prime);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc > 0) {
			long num = Long.parseLong(br.readLine());
			long result = findNum(num);
			bw.write(Long.toString(result)+"\n");
			tc--;
		}
		bw.flush();
	}

}
