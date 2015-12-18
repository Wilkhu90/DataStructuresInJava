import java.util.Stack;
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

public class DFS{

	public List<Object> dfs(Node root){

		List<Object> result = new ArrayList<Object>();

		Stack<Node> st = new Stack<Node>();
		if(root == null){
			return null;
		}

		st.add(root);
		while(!st.isEmpty()){
			Node tempHeadNode = st.pop();
			result.add(tempHeadNode.data);
			if(tempHeadNode.left != null)
				st.add(tempHeadNode.left);
			if(tempHeadNode.right != null)
				st.add(tempHeadNode.right);
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

		DFS searchObj = new DFS();
		System.out.println("DFS result is:");
		List<Object> result = searchObj.dfs(root);

		for(Object each : result){
			System.out.print(each+" ");
		}
		System.out.println();
	}

}