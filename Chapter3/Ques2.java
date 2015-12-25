class Stack {

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
}

public class Ques2 extends Stack{

	Stack stack;
	public Ques2(){
		stack = new Stack();
	}
	public void push(int item){
		if(min() >= item){
			stack.push(item);
		}
		super.push(item);
	}

	public Node pop(){
		Node item = super.pop();
		if((int)item.item == min()){
			stack.pop();
		}
		return item;
	}
	public int min(){
		if(stack.top.item == null)
			return Integer.MAX_VALUE;
		return (int)stack.top.item;
	}


	public static void main(String[] args){

		
		Ques2 solutionStack = new Ques2();
		solutionStack.push(3);
		solutionStack.push(4);
		solutionStack.push(2);			
		System.out.println(solutionStack.min());
		solutionStack.push(1);
		System.out.println(solutionStack.min());
		solutionStack.pop();
		System.out.println(solutionStack.min());
		solutionStack.pop();
		System.out.println(solutionStack.min());

	}
}