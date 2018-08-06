import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("/Users/kh1964/Documents/TestInput"));
		int nodesCount = sc.nextInt();
		int connections = sc.nextInt();
		
		GraphUndirected g = new GraphUndirected(nodesCount);
		
		while(connections > 0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			g.addEdge(a, b);
			connections--;
		}
		g.toString();
		
	}

}
