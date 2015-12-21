class Node{
	char c;
	int count;
	Node next;

	public Node(char newChar){
		c = newChar;
		count = 1;
		next = null;
	}
}
public class Ques4{


	public String compress(String str){

		StringBuffer solution = new StringBuffer();

		char[] charArray = str.toCharArray();
		int i = 0;
		char prev = charArray[i];
		Node head = new Node(prev);
		Node res = head;

		while(i < charArray.length-1){
			char current = charArray[i+1];
			if(prev == current){
				++res.count;
			}
			else{
				Node tmp = new Node(current);
				res.next = tmp;
				res = res.next;
			}
			prev = current;
			current = charArray[++i];
		}
		while(head != null){
			solution.append(Character.toString(head.c)+Integer.toString(head.count));
			head = head.next;
		}
		if (solution.toString().length() < str.length())
			return solution.toString();
		else
			return str;
	}

	

	public static void main(String[] args){

		String test = "aabcccccaaa";
		Ques4 solution = new Ques4();
		System.out.println(solution.compress(test));		

	}
}