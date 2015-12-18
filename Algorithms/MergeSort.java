public class MergeSort{

	int[] arr; 
	public MergeSort(int[] arr){
		this.arr = arr;
	}

	public int[] sort(int low, int high){
		if (low < high){
			int mid = (low+high)/2;
			sort(low, mid);
			sort(mid+1, high);
			merge(low, mid, high);
		}
		return this.arr;
	}

	public void merge(int low, int mid, int high){

		int[] arrNew = new int[this.arr.length];
		for(int i=low; i<=high; i++){
			arrNew[i] = this.arr[i];
		}

		int i = low;
		int j = mid+1;
		int k = low;

		while(i<=mid && j<=high){

			if(arrNew[i]<=arrNew[j]){
				this.arr[k] = arrNew[i];
				i++;
			}
			else{
				this.arr[k] = arrNew[j];
				j++;
			}
			k++;
		}

		while(i<=mid){
			this.arr[k] = arrNew[i];
			i++;
			k++;
		}

	}


	public static void main(String[] args){
		int[] arrInt = {3,5,8,3,2,6,18,56};
		MergeSort mSort = new MergeSort(arrInt);
		arrInt = mSort.sort(0, arrInt.length-1);
		for (int item : arrInt)
			System.out.println(item);
	}
}