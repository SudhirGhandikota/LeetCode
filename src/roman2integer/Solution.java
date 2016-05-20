package roman2integer;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Roman String:");
		String roman = sc.next();
		int num = convert(roman);
		System.out.println("Converted Integer value:"+num);
		sc.close();

	}

	private static int convert(String roman) {
		String dict[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int num[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		int index=0,i=0;
		int res = 0;
		while(i<roman.length() && index<13)
		{
			String r = dict[index];
			if(i+r.length()<=roman.length())
			{
				String n = roman.substring(i, i+r.length());
				if(r.equals(n))
				{
					res = res+num[index];
					i = i+r.length();
				}
				else
					index++;
			}
			else
				index++;
		}
		return res;
	}

}
