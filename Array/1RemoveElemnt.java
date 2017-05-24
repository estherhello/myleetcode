/*
	原题描述：
	Given an array and a value, remove all instances of that value in place and return the new length.
	Do not allocate extra space for another array, you must do this in place with constant memory.
	The order of elements can be changed. It doesn't matter what you leave beyond the new length.

	Example:
	Given input array nums = [3,2,2,3], val = 3
	Your function should return length = 2, with the first two elements of nums being 2.

	解析：给一个数组和一个值，原地移除数组中和给定值相等的元素，返回新数组的长度
	（不要为另外的数组申请额外的空间）
	难度：简单
*/

public class Solution{
	public int removeElement(int nums[], int val)
	{
		int j = 0;//新的计数值
		for(int i = 0;i < nums.length;i++)
		{
			//判断不等于的，然后增计数值
			if(nums[i] != val)
			{
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
	}
}

