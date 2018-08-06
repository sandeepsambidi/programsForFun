package stackQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KillingDragons {

	static int findStart(int[] dragon, int[] food) {
		Queue<Integer> queue = new LinkedList<>();
		int start = 0;
		int index = 0;
		int sum = 0;
		
		int length = dragon.length;
		
		while(queue.size()!= length ) {
			int currReq = food[index]-dragon[index];
			if((currReq + sum) >= 0 ) {
				queue.add(index);
				sum = sum+currReq;
				index = (index+1)%length;
			} else {
				while(!queue.isEmpty() && (sum+currReq)< 0) {
					int removed = queue.remove();
					sum = sum - (food[removed]-dragon[removed]);
					start = (start+1)%length;
					if(start == 0) {
						return -1;
					}
				}
				if(sum+currReq >= 0) {
					queue.add(index);
				}
				
				index = (index+1)%length;
			}
			
			
		}
	
		return queue.peek()+1;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc > 0) {
			int arraySize = Integer.parseInt(br.readLine());
			int index = 0;
			int[] dragonE = new int[arraySize];
			int[] food = new int[arraySize];
			StringTokenizer stDragon = new StringTokenizer(br.readLine());
			StringTokenizer stFood = new StringTokenizer(br.readLine());

			while(index < arraySize) {
				dragonE[index] = Integer.parseInt(stDragon.nextToken());
				food[index] = Integer.parseInt(stFood.nextToken());
				index++;
			}
			int start = findStart(dragonE, food);
			System.out.println(start);
			tc--;
		}
	}

}
