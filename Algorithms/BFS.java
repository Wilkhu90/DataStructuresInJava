import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Node{
	Object data;
	Node left;
	Node right;

	public Node(Object item){
		data = item;
		left = null;
		right = null;
	}
}

public class BFS{

	public List<Object> bfs(Node root){

		List<Object> result = new ArrayList<Object>();

		Queue<Node> queue = new LinkedList<Node>();
		if(root == null){
			return null;
		}

		queue.add(root);
		while(!queue.isEmpty()){
			Node tempHeadNode = queue.remove();
			result.add(tempHeadNode.data);
			if(tempHeadNode.left != null)
				queue.add(tempHeadNode.left);
			if(tempHeadNode.right != null)
				queue.add(tempHeadNode.right);
		}
		return result;
	}


	public static void main (String [] args){

		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);

		BFS searchObj = new BFS();
		System.out.println("BFS result is:");
		List<Object> result = searchObj.bfs(root);

		for(Object each : result){
			System.out.print(each+" ");
		}
		System.out.println();
	}

}