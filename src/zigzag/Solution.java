package zigzag;

import java.util.Scanner;

/*
 * Prints the given string in zig-zag form
 */
public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String:");
		String s = sc.next();
		System.out.println("Enter rows");
		int n = sc.nextInt();
		System.out.println("Entered String:"+s+" Entered rows:"+n);
		System.out.println(convert(s,n));

	}

	private static String convert(String s, int n) {
		//base case
		if(n==1)
			return s;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++)
		{
			//Even rows case
			if(i%2==0)
			{
				int j=i;
				while(j<s.length())
				{
					System.out.print(s.charAt(j));
					sb.append(s.charAt(j));
					System.out.print(" ");
					j = j+(n+(n%2));
				}
				System.out.println();
			}
			//Odd rows case
			if(i%2==1)
			{
				int j=i;
				while(j<s.length())
				{
					System.out.print(s.charAt(j));
					sb.append(s.charAt(j));
					j = j+(n-(1));
				}
				System.out.println();
			}
		}
		return sb.toString();
		
	}

}
