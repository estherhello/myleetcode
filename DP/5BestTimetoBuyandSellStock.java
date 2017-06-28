/*
	原题描述：
	Say you have an array for which the ith element is the price of a given stock on day i.
    If you were only permitted to complete at most one transaction 
    (ie, buy one and sell one share of the stock), design an algorithm 
    to find the maximum profit.

    Example 1:
    Input: [7, 1, 5, 3, 6, 4]
    Output: 5

    max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
    Example 2:
    Input: [7, 6, 4, 3, 1]
    Output: 0

    In this case, no transaction is done, i.e. max profit = 0.

	解析：递推式：
    local[i][j]代表第i天恰好进行j次交易所获利益
    local[i][j] = max{global[i-1][j-1]+max{diff,0}, local[i-1][j]+diff}
    global[i][j] = max{global[i-1][j],local[i][j]}
*/

