/*
	原题描述：
	Say you have an array for which the ith element is the price of a given stock on day i.
    If you were only permitted to complete at most one transaction (ie, buy one and sell 
    one share of the stock), design an algorithm to find the maximum profit.
    给一个数组代表第i天股票的价格，问怎么买卖能赚取最大利润，注：买要在卖之前

	Example 1:
    Input: [7, 1, 5, 3, 6, 4]
    Output: 5
    max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

    Example 2:
    Input: [7, 6, 4, 3, 1]
    Output: 0
    In this case, no transaction is done, i.e. max profit = 0.

	解析：这道题只让做一次transaction，那么就需要找到价格最低的时候买，价格最高的时候卖（买价的日期早于卖价的日期）。
    从而转化为在最便宜的时候买入，卖价与买价最高的卖出价最大时，就是我们要得到的结果。
    因为我们需要买价日期早于卖价日期，所以不用担心后面有一天价格特别低，而之前有一天价格特别高而错过
    了（这样操作是错误的）。所以，只许一次遍历数组，维护一个最小买价，和一个最大利润(保证了买在卖前面）即可
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1 || prices == null)
            return 0;

        int max = 0;//代表最大利润
        int min = prices[0];//代表最小值，即买入价格

        for(int i = 0;i <prices.length;i++)
        {
            min = Math.min(prices[i], min);//先存储最小值
            max = Math.max(prices[i]-min, max);
        }
        return max;
    }
}

