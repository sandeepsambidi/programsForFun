package stackQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class QueueCustom {

	int[] qArray;
	int f = -1;
	int r = 0;
	int size = 0;
	public QueueCustom(int capacity) {
		qArray = new int[capacity];
	}
	
	void enQueue(int item) {
		if(!isFull()) {
			qArray[r] = item;
			r = (r+1)%qArray.length;
			size++;
		}
	}
	
	int deQueue() {
		if(!isEmpty()) {
			f = (f+1)%qArray.length;
			size--;
			return qArray[f];
		}
		return Integer.MIN_VALUE;
	}
	
	boolean isFull(){
		if(size == qArray.length) {
			return true;
		}
		return false;
	}
	
	boolean isEmpty() {
		if(size==0) {
			return true;
		} return false;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		QueueCustom queue = new QueueCustom(10000);
		while(tc>0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("Enqueue")) {
				queue.enQueue(Integer.parseInt(st.nextToken()));
			} else {
				int i = queue.deQueue();
				bw.write(i == Integer.MIN_VALUE? "Empty"+"\n": Integer.toString(i) + "\n");
			}
			tc--;
		}
		bw.flush();
	}

}
