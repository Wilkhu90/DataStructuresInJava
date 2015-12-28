class Node{
	Integer data;
	Node left;
	Node right;

	public Node(Integer item){
		data = item;
		left = null;
		right = null;
	}
}
public class Ques5{

	public boolean isBST(Node n, Integer min, Integer max){

		if(n == null)
			return true;
		if((min != null && n.data <= min) ||
			(max != null && n.data > max)){
				return false;
			}

		if(!isBST(n.left, min, n.data) ||
			!isBST(n.right, n.data, max)){
				return false;
			}

		return true;
	}

	public static void main(String [] args){

		Ques5 solution = new Ques5();

		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(15);
		root.left.right = new Node(17);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(7);

		System.out.println(solution.isBST(root, null, null));

		Node roots = new Node(20);
		roots.left = new Node(10);
		roots.right = new Node(30);
		roots.left.right = new Node(25);

		System.out.println(solution.isBST(roots, null, null));
	}
}