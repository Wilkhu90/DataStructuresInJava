public class Stack {

	class Node{
		Object item;
		Node next;

		public Node(Object data){
			this.item = data;
			this.next = null;
		}
	}

	Node top;

	public Stack(){
		top = new Node(null);
	}

	public void push(Object data){
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}

	public Node pop(){
		Node res = null;
		if(top != null){
			res = top;
			top = top.next;
		}
		return res;
	}
	public void peek(){
		System.out.println(top.item);
	}

	
	public static void main(String [] args){
		Stack st = new Stack();
		st.push(3);
		st.push(6);
		st.push(8);
		st.peek();
		st.pop();
		st.pop();
		st.pop();
		st.peek();
	}

}

