class Node{
	Object item;
	Node next;

	public Node(Object item){
		this.item = item;
		this.next = null;
	}
}

class LinkedList {

	Node head;
	int count;

	public LinkedList(){
		this.head = new Node(null);		
		this.count = 0;
	} 

	public void addElement(Object element){
		Node tempNode = new Node(element);
		if(this.count == 0){
			this.head = tempNode;		}
		else{
			Node checkingNode = this.head;
			while(checkingNode.next != null){
				checkingNode = checkingNode.next;
			}
			checkingNode.next = tempNode;
		}
		this.count++;
	}

	public void display(){
		Node newNode = this.head;
		while(newNode != null){
			System.out.print(newNode.item+" ");
			newNode = newNode.next;
		}
		System.out.println();
	}
}

public class Ques7{
	Node head = null;
	public Node reverseList(Node n){
		
		if (n == null){
			return null;
		}
		if(n.next == null){
			head = new Node(n.item);
			return head;
		}

		Node x = reverseList(n.next);
		x.next = new Node(n.item);
		x = x.next;
		return x;	
	}

	public boolean isPalindrome(Node n){
		reverseList(n);
		while(n != null){
			if (head.item != n.item ){
				return false;
			}
			n = n.next;
			head = head.next;
		}
		
		return true;
	}

	public static void main(String[] args){

		
		Ques7 solution = new Ques7();
		LinkedList digitOne = new LinkedList();
		digitOne.addElement(1);
		digitOne.addElement(2);
		digitOne.addElement(3);
		digitOne.addElement(2);
		digitOne.addElement(1);
		System.out.println(solution.isPalindrome(digitOne.head));
	}
}