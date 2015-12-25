import java.util.ArrayList;

class Node{
	Object item;
	Node next;

	public Node(Object data){
		this.item = data;
		this.next = null;
	}
}

class Stack {

	Node top;
	int capacity;

	public Stack(){
		top = new Node(null);
		capacity = 0;
	}

	public void push(Object data){
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		capacity++;
	}

	public Node pop(){
		Node res = null;
		if(top != null){
			res = top;
			top = top.next;
		}
		capacity--;
		return res;
	}
	public void peek(){
		System.out.println(top.item);
	}
}

public class Ques3{

	ArrayList<Stack> setOfStacks = new ArrayList<Stack>();

	public void push(int item){
		Stack lastStack = getLastStack();
		if(lastStack != null && lastStack.capacity < 5){
			lastStack.push(item);
		}
		else{
			Stack newStack = new Stack();
			newStack.push(item);
			setOfStacks.add(newStack);
		}
	}

	public Node pop(){
		Node result;
		Stack lastStack = getLastStack();
		result = lastStack.pop();
		
		if(lastStack.capacity == 0){
			setOfStacks.remove(setOfStacks.size() - 1);			
		}
		if(result.item == null){
			lastStack = getLastStack();
			result = lastStack.pop();
		}
		
		return result;
	}
	public Stack getLastStack(){
		if(setOfStacks.size() == 0){
			return null;
		}
		else{
			return setOfStacks.get(setOfStacks.size() - 1);
		}
	}

	public static void main(String[] args){

		
		Ques3 solutionStack = new Ques3();
		solutionStack.push(3);
		solutionStack.push(4);
		solutionStack.push(2);
		solutionStack.push(1);
		solutionStack.push(4);
		solutionStack.push(2);
		solutionStack.push(1);
		System.out.println(solutionStack.pop().item);
		System.out.println(solutionStack.pop().item);
		System.out.println(solutionStack.pop().item);
		System.out.println(solutionStack.pop().item);
		System.out.println(solutionStack.pop().item);
		System.out.println(solutionStack.pop().item);
		System.out.println(solutionStack.pop().item);
	}
}