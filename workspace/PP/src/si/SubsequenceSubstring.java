package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SubsequenceSubstring {

	static String findIfSubsequence(String text,String pattern) {
	
		int patternIndex = 0;
		
		if(text == null || pattern == null || pattern.length() > text.length()) {
			return "No";
		}
		
		for(int j = 0; j<text.length(); j++) {
			char currentTextChar = text.charAt(j);
			if(currentTextChar == pattern.charAt(patternIndex)) {
				patternIndex++;
				if(patternIndex == pattern.length()) {
					return "Yes";
				}
			}
		}
		
		return "No";
		
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCount = Integer.parseInt(br.readLine());
		while(testCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String pattern = st.nextToken();
			String text = st.nextToken();
			String result = findIfSubsequence(text, pattern);
			bw.write(result+"\n");
			testCount--;
		}
		bw.flush();
	}

}
