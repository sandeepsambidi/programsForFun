import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SumCalculation {

	static void findSumBrut(int arr[]) {
		long res = 0;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				res = res + arr[j]/arr[i];
			}
		}
		System.out.println(res%1000003);
	}
	
	static void findSum(int arr[]) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		double result = 0;
		for (int i = 0; i < arr.length; i++) {
			result = result + Math.floorDiv(sum,arr[i]);
		}
		System.out.println((int)result);
	}
	
	static void calculate(int[] arr) {
		int mul = 1;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			mul = mul * arr[i];
		}
		
		for (int x = 0; x < arr.length; x++) {
			int k = Math.floorDiv(arr[x], mul);
			sum = sum + k;
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		while(testCaseCount>0) {
			int arrCount = Integer.parseInt(br.readLine());
			int arr[] = new int[arrCount];
			int index = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(arrCount > 0) {
				arr[index++] = Integer.parseInt(st.nextToken());
				arrCount--;
			}
		
			findSumBrut(arr);
			//calculate(arr);
			testCaseCount--;
		}
	}

}
