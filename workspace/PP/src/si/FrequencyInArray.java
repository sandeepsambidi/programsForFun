package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;


public class FrequencyInArray {
	
	private static HashMap<Integer, Integer> frequency = new HashMap<>();
	
	static int findFrequency(int target) {
		return frequency.containsKey(target)? frequency.get(target): 0;
	}

	private static void buildFrequencyMap(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if(frequency.containsKey(arr[i])) {
				frequency.put(arr[i], frequency.get(arr[i]) + 1);
			} else {
				frequency.put(arr[i], 1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arraySize = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[arraySize];
		int index = 0;
		while (st.hasMoreElements()) {
			arr[index] = Integer.parseInt(st.nextToken());
			index++;
		}
		buildFrequencyMap(arr);
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCount = Integer.parseInt(br.readLine());
		while (testCaseCount > 0) {
			int target = Integer.parseInt(br.readLine());
			int result = findFrequency(target);
			output.write(result + "\n");
			testCaseCount--;
		}
		output.flush();

	}

}
