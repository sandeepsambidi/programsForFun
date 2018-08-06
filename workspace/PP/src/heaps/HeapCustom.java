package heaps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HeapCustom {
	
	int[] arr;
	int end = 0;
	
	public HeapCustom(int nodeCount) {
		arr = new int[nodeCount+1];
	}
	
	void insert(int data) {
		end = end+1;
		arr[end] = data;
		int n = end;
		
		while(n > 1) {
			int k = n/2;
			if(arr[k] > arr[n]) {
				int temp = arr[k];
				arr[k] = arr[n];
				arr[n] = temp;
			} else {
				break;
			}
			n = k;
		}
	}
	
	void deleteMin() {
		if(end == 0) {
			return;
		}
		arr[1] = arr[end--];
		
		int k = 1;
		
		while(2*k <= end) {
			int left = 2*k; 
			int right = left + 1;
			
			if(right > end) {
				if(arr[k] > arr[left]) {
					int temp = arr[k];
					arr[k] = arr[left];
					arr[left] = temp;
					k = left;
					} else {
						break;
					}
			} else {
				if(arr[left] > arr[right]) {
					if(arr[k] > arr[right]) {
						int temp = arr[k];
						arr[k] = arr[right];
						arr[right] = temp;
						k = right;
					} else {
						break;
					}
				}	
				else {
					if(arr[k] > arr[left]) {
						int temp = arr[k];
						arr[k] = arr[left];
						arr[left] = temp;
						k = left;
					} else {
						break;
					}
				}
			}
		}				
		}
	
	int getMin() {
		if(end == 0) {
			return Integer.MIN_VALUE;
		}
		return arr[1];
	}
	
	boolean isFull() {
		if(end >= arr.length-1) {
			return true;
		}
		return false;
	}
	
	int size() {
		return end;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		HeapCustom heap = new HeapCustom(tc);
		while(tc>0) {
			String op = br.readLine();
			if(op.startsWith("insert")) {
				heap.insert(Integer.parseInt(op.split(" ")[1]));
			} else if(op.startsWith("getMin")) {
				int result = heap.getMin();
				if(result==Integer.MIN_VALUE) {
					System.out.println("Empty");
				} else {
					System.out.println(result);
				}
				
			} else {
				heap.deleteMin();
			}
			tc--;
		}

	}

}
