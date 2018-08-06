package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

import graph.PathInGraph.GraphUndirected;

public class CountConnectedComponents {
	static class GraphUndirected {
		int vertexCount;
		LinkedList<Integer>[] vertices;
		int state[];
		GraphUndirected(int vertexCount) {
			this.vertexCount = vertexCount+1;
			vertices = new LinkedList[this.vertexCount];
			this.state = new int[this.vertexCount];
			for(int i=1; i<this.vertexCount; i++) {
				vertices[i] = new LinkedList<Integer>();
			}
		}
		
		void addEdge(int a, int b) {
			vertices[a].add(b);
			vertices[b].add(a);
		}
		
		LinkedList<Integer>[] getGraph() {
			return vertices;
		}
		
		LinkedList<Integer> getNeighbours(int source) {
			return vertices[source];
		}
		
		void resetState() {
			this.state = new int[this.vertexCount];
		}
	}
	
	static void countConnectedComponents(GraphUndirected graph) {
		graph.resetState();
		int count = 0;
		for(int i = 1; i< graph.vertexCount; i++) {
			if(graph.state[i] == 0) {
				count++;
				dfs(i,graph);
			}
		}
		System.out.println(count);
	}
	
	static void dfs(int source, GraphUndirected graph) {
		graph.state[source] = 1;
		LinkedList<Integer> neighbours = graph.getNeighbours(source);
		for(Integer currNeighbour: neighbours) {
			if (graph.state[currNeighbour] == 0) {
				dfs(currNeighbour, graph);
			}
		}
		graph.state[source] = 2;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int testCount = 1;
		while (testCount <= tc) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nodeCount = Integer.parseInt(st.nextToken());
			int edgeCount = Integer.parseInt(st.nextToken());
			GraphUndirected graphUndirected = new GraphUndirected(nodeCount);
			while(edgeCount > 0) {
				st = new StringTokenizer(br.readLine());
				graphUndirected.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				edgeCount--;
			}
			countConnectedComponents(graphUndirected);
			testCount++;
		}
		
	}
}
