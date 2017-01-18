package removeVowels;

public class Solution {

	/* This method removes all the vowels from a string */
	public String removeVowel(String s, String v){
		StringBuilder res = new StringBuilder();
		String word = s.toLowerCase();
		String vowels = v.toLowerCase();
		for(int i=0;i<word.length();i++){
			if(vowels.indexOf(word.charAt(i)) > -1)
				continue;
			res.append(word.charAt(i));
		}
		//return "test";
		return res.toString();
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.removeVowel("leetcode", "aeiou"));

	}

}
