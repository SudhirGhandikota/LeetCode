package integer2roman;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = sc.nextInt();
		sc.close();
		String roman = convert(n);
		System.out.println("Converted Roman String is:"+roman);
	}

	private static String convert(int n) {
		StringBuilder sb = new StringBuilder();
		String dict[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		int val[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		for(int i=0;i<dict.length;i++)
		{
			if(n>=val[i])
			{
				int count = n/val[i];
				n %= val[i];
				for(int j=0;j<count;j++)
					sb.append(dict[i]);
			}
		}
		return sb.toString();
		}
}
