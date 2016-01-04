import java.util.*;
public class Ques6{

	public boolean findflement(int[][] matrix, int element) {
		int row = 0;
		int col = matrix[0].length - 1;
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == element)
				return true;
			else if (matrix[row][col] > element)
				col--;
			else
				row++;
		}
	return false;
	}
	public static void main(String[] args){
		Ques6 solution = new Ques6();
		int[][] matrix = {{15,20,40,85},{20,35,80,95},
			{30,55,95,105},
			{40,80,100,120}};
		System.out.println(solution.findflement(matrix, 95));
	}
}