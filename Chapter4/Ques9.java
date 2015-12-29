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

public class Ques9{

	public void findPathWithSum(Node n, int sum, int[] path, int level){

		if(n == null)
			return;

		path[level] = n.data;
		int t = 0;
		for(int i = level; i >= 0; i--){
			t += path[i];
			if(t == sum){
				print(path, i, level);
			}
		}

		findPathWithSum(n.left, sum, path, level+1);
		findPathWithSum(n.right, sum, path, level+1);

	}	

	public void findPathWithSum(Node n, int sum){
		int depth = depth(n);
		int[] path = new int[depth];
		findPathWithSum(n, sum, path, 0);
	}

	public int depth(Node n){
		if(n == null)
			return 0;
		return 1+depth(n.left) > 1+depth(n.right)? 1+depth(n.left): 1+depth(n.right);
	}

	public void print(int[] path, int start, int end){
		for (int i = start; i <= end; i++)
			System.out.print(path[i]+" ");
		System.out.println();
	}
	

	public static void main(String [] args){
		Ques9 solution = new Ques9();

		Node root = new Node(20);
		root.left = new Node(10);
		root.right = new Node(30);
		root.left.left = new Node(5);
		root.left.right = new Node(15);
		root.left.right.left = new Node(12);
		root.left.right.right = new Node(17);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(7);

		solution.findPathWithSum(root, 30);
	}

}