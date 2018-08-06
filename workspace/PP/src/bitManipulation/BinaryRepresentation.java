package bitManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinaryRepresentation {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			int n = Integer.parseInt(br.readLine());
			int bound = 1;
			int index = 0;
			StringBuilder sb = new StringBuilder();
			while(bound <= n) {
				if(bound > n) {
					break;
				}
				if((n&bound) == 0) {
					sb.append(0);
				} else {
					sb.append(1);
				}
				index++;
				bound = 1<<index;
			}
			bw.write(sb.reverse().toString() + "\n");
			tc--;
		}
		bw.flush();
	}

}
