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

public class Ques7{
	//Finding anscestor.
	public boolean isPresent(Node root, Node n){
		if(root == null)
			return false;
		if(root == n)
			return true;
		return isPresent(root.left, n) || isPresent(root.right, n);
	}

	public Node isAncestorHelper(Node root, Node p , Node q){

		if(root == null)
			return null;
		//Upper limit for recursion.
		if((root == p) || (root == q))
			return root;

		boolean isPLeft = isPresent(root.left, p);
		boolean isQLeft = isPresent(root.left, q);
		//Exit criteria for recursion.
		if(isPLeft != isQLeft)
			return root;
		//If both on same side then choose a direction.
		Node childSide = isPLeft ? root.left:root.right;
		return isAncestorHelper(childSide, p, q);

	}

	public Node isAncestor(Node root, Node p , Node q){
		// Valid values are input.
		if (!isPresent(root, p) || !isPresent(root, q))
			return null;
		return isAncestorHelper(root, p, q);

	}	

	public static void main(String [] args){
		Ques7 solution = new Ques7();

		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(15);
		root.left.right.right = new Node(17);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(7);

		System.out.println(solution.isAncestor(root, root.left.left.right, root.left.right.right).data);
	}

}