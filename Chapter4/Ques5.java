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
public class Ques5{

	public boolean isBST(Node n){

		if(n.left == null || n.right == null)
			return true;
		boolean flag = false;
		if((int)n.left.data < (int)n.data && (int)n.right.data >= (int)n.data)
			flag = isBST(n.left) && isBST(n.right);

		return flag;
	}

	public static void main(String [] args){

		Ques5 solution = new Ques5();

		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(15);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.left = new Node(10);
		root.right.right = new Node(35);

		System.out.println(solution.isBST(root));

		Node roots = new Node(5);
		roots.left = new Node(3);
		roots.right = new Node(15);
		roots.left.left = new Node(2);
		roots.left.right = new Node(4);
		roots.right.left = new Node(10);
		roots.right.right = new Node(9);

		System.out.println(solution.isBST(roots));
	}
}