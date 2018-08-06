package stringManipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ReverseSentence {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCount = Integer.parseInt(br.readLine());
		while(testCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			StackOfStrings stack = new StackOfStrings();
			while(st.hasMoreTokens()) {
				
				stack.push(st.nextToken());
				
				}
			LinkedList<String> stackPtr = stack.getStack();
			while(!stackPtr.isEmpty()) {
				sb.append(stack.pop());
				sb.append(" ");
			}
			bw.write(sb.toString()+ "\n");
			testCount--;
		}
		bw.flush();
	}
	
	static class StackOfStrings {
		int count = 0;
		LinkedList<String> list = new LinkedList<String>();
		
		LinkedList<String> getStack() {
			return list;
		}
		
		void push(String str) {
			list.addFirst(str);
			count++;
		}
		
		String pop() {
			if(count==0){
				return null;
			}
			count--;
			return list.removeFirst();
		}
		
		void clear(){
			list.clear();
		}
	}

}
