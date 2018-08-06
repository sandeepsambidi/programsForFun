package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class LeftViewBinaryTree {

	class Node {
		int data;
		Node left;
		Node right;
		int height;
	}
	
	Node buidTree(int[] arr) {
		//System.out.println("arr = "+Arrays.toString(arr));
		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			root = insert(root, arr[i]);
		}
		return root;
	}
	
	Node insert(Node root, int data) {
		Node newNode = new Node();
		newNode.data = data;
		if(root==null) {
			root = newNode;
		} else {
			if(data> root.data) {
				root.right = insert(root.right, data);
			} else {
				root.left = insert(root.left, data);
			}
		}
		return root;
	}
	
	boolean isHeightBalanced(Node root) {
		if(root == null ) {
			return true;
		}
		
		boolean leftHeightBalanced = isHeightBalanced(root.left);
		boolean rightHeighBalanced = isHeightBalanced(root.right);
		
		if(!(leftHeightBalanced&&rightHeighBalanced)) {
			return false;
		}
		
		if(root.left!=null && root.right!=null) {
			if(Math.abs(root.left.height-root.right.height) > 1) {
				return false;
			}
			root.height = (1 + Math.max(root.left.height, root.right.height));
		} else if(root.left!=null) {
			if((root.left.height) > 1) {
				return false;
			}
			root.height = (1 + root.left.height);
		} else if(root.right!=null){
			if(root.right.height > 1) {
				return false;
			}
			root.height = (1 + root.right.height);
		} else {
			root.height = 1;
		}
		
		
		return true;
	}
	
	void leftView(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			Queue<Node> nextQueue = new LinkedList<Node>();
			Node curr = queue.remove();
			System.out.print(curr.data + " ");
			if(curr.left != null) {
				nextQueue.add(curr.left);
			}
			if(curr.right != null) {
				nextQueue.add(curr.right);
			}
			while(!queue.isEmpty()) {
				curr = queue.remove();
				if(curr.left != null) {
					nextQueue.add(curr.left);
				}
				if(curr.right != null) {
					nextQueue.add(curr.right);
				}
			}
			queue = nextQueue;
			
			
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
			LeftViewBinaryTree leftViewBinaryTree = new LeftViewBinaryTree();
			Node treeRoot = leftViewBinaryTree.buidTree(arr);
			
			leftViewBinaryTree.leftView(treeRoot);
			tc--;
		}
		bw.flush();
	}

}
