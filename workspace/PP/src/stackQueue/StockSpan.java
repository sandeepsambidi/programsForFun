package stackQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StockSpan {

	static int[] calculateSpan(int[] stockPrices) {
        //System.out.println(Arrays.toString(stockPrices));
        Stack<Integer> stack = new Stack<Integer>();
        int[] span = new int[stockPrices.length];
        stack.push(stockPrices.length - 1);
        int index = stockPrices.length - 2;
        while(!stack.isEmpty()) {
            if(index >= 0) {
                while(!stack.isEmpty() && stockPrices[index] > stockPrices[stack.peek()]) {
                    int currIndex = stack.pop();
                    span[currIndex] = currIndex - index;
                }
                stack.push(index);
                index--;
            } else {
                int currIndex = stack.pop();
                span[currIndex] = currIndex+1; 
            }
            
        }
        return span;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(br.readLine());
        while(testCaseCount > 0) {
            int arraySize = Integer.parseInt(br.readLine());
            int index = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] stockPrices = new int[arraySize]; 
            while(index < arraySize) {
                stockPrices[index++] = Integer.parseInt(st.nextToken());
            }
            int[] span = calculateSpan(stockPrices);
            StringBuilder builder = new StringBuilder();
            for (int value : span) {
                builder.append(value + " ");
            }
            String text = builder.toString();
            System.out.println(text);
            testCaseCount--;
        }
    }

}
