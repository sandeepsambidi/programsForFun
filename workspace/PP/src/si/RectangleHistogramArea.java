package si;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class RectangleHistogramArea {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		while(tc > 0) {
			int result = 0;
			int arraySize = Integer.parseInt(br.readLine());
			int index = 0;
			int heights[] = new int[arraySize];
			Stack<Integer> stack = new Stack<Integer>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(index < arraySize) {
				int currIndex = index;
				heights[index++] = Integer.parseInt(st.nextToken());
				int currHeight = heights[currIndex];
				if(stack.isEmpty()){
					stack.push(currIndex);
				} else {
					if(currHeight >= heights[stack.peek()]) {
						stack.push(currIndex);
					} else {
						while(!stack.isEmpty() && heights[stack.peek()] > currHeight ) {
							int indexToEvaluate = stack.pop();
							int localResult = 0;
							if(stack.isEmpty()) {
								localResult = heights[indexToEvaluate]*currIndex;
							} else {
								localResult = heights[indexToEvaluate]*(currIndex - stack.peek() - 1);
							}
							if(localResult > result) {
								result = localResult;
							}
							
						}
						stack.push(currIndex);
					}
					
				}
			}
			while(!stack.isEmpty()) {
				int top = stack.pop();
				int localResult = 0;
				if(stack.isEmpty()) {
					localResult = heights[top]*(arraySize);
				} else {
					localResult = heights[top]*((arraySize) - stack.peek() -1);
				}
				if(localResult> result) {
					result = localResult;
				}
			}
			//System.out.println("arr = "+Arrays.toString(heights));
			System.out.println(result);
			tc--;
		}
	}

}
