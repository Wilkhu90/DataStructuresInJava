import java.util.Arrays;

public class BinarySearch{
	int[] arr;
	public BinarySearch(int[] arr){
		this.arr = arr;
	}

	public Boolean bsearch(int i, int j, int key){
		if(i > j){
			return false;
		}

		int mid = (i+j)/2;
		if(arr[mid] == key){
			return true;
		}
		else{
			if (key < arr[mid]){
				return bsearch(i, mid-1, key);
			}
			else{
				return bsearch(mid+1, j, key);
			}
		}
		
	}

	public static void main(String[] args){
		int[] arrInt = {3,5,8,3,2,6,18,56};
		Arrays.sort(arrInt);
		BinarySearch bs = new BinarySearch(arrInt);
		System.out.println(bs.bsearch(0, arrInt.length-1, 56));

	}
}