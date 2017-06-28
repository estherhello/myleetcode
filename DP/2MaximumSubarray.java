/*
	原题描述：
	Find the contiguous subarray within an array (containing at least one number) 
    which has the largest sum.
    For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
    the contiguous subarray [4,-1,2,1] has the largest sum = 6.

	解析：最长连续子序列和
    典型的动态规划，找出状态转移方程：sum[i] = max{sum[i-1]+a[i], a[i]}
    如果第i个元素加进去，则说明为i之前的最优解加上i的值
    不加的话，说明前面已经不是最优解，要从i开始重新开始
    此外还要维护一个变量max存放最大值
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length];
        int max = nums[0];
        sums[0] = sums[0];
        for(int i = 1;i < nums.length;i++)
        {
            sums[i] = Math.max(nums[i], nums[i]+sums[i-1]);
            max = Math.max(max,sums[i]);
        }
    }
}

