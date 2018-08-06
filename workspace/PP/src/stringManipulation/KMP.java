package stringManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KMP {
	

	static int[] buildFailureFunciton(String pattern) {
		//System.out.println("pattern = "+pattern);
		int[] ps = new int[pattern.length()];
		int prefixIndex = 0;
		int suffixIndex = 0;
		ps[suffixIndex++] = 0;

		while(suffixIndex < pattern.length()) {
			if(pattern.charAt(prefixIndex) == pattern.charAt(suffixIndex)) {
				prefixIndex++;
				ps[suffixIndex] = prefixIndex;
				suffixIndex++;
			} else {
				if(prefixIndex == 0) {
					ps[suffixIndex] = 0;
					suffixIndex++;
				} else {
					prefixIndex = ps[prefixIndex-1];
				}
				
			}
		}
		//System.out.println("prefix suffix = "+Arrays.toString(ps));
		return ps;
	}
	
	static int kmp(String text, String pattern) {
		System.out.println("text = "+text);
		System.out.println("pattern = "+pattern);
		int[] ps = buildFailureFunciton(pattern);
		int textIndex = 0;
		int patIndex = 0;
		int count = 0;
		
		while(textIndex < text.length()) {

			if(text.charAt(textIndex) == pattern.charAt(patIndex)) {
				textIndex++;
				patIndex++;
				if(patIndex == pattern.length()) {
					count++;
					patIndex = ps[patIndex - 1];
				}
			} else {
				
				if(patIndex == 0) {
					if(text.charAt(textIndex) == pattern.charAt(patIndex)){
						textIndex++;
						patIndex++;
					} else {
						textIndex++;
					}
				} else {
					if(text.charAt(textIndex) == pattern.charAt(patIndex)){
						textIndex++;
						patIndex++;
					} else {
						patIndex = ps[patIndex-1];
					}
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCount = Integer.parseInt(br.readLine());
		while (testCaseCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String pattern = st.nextToken();
			String text = st.nextToken();
			int result = kmp(text, pattern);
			//buildFailureFunciton(pattern);
			output.write(Integer.toString(result)+"\n");
			testCaseCount--;
		}
		output.flush();
		//buildFailureFunciton("aaaaaa");
	}

}
