package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CompleteBinaryTree {

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
	
	boolean isCBT(Node root, int index, int nodeCount) {
		if(root== null) {
			return true;
		}
		if(index >= nodeCount) {
			return false;
		}
		
		return (isCBT(root.left, (2*index) +1, nodeCount) && isCBT(root.right, (2*index) +2, nodeCount));
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
			CompleteBinaryTree tree = new CompleteBinaryTree();
			Node treeRoot = tree.buidTree(arr);
			System.out.println(tree.isCBT(treeRoot,0,nodeCount)?"Yes": "No");
			tc--;
		}
		bw.flush();
	}

}
