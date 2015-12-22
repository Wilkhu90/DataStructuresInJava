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
			this.head = tempNode;
		}
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

public class Ques3{

	public void deleteNode(Node n){
		Node previous = null;
		Node current = n;
		while(current != null){
			
			if(current.next == null){
				previous.next = null;
				break;
			}
			current.item = current.next.item;
			previous = current;
			current = current.next;
		}
	}


	public static void main(String[] args){

		
		Ques3 solution = new Ques3();
		LinkedList lList = new LinkedList();
		lList.addElement(2);
		lList.addElement(3);
		lList.addElement(5);
		lList.addElement(3);
		lList.addElement(7);
		solution.deleteNode(lList.head.next.next);		
		lList.display();
	}
}