package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CountBSTs {
	
	int count = 0;
	
	class MinMax {
		int min;
		int max;
	}
	
	boolean countBST(int[] arr, int currIndex, MinMax range) {	
		
		if(currIndex >= arr.length) {
			range.min = Integer.MAX_VALUE;
			range.max = Integer.MIN_VALUE;
			return true;
		}
		
		int leftNodeIndex = currIndex*2;
		int rightNodeIndex = leftNodeIndex+1;
		
		if(leftNodeIndex >= arr.length && rightNodeIndex >= arr.length) {
			range.max = arr[currIndex];
			range.min = arr[currIndex];
			count++;
			return true;
		}
		
		MinMax rl = new MinMax();
		MinMax rr = new MinMax();
		boolean isLeftBST = countBST(arr, leftNodeIndex, rl);
		boolean isRightBST = countBST(arr, rightNodeIndex, rr);
		
		int rMin = Math.min(Math.min(rl.min, rr.min), arr[currIndex]);
		int rMax = Math.max(Math.max(rl.max, rr.max), arr[currIndex]);
		if(isLeftBST && isRightBST) {
			if(leftNodeIndex >= arr.length && rightNodeIndex < arr.length ) { // left child null
				range.min = Math.min(arr[currIndex],rr.min);
				range.max = Math.max(arr[currIndex], rr.max);	
				
			} else if(leftNodeIndex < arr.length && rightNodeIndex >= arr.length ) { // right child null
				range.min = Math.min(arr[currIndex],rl.min);
				range.max = Math.max(arr[currIndex], rl.max);
			} else { //both left and right childs available
				range.max = rMax;
				range.min = rMin;
			}
			if(arr[currIndex] > rl.max && arr[currIndex]<rr.min){	
				count++;
				return true;
			}  
		}
		
		return false;
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
			
			CountBSTs obj = new CountBSTs();
			obj.countBST(arr,1, obj.new MinMax());
			bw.write(obj.count + "\n");
			obj.count = 0;
			tc--;
		}
		bw.flush();
	}
}
