public class MaxHeap{

	int maxHeap[];
	int maxSize;
	int heapSize;

	public MaxHeap(int MxSz){
		maxSize = MxSz;
		heapSize = 0;
		maxHeap = new int[maxSize];
	}

	public boolean isEmpty(){

		return heapSize == 0;
	}

	public boolean insert(int item){

		if (heapSize + 1 == maxSize){
			return false;
		}

		maxHeap[++heapSize] = item;
		int pos = heapSize;

		while (pos != 1 && item > maxHeap[pos/2]){
			maxHeap[pos] = maxHeap[pos/2];
			pos /= 2; 
		}

		maxHeap[pos] = item;
		return true;
	}
	// Always removing the max item from the heap.
	public int remove(){

		/*int result = maxHeap[0];
		maxHeap[0] = maxHeap[heapSize];
		int pos = -1;
		int newPos = 0;

		while(pos <= heapSize && pos < newPos){
			pos = newPos;
			if (maxHeap(2*pos + 1) > maxHeap(2*pos + 2) && 
				maxHeap(2*pos + 1) > maxHeap[pos]){
				//swap
				newPos = 2*pos + 1;
			}
			else if (maxHeap(2*pos + 1) < maxHeap(2*pos + 2) && 
				maxHeap(2*pos + 2) > maxHeap[pos]){
				//swap
				newPos = 2*pos + 2;*/
		int parent, child;
        int item, temp;

        if (isEmpty() )
            throw new RuntimeException("Error : Heap empty!");

        item = maxHeap[1];
        temp = maxHeap[heapSize--];

        parent = 1;
        child = 2;

        while (child <= heapSize){

            if (child < heapSize && maxHeap[child] < maxHeap[child + 1])
                child++;

            if (temp >= maxHeap[child])
                break;

            maxHeap[parent] = maxHeap[child];
            parent = child;
            child *= 2;
        }
        maxHeap[parent] = temp;
	    return item;
	}
	


	public void displayHeap(){

        /* Array format */
        System.out.print("\nHeap array: ");    
        for(int i = 1; i <= heapSize; i++)
            System.out.print(maxHeap[i] +" ");
        System.out.println("\n");

    }  

    public static void main(String[] args){

    	MaxHeap mxheap = new MaxHeap(10);
    	mxheap.insert(3);
    	mxheap.insert(4);
    	mxheap.insert(5);
    	mxheap.insert(6);
    	mxheap.insert(1);
    	mxheap.insert(2);

    	mxheap.displayHeap();

    	mxheap.remove();
    	mxheap.remove();
    	mxheap.displayHeap();

    }



}