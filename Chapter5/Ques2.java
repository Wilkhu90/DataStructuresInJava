public class Ques2{

	public String displayBinary(double num){

		if(num >= 1 || num <= 0)
			return "Error";

		StringBuilder result = new StringBuilder();
		result.append(".");
		while(num > 0){
			if(result.length() >= 32)
				return "Error";
			double r = num * 2;
			if(r >=1){
				result.append("1");
				num = r - 1;
			}
			else {
				result.append("0");
				num = r;
			}
		}
		return result.toString();
	}

	public static void main(String[] args){
		Ques2 solution = new Ques2();
		System.out.println(solution.displayBinary(0.72));
		System.out.println(solution.displayBinary(0.5));
	}
}