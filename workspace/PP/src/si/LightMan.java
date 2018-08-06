package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class LightMan {
	
	static int count(int[] arr, int spellCount) {
		int result = 0;
		int count = 0;
		int currentLigtIndex = 0;
		int start = 0;
		while(currentLigtIndex < arr.length) {
			
			if(arr[currentLigtIndex] == 0) {
				if(spellCount == 0) {
					break;
				}
				//arr[currentLigtIndex] = 1;
				spellCount--;
			}
			currentLigtIndex++;
		}
		count = currentLigtIndex;
		result = count;
		if(currentLigtIndex == arr.length) {
			return arr.length;
		}
		//System.out.println("currentLigtIndex = "+currentLigtIndex);
		//System.out.println("count = "+count);

		
		while(currentLigtIndex < arr.length) {
			if(arr[currentLigtIndex]==1) {
				count++;
				if(count>result){
					result = count;
				}
			} else {
				if(arr[start] == 0) {
					start++;
				} else {
					while(start < currentLigtIndex && arr[start] != 0) {
						count--;
						start++;
					}
					start++;
				}
			}
			currentLigtIndex++;
		}
		
		return result;
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCount = Integer.parseInt(br.readLine());
		while (testCaseCount > 0) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int arraySize = Integer.parseInt(st1.nextToken());
			int spellCount = Integer.parseInt(st1.nextToken());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[arraySize];
			int index = 0;
			while (st.hasMoreElements()) {
				arr[index] = Integer.parseInt(st.nextToken());
				index++;
			}
			//System.out.println(Arrays.toString(arr));
			int result = count(arr,spellCount);
			output.write(result + "\n");
			testCaseCount--;
		}
		output.flush();

	}

}
