package com.sandy.codeChef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Workers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			int raceCount = Integer.parseInt(br.readLine().trim());
			int coins[] = new int[raceCount];
			int type[] = new int[raceCount];
			
			int index = 0;
			StringTokenizer coinsSt = new StringTokenizer(br.readLine());
			StringTokenizer typeSt = new StringTokenizer(br.readLine());
			
			int minTrans = 100001;
			int minAuth = 100001;
			int minAT = 100001;
			
			while (index < raceCount) {
				coins[index] = Integer.parseInt(coinsSt.nextToken());
				type[index] = Integer.parseInt(typeSt.nextToken());
				
				switch (type[index]) {
				case 1:
					if (coins[index] < minTrans) {
						minTrans = coins[index];
					}
					break;
				case 2:
					if (coins[index] < minAuth) {
						minAuth = coins[index];
					}
					break;
				case 3:
					if (coins[index] < minAT) {
						minAT = coins[index];
					}
					break;
				default:
					break;
				}
				index++;
			}


			if(minAT < (minTrans+minAuth)) {
				System.out.println((minAT));
			} else {
				System.out.println((minTrans+minAuth));
			}
			
	}

}
