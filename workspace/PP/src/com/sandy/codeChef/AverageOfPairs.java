package com.sandy.codeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class AverageOfPairs {
	
	int findCount1(int[] a, HashMap<Integer, Integer> map) {
		HashMap<Integer, Integer> processed = new HashMap<>();

		int res = 0;
		for (int i = 0; i < a.length; i++) {
			int curr = a[i] * 2;
			if (processed.get(a[i]) == null) {
				processed.put(a[i], 0);
				if (map.get(a[i]) > 1) {
					res = res + ((map.get(a[i]) * (map.get(a[i]) - 1)) / 2);
				}
				int left = -1000;
				int right = 1000;
				
				while (left < right) {
					if((left+right)>curr) {
						right--;
					} else if ((left+right) < curr) {
						left++;
					} else {
						int req = curr - left;
						int leftHm = map.get(left) != null ? map.get(left) : 0;
						int rightHm = map.get(req) != null ? map.get(req) : 0;

						if (leftHm == 1 && rightHm == 1) {
							//System.out.println(left + ", "+req);
							res++;
						} else if (leftHm > 1 && rightHm > 1) {
							//System.out.println(left + ", "+req);
							res = res + (leftHm * rightHm);
						} else if (leftHm > 1 && rightHm == 1) {
							//System.out.println(left + ", "+req);
							res = res + leftHm;
						} else if (leftHm == 1 && rightHm > 1) {
							//System.out.println(left + ", "+req);
							res = res + rightHm;
						}
						right--;
						left++;
					}
					
				}
			}

		}
		return res;
	}
	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		int testCaseCount = Integer.parseInt(br.readLine());
//		while (testCaseCount > 0) {
//			int raceCount = Integer.parseInt(br.readLine());
//			int a[] = new int[raceCount];
//			
//			int index = 0;
//			StringTokenizer aSt = new StringTokenizer(br.readLine());
//			
//			while (index < raceCount) {
//				a[index] = Integer.parseInt(aSt.nextToken());
//				index++;
//			}
//			AverageOfPairs averageOfPairs = new AverageOfPairs();
//			System.out.println(averageOfPairs.findCount1(a));
//			testCaseCount --;
//		}
//	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCaseCount = Integer.parseInt(br.readLine());
		while (testCaseCount > 0) {
			int raceCount = Integer.parseInt(br.readLine());
			int a[] = new int[raceCount];
			
			int index = 0;
			StringTokenizer aSt = new StringTokenizer(br.readLine());
			int res = 0;
			HashMap<Integer, Integer> map = new HashMap<>();
			while (index < raceCount) {
				a[index] = Integer.parseInt(aSt.nextToken());
				if (map.containsKey(a[index])) {
					map.put(a[index], map.get(a[index]) + 1);
				} else {
					map.put(a[index], 1);
				}
				index++;
			}
//			
//			for (int i = 0; i < (a.length-1); i++) {
//				for (int j = i+1; j < a.length; j++) {
//					int c = (a[i]+a[j]);
//					if(map.containsKey(c)) {
//						System.out.println(a[i] + ", "+a[j]);
//						res++;
//					}
//				}
//			}
//			System.out.println("result brut = "+res);
			AverageOfPairs averageOfPairs = new AverageOfPairs();
			System.out.println(averageOfPairs.findCount1(a, map));
			testCaseCount --;
		}
	}


}
