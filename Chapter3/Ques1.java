public class Ques1{

	int[] arr;
	int size;
	int maxSize;

	public Ques1(int Max){
		maxSize = Max;
		size=0;
		arr = new int[maxSize];
	}

	public void push(int item){
		if(size < maxSize){
			arr[size] = item;
			size++;
		}
	}
	public int pop(){
		int result=-1;
		if(size > 0){
			size--;
			result = arr[size];

		}
		return result;
	}

	public void peek(){
		System.out.println("The value at top is: "+arr[size-1]);
	}


	public static void main(String[] args){

		Ques1 solution = new Ques1(8);

		solution.push(1);
		solution.push(2);
		solution.push(3);
		solution.push(4);
		solution.push(5);
		solution.push(6);
		solution.push(7);
		solution.push(8);
		solution.peek();
		solution.pop();	
		solution.pop();
		solution.pop();
		solution.pop();
		solution.pop();
		solution.pop();
		solution.pop();
		solution.peek();

	}
}