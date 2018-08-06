package heaps;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CostToConnectRods {
	
	static int findMinCostToConnect(int[] rods) {
		if(rods.length == 1) {
			return 0;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(Integer cur: rods) {
			pq.add(cur);
		}
		
		int result = 0;
		
		while(!pq.isEmpty()) {
			int first = pq.remove();
			int second = pq.remove();
			result = result + (first+second);
			
			if(pq.isEmpty()) {
				break;
			} else {
				pq.add(first+second);
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			int rodsCount = Integer.parseInt(br.readLine());
			int[] arr = new int[rodsCount];
			int index = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(index < rodsCount) {
				arr[index++] = Integer.parseInt(st.nextToken());
			}
			System.out.println(findMinCostToConnect(arr));
			tc--;
		}
	}

}
