package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;


public class LevelOrderZigZag {

	class Node {
		int data;
		Node left;
		Node right;
	}
	
	Node buidTree(int[] arr) {
		//System.out.println("arr = "+Arrays.toString(arr));
		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			root = insert(root, arr[i], 0);
		}
		//System.out.println("");
		return root;
	}
	
	Node insert(Node root, int data, int depth) {
		Node newNode = new Node();
		newNode.data = data;
		if(root==null) {
			root = newNode;
			//System.out.print(depth + " ");
		} else {
			if(data> root.data) {
				root.right = insert(root.right, data, depth+1);
			} else {
				root.left = insert(root.left, data, depth +1);
			}
		}
		return root;
	}
	
	void printLevelOrder(Node root) {
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				Node curr = stack1.pop();
				if(curr.right!= null) {
					stack2.push(curr.right);
				}
				if(curr.left!= null) {
					stack2.push(curr.left);
				}
				System.out.print(curr.data + " ");
			}
			
			while(!stack2.isEmpty()) {
				Node curr = stack2.pop();
				if(curr.left!= null) {
					stack1.push(curr.left);
				}
				if(curr.right!= null) {
					stack1.push(curr.right);
				}
				
				System.out.print(curr.data + " ");
			}
		}
		System.out.println();
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			int nodeCount = Integer.parseInt(br.readLine());
			int index = 0;
			int[] arr = new int[nodeCount];
			StringTokenizer st = new StringTokenizer(br.readLine());
			while(index < nodeCount) {
				arr[index] = Integer.parseInt(st.nextToken());
				index++;
			}
			LevelOrderZigZag levelOrderZigZag = new LevelOrderZigZag();
			Node treeRoot = levelOrderZigZag.buidTree(arr);
			levelOrderZigZag.printLevelOrder(treeRoot);
			tc--;
		}
		bw.flush();
	}

}
