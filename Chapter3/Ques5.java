import java.util.Stack;

public class Ques5{

	Stack<Integer> stack1;
	Stack<Integer> stack2;

	public Ques5(){
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}

	public void add(int item){
		stack1.push(item);
	}

	public void peek(){
		shiftStack1();
		System.out.println(stack2.peek());
	}

	public int remove(){
		shiftStack1();
		return stack2.pop();
	}
	public void shiftStack1(){
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
	}

	public static void main(String[] args){
		Ques5 myQueue = new Ques5();
		myQueue.add(3);
		myQueue.add(4);
		myQueue.add(5);
		myQueue.remove();
		myQueue.peek();
		myQueue.add(3);
		myQueue.add(4);
		myQueue.add(5);
		myQueue.remove();
		myQueue.peek();
		myQueue.remove();
		myQueue.peek();
		myQueue.remove();
		myQueue.peek();

	}
}