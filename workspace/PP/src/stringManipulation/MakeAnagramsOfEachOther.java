package stringManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class MakeAnagramsOfEachOther {
	
	static int makeAnagrams(String str1, String str2) {
		int countStr1 = str1.length();
		int countStr2 = 0;
		HashMap<Character, Integer> fMapStr1 = new HashMap<Character, Integer>();
		
		for (int i = 0; i < str1.length(); i++) {
			char currentChar = str1.charAt(i);
			if(fMapStr1.containsKey(currentChar)){
				fMapStr1.put(currentChar, fMapStr1.get(currentChar) + 1 );
			} else {
				fMapStr1.put(currentChar, 1);
			}
		} 
		
		for( int i=0; i< str2.length(); i++) {
			char currentChar = str2.charAt(i);
			if(fMapStr1.containsKey(currentChar)) {
				
				if(fMapStr1.get(currentChar) > 0) {
					countStr1--;
					fMapStr1.put(currentChar,fMapStr1.get(currentChar)-1);
				} else {
					countStr2 ++;
				}	
			} else {
				countStr2 ++;
			}
		}
		return countStr1+countStr2;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCount = Integer.parseInt(br.readLine());
		while(testCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();
			int result = makeAnagrams(str1, str2);
			bw.write(Integer.toString(result)+"\n");
			testCount--;
		}
		bw.flush();
	}

}
