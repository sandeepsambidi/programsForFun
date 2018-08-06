//https://www.hackerrank.com/contests/smart-interviews/challenges/si-enclosing-substring
package stringManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class EnclosingSubstring {
	
	static int findMinEnclosingWindowSize(String text, String pattern) {
		int windowSize = Integer.MAX_VALUE;
		int count = pattern.length();
		int start = 0;
		int end = 0;
		HashMap<Character, Integer> fMap = new HashMap<Character, Integer>();
		
		for (int i = 0; i < pattern.length(); i++) {
			char currentChar = pattern.charAt(i);
			if(fMap.containsKey(currentChar)){
				fMap.put(currentChar, fMap.get(currentChar) + 1 );
			} else {
				fMap.put(currentChar, 1);
			}
		} 
		
		for( int i=0; i< text.length(); i++) {
			char currentChar = text.charAt(i);
			if(fMap.containsKey(currentChar)) {
				
				if(fMap.get(currentChar) > 0) {
					count--;
				}
				
				fMap.put(currentChar,fMap.get(currentChar)-1);
				
				if(count == 0) {
					while(start < i) {
						char startChar = text.charAt(start);
						if(fMap.containsKey(startChar)) {
							if(fMap.get(startChar) == 0) {
								break;
							} else if (fMap.get(startChar) < 0) {
								start++;
								fMap.put(startChar, fMap.get(startChar) + 1);
							}
						} else {
							start++;
						}
						
					}
					if((i - start +1) < windowSize) {
						windowSize = i - start + 1;
					}
				}
				
			}
			
		}
		return windowSize == Integer.MAX_VALUE ? -1: windowSize;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCount = Integer.parseInt(br.readLine());
		while(testCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String pattern = st.nextToken();
			String text = st.nextToken();
			int count = findMinEnclosingWindowSize(text, pattern);
			bw.write(Integer.toString(count)+"\n");
			testCount--;
		}
		bw.flush();
	}

}
