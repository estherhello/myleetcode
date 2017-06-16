/*
	原题描述：
	Say you have an array for which the ith element is the price of a given stock on day i.
    Design an algorithm to find the maximum profit. You may complete at most two transactions.
    Note:
    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    Subscribe to see which companies asked this question.
	解析：http://blog.csdn.net/fightforyourdream/article/details/14503469


*/

/**
*方法一：求p[0~n-1]两个最大值可以转换成求p[0~j]和p[j~n-1]最大值，然后把两个最大值相加
*维护两个临时数组left[i]和right[i]
*left[i]记录了0~j的最大值
*right[i]记录了j~n-1的最大值
**/

public class Solution{
    public int maxProfit(int[] prices)
    {
        if(prices.length <= 1 || prices == null)return 0;

        int max = 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        process(prices, left, right);

        for(int i = 0;i < prices.length;i++)
        {
            max = Math.max(max, left[i]+right[i]);
        }
        return max;

    }

    public static void process(int[] prices, int[] left, int[] right)
    {
        //求0~j最大值，存入left[i]
        int min = prices[0];//最低买入价
        left[0] = 0;
        for(int i = 1;i < prices.length;i++)
        {
            left[i] = Math.max(left[i-1], prices[i]-min);
            min = Math.min(min, prices[i]);//更新最小买入价
        }

        //求j~n-1最大值，存入right[i]
        int max = prices[prices.length-1];//最高卖出价
        right[right.length-1] = 0;
        for(int j = right.length-2;i > 0;i--)
        {
            right[i] = Math.max(right[i+1], max-prices[i]);
            max = Math.max(max,prices[i]);//更新最高卖出价
        }
    }
}


/**
*方法二：求解k次方法，令k = 2
*关键在于找递推公式：局部最优和全局最优
*global[i][j]代表第i天最多进行j次交易后所获利益，local[i][j]代表当前到达第i天，
*最多可进行j次交易，并且最后一次交易在当天卖出的最好的利润
*则global[i][j]=max{global[i-1][j],local[i][j]}
*  local[i][j]=max{global[i-1][j-1]+max{diff,0}, local[i-1][j]+diff}
*全局（到达第i天进行j次交易的最大收益） = max{局部（在第i天交易后，恰好满足j次交易），全局（到达第i-1天时已经满足j次交易）}
*局部（在第i天交易后，总共交易了j次） =  max{情况2，情况1}
*情况1：在第i-1天时，恰好已经交易了j次（local[i-1][j]），那么如果i-1天到i天再交易一次：即在第i-1天买入，第i天卖出（diff），则这不并不会增加交易次数！【例如我在第一天买入，第二天卖出；然后第二天又买入，第三天再卖出的行为  和   第一天买入，第三天卖出  的效果是一样的，其实只进行了一次交易！因为有连续性】
*情况2：第i-1天后，共交易了j-1次（global[i-1][j-1]），因此为了满足“第i天过后共进行了j次交易，且第i天必须进行交易”的条件：我们可以选择1：在第i-1天买入，然后再第i天卖出（diff），或者选择在第i天买入，然后同样在第i天卖出（收益为0）。
**/

public class Solution{
    public int maxProfit(int[] prices)
    {
        if(prices.length <= 1 || prices == null)return 0;
        return maxPro(prices, 2);
    }

    public int maxPro(int[] prices, int k)
    {
        int len = prices.length;
        int[][] global = new int[len][k+1];
        int[][] local = new int[len][k+1];

        for(int i = 1; i < len;i++)
        {
            int diff = prices[i]-prices[i-1];
            for(int j = 1; j <= k;j++)
            {
                local[i][j] = Math.max(global[i-1][j-1]+Math.max(diff, 0), local[i-1][j]+diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[len-1][k];
    }
}
