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
public class Ques4{
	Node root;

	public Ques4(){
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

	public void depthWiseList(ArrayList<LinkedList<Node>> listArray, int level, Node n){

		LinkedList<Node> list = null;

		if (n == null)
			return;
		if(listArray.size() == level){
			list = new LinkedList<Node>();
			listArray.add(list);
		}
		else{
			list = listArray.get(level);
		}
		list.add(n);
		depthWiseList(listArray, level+1, n.left);
		depthWiseList(listArray, level+1, n.right);

	}
	public ArrayList<LinkedList<Node>> createList(Node n){

		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		depthWiseList(result, 0, n);
		return result;

	}

	

	public static void main(String[] args){
		Ques4 bTree = new Ques4();
		bTree.insert(6);
		bTree.insert(4);
		bTree.insert(7);
		bTree.insert(3);
		bTree.insert(5);
		bTree.insert(6);
		bTree.insert(8);
		ArrayList<LinkedList<Node>> listArray = bTree.createList(bTree.root);
		int level = 0;
		for (LinkedList<Node> each : listArray){
			System.out.print("The elements in level "+level+": ");
			Node n = each.poll();
			while (n != null){
				System.out.print(n.data+" ");
				n = each.poll();
			}
			System.out.println();
			level++;
		}
	}
}