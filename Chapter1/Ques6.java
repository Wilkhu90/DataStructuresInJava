public class Ques6{

	public int[][] rotate(int[][] matrix, int n){

		for (int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			System.out.println(first);
			System.out.println(last);
			for(int i = first; i < last; ++i) {
				System.out.println(i);
				int offset = i - first;
				// save top
				int top = matrix[first][i];
				// left -> top
				matrix[first][i] = matrix[last-offset][first];
				// bottom -> left
				matrix[last-offset][first] = matrix[last][last - offset];
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				// top -> right
				matrix[i][last] = top;
			}
		}
		return matrix;
	}

	public static void main(String[] args){

		int n = 3;
		int[][] matrix = new int[n][n];
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		matrix[0][2] = 3;
		matrix[1][0] = 4;
		matrix[1][1] = 5;
		matrix[1][2] = 6;
		matrix[2][0] = 7;
		matrix[2][1] = 8;
		matrix[2][2] = 9;
		Ques6 solution = new Ques6();
		matrix = solution.rotate(matrix, n);

		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				System.out.println(matrix[i][j]);		

	}
}
