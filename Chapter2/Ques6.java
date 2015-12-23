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

public class Ques6{

	public boolean hasLoop(Node head){
		Node slow = head;
		Node fast = head;

		while(fast !=null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				return true;
			}
		}
		return false;
	}

	public Node loopStartPoint(Node head){
		Node slow = head;
		Node fast = head;

		while(fast !=null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				break;
			}
		}
		
		if(fast == null || fast.next == null){
			return new Node(null);
		}

		slow = head;
		while(slow != fast){
			slow = slow.next;
			fast = fast.next;
			
		}
		return fast;
	}

	public static void main(String[] args){

		
		Ques6 solution = new Ques6();
		LinkedList digitOne = new LinkedList();
		digitOne.addElement(7);
		digitOne.addElement(1);
		digitOne.addElement(6);
		digitOne.addElement(8);
		digitOne.head.next.next.next.next = digitOne.head.next;
		System.out.println(solution.hasLoop(digitOne.head));
		System.out.println(solution.loopStartPoint(digitOne.head).item);
	}
}