package heaps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MaxPairSum {
	
	static String findTopK(int[] arr1, int[] arr2, int req) {
		StringBuilder sb = new StringBuilder();
		
		class IndexInfo implements Comparable<IndexInfo>{
			int i;
			int j;
			int sum;
			public IndexInfo(int i, int j, int sum) {
				this.i = i;
				this.j = j;
				this.sum = sum;
			}
			@Override
			public int compareTo(IndexInfo o) {
				if(this.sum > o.sum) {
					return -1;
				} else if (this.sum == o.sum) {
					return 0;
				}
				return 1;
			}
		}
		
		PriorityQueue<IndexInfo> heap = new PriorityQueue<>();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		int count = 0;
		int index = arr1.length-1;
		
		heap.add(new IndexInfo(index, index, arr1[index]+arr2[index]));
		
		while(count < req) {
			IndexInfo topInfo = heap.remove();
			int i = topInfo.i;
			int j = topInfo.j;
			sb.append(arr1[i]+arr2[j] + " ");
			
			if(j > 0) {
				heap.add(new IndexInfo(i, j-1, arr1[i]+arr2[j-1]));
				}
			if(j == index && i > 0) {
				heap.add(new IndexInfo(i-1, j, arr1[i-1]+arr2[j]));
			}
			count++;
		}
	
		return sb.toString();
		
	}
	
	//O(heap) space. time N^2 * O(log Heap)
//	static String findTopK(int[] arr1, int[] arr2, int req) {
//		PriorityQueue<Integer> heap = new PriorityQueue<>(req);
//		
//		for(int i = 0; i< arr1.length; i++) {
//			for(int j = 0; j < arr2.length; j++) {
//				int sum = arr1[i]+arr2[j];
//				if(heap.isEmpty() || heap.size() < req) {
//					heap.add(sum);
//				} else {
//					if(heap.peek() < sum){
//							heap.remove();
//							heap.add(sum);
//						}
//					
//				}
//			}
//		}
//		
//		Object[] arr = heap.toArray();
//		Arrays.sort(arr, Collections.reverseOrder());
//		String s = Arrays.toString(arr).replaceAll(",", "").substring(1);
//		s = s.substring(0,s.length()-1);
//		return s;
//		
//	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			int arrSize = Integer.parseInt(s.nextToken());
			int req = Integer.parseInt(s.nextToken());
			int[] arr1 = new int[arrSize];
			int[] arr2 = new int[arrSize];

			int index = 0;
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			while(index < arrSize) {
				arr1[index] = Integer.parseInt(st1.nextToken());
				arr2[index] = Integer.parseInt(st2.nextToken());
				index++;
			}
			
			int brutResult[] = new int[index*index];
			int res = 0;
			for(int i = 0; i< arr1.length; i++) {
				for(int j = 0; j < arr2.length; j++) {
					int sum = arr1[i]+arr2[j];
					brutResult[res] = sum;
					res++;
				}
			}
			Arrays.sort(brutResult);
			System.out.println(Arrays.toString(brutResult));
			bw.write(findTopK(arr1, arr2, req));
			bw.newLine();
			tc--;
		}
		bw.flush();
	}

}
