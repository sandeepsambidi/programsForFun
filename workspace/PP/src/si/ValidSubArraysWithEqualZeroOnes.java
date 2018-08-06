package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ValidSubArraysWithEqualZeroOnes {
	
	static int countSubArraysWithEqualZerosAndOnes(int[] arr) {
		HashMap<Integer, Integer> frequency = new HashMap<>();
		frequency.put(0, 0);
		int sum = 0;
		if(arr[0] == 0) {
			arr[0] = -1;
			frequency.put(arr[0], 0);
		} else {
			frequency.put(arr[0], 0);
		}
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] == 0) {
					arr[i] = arr[i-1] + (-1);
			} else {
				arr[i] = arr[i-1] + 1;
			}
			
			if(frequency.containsKey(arr[i])) {
				frequency.put(arr[i], frequency.get(arr[i])+1);
			} else {
				frequency.put(arr[i], 0);
			}
		}
		Collection<Integer> valuesSet = frequency.values();
		for (Integer count : valuesSet) {
			int currentSum = ((count * (count+1))/2);
			sum = sum + currentSum;
		}
		return sum;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		while(testCaseCount > 0) {
			int arrSize = Integer.parseInt(br.readLine());
			int[] arr = new int[arrSize];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = 0;
			while(st.hasMoreTokens()) {
				arr[index] = Integer.parseInt(st.nextToken());
				index++;
			}
			int result = countSubArraysWithEqualZerosAndOnes(arr);
			output.write(result + "\n");
			testCaseCount--;
		}
		output.flush();
	}
	
}
