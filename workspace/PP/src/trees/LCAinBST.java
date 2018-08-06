package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import trees.NodesAtDistanceK.Distance;
import trees.NodesAtDistanceK.Node;

public class LCAinBST {
	
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
	
	int findLCA(Node root, int leftNode, int rightNode) {
		if(root == null) {
			return -1;
		}
		
		if(leftNode > root.data && rightNode > root.data) {
			return findLCA(root.right, leftNode, rightNode);
		} else if(leftNode < root.data && rightNode < root.data) {
			return findLCA(root.left, leftNode, rightNode);
		} else {
			//System.out.print(root.data+ "\n");
			return root.data;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			int nodeCount = Integer.parseInt(st.nextToken());
			int queryCount = Integer.parseInt(st.nextToken());
			int index = 0;
			int[] arr = new int[nodeCount];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			while(index < nodeCount) {
				arr[index] = Integer.parseInt(st1.nextToken());
				index++;
			}
			LCAinBST tree = new LCAinBST();
			Node root = tree.buidTree(arr);
			index = 0;
			while(index < queryCount) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int result;
				if(x < y) {
					result = tree.findLCA(root, x, y);
				} else {
					result = tree.findLCA(root, y, x);
				}
				bw.write(result + " ");
				index++;
			}
			//System.out.println("array = "+Arrays.toString(arr));
			bw.newLine();
			tc--;
		}
		bw.flush();
	}

}
