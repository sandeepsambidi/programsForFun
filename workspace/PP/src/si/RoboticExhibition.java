package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RoboticExhibition {
	
	static int findMissingElement(int[] arr) {
		int missingNumber =1;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > missingNumber) {
				return missingNumber;
			} else {
				missingNumber = missingNumber + arr[i];
			}
		}
		return missingNumber;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCount = Integer.parseInt(br.readLine());
		while (testCaseCount > 0) {
			int arraySize = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[arraySize];
			int index = 0;
			while (st.hasMoreElements()) {
				arr[index] = Integer.parseInt(st.nextToken());
				index++;
			}
			//System.out.println(Arrays.toString(arr));
			int result = findMissingElement(arr);
			output.write(result + "\n");
			testCaseCount--;
		}
		output.flush();
	}

}
