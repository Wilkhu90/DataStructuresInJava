import java.util.Comparator;
import java.util.Arrays;

class AnagramComparator implements Comparator<String>{

	public String sortChars(String A){

		char[] content = A.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

	public int compare(String A, String B){

		return sortChars(A).compareTo(sortChars(B));

		}
}

public class Ques2{

	public static void main(String[] args){

		AnagramComparator comparator = new AnagramComparator();
		String[] A = {"race","anagram","nagaram","assda","acre","asda","asd","care","fff","asda"};
		
		Arrays.sort(A, comparator);
		for(String str: A)
			System.out.println(str);

	}
}