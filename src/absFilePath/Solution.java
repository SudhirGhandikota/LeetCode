package absFilePath;

import java.util.Stack;

/*
 * Solution to "Longest Absolute File path" problem in LeetCode
 * https://leetcode.com/problems/longest-absolute-file-path/
 * Sample I/P: "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
 * O/P: 20(longest path: dir/subdir2/file.ext)
 */
public class Solution {
	/*
	 * method returns the path with the longest length
	 * Strategy is to maintain length of each level in a stack
	 * if a file is encountered(if the string contains a .) then the length of the path to that file is stored
	 */
	public int lengthLongestPath(String input)
	{
		String[] tokens = input.split("\n");//splitting each level
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		int curLen = 0; //maintains the length of current depth/level directory
		for(String s : tokens)
		{
			System.out.println("Current Level:"+s);
			int level = getLevel(s);
			// if the current depth/level of the directory is lower or equal to the current level already in the stack
			while(stack.size()>level)
			{
				//we are coming back up levels so curLen should also be moved to the earlier depths
				curLen-=stack.pop();
			}
			int len = s.replaceAll("\t", "").length()+1;//adding 1 to length because the "/" after each level has to be counted
			curLen+=len;
			if(s.contains("."))//if the string contains a ".". Indicates we found a file
			{
				result = curLen -1 > result ? curLen -1 : result; //subtracting -1 because we have considered the ending  "/" earlier. We should remove that as a file is found
			}
			stack.add(len);//storing length of current depth in stack
		}
		return result;
	}
	/*
	 * This method returns the level of directory/file
	 * The depth/level of the directory is calculated by counting the "/t" delimiter
	 */
	private int getLevel(String s)
	{
		String temp = s.replaceAll("\t", ""); //replace \t with null values
		return s.length() - temp.length();//the difference in lengths would give the count of \t's thus the level/depth
	}
	public static void main(String[] args)
	{
		String path = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		System.out.println(new Solution().lengthLongestPath(path));
	}

}
