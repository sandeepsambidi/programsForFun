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

public class InPreToPost {
	
	int findPreInIn(int preValue, int[] in, int[] pre, int left, int right) {
		for(int i = left; i<=right; i++) {
			if(in[i]==preValue) {
				return i;
			}
		}
		return -1;
	}
	
	int prePos = 0;
	
	void printPost(int[] in, int[] pre, int left, int right) {
		if(left > right) {
			return;
		}
		int rootPos = findPreInIn(pre[prePos++], in, pre, left, right);
		printPost(in, pre, left, rootPos-1);
		printPost(in, pre, rootPos+1, right);
		System.out.print(in[rootPos]+" ");
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		while(tc>0) {
			int nodeCount = Integer.parseInt(br.readLine());
			int index = 0;
			int[] pre = new int[nodeCount];
			int[] in = new int[nodeCount];

			StringTokenizer preSt = new StringTokenizer(br.readLine());
			StringTokenizer inSt = new StringTokenizer(br.readLine());

			while(index < nodeCount) {
				pre[index] = Integer.parseInt(preSt.nextToken());
				in[index] = Integer.parseInt(inSt.nextToken());
				index++;
			}
			
			//System.out.println("pre = "+Arrays.toString(pre));
			//System.out.println("in = "+Arrays.toString(in));

			
			InPreToPost inPreToPost = new InPreToPost();
			inPreToPost.printPost(in, pre, 0, nodeCount-1);
			System.out.println();
			tc--;
		}
		bw.flush();
	}

}
