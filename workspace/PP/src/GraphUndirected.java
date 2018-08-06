import java.util.LinkedList;

public class GraphUndirected {

	LinkedList<Integer>[] nodes;
	boolean[] visited;
	
	public GraphUndirected(int nodesCount) {
		nodes = new LinkedList[nodesCount+1];
		visited = new boolean[nodesCount+1];
		
		for (int i = 1; i < nodes.length; i++) {
			nodes[i] = new LinkedList<Integer>();
			visited[i] = false;
		}
	}
	
	public void addEdge(int a, int b){
		nodes[a].add(b);
		nodes[b].add(a);
	}
	
	public void removeEdge(int a, int b){
		
	}
	
	public LinkedList adj(int a){
		return nodes[a];
	}
	
	@Override
	public String toString() {
		for (int i = 1; i < 10; i++) {
			System.out.println(i+" : "+nodes[i].toString());
		}
		return super.toString();
	}
	
	void findArticulationPoints(){
		
	}
	
	void DFS(int root){
	
	}

}
