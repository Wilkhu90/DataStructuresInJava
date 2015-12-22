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

public class Ques4{

	public LinkedList partition(LinkedList lList, int x){

		LinkedList leftPart = new LinkedList();
		LinkedList rightPart = new LinkedList();

		while(lList.head != null){
			if((int)lList.head.item < x)
				leftPart.addElement(lList.head.item);
			else
				rightPart.addElement(lList.head.item);

			lList.head = lList.head.next;
		}
		if(rightPart.head.item == null)
			return leftPart;

		while(rightPart.head != null){
			leftPart.addElement(rightPart.head.item);
			rightPart.head = rightPart.head.next;
		}
		return leftPart;

	}

	public static void main(String[] args){

		
		Ques4 solution = new Ques4();
		LinkedList lList = new LinkedList();
		lList.addElement(2);
		lList.addElement(3);
		lList.addElement(5);
		lList.addElement(3);
		lList.addElement(7);
		LinkedList ans = solution.partition(lList, 8);		
		lList.display();
		ans.display();
	}
}