import java.util.HashMap;
import java.util.TreeMap;

public class VowelEndingWithConsonent {

	void findStrings(String str) {
		TreeMap<String, String> map = new TreeMap<>();
		HashMap<Character, Integer> vow = new HashMap<>();
		vow.put('a', 1);
		vow.put('e', 1);
		vow.put('i', 1);
		vow.put('o', 1);
		vow.put('u', 1);

		for(int i = 0; i< str.length(); i++) {
			for(int j = i; j< str.length(); i++) {
				String currStr = str.substring(i, j+1);
				System.out.println(currStr);
				if(vow.containsKey(currStr.charAt(0))) {
					if(!vow.containsKey(currStr.charAt(currStr.length()-1))) {
						map.put(currStr, "");
					}
				}
			}
		}
		System.out.println("map = "+  map.toString());
		System.out.println(map.firstKey());
		System.out.println(map.lastKey());
	}
	public static void main(String[] args) {
		VowelEndingWithConsonent obj = new VowelEndingWithConsonent();
		obj.findStrings("bac");
	}

}
