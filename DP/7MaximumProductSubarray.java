/*
	原题描述：
	Find the contiguous subarray within an array (containing at least one number) 
	which has the largest product.

	For example, given the array [2,3,-2,4],
	the contiguous subarray [2,3] has the largest product = 6.

	解析：求最大连续子序列乘积，注意有正负之分，所以维护两个递推式
	max_temp = max{nums[i]*max_temp,nums[i]*min_temp,nums[i]}
	min_temp = min{nums[i]*max_temp,nums[i]*min_temp,nums[i]}
*/

public class Solution {
    public int maxProduct(int[] nums) {
    	int max_temp = nums[0];
    	int min_temp = nums[0];
    	int maxProduct = nums[0];

    	for(int i = 1;i < nums.length;i++)
    	{
    		int a = nums[i]*max_temp;
    		int b = nums[i]*min_temp;
    		max_temp = Math.max(nums[i], Math.max(a, b));
    		min_temp = Math.min(nums[i], Math.min(a, b));
    		maxProduct = Math.max(maxProduct, max_temp);
    	}
        return maxProduct;
    }
}