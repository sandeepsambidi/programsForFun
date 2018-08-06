import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MatrixFlips {

	static int findCount(int arr[]) {
		int state = 0;
		int res = 0;
		for(int i = arr.length - 1; i>= 0; i--) {
			if(arr[i] == state) {
				res++;
				state = 1 - state;
			}
		}
		return res;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		int testCount = 1;
		
		while (testCount <= tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int rowCount = Integer.parseInt(st.nextToken());
			int colCount = Integer.parseInt(st.nextToken());
			int rowIndex = 0;
			int colIndex = 0;
			int res = 0;
			while (rowIndex < rowCount) {
				char[] curArr = br.readLine().toString().toCharArray();
				colIndex = 0;
				int arr[] = new int[colCount];
				while (colIndex < colCount) {
					arr[colIndex] = Integer.parseInt(String.valueOf(curArr[colIndex]));
					colIndex++;
				}
				res = res + findCount(arr);
				rowIndex++;
			}
			bw.write(Integer.toString(res));
			testCount++;
			bw.newLine();
		}
		bw.flush();
	}

}
