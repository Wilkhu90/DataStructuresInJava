public class Ques5{

	public int bitSwapRequired(int a, int b){

		int count = 0;

		for(int i = a ^ b; i != 0; i = i >> 1){
			count += i & 1;
		} 
		return count;
	}

	public static void main(String[] args){
		Ques5 solution = new Ques5();
		System.out.println(solution.bitSwapRequired(1100, 1024));
	}
}