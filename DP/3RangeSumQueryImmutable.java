/*
	原题描述：
	Given an integer array nums, find the sum of the 
    elements between indices i and j (i ≤ j), inclusive.

    Example:
    Given nums = [-2, 0, 3, -5, 2, -1]

    sumRange(0, 2) -> 1
    sumRange(2, 5) -> -1
    sumRange(0, 5) -> -3

    Note:
    You may assume that the array does not change.
    There are many calls to sumRange function.

	解析：因为要求很多次所以用动规
*/

public class NumArray {
    
    private int[] dp;

    public NumArray(int[] nums) {
        dp = new int[nums.length];
        int sum = 0;
        for(int i =0;i < nums.length;i++)
        {
            sum += nums[i];
            dp[i] = sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return i == 0 ? dp[j] : dp[j]-dp[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
