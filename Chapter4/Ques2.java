import java.util.Stack;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class DirectedGraph{
	Map<Integer, List<Integer>> adjList;
	int vertices;

	public DirectedGraph(int vertices){
		this.vertices = vertices;
		adjList = new HashMap<Integer, List<Integer>>();
		for (int i=1; i<=vertices; i++){
			adjList.put(i, new LinkedList<Integer>());
		}
	}

	public void setEdge(int source, int destination){
		int size = adjList.size();
		if(source > size || destination > size){
			return;
		}
		List<Integer> sourceList = adjList.get(source);
		sourceList.add(destination);

	}

	public List<Integer> getEdge(int vertex){
		int size = adjList.size();
		if(vertex > size){
			return null;
		}
		List<Integer> edgeList = adjList.get(vertex);
		return edgeList;
	}
}

public class Ques2{

	DirectedGraph directedGraph;
	public Ques2(DirectedGraph dg){
		directedGraph = dg;
	}

	public boolean hasPath(int source, int destination){
		if(source == destination){
			return true;
		}
		Boolean[] visited = new Boolean[directedGraph.vertices+1];
		for(int i=0; i<directedGraph.vertices; i++)
			visited[i] = false;

		Stack<Integer> st = new Stack<Integer>();
		st.push(source);
		while(!st.isEmpty()){
			int popped = st.pop();
			for(int edge : directedGraph.getEdge(popped)){
				if(edge == destination){
						return true;
				}
				else{
					if(!visited[edge-1]){
						st.push(edge);
						visited[edge-1] = true;
					}
				}
			}
		}
		return false;
	}


	public static void main(String[] args){

		DirectedGraph directedGraph = new DirectedGraph(5);
		directedGraph.setEdge(1, 2);
		directedGraph.setEdge(2, 3);
		directedGraph.setEdge(3, 1);
		directedGraph.setEdge(2, 4);
		directedGraph.setEdge(3, 4);
		Ques2 solution = new Ques2(directedGraph);
		System.out.println(solution.hasPath(1, 4));
		System.out.println(solution.hasPath(1, 5));

	}
}