/*
	原题描述：
	Design an algorithm to find the maximum profit. You may complete as many 
    transactions as you like (ie, buy one and sell one share of the stock multiple times). 
    However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    给一个数组代表第i天股票的价格，问怎么买卖能赚取最大利润(可多次买卖)，注：买要在卖之前，并且同一时间
    只能有一股在手

	解析：这个更简单了，题目要求可以多次买卖，但是同一时间只能有一股在手里。
    这样就可以在每次上升子序列之前买入，在上升子序列结束的时候卖出。相当于能够获得所有的上升子
    序列的收益。而且，对于一个上升子序列，比如：5，1，2，3，4，0 中的1，2，3，4序列来说，
    对于两种操作方案：
    一，在1买入，4卖出；
    二，在1买入，2卖出同时买入，3卖出同时买入，4卖出；
    这两种操作下，收益是一样的。


    所以算法就是：从头到尾扫描prices，如果i比i-1大，那么price[i] – price[i-1]就可以计入
    最后的收益中。这样扫描一次O(n)就可以获得最大收益了。


*/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1 || prices == null)
            return 0;

        int max = 0;//代表最大利润

        for(int i = prices.length-1;i > 0 ;i--)
        {
            if(prices[i] > prices[i-1])
            {
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
}

