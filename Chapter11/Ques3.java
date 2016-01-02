public class Ques3{

	public int modifiedBinarySearch(int[] a, int key, int p, int q){

		if(p <= q){

			int mid = (p+q)/2;
			if(a[mid] == key)
				return mid;

			if(a[mid] < a[p] && a[mid] < a[q]){
				if(key <= a[q]){
					return modifiedBinarySearch(a, key, mid+1, q);
				}
				else{
					return modifiedBinarySearch(a, key, p, mid);
				}
			}
			if(a[mid] > a[p] && a[mid] > a[q]){
				if(key <= a[q]){
					return modifiedBinarySearch(a, key, mid+1, q);
				}
				else{
					return modifiedBinarySearch(a, key, p, mid);
				}
			}
			else{
				if(key > a[mid]){
					return modifiedBinarySearch(a, key, mid+1, q);
				}
				else{
					return modifiedBinarySearch(a, key, p, mid);
				}

			}

		}
		return -1;
	}


	public static void main(String[] args){
		Ques3 solution = new Ques3();
		int[] arr = {7,10,14,15,16,19,20,25,1,3,4,5};
		int key = 3;
		System.out.println("Position of key is: "+solution.modifiedBinarySearch(arr, key, 0, arr.length-1));
	}
}