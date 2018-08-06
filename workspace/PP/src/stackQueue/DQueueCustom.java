package stackQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DQueueCustom {

	static int len = 10000;
	static String arr[] = new String[10000];
	static int front = -1;
	static int rear = 0;
	static int count = 0;
	
	static void pushFront(String item) {
		if(!isFull()) {
			if(front == -1) {
				front = 0;
				rear = 0;
			} else if(front == 0){
				front = len-1;
			} else {
				front = front-1;
			}
			arr[front] = item;
			count++;
		}
	}
	
	static void pushRear(String item) {
		if(!isFull()) {
			if(front == -1) {
				front = 0;
				rear = 0;
			} else {
				rear = (rear+1)%len;
			}
			arr[rear] = item;
			count++;
		}
	}
	
	static String popFront() {
		if(!isEmpty()) {
			int toReturn = front;
			if(front==rear) {
				front = -1;
				rear = 0;
			} else if(front == len-1){
				front = 0;
			} else {
				front = front+1;
			}
			count--;
			return arr[toReturn];
		}
		return "Empty";
	}
	
	static String popRear() {
		if(!isEmpty()) {
			int toReturn = rear;
			if(front==rear) {
				front = -1;
				rear = 0;
			} else if(rear == 0){
				rear = len-1;
			} else {
				rear = rear-1;
			}
			count--;
			return arr[toReturn];
			
		}
		return "Empty";
	}
	
	static boolean isFull() {
		if((rear+1 == front) || (front==0 && rear == (len-1))) {
			return true;
		}
		return false;
	}
	
	static boolean isEmpty() {
		if(front==-1) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int opCount = Integer.parseInt(br.readLine());
		while(opCount > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			switch (op) {
			case "push_front":
				pushFront(st.nextToken());
				break;
			case "push_back":
				pushRear(st.nextToken());
				break;
			case "pop_front":
				System.out.println(popFront());
				break;
			case "pop_back":
				System.out.println(popRear());
				break;
			default:
				break;
			}
			opCount--;
		}
	}

}
