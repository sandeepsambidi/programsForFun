//https://www.hackerrank.com/contests/smart-interviews/challenges/si-string-modulo
package stringManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class StringModuloEasy {

	static void printModulo(String n, int p) {
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCount = Integer.parseInt(br.readLine());
		while(testCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String N = st.nextToken();
			int P = Integer.parseInt(st.nextToken());
			printModulo(N, P);
			testCount--;
		}
		bw.flush();
	}

}
