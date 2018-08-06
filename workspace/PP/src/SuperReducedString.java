import java.util.Scanner;

public class SuperReducedString {
	
	static String super_reduced_string(String s){
        // Complete this function
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(s.charAt(0));
		for(int position = 1; position < s.length(); position++) {
			if(stringBuilder.length() == 0) {
				stringBuilder.append(s.charAt(position));
			}
			else if(s.charAt(position) == stringBuilder.charAt(stringBuilder.length()-1)) {
				stringBuilder.deleteCharAt(stringBuilder.length()-1);
			} else {
				stringBuilder.append(s.charAt(position));
			}
		}
		
		return stringBuilder.length() == 0 ? "Empty String":stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}
