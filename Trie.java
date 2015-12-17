import java.util.*;
class TrieNode{
	char value;
	HashMap<Character, TrieNode> children;
	boolean isWord;

	public TrieNode(char ch){
		value = ch;
		children = new HashMap<>();
		isWord = false;
	}

}

public class Trie{

	TrieNode root;

	public Trie(){
		root = new TrieNode((char) 0 );
	}

	public void insert(String word){
		TrieNode crawl = root;

		for(int i=0; i<word.length(); i++){
			char ch = word.charAt(i);

			if (crawl.children.containsKey(ch))
				crawl = crawl.children.get(ch);
			else{
				TrieNode temp = new TrieNode(ch);
				crawl.children.put(ch, temp);
				crawl = temp;

			}
		}
		crawl.isWord = true;

	}

	public String contains(String word){
		String result = "";
		TrieNode crawl = root;

		int previousMatch = 0;
		for(int i=0; i<word.length(); i++){
			char ch = word.charAt(i);

			if (crawl.children.containsKey(ch)){
				crawl = crawl.children.get(ch);
				result += ch;

				if (crawl.isWord)
					previousMatch = i+1;
			}
			else
				break;
		}
		if ( !crawl.isWord ){
			return result.substring(0, previousMatch);
		}
		else
			return result;

	}

	public static void main(String[] args){
		Trie dict = new Trie();        
        dict.insert("are");
        dict.insert("area");
        dict.insert("base");
        dict.insert("cat");
        dict.insert("cater");        
        dict.insert("basement");

        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(dict.contains(input));              
 
        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(dict.contains(input));                      
         
        input = "are";
        System.out.print(input + ":   ");
        System.out.println(dict.contains(input));              
 
        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(dict.contains(input));              
 
        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(dict.contains(input));                      
         
        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(dict.contains(input));
        
        
	}
}