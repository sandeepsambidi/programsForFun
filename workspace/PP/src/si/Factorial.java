package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Factorial {

	static long[] findFactoiral() {
		long prime = 1000000007;
		long fact = 1;
		long facts[] = new long[1000001];
		facts[0] = 1;
		for (int i = 1; i<= 1000000; i++) {
			fact = (fact * i)%prime;
			facts[i] = fact;	
		}
		return facts;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int tcCount = Integer.parseInt(br.readLine());
		long[] facts = findFactoiral();
		while (tcCount > 0) {
			System.out.println(facts[Integer.parseInt(br.readLine())]);
			tcCount--;
		}
		
		
		output.flush();
	}

}
