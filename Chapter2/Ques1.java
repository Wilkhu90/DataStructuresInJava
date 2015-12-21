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

public class Ques1{

	public void removeDuplicateNSquareComplexity(LinkedList lList){

		LinkedList newList = new LinkedList();
		newList.addElement(lList.head.item);
		lList.head.item = null;
		lList.head = lList.head.next;
		while(lList.head != null){
			Node hd = newList.head;
			boolean flag = true;
			while(hd != null && flag){
				if(lList.head.item == hd.item){
					flag = false;
				}
				hd = hd.next;
			}
			if(flag){
				newList.addElement(lList.head.item);
			}
			lList.head.item = null;
			lList.head = lList.head.next;
		}

		lList.display();
		newList.display();

	}	


	public static void main(String[] args){

		Ques1 solution = new Ques1();
		LinkedList lList = new LinkedList();
		lList.addElement(2);
		lList.addElement(3);
		lList.addElement(5);
		lList.addElement(3);
		lList.addElement(2);

		solution.removeDuplicateNSquareComplexity(lList);	

	}
}