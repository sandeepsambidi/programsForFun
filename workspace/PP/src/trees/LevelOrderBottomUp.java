package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import trees.LevelOrderTree.Node;

public class LevelOrderBottomUp {

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
	
	void printLevelOrderBottomUp(Queue<Node> queue) {
		Queue<Node> nextQueue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			Node curr = queue.remove();
			sb.append(curr.data + " ");
			if(curr.left != null) {
				nextQueue.add(curr.left);
			}
			if(curr.right != null) {
				nextQueue.add(curr.right);
			}
		}
		if(!nextQueue.isEmpty()) {
			printLevelOrderBottomUp(nextQueue);
		}
		System.out.println(sb.toString());
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
			LevelOrderBottomUp levelOrderBottomUp = new LevelOrderBottomUp();
			Node treeRoot = levelOrderBottomUp.buidTree(arr);
			Queue< Node> queue = new LinkedList<Node>();
			queue.add(treeRoot);
			levelOrderBottomUp.printLevelOrderBottomUp(queue);
			tc--;
			System.out.println();
		}
		bw.flush();
	}

}
