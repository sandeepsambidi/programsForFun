package si;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class WindowMaximum {
	
	static int findWinMaxSum(int[] arr, int winSize) {
		int sum = 0;
		int index = 0;
		Deque<Integer> deque = new LinkedList<>();
		while(index < winSize) {
			if(deque.isEmpty()) {
				deque.add(index);
				index++;
			} else if(arr[index] >= arr[deque.peekLast()]){
				deque.removeLast();
			} else {
				deque.add(index);
				index++;
			}
		}
		sum = sum + arr[deque.peekFirst()];
		
		while(index < arr.length) {
			if (!deque.isEmpty() && (index - deque.peekFirst())==winSize) {
				deque.removeFirst();
			}
			
			if(deque.isEmpty()) {
				deque.add(index++);
			} else {
				while(!deque.isEmpty() && arr[index] >= arr[deque.peekLast()]) {
					deque.removeLast();
				}
				deque.add(index++);
			}
			sum = sum + arr[deque.peekFirst()];
		}
		return sum;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc > 0) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int arraySize = Integer.parseInt(st1.nextToken());
			int winSize = Integer.parseInt(st1.nextToken());
			int index = 0;
			int[] arr = new int[arraySize];
			StringTokenizer st = new StringTokenizer(br.readLine());

			while(index < arraySize) {
				arr[index] = Integer.parseInt(st.nextToken());
				index++;
			}
			int start = findWinMaxSum(arr,winSize);
			System.out.println(start);
			tc--;
		}
	}
}
