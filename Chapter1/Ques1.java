public class Ques1{

	public boolean isUnique(String str){
		int a = 0;
		for(int i=0; i<str.length(); i++){
			char c = str.charAt(i);
			int bitShift = c - 'a';
			int res = a ^ (1 << bitShift);
			if (res < a){
				return false;
			}
			a = res;
		}
		return true;
	}

	public static void main(String[] args){

		String checkString = "park";
		Ques1 solution = new Ques1();
		System.out.println(solution.isUnique(checkString));		

	}
}