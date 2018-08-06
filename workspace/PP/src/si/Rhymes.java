package si;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Rhymes {

	private class Trie {
		
		Node root = new Node();
		
		public class Node {
			Node[] next = new Node[26];
			boolean end = false;
		}
		
		public void add(String str) {
			add(str, root);
		}
		
		private void add(String str, Node root) {
			
			int pos = str.length()-1;
			
			while (pos >= 0) {
				char currChar = str.charAt(pos);
				int currInt = currChar - 'a';
				
				if (root.next[currInt] == null) {
					Node newNode = new Node();
					root.next[currInt] = newNode;
					root = root.next[currInt];
				} else {
					root = root.next[currInt];
				}
				pos--;
			}
			root.end = true;
			
		}
	}
	
	public String findLargestSuffix(Trie trie, String query) {
		
		int pos = query.length() - 1;
		Trie.Node root = trie.root;
		
		if (query == null || root.next[query.charAt(pos)-'a'] == null) {
			return "";
		}
		
		while (pos >= 0 && root.next[query.charAt(pos)-'a'] != null) {
			root = root.next[query.charAt(pos)-'a'];
			pos--;
		}
		
//		if (pos == -1 && root.end == true) {
//			return query;
//		}
		
		ArrayList<String> list = new ArrayList<String>();
		doDFS(root, "", list);
		String toAppend = "";
		for (String rem: list) {
			if (rem.length() > toAppend.length()) {
				toAppend = rem;
			}
		}
		
		String toReturn =  new StringBuilder(toAppend).reverse().toString() + query.substring(pos + 1, query.length());
		return toReturn;
		
	}
	
	void doDFS(Trie.Node root, String str, ArrayList<String> list) {
		if (root.end) {
			list.add(str) ;
		}
		
		for (int i=0; i< 26; i++) {
			if (root.next[i] != null) {
				doDFS(root.next[i], str+((char) (i+'a')), list);
			}
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		int wordCount = Integer.parseInt(br.readLine());
		Rhymes rhymes = new Rhymes();
		Trie trie = rhymes.new Trie();
		while (wordCount > 0) {
			trie.add(br.readLine());
			wordCount--;
		}
		
		int queryCount = Integer.parseInt(br.readLine());
		while (queryCount >0) {
			output.write(Integer.toString((rhymes.findLargestSuffix(trie, br.readLine()).length())) + "\n");
			queryCount--;
		}
		output.flush();
	}

}
