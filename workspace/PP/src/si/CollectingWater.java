package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CollectingWater {
	
	static int calculateWaterCollected(int[] buildlingsHeightArray) {
		int[] heighestBuildingOnLeft = findHeighestBuildingtoLeft(buildlingsHeightArray);
		//Calculate water above each building now
		int waterAccumulated = 0;
		int currentIndex = buildlingsHeightArray.length-1;
		int maxUntilNowOnRight = Integer.MIN_VALUE;
		while(currentIndex >= 0) {
			if(buildlingsHeightArray[currentIndex] > maxUntilNowOnRight) {
				maxUntilNowOnRight = buildlingsHeightArray[currentIndex];
			}
			int maxUntilNowOnLeft = heighestBuildingOnLeft[currentIndex];
			int possibleAccumulation = maxUntilNowOnRight >= maxUntilNowOnLeft ?  
					maxUntilNowOnLeft:maxUntilNowOnRight; 
			if(buildlingsHeightArray[currentIndex] < possibleAccumulation) {
				waterAccumulated = waterAccumulated + 
						(possibleAccumulation - buildlingsHeightArray[currentIndex]);
			}
			currentIndex--;
		}
		return waterAccumulated;
	}
	
	private static int[] findHeighestBuildingtoLeft(int[] buildlingsHeightArray) {
		int[] heighestBuildingOnLeft = new int[buildlingsHeightArray.length];
		int currentIndex = 0;
		int maxUntilNow = Integer.MIN_VALUE;
		while(currentIndex < buildlingsHeightArray.length) {
			if(buildlingsHeightArray[currentIndex] > maxUntilNow) {
				maxUntilNow = buildlingsHeightArray[currentIndex];
			}
			heighestBuildingOnLeft[currentIndex]  = maxUntilNow;
			currentIndex++;
		}
		return heighestBuildingOnLeft;
	}
	
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int testCaseCount = Integer.parseInt(br.readLine());
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
			while(testCaseCount>0) {
				int buildingsCount = Integer.parseInt(br.readLine());
				int buildlingsHeightArray[] = new int[buildingsCount];
				int buildingIndex = 0;
				StringTokenizer st = new StringTokenizer(br.readLine());
				while(buildingsCount > 0) {
					buildlingsHeightArray[buildingIndex++] = Integer.parseInt(st.nextToken());
					buildingsCount--;
				}
				//System.out.println(Arrays.toString(buildlingsHeightArray));
				//System.out.println(CollectingWater.calculateWaterCollected(buildlingsHeightArray));
				int result = CollectingWater.calculateWaterCollected(buildlingsHeightArray);
				output.write(Integer.toString(result)+"\n");
				testCaseCount--;
			}
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
