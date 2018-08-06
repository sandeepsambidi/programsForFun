package si;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinaryStringsOfLenNDP {

	static int[] count(int n) {
		long prev0 = 1;
		long prev1 = 1;
		int prime = 1000000007;
		int[] arr = new int[n+1];
		arr[0] = 0;
		arr[1] = 2;
		
		for (int i = 2; i<=n; i++) {
			long curr0 = (prev0 + prev1)%prime;
			long curr1 = prev0;
			
			prev0 = curr0;
			prev1 = curr1;
			
			arr[i] = (int)(prev0 + prev1)%prime;
		}
		
		return arr;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcCount = Integer.parseInt(br.readLine());
		int arr[] = count(100000);
		while (tcCount > 0) {
			System.out.println(arr[(Integer.parseInt(br.readLine()))]);
			tcCount--;
		}
	}

}
