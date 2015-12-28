class Node{
	Integer data;
	Node left;
	Node right;
	Node parent;

	public Node(Integer item){
		data = item;
		left = null;
		right = null;
		parent = null;
	}
}
public class Ques6{

	public Node getSuccessor(Node n){

		if (n == null)
			return null;

		if (n.right != null){
			Node current = n.right;
			while(current.left != null){
				current = current.left;
			}
			return current;
		}
		else{
			Node current = n.parent;
			while(current != current.parent.left){
				current = current.parent;
			}
			current = current.parent;
			return current;
		}
	}

	public static void main(String [] args){

		Ques6 solution = new Ques6();

		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(15);
		root.left.right.right = new Node(17);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(7);
		root.left.parent = root;
		root.right.parent = root;
		root.parent = null;
		root.left.left.parent = root.left;
		root.left.right.parent = root.left;
		root.left.left.left.parent =  root.left.left;
		root.left.left.right.parent =  root.left.left;
		root.left.right.right.parent = root.left.right;


		System.out.println(solution.getSuccessor(root.left.left.right).data);

		
	}
}