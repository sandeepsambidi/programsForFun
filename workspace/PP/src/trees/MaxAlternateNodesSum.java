package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import trees.NodesAtDistanceK.Distance;
import trees.NodesAtDistanceK.Node;

public class MaxAlternateNodesSum {
	
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
	
	class Sum {
		int in;
		int ex;
	}
	
	boolean isLeaf(Node root) {
		if(root.left == null && root.right == null) {
			return true;
		} else {
			return false;
		}
	}
	
	int findMaxSum(Node root, Sum s) {
		if(root == null) {
			return 0;
		}
		if(isLeaf(root)) {
			s.in = root.data;
			s.ex = 0;
		}
		
		Sum leftSum = new Sum();
		Sum rightSum = new Sum();
		findMaxSum(root.left, leftSum);
		findMaxSum(root.right, rightSum);
		
		s.in = root.data + leftSum.ex + rightSum.ex;
		s.ex = Math.max((Math.max((leftSum.in + rightSum.in), (leftSum.ex + rightSum.ex))), 
				Math.max((leftSum.in + rightSum.ex), (leftSum.ex + rightSum.in)));
		return Math.max(s.in, s.ex);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			int nodeCount = Integer.parseInt(st.nextToken());
			int index = 0;
			int[] arr = new int[nodeCount];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			while(index < nodeCount) {
				arr[index] = Integer.parseInt(st1.nextToken());
				index++;
			}
			//System.out.println("array = "+Arrays.toString(arr));
			MaxAlternateNodesSum maxAlternateNodesSum = new MaxAlternateNodesSum();
			Node treeRoot = maxAlternateNodesSum.buidTree(arr);
			int result = maxAlternateNodesSum.findMaxSum(treeRoot, maxAlternateNodesSum.new Sum());
			System.out.println(result);
			tc--;
		}
		bw.flush();
	}
}
