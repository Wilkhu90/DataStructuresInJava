import java.util.*;
public class Ques5{

	public int stringBinarySearch(String[] a, String key, int p, int q){

		if(key.isEmpty() || a == null || key == null)
			return -1;

		if(p <= q){

			int mid = (p+q)/2;
			int new1=mid;
			int new2=mid;
			while(a[new1].isEmpty() && a[new2].isEmpty()){
				new1++;
				new2--;
			}
			Random rno = new Random();
			if(!a[new1].isEmpty() && !a[new2].isEmpty())
				mid = rno.nextBoolean() ? new1 : new2;
			else
				mid = a[new1].isEmpty()?new2:new1;

			if(key.equals(a[mid]))
				return mid; 

			if(key.compareTo(a[mid]) > 0)
				return stringBinarySearch(a, key, mid+1, q);
			else
				return stringBinarySearch(a, key, p, mid);
		}
		return -1;
	}


	public static void main(String[] args){
		Ques5 solution = new Ques5();
		String[] arr = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "eee"};
		String key = "eee";
		System.out.println("Position of key is: "+solution.stringBinarySearch(arr, key, 0, arr.length-1));
	}
}