package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TreeTraversal {
	
	class Node {
		int data;
		Node left;
		Node right;
	}

	void inOrder(Node root, StringBuilder sb) {
		if(root == null) {
			return;
		}
		inOrder(root.left,sb);
		sb.append(root.data + " ");
		inOrder(root.right, sb);
	}
	
	void preOrder(Node root, StringBuilder sb) {
		if(root == null) {
			return;
		}
		sb.append(root.data + " ");
		preOrder(root.left,sb);
		preOrder(root.right, sb);
	}
	
	void postOrder(Node root, StringBuilder sb) {
		if(root == null) {
			return;
		}
		postOrder(root.left,sb);
		postOrder(root.right, sb);
		sb.append(root.data + " ");

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
			TreeTraversal treeTraversal = new TreeTraversal();
			Node treeRoot = treeTraversal.buidTree(arr);
			StringBuilder sb = new StringBuilder();
			treeTraversal.preOrder(treeRoot, sb);
			bw.write(sb.toString() + "\n");
			sb = new StringBuilder();
			treeTraversal.inOrder(treeRoot,sb);
			bw.write(sb.toString() + "\n");
			sb = new StringBuilder();
			treeTraversal.postOrder(treeRoot,sb);
			bw.write(sb.toString()+ "\n");
			bw.newLine();
			tc--;
		}
		bw.flush();
	}
	

}
