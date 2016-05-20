package longestPrefix;

public class Solution {

	public static void main(String[] args) {
		String strs[] = {"cash","castle","car"};
		String prefix = longestCommonPrefix(strs);
		System.out.println("Longest Common Prefix is:"+prefix);
	}

	private static String longestCommonPrefix(String[] strs) {
		if(strs.length==0)
			return "";
		if(strs.length==1)
			return strs[0];
		String str = strs[0];
		
		//comparing each character of the first string
		for(int i=0;i<str.length();i++)
		{
			char c = str.charAt(i);
			//comparing the prefix of first string with rest of the strings in the array
			for(int j=1;j<strs.length;j++)
			{
				//checks for the end of the prefix
				if(strs[j].length()==i || strs[j].charAt(i)!=c)
					return str.substring(0,i);
			}
		}
		return str;
	}

}
