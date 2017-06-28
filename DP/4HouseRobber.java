/*
	原题描述：
	You are a professional robber planning to rob houses along a street. 
    Each house has a certain amount of money stashed, the only constraint 
    stopping you from robbing each of them is that adjacent houses have 
    security system connected and it will automatically contact the police 
    if two adjacent houses were broken into on the same night.

    Given a list of non-negative integers representing the amount of money of 
    each house, determine the maximum amount of money you can rob tonight without 
    alerting the police.

	解析：即给一组正数数组，求不相邻元素的最大和
    可找出递推式：f[i] = max(f[i-2]+nums[i], f[i-1])
    
*/

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }else {
            if(nums.length == 1)
            {
                return nums[0];
            }else{
                f[0] = nums[0];
                f[1] = Math.max(nums[0], nums[1]);
                for(int i = 1;i < nums.length;i++)
                {
                    f[i] = Math.max(f[i-2]+nums[i], f[i-1]);
                }
                return f[nums.length-1];
            }
        }

    }
}
