package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class HeightOfTree {

	class Node {
		int data;
		Node left;
		Node right;
		int height;
		Node parent;
	}
	
	Node buidTree(int[] arr) {
		//System.out.println("arr = "+Arrays.toString(arr));
		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			root = insert(root, arr[i]);
			System.out.print(root.height - 1 + " ");

		}
		return root;
	}
	
	Node insert(Node root, int data) {
		Node newNode = new Node();
		newNode.data = data;
		if(root==null) {
			root = newNode;
			root.height = 1;
		} else {
			if(data> root.data) {
				Node nodeToInsert = insert(root.right, data);
				root.right = nodeToInsert;
				nodeToInsert.parent = root;
				findHeight(root);
				
			} else {
				Node nodeToInsert = insert(root.left, data);
				root.left = nodeToInsert;
				nodeToInsert.parent = root;
				findHeight(root);
			}
		}
		return root;
	}
	
	void findHeight(Node root) {
		Node prev = null;
		while(root!=null) {
			root.height = maxheight(root.left, root.right) + 1;
			prev = root;
			root = root.parent;
		}
	}
	
	int maxheight(Node root1, Node root2) {
		int h1 = 0;
		int h2 = 0;
		if(root1 != null) {
			h1 = root1.height;
		}
		
		if(root2 != null) {
			h2 = root2.height;
		}
		
		return Math.max(h1, h2);
	}
	
	int height(Node root) {
		if(root == null ) {
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
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
			HeightOfTree heightOfTree = new HeightOfTree();
			Node treeRoot = heightOfTree.buidTree(arr);
			
//			int h = heightOfTree.height(treeRoot);
//			bw.write(Integer.toString(h-1) + "\n");
			tc--;
			System.out.println();
		}
		bw.flush();
	}
}
