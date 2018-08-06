package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class PathInGraph {
	
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
	
	static boolean isPathExists(GraphUndirected graph, int source, int dest) {
		graph.resetState();
		return dfs(source, dest, graph);
	}
	
	static boolean dfs(int source, int dest, GraphUndirected graph) {
		graph.state[source] = 1;
		if(source == dest) {
			return true;
		}
		LinkedList<Integer> neighbours = graph.getNeighbours(source);
		for(Integer currNeighbour: neighbours) {
			if (graph.state[currNeighbour] == 0) {
				if (dfs(currNeighbour, dest, graph)) {
					return true;
				}
			}
		}
		graph.state[source] = 2;
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		int testCount = 1;
		while (testCount <= tc) {
			System.out.println("Test Case #"+testCount+":");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int nodeCount = Integer.parseInt(st.nextToken());
			int edgeCount = Integer.parseInt(st.nextToken());
			GraphUndirected graphUndirected = new GraphUndirected(nodeCount);
			while(edgeCount > 0) {
				st = new StringTokenizer(br.readLine());
				graphUndirected.addEdge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				edgeCount--;
			}
			int queryCount = Integer.parseInt(br.readLine());
			while (queryCount > 0) {
				st = new StringTokenizer(br.readLine());
				int source = Integer.parseInt(st.nextToken());
				int dest = Integer.parseInt(st.nextToken());
				
				System.out.println(isPathExists(graphUndirected, source, dest) ? "Yes": "No");
				queryCount--;
			}
			testCount++;
		}
		
	}

}
