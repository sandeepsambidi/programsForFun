package com.sandy.codeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChefJudgesCompetetion {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCaseCount = Integer.parseInt(br.readLine());
		while (testCaseCount > 0) {
			int raceCount = Integer.parseInt(br.readLine());
			int a[] = new int[raceCount];
			int b[] = new int[raceCount];
			
			int index = 0;
			StringTokenizer aSt = new StringTokenizer(br.readLine());
			StringTokenizer bSt = new StringTokenizer(br.readLine());

			int aMax = Integer.MIN_VALUE;
			int bMax = Integer.MIN_VALUE;
			int aSum = 0;
			int bSum = 0;
			
			while (index < raceCount) {
				a[index] = Integer.parseInt(aSt.nextToken());
				b[index] = Integer.parseInt(bSt.nextToken());
				
				aSum = aSum + a[index];
				bSum = bSum + b[index];
				
				if (a[index] > aMax) {
					aMax = a[index];
				}
				
				if (b[index] > bMax) {
					bMax = b[index];
				}
				index++;
			}
			
			aSum = aSum - aMax;
			bSum = bSum - bMax;
			
			if(aSum < bSum) {
				System.out.println("Alice");
			} else if (bSum < aSum) {
				System.out.println("Bob");
			} else {
				System.out.println("Draw");
			}
			
			testCaseCount --;
		}
	}

}
