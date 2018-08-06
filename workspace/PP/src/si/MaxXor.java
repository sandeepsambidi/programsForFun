package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MaxXor {

	private class Trie {
		
		Node root = new Node();
		
		public class Node {
			Node[] next = new Node[2];
			boolean end = false;
		}
		
		public void add(String str) {
			add(str, 0, root);
		}
		
		private void add(String str, int pos, Node root) {
			
			while (pos < str.length()) {
				char currChar = str.charAt(pos);
				int currInt = Integer.parseInt(Character.toString(currChar));
				
				if (root.next[currInt] == null) {
					Node newNode = new Node();
					root.next[currInt] = newNode;
					root = root.next[currInt];
				} else {
					root = root.next[currInt];
				}
				pos++;
			}
			root.end = true;
			
			
		}
	}
	
	public int getIntValueFromBinaryString(String str) {
		int val = 0;
		int curr = 1;
		for (int i=str.length()-1; i>=0; i--) {
			if (str.charAt(i) == '1') {
				val = val + curr;
			}
			curr = curr*2;
		}
		
		return val;
	}
	
	private String findMaxBinaryString(Trie trie, String binRep) {
		StringBuilder sb = new StringBuilder();
		Trie.Node root = trie.root;
		int i = 0;
		
		while (i < binRep.length()) {
			if (binRep.charAt(i) == '0') {
				if (root.next[1] != null) {
					sb.append("1");
					root = root.next[1];
				} else {
					sb.append("0");
					root = root.next[0];
				}
			} else {
				if (root.next[0] != null) {
					sb.append("0");
					root = root.next[0];
				} else {
					sb.append("1");
					root = root.next[1];
				}
			}
			
			i++;
		}
		
		return sb.toString();
	}
	
	public int findMax(int arr[]) {
		Trie trie = new Trie();
		int maxXor = Integer.MIN_VALUE;
		int maxBits = 0;
		
		for (int i= 0; i< arr.length; i++) {
			int logVal = (int) (Math.log(arr[i])/Math.log(2));
			if (logVal > maxBits) {
				maxBits = logVal;
			}
		}
		
		maxBits++;
		
		for (int i= 0; i< arr.length; i++) {
			String binRep = Integer.toBinaryString(arr[i]);
			if (binRep.length() < maxBits) {
				binRep = getZeros(maxBits-binRep.length()) + binRep;
			}
			
			trie.add(binRep);
		}
		
		for (int i= 0; i< arr.length; i++) {
			String binRep = Integer.toBinaryString(arr[i]);
			if (binRep.length() < maxBits) {
				binRep = getZeros(maxBits-binRep.length()) + binRep;
			}
			
			String otherNumBin = findMaxBinaryString(trie, binRep);
			int otherNum = getIntValueFromBinaryString(otherNumBin);
			
			int curXor = (arr[i]^otherNum);
			if (curXor > maxXor) {
				maxXor = curXor;
			}
		}
		
		
		return maxXor;
	}
	
	String getZeros(int count) {
		StringBuilder sb = new StringBuilder();
		while (count > 0) {
			sb.append("0");
			count--;
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCaseCount = Integer.parseInt(br.readLine());
		while (testCaseCount > 0) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int arraySize = Integer.parseInt(st1.nextToken());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int arr[] = new int[arraySize];
			int index = 0;
			while (st.hasMoreElements()) {
				arr[index] = Integer.parseInt(st.nextToken());
				index++;
			}
			//System.out.println(Arrays.toString(arr));
			MaxXor obj = new MaxXor();
			int result = obj.findMax(arr);
			output.write(Integer.toString(result) + "\n");
			testCaseCount--;
		}
		output.flush();
		
//		MaxXor obj = new MaxXor();
//		int[] arr = {};//{3, 10, 5, 25, 2, 8};//{12, 15, 9}; //{13, 11, 35, 3, 32 };
//		System.out.println(obj.findMax(arr));
	}

}
