public class QuickSort{

	int[] arr;
	public QuickSort(int[] arr){
		this.arr = arr;
	}

	public int[] sort(int p, int r){
		if (p < r){
			int q = partition(p,r);
			sort(p,q-1);
			sort(q+1,r);
		}
		return this.arr;
	}

	public int partition(int p, int r){
		int tmp = -100;
		int randomIndex = (int) Math.random()*(r-p) + p;
		tmp  = arr[randomIndex];
		this.arr[randomIndex] = this.arr[r];
		this.arr[r] = tmp;
		int pivot = this.arr[r];
		
		int i = p-1;
		for (int j=p; j<r; j++){
			if (this.arr[j]<=pivot){
				i = i+1;
				tmp  = this.arr[i];
				this.arr[i] = this.arr[j];
				this.arr[j] = tmp;
			}
		}
		tmp = this.arr[i+1];
		this.arr[i+1] = this.arr[r];
		this.arr[r] = tmp;

		return i+1;

	}


	public static void main(String [] args){

		int[] arrInt = {3,5,8,3,2,6,18,56};
		QuickSort qSort = new QuickSort(arrInt);
		arrInt = qSort.sort(0, arrInt.length-1);
		for (int item : arrInt)
			System.out.println(item);

	}
}