package stringManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ReverseSentenceWords {
	
	static String reverseWords(String sentence) {
		String reversedSentence = reverse(sentence);
		StringBuilder sb = new StringBuilder();
		int index = 0;
		int wordStartIndex = 0;
		while (index < reversedSentence.length()) {
			if(reversedSentence.charAt(index) == ' ') {
				String finalWord = reverse(reversedSentence.substring(wordStartIndex, index-1));
				sb.append(finalWord);
				sb.append(' ');
				wordStartIndex = index+1;
			} 
			index++;
		}
		return sb.toString();
	}
	
	static String reverse(String str) {
		StringBuilder sb = new StringBuilder(str);
		int left = 0;
		int right = str.length()-1;
		while(left <= right) {
			char rightChar = sb.charAt(right);
			char leftChar = sb.charAt(left);
			sb.deleteCharAt(left);
			sb.deleteCharAt(right-1);
			sb.setCharAt(left, rightChar);
			sb.setCharAt(right, leftChar);
			left++;
			right--;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCount = Integer.parseInt(br.readLine());
		while(testCount > 0) {
			System.out.println(reverseWords(br.readLine()));
			testCount--;
		}
		bw.flush();
	}
}
