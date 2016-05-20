package Levenshtien;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * This class finds the list of Levenshtein distances of the given word with all the words
 * in the dictionary. It then displays the closest possible word if any wrongly spelt word is found
 */
public class Solution {

	static int getLevenshtien(String a, String b)
	{
		int m = a.length();
		int n = b.length();
		if(m==0)
			return n;
		if(n==0)
			return m;
		//Make sure m is smallest as we will loop over m
		if(m>n)
		{
			int t = m;
			m = n;
			n = t;
		}
		int diff = n - m;
		int cost = 0;
		for(int i=0;i<m;i++)
			cost = cost + (a.charAt(i)==b.charAt(i) ? 0 : 1);
		cost = cost + diff;
		return cost;
	}
	public static void main(String[] args) {
		String text = "In computer science, approximate string matching,"
				+ "often colloquially referred to as fuzzy string searching "
				+ "is the technique of finding strings that match a pattern approximately rather than exactly."
				+ "The problem of approximate string matching is typically divided into two sub-problems: "
				+ "finding approximate substring matches inside a given string and"
				+ "dictionary strings that match the pattern approximately.";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter keyword to search");
		String keyword = sc.next();
		String data[] = text.split(" ");
		TreeMap<Integer,String> map = new TreeMap();
		int dist = 0;
		for(int i=0;i<data.length;i++)
		{
			dist = getLevenshtien(data[i],keyword);
			if(map.containsKey(dist))
			{
				String word = map.get(dist);
				if(!data[i].toLowerCase().equals(word.toLowerCase()))
					map.put(dist, word+","+data[i]);
			}
			else
				map.put(dist, data[i]);
		}
		System.out.println("Did you mean:");
		Map.Entry<Integer, String> entry= map.entrySet().iterator().next();
		System.out.println("Distance is:"+entry.getKey());
		System.out.println("Word is:"+entry.getValue().split(",")[0]);
		

	}

}
