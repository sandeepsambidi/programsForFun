package bitManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FlipBits {
	
	static int countFlips(int a, int b) {
		int c = a^b;
		return countSetBits(c);
	}
	
	static int countSetBits(int c) {
		int count = 0;
		while(c > 0) {
			c = (c&(c-1));
			count++;
		}
		return count;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int result = countFlips(a, b);
			bw.write(Integer.toString(result) + "\n");
			tc--;
		}
		bw.flush();
	}

}
