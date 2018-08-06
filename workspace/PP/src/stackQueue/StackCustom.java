package stackQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class StackCustom {
	
	static int stack[] = new int[10000];
	static int size = 0;
	static int top = -1;
	
	static boolean push(int item) {
		if(isFull()) {
			return false;
		} else {
			top++;
			stack[top] = item;
			size++;
			return true;
		}
	}
	
	static int pop() {
		if(isEmpty()) {
			return -101;
		} else {
			int topItem = stack[top];
			top--;
			size--;
			return topItem;
		}
		
	}
	
	static boolean isFull() {
		if(size == stack.length) {
			return true;
		} else {
			return false;
		}
	}
	
	static boolean isEmpty() {
		if(size == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCount = Integer.parseInt(br.readLine());
		while(testCount > 0) {
			String operation = br.readLine();
			if(operation.equals("pop")) {
				int popedItem = pop();
				String result = popedItem==-101? "Empty":Integer.toString(popedItem); 
				bw.write(result + "\n");
			} else {
				StringTokenizer st = new StringTokenizer(operation);
				st.nextToken();
				int itemToPush = Integer.parseInt(st.nextToken());
				System.out.println(push(itemToPush));
			}
			testCount--;
		}
		bw.flush();
	}

}
