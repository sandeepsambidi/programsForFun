package si;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OverlappingRectangles {
	
	static long getOverLapArea(long xbl1, long ybl1, long xtr1, long ytr1, long xbl2, long ybl2, long xtr2, long ytr2) {
		if(xbl2 >= xtr1 || xbl1 >= xtr2 || ybl1 >= ytr2 || ybl2 >= ytr1) {
			return 0;
		}
		
		long xbl = Math.max(xbl1, xbl2);
		long ybl = Math.max(ybl1, ybl2);
		long xtr = Math.min(xtr1, xtr2);
		long ytr = Math.min(ytr1, ytr2);
		
		return (xtr-xbl)*(ytr-ybl);
		
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long xbl1 = Long.parseLong(st.nextToken()); //a1
			long ybl1 = Long.parseLong(st.nextToken()); //b1
			long xtr1 = Long.parseLong(st.nextToken()); //p1
			long ytr1 = Long.parseLong(st.nextToken()); //q1
			st = new StringTokenizer(br.readLine());
			long xbl2 = Long.parseLong(st.nextToken()); //a2
			long ybl2 = Long.parseLong(st.nextToken()); //b2
			long xtr2 = Long.parseLong(st.nextToken()); //p2
			long ytr2 = Long.parseLong(st.nextToken()); //q2
			
			long area1 = Math.abs(xtr1-xbl1)*Math.abs(ytr1-ybl1);
			long area2 = Math.abs(xtr2-xbl2)*Math.abs(ytr2-ybl2);
			long area = area1 + area2;
			long olArea = getOverLapArea(xbl1, ybl1, xtr1, ytr1, xbl2, ybl2, xtr2, ytr2);
			area = area -olArea;
			System.out.println(area);
			tc--;
		}

	}

}
