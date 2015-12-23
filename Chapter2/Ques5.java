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

public class Ques5{

	public Node sumReverse(Node digitOne, Node digitTwo, int carry){
		if(digitTwo == null && digitTwo == null && carry == 0){
			return null;
		}
		Node result = new Node(carry);
		int value = carry;

		if(digitOne != null)
			value += (int)digitOne.item;
		if(digitTwo != null)
			value += (int)digitTwo.item;
		
		result.item = value % 10;

		if(digitOne != null || digitTwo != null){
			Node more = sumReverse(digitOne == null ? null:digitOne.next,
				digitTwo == null ? null:digitTwo.next,
				value >= 10 ? 1:0);
			result.next = more;
		}
		return result;

	}

	public static void main(String[] args){

		
		Ques5 solution = new Ques5();
		LinkedList digitOne = new LinkedList();
		LinkedList digitTwo = new LinkedList();
		digitOne.addElement(7);
		digitOne.addElement(1);
		digitOne.addElement(6);
		digitOne.addElement(8);

		digitTwo.addElement(5);
		digitTwo.addElement(9);
		digitTwo.addElement(2);
		Node ans = solution.sumReverse(digitOne.head, digitTwo.head, 0);
		System.out.println(ans.item);
	}
}