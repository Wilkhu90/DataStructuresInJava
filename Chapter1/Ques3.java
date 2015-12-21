public class Ques3{

	public int lastChar(char[] charSet){
		int j;
		for (j=charSet.length-1; j>=0; j--){
			if(charSet[j] != ' ')
				return j;
		}
		return j;
	}

	public char[] replaceString(char[] charSet){
		
		for(int i=0; i<charSet.length; i++){
			if(charSet[i] == ' '){
				int tmp = lastChar(charSet);
				while(tmp > i){
					charSet[tmp+2] = charSet[tmp];
					tmp--;
				}
				charSet[i] = '%';
				charSet[i+1] = '2';
				charSet[i+2] = '0';
			}
		}
		return charSet;
	}


	public static void main(String[] args){

		char[] charSet ={'M','r',' ','J','o','h','n',' ','S','m','o',' ',' ',' ',' '};

		Ques3 solution = new Ques3();
		String res = new String(solution.replaceString(charSet));
		System.out.println(res);		

	}
}