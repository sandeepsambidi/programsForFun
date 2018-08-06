package bitManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SwapBits {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			int n = Integer.parseInt(br.readLine());
			long result = 0;
			int bitPos = 0;
			while(bitPos < 32) {
				if((n&(1<<bitPos))!=0) {
					result = result + (1<<(bitPos+1));
				}
				if((n&(1<<(bitPos+1)))!=0) {
					result = result + (1<<(bitPos));
				}
				
				bitPos = bitPos + 2;
			}
			bw.write(Long.toString(result) + "\n");
			tc--;
		}
		bw.flush();
	}

}
