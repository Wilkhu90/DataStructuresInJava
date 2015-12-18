public class Queue {

	class Node{
		Object item;
		Node next;

		public Node(Object data){
			this.item = data;
			this.next = null;
		}
	}

	Node head;
	Node tail;

	public void enqueue(Object data){
		Node newNode = new Node(data);
		if(head == null){
			tail = newNode;
			head = tail;
		}
		else{
			tail.next = newNode;
			tail = tail.next;
		}
	}
	public Node dequeue(){
		Node res = null;
		if(head != null){
			res = head;
			head = head.next;
		}
		return res;
	}	

	public void peek(){
		System.out.println("Head: "+head.item);
		System.out.println("Tail: "+tail.item);
	}
	
	public static void main(String [] args){
		Queue q = new Queue();
		q.enqueue(3);
		q.peek();
		q.enqueue(6);
		q.enqueue(8);
		q.peek();
		q.dequeue();
		q.peek();
		q.dequeue();
		q.dequeue();
		q.peek();
	}

}

