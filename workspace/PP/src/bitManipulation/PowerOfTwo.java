package bitManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PowerOfTwo {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			int n = Integer.parseInt(br.readLine());
			if((n&(n-1))== 0) {
				bw.write("True"+ "\n");
			} else {
				bw.write("False"+ "\n");
			}
			tc--;
		}
		bw.flush();
	}

}
