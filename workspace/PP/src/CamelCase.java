import java.util.Scanner;

public class CamelCase {
	public static void main(String[] args) {
		String numAsString = Integer.toString(123);
		int rightIndex = numAsString.length();
		int leftIndex = 1;
		while(leftIndex < rightIndex) {
			String subString = numAsString.substring(leftIndex, rightIndex);
			System.out.println("sub = "+subString);
			leftIndex++;
		}
		System.out.println("my sub = "+"sandy".substring(3, 5));
    }
}
