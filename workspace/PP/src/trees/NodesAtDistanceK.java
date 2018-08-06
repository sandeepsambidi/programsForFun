package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class NodesAtDistanceK {
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
	
	int count = 0;
	class Distance {
		int dist;
	}
	
	boolean findNodes(Node root, int k, int source, Distance d) {
		
		if(root == null) {
			return false;
		}
		
		if(root.data == source) {
			findNodesAtk(root, k);
			d.dist = 1;
			return true;
		}
		
		boolean leftFound = findNodes(root.left, k,source, d);
		if(leftFound && d.dist <= k) {
			if(d.dist == k) {
				findNodesAtk(root, 0);
			} else {
				findNodesAtk(root.right, k-d.dist-1);
			}
			d.dist = d.dist + 1;
			return true;
		} else {
			boolean rightFound = findNodes(root.right, k,source, d);
			if(rightFound && d.dist <=k) {
				if(d.dist == k) {
					findNodesAtk(root, 0);
				} else {
					findNodesAtk(root.left, k-d.dist-1);
				}
				d.dist = d.dist+1;
				return true;
			}
		}
		
		return false;
				
	}
	
	void findNodesAtk(Node root, int k) {
		if(root == null ) {
			return;
		} 
		if(k == 0) {
			//System.out.print(root.data + " ");
			count++;
			return;
		}
		findNodesAtk(root.left, k-1);
		findNodesAtk(root.right, k-1);
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
		
			int nodeCount = Integer.parseInt(st.nextToken());
			int source = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int index = 0;
			int[] arr = new int[nodeCount];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			while(index < nodeCount) {
				arr[index] = Integer.parseInt(st1.nextToken());
				index++;
			}
			//System.out.println("array = "+Arrays.toString(arr));
			NodesAtDistanceK nodesAtDistanceK = new NodesAtDistanceK();
			Node treeRoot = nodesAtDistanceK.buidTree(arr);
			Distance d = nodesAtDistanceK.new Distance();
			nodesAtDistanceK.findNodes(treeRoot, k, source, d);
			//System.out.println();
			System.out.println(nodesAtDistanceK.count);
			tc--;
		}
		bw.flush();
	}
}
