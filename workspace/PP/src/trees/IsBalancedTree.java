package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import trees.HeightOfTree.Node;

public class IsBalancedTree {
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
			IsBalancedTree heightOfTree = new IsBalancedTree();
			Node treeRoot = heightOfTree.buidTree(arr);
			
			boolean isBalanced = heightOfTree.isHeightBalanced(treeRoot);
			bw.write(isBalanced? "Yes"+"\n":"No" + "\n");
			tc--;
		}
		bw.flush();
	}
}
