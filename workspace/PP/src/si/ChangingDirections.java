package si;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class ChangingDirections {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		while(testCaseCount >0) {
			int opCount = Integer.parseInt(br.readLine());
			Stack<String> stack =new Stack<String>();
			while(opCount > 0) {
				
				String op = br.readLine();
				if(op.startsWith("cd")) {
					String path = op.substring(3, op.length());
					StringTokenizer st = new StringTokenizer(path,"/");
					if(path.startsWith("/")) {
						stack.clear();
					} 
					while(st.hasMoreTokens()) {
						String nextToken = st.nextToken();
						if(nextToken.equals("..")) {
							if(!stack.isEmpty()) {
								stack.pop();
							}
							
						} else {
							stack.push(nextToken);
							}
					}
						
				} else { //op = pwd
					//print stack
					if(stack.isEmpty()) {
						System.out.println("/");
					} else {
						String stackContents = stack.toString();
						stackContents = stackContents.replaceAll(", ", "/");
						stackContents = stackContents.substring(1, stackContents.length()-1);
						stackContents = "/"+stackContents+"/";
						System.out.println(stackContents);
					}
				}
				opCount--;
			}
			testCaseCount--;
			System.out.println();
		}
	}

}
