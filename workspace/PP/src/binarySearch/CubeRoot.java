package binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CubeRoot {
	
	static long cubeRoot(long num) {
		long lo = 0;
		long hi = 0;
		long absNum = Math.abs(num);
		hi = absNum;
		if(hi > 1000000) {
			hi = 1000000;
		}
		
		while (lo < hi) {
			long mid = lo + ((hi - lo)/2);
			long valueToCompare = mid*mid*mid;
			if(valueToCompare == absNum) {
				return num<0?mid*-1:mid;
			} else if (valueToCompare > absNum) {
				hi = mid-1;
			} else {
				lo = mid+1;
			}
		}
		
		return num<0?lo*-1:lo;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		//System.out.println("test case count = "+testCaseCount);
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		while (testCaseCount > 0) {
			long result = cubeRoot(Long.parseLong(br.readLine()));
			output.write(result + "\n");
			testCaseCount--;
		}
		output.flush();
	}
}
