public class Ques1{

	public int bitAddBetween(int num, int m, int i, int j){

		int prep1 = ~((1 << (j + 1)) - 1);
		int prep2 = (1 << (i + 1)) - 1;
		int mask = prep1 | prep2;
		return (num & mask) | (m << i);
	}

	public static void main(String[] args){
		Ques1 solution = new Ques1();
		System.out.println(solution.bitAddBetween(1024, 19, 2, 6));
	}
}