package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PrimeCoins {

	static String whoWins(long coinCount) {
		if ((coinCount % 6 ) == 0) {
			return "Banta";
		} else {
			return "Santa";
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCount = Integer.parseInt(br.readLine());
		while( testCaseCount > 0) {
			bw.write(whoWins(Integer.parseInt(br.readLine())) + "\n");
			testCaseCount--;
		}
		bw.flush();
	}
}
