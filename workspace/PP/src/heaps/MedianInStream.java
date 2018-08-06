package heaps;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MedianInStream {
	
	static String findMedian(int[] arr) {
		
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();

		for(int i=0; i< arr.length; i++) {
			if(left.isEmpty()) {
				left.add(arr[i]);
				sb.append(arr[i] + " ");
			} else {
				if(arr[i] <= left.peek()) {
					if(right.size() < left.size()) {
						right.add(left.remove());
						left.add(arr[i]);
					} else if(right.size() == left.size()){
						left.add(arr[i]);
					} else {
						left.add(arr[i]);
					}
					
				} else if(right.isEmpty()) {
					right.add(arr[i]);
				} else if(arr[i] >= right.peek()) {
					if(left.size() < right.size()) {
						left.add(right.remove());
						right.add(arr[i]);
					} else if(left.size() == right.size()) {
						right.add(arr[i]);
					} else {
						right.add(arr[i]);
					}
					
				} else {
					if(left.size() == right.size()) {
						left.add(arr[i]);
					} else if(left.size() > right.size()) {
						right.add(arr[i]);
					} else {
						left.add(arr[i]);
					}
				}
					
				if(left.size() == right.size()) {
					sb.append(Math.min(left.peek(), right.peek()) +" ");
					//sb.append((left.peek()+right.peek())/2+ " ");
				} else if(left.size() > right.size()) {
					sb.append(left.peek() +" ");
				} else {
					sb.append(right.peek() +" ");
				}
			}
		}
		
		return sb.toString();
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			int arrCount = Integer.parseInt(br.readLine());
			int[] arr = new int[arrCount];
			int i = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> right = new PriorityQueue<>();
			while(i < arrCount) {
				arr[i] = Integer.parseInt(st.nextToken());
				
				
				if(left.isEmpty()) {
					left.add(arr[i]);
					bw.write(arr[i] + " ");
					//sb.append(arr[i] + " ");
				} else {
					if(arr[i] <= left.peek()) {
						if(right.size() < left.size()) {
							right.add(left.remove());
							left.add(arr[i]);
						} else if(right.size() == left.size()){
							left.add(arr[i]);
						} else {
							left.add(arr[i]);
						}
						
					} else if(right.isEmpty()) {
						right.add(arr[i]);
					} else if(arr[i] >= right.peek()) {
						if(left.size() < right.size()) {
							left.add(right.remove());
							right.add(arr[i]);
						} else if(left.size() == right.size()) {
							right.add(arr[i]);
						} else {
							right.add(arr[i]);
						}
						
					} else {
						if(left.size() == right.size()) {
							left.add(arr[i]);
						} else if(left.size() > right.size()) {
							right.add(arr[i]);
						} else {
							left.add(arr[i]);
						}
					}
						
					if(left.size() == right.size()) {
						//sb.append(Math.min(left.peek(), right.peek()) +" ");
						bw.write(Math.min(left.peek(), right.peek()) +" ");

					} else if(left.size() > right.size()) {
						//sb.append(left.peek() +" ");
						bw.write(left.peek() +" ");
					} else {
						//sb.append(right.peek() +" ");
						bw.write(right.peek() +" ");

					}
				}
				i++;
			}
			//System.out.println(Arrays.toString(arr));
			//System.out.println(findMedian(arr));
			bw.newLine();
			tc--;
		}
		bw.flush();
	}

}
