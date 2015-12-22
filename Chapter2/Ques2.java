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

public class Ques2{

	public void displayKth(LinkedList lList, int k){
		if (k > lList.count || k <= 0)
			System.exit(0);
		int noTimesIteration = lList.count - k;
		Node solution = lList.head;
		while(noTimesIteration > 0 ){
			solution = solution.next;
			noTimesIteration--;
		}
		System.out.println(solution.item);

	}
	public int displayKthRecursive(Node head, int k){
		if(head == null)
			return 0;

		int i = displayKthRecursive(head.next, k) + 1;
		if(i == k){
			System.out.println(head.item);
		}
		return i;

	}


	public static void main(String[] args){

		
		Ques2 solution = new Ques2();
		LinkedList lList = new LinkedList();
		lList.addElement(2);
		lList.addElement(3);
		lList.addElement(5);
		lList.addElement(3);
		lList.addElement(7);
		solution.displayKth(lList, 1);
		solution.displayKthRecursive(lList.head, 1);	

	}
}