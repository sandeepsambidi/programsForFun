package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CabinetPartition {
	
	static int findTimeToCompleteAllTasks(int[] timePerTask, int availableWorkers) {
		int minTime = findMax(timePerTask); //If one worker is alloted per task, min time will be time for the longest task
		int maxTime = sumOfAllTasksTime(timePerTask); // In one worker is alloted all the tasks, min time taken will be sum of all the task times
		int midTime = minTime + ((maxTime-minTime)/2);
		
		while(minTime < maxTime) {
			midTime = minTime + ((maxTime-minTime)/2);
			int workersCount = 1; // workers count with max time for each worker being midTime
			int workLoadForCurrentWorker = 0;
			for(int currentTask = 0; currentTask < timePerTask.length; currentTask++) {
				int workLoadForEvaluationForCurrentWorker = workLoadForCurrentWorker + timePerTask[currentTask];
				if (workLoadForEvaluationForCurrentWorker > midTime ) {
					workersCount++; //add a new worker
					workLoadForCurrentWorker = timePerTask[currentTask]; // reset work load for the new worker to the time taken for current task 
				} else {
					workLoadForCurrentWorker = workLoadForEvaluationForCurrentWorker;
				}		
			}
			
			if (workersCount <= availableWorkers) {
				maxTime = midTime; // Less workers are being used. That means more work is being given to each worker. Reduce
			} else {
				minTime = midTime + 1;
			}
		}
		return minTime;
	}
	
	private static int findMax(int[] timePerTask) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<timePerTask.length; i++) {
			if(timePerTask[i] > max ) {
				max = timePerTask[i];
			}
		}
		return max;
	}
	
	private static int sumOfAllTasksTime(int[] timePerTask) {
		int sum = 0;
		for(int i=0; i<timePerTask.length; i++) {
			sum = sum + timePerTask[i];
		}
		return sum;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		System.out.println("test case count = "+testCaseCount);
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		while (testCaseCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tasksCount = Integer.parseInt(st.nextToken());
			int availableWorkerCount = Integer.parseInt(st.nextToken());
			int timeForTask[] = new int[tasksCount];
			st = new StringTokenizer(br.readLine());
			int taskNum = 0;
			while (st.hasMoreElements()) {
				timeForTask[taskNum] = Integer.parseInt(st.nextToken());
				taskNum++;
			}
			System.out.println("available worker count = "+availableWorkerCount);
			System.out.println("tasks time = "+Arrays.toString(timeForTask));
			int result = findTimeToCompleteAllTasks(timeForTask, availableWorkerCount);
			output.write(result+"\n");
			testCaseCount--;
		}
		output.flush();
		
	}
}
