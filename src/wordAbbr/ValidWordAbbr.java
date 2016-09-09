package wordAbbr;

import java.util.HashMap;

/*
 * Solution to Valid Word Abbreviation problem
 * https://leetcode.com/problems/unique-word-abbreviation/
 * We contain two hashmaps, one contains the words in the dictionary and their frequency
 * The other one saves the abbreviation word and their frequency
 * The logic is, if the abbreviation of the word being searched is not present in the abbreviation map(no other word in the dictionary have this abbreviation) we return a true
 * But if the abbreviation of the word being searched does exist in the abbreviation map, we have to make sure the frequencies match in both maps.
 * The intuition here is since no other word should have the same abbreviation as the word being searched, we maintain the count of the words in the dictionary and also the count of the abbreviations and make sure they match
 * 
 */
public class ValidWordAbbr {
	private HashMap<String,Integer> abbrmap = new HashMap<String,Integer>();
	private HashMap<String, Integer> wordmap = new HashMap<String, Integer>();
	
	public boolean isUnique(String s)
	{
		//if the word is null
		if(s==null ||s.length()==0)
			return true;
		String abbr = getAbbr(s);
		//if the abbreviation does not exist
		if(!abbrmap.containsKey(abbr))
			return true;
		//if the abbreviation already exists we make sure the frequencies match to make sure no other words having the same abbreviation are not present in the word dictionary
		else if(abbrmap.containsKey(abbr) && abbrmap.get(abbr)==wordmap.get(s))
			return true;
		return false;
	}
	public ValidWordAbbr(String[] dictionary)
	{
		buildMap(dictionary);
	}
	//builds the maps
	private void buildMap(String[] dictionary) {
		for(String s : dictionary){
			//if word is not already present in the word dictionary
			if(!wordmap.containsKey(s))
				wordmap.put(s, 1);
			//if the word is already present in the word dictionary we update the frequency
			else
				wordmap.put(s, wordmap.get(s)+1);
		
			String abbr = getAbbr(s);
			//if the abbreviation is not present in the abbreviation dictionary
			if(!abbrmap.containsKey(abbr))
				abbrmap.put(abbr, 1);
			////if the abbreviation is already present in the abbreviation dictionary we update the frequency
			else
				abbrmap.put(abbr, abbrmap.get(abbr)+1);
		}
	}
	//returns the abbreviation of the word
	private String getAbbr(String s)
	{
		//case where the string only has 1 or 2 characters
		if(s.length()<3)
			return s;
		//constructing the abbreviation of the word
		StringBuffer sb = new StringBuffer();
		sb.append(s.charAt(0));
		sb.append(s.length()-2);
		sb.append(s.charAt(s.length()-1));
		return sb.toString();
	}
	public static void main(String[] args) {
		String dictionary[] = {"hello"};
		ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
		System.out.println(vwa.isUnique("hello"));

	}

}
