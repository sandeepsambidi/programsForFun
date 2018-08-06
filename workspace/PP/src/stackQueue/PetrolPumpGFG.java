package stackQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PetrolPumpGFG {
	
	static int findStart(int dragons[], int[] food)
    {  
        int start = 0;
        int end = 1;
        int curr_petrol = food[start] - dragons[start];
         
        // If current amount of petrol in truck becomes less than 0, then
        // remove the starting petrol pump from tour
        while(end != start || curr_petrol < 0)
        {
             
            // If current amount of petrol in truck becomes less than 0, then
            // remove the starting petrol pump from tour
            while(curr_petrol < 0 && start != end)
            {
                // Remove starting petrol pump. Change start
                curr_petrol -= food[start] - dragons[start];
                start = (start + 1) % dragons.length;
                 
                // If 0 is being considered as start again, then there is no
                // possible solution
                if(start == 0)
                    return -1;
            }
            // Add a petrol pump to current tour
            curr_petrol += food[end] - dragons[end];
             
            end = (end + 1)%dragons.length;
        }
         
        // Return starting point
        return start+1;
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
