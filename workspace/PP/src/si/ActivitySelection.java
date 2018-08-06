package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class ActivitySelection {
	
	class Schedule implements Comparable<Schedule>{
		
		int start;
		int end;
		
		public Schedule(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Schedule that) {
			if (this.end > that.end) {
				return 1;
			} else if (this.end < that.end) {
				return -1;
			} else if (this.end == that.end) {
				if (this.start > that.start) {
					return 1;
				} else if (this.start < that.start) {
					return -1;
				}
			}
			return 0;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return  start + ", " + end;
		}
	}
	
	int findMaxOverlaps(Schedule timings[]) {
		Arrays.sort(timings);
		System.out.println(Arrays.toString(timings));
		int nonOverlaps = 1;
		int minEndSoFar = 0;
		for (int i = 1; i < timings.length; i++) {
			if (minEndSoFar < i && timings[i].start >= timings[minEndSoFar].end) {
				nonOverlaps++;
				minEndSoFar = i;
			} 
		}
		
		return nonOverlaps;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int tcCount = Integer.parseInt(br.readLine());

		while (tcCount > 0) {
			int arrCount = Integer.parseInt(br.readLine());
			int[] start = new int[arrCount];
			int[] end = new int[arrCount];
			Schedule timings[] = new Schedule[arrCount];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			ActivitySelection activitySelection = new ActivitySelection();
			int index = 0;
			
			while (st1.hasMoreElements()) {
				start[index] = Integer.parseInt(st1.nextToken());
				end[index] = Integer.parseInt(st2.nextToken());
				timings[index] = activitySelection.new Schedule(start[index], end[index]);
				index++;
			}
			
			System.out.println(activitySelection.findMaxOverlaps(timings));
			tcCount--;
		}
		
		
		output.flush();
	}

}
