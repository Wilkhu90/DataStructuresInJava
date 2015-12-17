public class LinkedList {

	class Node{
		Object item;
		Node next;

		public Node(Object data){
			this.item = data;
			this.next = null;
		}
	}

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

	public static void main(String [] args){
		LinkedList list = new LinkedList();
		System.out.println(list.count);
		list.addElement(3);
		list.addElement(9);
		list.addElement(8);
		System.out.println(list.count);
		System.out.println(list.head.item);
		System.out.println(list.head.next.next.item);
	}

}

