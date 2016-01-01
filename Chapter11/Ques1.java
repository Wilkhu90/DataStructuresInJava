public class Ques1{

	public int[] mergeAWithB(int[] A, int[] B, int k){

		int i = A.length -1;
		int j = B.length -1;

		while(k>=0 && j>=0){
			if(A[k] < B[j]){
				A[i] = B[j];
				i--;
				j--;
			}
			else{
				A[i] = A[k];
				i--;
				k--;
			}
		}
		while(j>=0){
			A[i] = B[j];
			i--;
			j--;
		}
		return A;
	}

	public static void main(String[] args){

		Ques1 solution = new Ques1();
		int[] A = new int[10];
		A[0] = 1;
		A[1] = 3;
		A[2] = 5;
		A[3] = 7;
		A[4] = 9;
		int[] B = new int[5];
		B[0] = 2;
		B[1] = 4;
		B[2] = 6;
		B[3] = 8;
		B[4] = 10;
		A = solution.mergeAWithB(A, B, 4);
		for(int i=0; i<A.length; i++)
			System.out.println(A[i]);

	}
}