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

public class BST{

	Node root;

	public BST(){
		this.root = null;
	}

	public void inorder_traversal(Node root){
		if (root != null){
			inorder_traversal(root.left);
			System.out.println(" " + root.data);
			inorder_traversal(root.right);
		}
	}

	public boolean search(int data){
		Node current = root;
		while(current != null){
			if ((int)current.data == data){
				return true;
			}
			else if((int)current.data < data){
				current = current.left;
			}
			else{
				current = current.right;
			}
		}
		return false;
	}

	public void insert(Object item){
		root = insert(root, item);
	}

	public Node insert(Node node, Object item){
		if (node == null){
			node = new Node(item);
		}
		else{
			if ((int)root.data > (int)item){
				node.left = insert(node.left, item);
			}
			else {
				node.right = insert(node.right, item);
			}
		}
		return node;
	}

	public boolean delete(Object item){
		Node parent = root;
		Node current = root;

		boolean isLeftChild = false;
		while((int)current.data != (int) item){
			parent = current;
			if((int)current.data > (int) item){
				isLeftChild = true;
				current = current.left;
			}
			else{
				isLeftChild = false;
				current = current.right;
			}
			if(current == null){
				return false;
			}
		}

		if(current.left == null && current.right == null){
			if(current == root)
				root = null;
			if(isLeftChild ==true){
				parent.left = null;
			}else{
				parent.right = null;
			}
		}

		else if(current.right==null){
			if(current==root){
				root = current.left;
			}else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		}
		else if(current.left==null){
			if(current==root){
				root = current.right;
			}else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}

		else if(current.left!=null && current.right!=null){
			
			Node successor	 = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		return true;

	}

	public Node getSuccessor(Node deleleNode){
		Node successsor =null;
		Node successsorParent =null;
		Node current = deleleNode.right;
		while(current!=null){
			successsorParent = successsor;
			successsor = current;
			current = current.left;
		}

		if(successsor!=deleleNode.right){
			successsorParent.left = successsor.right;
			successsor.right = deleleNode.right;
		}
		return successsor;
	}



	public static void main(String [] args){
		BST bTree = new BST();
		bTree.inorder_traversal(bTree.root);
		bTree.insert(3);
		bTree.insert(4);
		bTree.insert(2);
		bTree.insert(1);
		bTree.insert(5);
		bTree.insert(8);
		bTree.inorder_traversal(bTree.root);
		System.out.println();
		bTree.delete(2);
		bTree.inorder_traversal(bTree.root);
	}

}