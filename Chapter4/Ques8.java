class Node{
	int data;
	Node left;
	Node right;

	public Node(int item){
		data = item;
		left = null;
		right = null;
	}
}

public class Ques8{
	
	public boolean isSubtree(Node t1, Node t2){
		if(t2 == null){
			return true;
		}

		if(t1 != null){
			//Roots are matched.
			if(t1.data == t2.data){
				if(matchRemainingTree(t1, t2))
					return true;
			}
			return isSubtree(t1.left, t2) || isSubtree(t1.right, t2);
		}
		return false;
	}

	public boolean matchRemainingTree(Node t1, Node t2){
		
		if(t1 == null && t2 == null)
			return true;

		if(t1 == null || t2 == null)
			return false;

		if(t1.data == t2.data)
				return matchRemainingTree(t1.left, t2.left) && matchRemainingTree(t1.right, t2.right);
		else
			return false;
		

	}

	public static void main(String [] args){
		Ques8 solution = new Ques8();

		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(15);
		root.left.right.left = new Node(12);
		root.left.right.right = new Node(17);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(7);

		Node root1 = new Node(15);
		root1.left = new Node(12);
		root1.right = new Node(17);

		System.out.println(solution.isSubtree(root, root1));
	}

}