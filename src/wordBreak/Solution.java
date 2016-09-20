package wordBreak;

public class Solution {

	/*
	 * Checks whether the str exists in the dictionary or not.
	 * https://leetcode.com/problems/word-break/
	 * I/P: s= "leetcode", dict=["leet","code"] O/P: true
	 */
	static boolean dictionaryContains(String str)
	{
		String dictionary[] = {"mobile","samsung","sam","sung","man","mango","icecream","and","go","i","like","ice","cream"};
		for(int i=0;i<dictionary.length;i++)
		{
			if(dictionary[i].compareTo(str)==0)
				return true;
		}
		return false;
	}
	/*
	 * This method returns true if the string can be segmented into space separated words
	 * that are part of the dictionary
	 * It tries prefixes of all length and recursively checks the possible suffixes
	 */
	static boolean WordBreak(String str)
	{
		System.out.println("String found:"+str);
		//base condition
		if(str.length()==0)
			return true;
		int len = str.length();
		//trying all prefixes from lengths 1 to size
		for(int i=1;i<=len;i++)
		{
			/*
			 * str.substring(0,i) is the prefix of length i
			 * We check if the current prefix is in dictionary.
			 * Then we check recursively for the remaining string
			 * str.substr(i,size-i) which is suffix of length size-i
			 */
			if(dictionaryContains(str.substring(0,i))&& WordBreak(str.substring(i, len)))
			{
				System.out.println("Prefix found is:"+str.substring(0, i));
				return true;
			}
				
		}
		return false;
	}
	public static void main(String[] args) {
		
		System.out.println(WordBreak("ilikesamsung"));
		System.out.println(WordBreak("iiiiii"));
		System.out.println(WordBreak("ilikelikeimangoiii"));
		System.out.println(WordBreak("samsungandmango"));
		System.out.println(WordBreak("samsungandmangok"));

	}

}
