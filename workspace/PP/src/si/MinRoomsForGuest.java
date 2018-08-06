package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinRoomsForGuest {
	
	static int findMidRooms(int[] arrivalTimes, int[] departureTimes, int guestSize) {
		
		Arrays.sort(arrivalTimes);
		Arrays.sort(departureTimes);
		int roomsNeeded = 1;
		int result = 1;
		int arrivalIndex = 1;
		int departureIndex = 0;
		
		while(arrivalIndex < arrivalTimes.length && departureIndex < departureTimes.length) {
			if(departureTimes[departureIndex] >= arrivalTimes[arrivalIndex]) {
				roomsNeeded++;
				arrivalIndex++;
				if(roomsNeeded > result) {
					result = roomsNeeded;
				}
			} else {
				roomsNeeded--;
				departureIndex++;
			}
		}
		return result;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCount = Integer.parseInt(br.readLine());
		while(testCount > 0) {
			//System.out.println("test c = "+testCount);
			int guestCount = Integer.parseInt(br.readLine());
			int[] arrivalTime = new int[guestCount];
			int[] departureTime = new int[guestCount];

			int i = 0;
			while(i < guestCount) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int at = Integer.parseInt(st.nextToken());
				int dt = Integer.parseInt(st.nextToken());
				arrivalTime[i] = at;
				departureTime[i] = dt;
				i++;
			}
			int result = findMidRooms(arrivalTime, departureTime, guestCount);
			bw.write(result+"\n");
			testCount--;
		}
		bw.flush();

	}

}
