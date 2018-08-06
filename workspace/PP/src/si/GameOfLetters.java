package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class GameOfLetters {

	static String findWinner(String gameString) {
		int current = 0;
		int len = gameString.length();
		int xorValue = 0;
		HashMap<Character, Integer> charCountMap = new HashMap<>();
		while (current < len) {
			char c = gameString.charAt(current);
			if(charCountMap.containsKey(c)) {
				charCountMap.put(c, charCountMap.get(c)+1);
			} else {
				charCountMap.put(c, 1);
			}
			current++;
		}
		Collection<Integer> values = charCountMap.values();
		for (Integer integer : values) {
			xorValue = xorValue ^ integer;
		}
		if(xorValue == 0) {
			return "Banta";
		} else {
			return "Santa";
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCount = Integer.parseInt(br.readLine());
		while(testCaseCount > 0) {
			bw.write(findWinner(br.readLine()) + "\n");
			testCaseCount--;
		}
		bw.flush();
	}

}
