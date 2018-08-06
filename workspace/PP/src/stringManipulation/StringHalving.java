//Top coder contest problem: 
package stringManipulation;

import java.util.HashMap;
import java.util.TreeMap;

public class StringHalving {
	
	public String lexsmallest(String s) {
		int count = 0;
		String result = null;
		int halfSize = s.length()/2;
		TreeMap<Character, Integer> freq = new TreeMap<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			if(!freq.containsKey(s.charAt(i))) {
				freq.put(s.charAt(i),0);
				count++;
				if(count == halfSize) {
					result = String.valueOf(freq.firstKey());
					break;
				}
			}  else {
				result = String.valueOf(freq.firstKey());
				break;
			}
			
		}
		return result;
	}

	public static void main(String[] args) {
		StringHalving stringHalving = new StringHalving();
		System.out.println(stringHalving.lexsmallest("baba"));

	}

}
