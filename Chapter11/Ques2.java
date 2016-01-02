import java.util.Comparator;
import java.util.Arrays;

public class Ques2 implements Comparator<String>{

	public String sortChars(String A){

		char[] content = A.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	public int compare(String A, String B){

		return sortChars(A).compareTo(sortChars(B));

		}


	public static void main(String[] args){

		Ques2 comparator = new Ques2();
		String[] A = {"race","anagram","nagaram","assda","acre","asda","asd","care","fff","asda"};
		
		Arrays.sort(A, comparator);
		for(String str: A)
			System.out.println(str);

	}
}