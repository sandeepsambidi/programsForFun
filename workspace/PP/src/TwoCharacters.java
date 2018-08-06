import java.util.HashMap;
import java.util.Scanner;

public class TwoCharacters {

	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	     //int len = in.nextInt();
	     String s = in.next();
	     HashMap<Character, Integer> map = new HashMap<>(); 
	     int charCount = 0;
	     for (Character c : s.toCharArray()) {
			if(map.containsKey(c)) {
				//skip
			} else {
				map.put(c, charCount);
				charCount++;
			}
		}
	     System.out.println("map = "+map.toString());
	     System.out.println("char count = "+charCount);
	     char arr[][] = new char[charCount][charCount];
	     int count[][] = new int[charCount][charCount];
	     for(Character c : s.toCharArray()) {
	    	 int indexOfChar = map.get(c);
	    	 for(int i=0; i<charCount; i++) {
	    		 if(indexOfChar!= i) {
	    			 if(count[indexOfChar][i] != -1 && arr[indexOfChar][i] != c) {
	    				 arr[indexOfChar][i] = c;
	    				 count[indexOfChar][i] = count[indexOfChar][i] +1;
	    			 } else {
	    				 count[indexOfChar][i] = -1;
	    			 }
	    		 }
	    	 }
	    	 for(int i=0; i<charCount; i++) {
	    		 if(indexOfChar!= i) {
	    			 if(count[i][indexOfChar] != -1 && arr[i][indexOfChar] != c) {
	    				 arr[i][indexOfChar] = c;
	    				 count[i][indexOfChar] = count[i][indexOfChar] +1;
	    			 } else {
	    				 count[i][indexOfChar] = -1;
	    			 }
	    		 }
	    	 }
	     }
	     int maxPairs = 0;
	     for (int i=0; i<charCount; i++) {
	    	 for (int j=0; j<charCount; j++) {
	    		 if(count[i][j] > maxPairs) {
	    			 maxPairs = count[i][j];
	    		 }
	    	 } 
	     }
	     System.out.println(maxPairs);
	}

}
