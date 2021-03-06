package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IsBST {
	
	boolean checkBST(int[] arr, int currIndex, int leftMax, int rightMax) {	
		
		if(currIndex >= arr.length) {
			return true;
		}
		
		if(arr[currIndex] >= leftMax && arr[currIndex]<=rightMax) {
			int leftNodeIndex = currIndex*2;
			int rightNodeIndex = leftNodeIndex+1;
			
			return checkBST(arr, leftNodeIndex, leftMax, arr[currIndex]-1) && checkBST(arr, rightNodeIndex, arr[currIndex]+1, rightMax);
			
		} else {
			return false;
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			int nodeCount = Integer.parseInt(br.readLine());
			int index = 1;
			int[] arr = new int[nodeCount+1];

			StringTokenizer st = new StringTokenizer(br.readLine());

			while(index <= nodeCount) {
				arr[index] = Integer.parseInt(st.nextToken());
				index++;
			}
			
			//System.out.println("pre = "+Arrays.toString(arr));
			
			IsBST obj = new IsBST();
			String result =obj.checkBST(arr,1, Integer.MIN_VALUE, Integer.MAX_VALUE) ? "True" : "False";
			bw.write(result + "\n");
			tc--;
		}
		bw.flush();
	}

}
