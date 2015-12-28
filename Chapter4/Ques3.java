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
public class Ques3{

	public void inorder_traversal(Node root){
		if (root != null){
			inorder_traversal(root.left);
			System.out.println(" " + root.data);
			inorder_traversal(root.right);
		}
	}

	public Node createBST(int[] arr, int p, int r){
		if(p > r)
			return null;

		int mid = (p+r)/2;
		Node n = new Node(arr[mid]);
		
		n.left = createBST(arr, p, mid-1);
		n.right = createBST(arr, mid+1, r);
		return n;
	}

	public static void main(String[] args){
		Ques3 solution = new Ques3();
		int[] arr = {1,2,3,4,5,6,7};
		Node newNode = solution.createBST(arr, 0, arr.length-1);
		//Inorder Traversal to check if BST is sorted or not.
		solution.inorder_traversal(newNode);
	}
}