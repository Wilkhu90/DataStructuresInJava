import java.util.Arrays;
public class Ques2{

	public boolean isPermutation(char[] a, char[] b){

		Arrays.sort(a);
		Arrays.sort(b);
		String str1, str2;
		str1 = new String(a);
		str2 = new String(b);
		return str1.equals(str2);
	}	


	public static void main(String[] args){

		String a = "dog";
		String b = "god";

		Ques2 solution = new Ques2();
		System.out.println(solution.isPermutation(a.toCharArray(), b.toCharArray()));		

	}
}