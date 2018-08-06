package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import trees.LeftViewBinaryTree.Node;

public class TreeDiameter {
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

	class Height {
		int height;
	}
	
	int diameter(Node root, Height h) {
		if(root == null) {
			h.height = 0;
			return 0;
		}
		Height leftHeight = new Height();
		Height rightHeight = new Height();

		int dL = diameter(root.left, leftHeight);
		int dR = diameter(root.right, rightHeight);
		
		h.height = 1 + Math.max(leftHeight.height, rightHeight.height);
		
		return Math.max(Math.max(dL, dR), (1 + leftHeight.height + rightHeight.height)); 
		
		
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
			//System.out.println("array = "+Arrays.toString(arr));
			TreeDiameter treeDiameter = new TreeDiameter();
			Node treeRoot = treeDiameter.buidTree(arr);
			Height h = treeDiameter.new Height();
			int res = treeDiameter.diameter(treeRoot, h);
			//System.out.println("res = "+res);
			bw.write(Integer.toString(res)+ "\n");
			tc--;
		}
		bw.flush();
	}
}
