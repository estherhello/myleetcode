/*
	原题描述：
	Given an array of integers, return indices of the two numbers such that they add up to a specific target.
	You may assume that each input would have exactly one solution, and you may not use the same element twice.

	Example:
	Given nums = [2, 7, 11, 15], target = 9,
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].

	解析：给一个整数数组和一个数，返回整数数组中加起来正好等于所给数的两个数的下标
	难度：简单
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0;i < nums.length;i++)
        {
        	for(int j = nums.length-1;j > i;j--)
        	{
        		if((nums[i] + nums[j]) == target)
        		{
        			res[0] = i;
        			res[1] = j;
        		}
        	}
        }
        return res; 	
    }
}

