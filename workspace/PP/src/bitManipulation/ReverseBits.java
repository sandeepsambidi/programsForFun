package bitManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReverseBits {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			int n = Integer.parseInt(br.readLine());
			long result = 0;
			for(int i = 0; i< 32; i++){
				if((n&(1<<i))!=0) {
					long newBitValue = ((long)1<<(31-i));
					//System.out.println("bit value :"+i + ": "+newBitValue);
					result = result + newBitValue;
				}
			}
			bw.write(Long.toString(result) + "\n");
			tc--;
		}
		bw.flush();
	}

}
