package bitManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Powerab {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int prime = 1000000007;
			long base = Long.parseLong(st.nextToken())%prime;
			long power = Long.parseLong(st.nextToken())%prime;
			long result = 1;
			long x = base;
			if(base != 0) {
				while(power> 0) {
					if(power == 1){
						result = (base * result)%prime;
						break;
					}
					if((power&1) == 1) {
						result = (result * base)%prime;
						power--;
					}
					else {
						base = (base * base)%prime;
						power = power>>1;
					}
				}
				
			}
			else {
				result = 0;
			}
				
			bw.write(Long.toString(result) + "\n");
			tc--;
		}
		bw.flush();
	}


}
