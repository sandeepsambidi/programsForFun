package trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TreeVerticalOrder {

	TreeMap<Integer, ArrayList> map = new TreeMap<Integer,ArrayList>();
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
	
	void buildVerticalOrder(Node root, int pos) {
		if(root == null) {
			return;
		}
		if(map.containsKey(pos)) {
			map.get(pos).add(root.data);
		} else {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(root.data);
			map.put(pos, list);
		}
		buildVerticalOrder(root.left, pos-1);
		buildVerticalOrder(root.right, pos+1);
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
			TreeVerticalOrder treeVerticalOrder = new TreeVerticalOrder();
			Node treeRoot = treeVerticalOrder.buidTree(arr);
			treeVerticalOrder.buildVerticalOrder(treeRoot, 0);
			for (int i : treeVerticalOrder.map.keySet()) {
				Collections.sort(treeVerticalOrder.map.get(i));
				ArrayList<Integer> list = treeVerticalOrder.map.get(i);
				for (Iterator iterator = list.iterator(); iterator.hasNext();) {
					Integer integer = (Integer) iterator.next();
					System.out.print(integer + " ");
				}
				System.out.println();
			}
			tc--;
			System.out.println();
		}
		bw.flush();
	}

}
