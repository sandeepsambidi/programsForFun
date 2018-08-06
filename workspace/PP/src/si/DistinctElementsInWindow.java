//https://www.hackerrank.com/contests/smart-interviews/challenges/si-distinct-elements-in-window

package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class DistinctElementsInWindow {

	static String distinctElementsInWindow(int arr[], int windowSize) {
		HashMap<Integer, Integer> frequencyInCurrentWindow = new HashMap<>();
		int disctinctCountInCurrentWindow = 0;
		StringBuilder resultBuilder = new StringBuilder();
		int i = 0;
		while (i < windowSize) {
			if (!frequencyInCurrentWindow.containsKey(arr[i])) {
				frequencyInCurrentWindow.put(arr[i], 1);
				disctinctCountInCurrentWindow++;
			} else {
				frequencyInCurrentWindow.put(arr[i], frequencyInCurrentWindow.get(arr[i]) + 1);
			}
			i++;
		}
		resultBuilder.append(disctinctCountInCurrentWindow);
		
		while(i < arr.length) {
			if(frequencyInCurrentWindow.get(arr[i-windowSize]) == 1) {
				frequencyInCurrentWindow.remove(arr[i-windowSize]);
				disctinctCountInCurrentWindow--;
			} else {
				frequencyInCurrentWindow.put(arr[i-windowSize], frequencyInCurrentWindow.get(arr[i-windowSize])-1);
			}
			
			if (!frequencyInCurrentWindow.containsKey(arr[i])) {
				frequencyInCurrentWindow.put(arr[i], 1);
				disctinctCountInCurrentWindow++;
			} else {
				frequencyInCurrentWindow.put(arr[i], frequencyInCurrentWindow.get(arr[i])+1);
			}
			resultBuilder.append(" ");
			resultBuilder.append(disctinctCountInCurrentWindow);
			i++;
		}
		
		return resultBuilder.toString();
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		while (testCaseCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arraySize = Integer.parseInt(st.nextToken());
			int windowSize = Integer.parseInt(st.nextToken());
			int arr[] = new int[arraySize];
			st = new StringTokenizer(br.readLine());
			int index = 0;
			while (st.hasMoreElements()) {
				arr[index] = Integer.parseInt(st.nextToken());
				index++;
			}
			String result = distinctElementsInWindow(arr,windowSize);
			output.write(result+"\n");
			testCaseCount--;
		}
		output.flush();
	}

}
