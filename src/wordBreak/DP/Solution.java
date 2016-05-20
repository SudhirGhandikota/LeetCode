package wordBreak.DP;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	/*
	 * Checks whether the str exists in the dictionary or not.
	 */
	static boolean dictionaryContains(String str)
	{
		//System.out.println("String Received for test:"+str);
		String dictionary[] = {"mobile","samsung","sam","sung","man","mango","icecream","and","go","i","like","ice","cream"};
		for(int i=0;i<dictionary.length;i++)
		{
			if(dictionary[i].compareTo(str)==0)
				return true;
		}
		return false;
	}
	
	static boolean wordBreak(String str)
	{
		List<String> list= new ArrayList();
		String result= "";
		System.out.println("String received:"+str);
		int len = str.length();
		//base condition
		if(len==0)
			return true;
		/*
		 * Create the DP table to store results of subproblems.
		 * The value wb[i] will be true if the prefix str[0..i-1] can be segmented into dictionary words.
		 * Otherwise it will be false
		 */
		boolean wb[] = new boolean[len+1];
		//initializing DP table to false
		for(int i=0;i<wb.length;i++)
			wb[i] = false;
		for(int i=1;i<=len;i++)
		{
			//check if current prefix is already false and if it can be made true
			if(wb[i]==false && dictionaryContains(str.substring(0,i)))
			{
				System.out.println("Prefix:"+str.substring(0,i));
				wb[i] = true;
				result = str.substring(0,i);
			}
			//while the prefix is true check for all substrings starting from i+1th character
			if(wb[i]==true)
			{
				//if we reached last prefix
				if(i==len)
					return true;
				for(int j=i+1;j<=len;j++)
				{
					//System.out.println("j is:"+j+" i is:"+i);
					//Check if substring from (i+1)th position is present in the dictionary
					//If yes update the entry in wb to true so that we need to check it again
					if(wb[j]==false && dictionaryContains(str.substring(i, j)))
					{
						System.out.println("Sub string found:"+str.substring(i, j));
						wb[j] = true;
						result = result+" "+str.substring(i,j);
					}
					if(j==len && wb[j]==true)
					{
						list.add(result);
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(wordBreak("ilikesamsung"));
		System.out.println(wordBreak("iiiiii"));
		System.out.println(wordBreak("ilikelikeimangoiii"));
		System.out.println(wordBreak("samsungandmango"));
		System.out.println(wordBreak("samsungandmangok"));

	}

}
