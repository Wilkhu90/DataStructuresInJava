public class Ques7{

	public int[][] setZeros(int[][] matrix) {
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		// Store the row and column index with value 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length;j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}

		// Set arr[i][j] to 0 if either row i or column j has a 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] || column[j]) {
					matrix[i][j] = 0;
				}
			}
		}
		return matrix;
	}

	public static void main(String[] args){

		int n = 3;
		int[][] matrix = {{0,2,3},{4,5,6},{7,8,9}};
		Ques7 solution = new Ques7();

		matrix = solution.setZeros(matrix);

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(matrix[i][j] + " ");	
			}
			System.out.println();
		}

	}
}