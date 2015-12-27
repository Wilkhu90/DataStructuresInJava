import java.util.Stack;
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

public class Ques1{

	Node root;

	public Ques1(){
		this.root = null;
	}

	public void inorder_traversal(Node root){
		if (root != null){
			inorder_traversal(root.left);
			System.out.println(" " + root.data);
			inorder_traversal(root.right);
		}
	}

	public void insert(Object item){
		root = insert(root, item);
	}

	public Node insert(Node node, Object item){
		if (node == null){
			node = new Node(item);
		}
		else{
			if ((int)node.data > (int)item){
				node.left = insert(node.left, item);
			}
			else {
				node.right = insert(node.right, item);
			}
		}
		return node;
	}

	public int isBalanced(Node node){

		if(node == null){
			return 0;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(node);

		while(!stack.isEmpty()){
			Node popped = stack.pop();
			int a = isBalanced(popped.left)+1;
			int b = isBalanced(popped.right)+1;
			if(Math.abs(a - b) <= 1){
				return a>b?a:b;
			}
			else{
				break;
			}

		}
		return -1;
	}

	public static void main(String [] args){
		Ques1 bTree = new Ques1();
		Ques1 bTree1 = new Ques1();
		bTree.insert(6);
		bTree.insert(4);
		bTree.insert(7);
		bTree.insert(3);
		bTree.insert(5);
		bTree.insert(6);
		bTree.insert(8);

		System.out.println(bTree.isBalanced(bTree.root) != -1);

		bTree1.insert(6);
		bTree1.insert(4);
		bTree1.insert(7);
		bTree1.insert(3);
		bTree1.insert(5);
		bTree1.insert(6);
		bTree1.insert(8);
		bTree1.insert(9);
		bTree1.insert(10);
		System.out.println(bTree.isBalanced(bTree1.root) != -1);
	}

}