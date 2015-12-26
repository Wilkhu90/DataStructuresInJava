import java.util.Stack;

public class Ques6{

	Stack<Integer> stack1;
	Stack<Integer> stack2;

	public Ques6(Stack<Integer> stacks){
		stack1 = stacks;
		stack2 = new Stack<Integer>();
	}

	public void sort(){
		while(!stack1.isEmpty())
			sortItem(stack1.pop());
	}

	public void sortItem(int item){
		if(stack2.isEmpty()){
			stack2.push(item);
			return;
		}
		if(stack2.peek() >= item){
			int i = stack2.pop();
			sortItem(item);
			stack2.push(i);
		}
		else{
			stack2.push(item);
		}
		return;
	}
	public void display(){
		while(!stack2.isEmpty())
			System.out.println(stack2.pop());
	}

	public static void main(String[] args){
		
		Stack<Integer> myStack = new Stack<Integer>();
		myStack.add(5);
		myStack.add(3);
		myStack.add(7);
		myStack.add(2);
		myStack.add(4);
		Ques6 solution = new Ques6(myStack);
		solution.sort();
		solution.display();

	}
}