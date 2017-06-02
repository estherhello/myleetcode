/*
	原题描述：
	Given an array of integers and an integer k, find out whether there are two distinct indices i and j 
    in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

	Example:
	无

	解析：给一个整数数组和k，找出数组中是否存在两个下标为i和j，使得nums[i]=nums[j]，并且|i-j|<=k
	难度：这题对我来说已经有点难了，用一个长度为k的集合，既保证了|i-j|<=k，又保证了有重复元素的时候跳出
    （集合特性：元素不重复）
*/

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> s = new HashSet<Interge>();
        for(int i = 0;i < nums.length;i++)
        {
            //保证长度小于k，大于k的时候就去掉第一个元素
            if(s.size() > k)
            {
                s.remove(nums[i-k-1]);
            }

            //如果向集合中加入元素失败，即说明集合中有重复元素，则符合题意
            if(!s.add(nums[i]))
            {
                return true;
            }
        }
        return false;
    }
}

