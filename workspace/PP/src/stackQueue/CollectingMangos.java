package stackQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class CollectingMangos {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCount = Integer.parseInt(br.readLine());
		int caseNum = 1;
		while(caseNum <= testCount) {
			StringBuilder sb = new StringBuilder();
			//bw.write("Case ");
			sb.append("Case ");
			//bw.write(Integer.toString(caseNum));
			sb.append(caseNum);
			//bw.write(":"+"\n");
			sb.append(":"+"\n");
			Stack<Integer> stack = new Stack<Integer>();
			Stack<Integer> auxStack = new Stack<Integer>();

			int operationCount = Integer.parseInt(br.readLine());
			while(operationCount > 0) {
				String op = br.readLine();
				if(op.contains("A")) {
					int item = Integer.parseInt(op.substring(2,op.length()));
					stack.push(item);
					if(auxStack.isEmpty()) {
						auxStack.push(item);
					} else if(item >= auxStack.peek()) {
						auxStack.push(item);
					}
				} else if(op.equals("Q")) {
					if(stack.isEmpty()) {
						//bw.write("Empty" + "\n");
						sb.append("Empty" + "\n");
					} else {
						sb.append(auxStack.peek() + "\n");
						//bw.write(Integer.toString(auxStack.peek()) + "\n");
					}
				} else { //equals "R"
					if(!stack.isEmpty()) {
						int popedItem = stack.pop();
						if(auxStack.peek() == popedItem) {
							auxStack.pop();
						}
					}
				}
				operationCount--;
				
			}
			caseNum++;
			bw.write(sb.toString());
		}
		bw.flush();
	}

}
