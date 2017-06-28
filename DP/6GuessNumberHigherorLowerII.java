/*
	原题描述：
	We are playing the Guess Game. The game is as follows:
    I pick a number from 1 to n. You have to guess which number I picked.
    Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
    However, when you guess a particular number x, and you guess wrong, you pay $x. 
    You win the game when you guess the number I picked.

    Example:
    n = 10, I pick 8.

    First round:  You guess 5, I tell you that it's higher. You pay $5.
    Second round: You guess 7, I tell you that it's higher. You pay $7.
    Third round:  You guess 9, I tell you that it's lower. You pay $9.

    Game over. 8 is the number I picked.

    You end up paying $5 + $7 + $9 = $21.
    Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.

	解析：即求猜对时最坏情况下最小花费
    假设取k，k属于[1,n]，则递推式为：
    dp[i][j]为区间[i,j]中最小花费·
    dp[i][j] = min{k+max{dp[i][k-1], dp[k+1][j]} },k属于[1,n]
*/

public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int L = n-1;L > 0;L--)
        {
            for(int R = L+1;R <= n;R++)
            {
                dp[L][R] = Integer.MAX_VALUE;
                for(int i = L;i < R;i++)
                {
                    dp[L][R] = Math.min(dp[L][R], i+Math.max(dp[L][i-1], dp[i+1][R]));
                }
            }
        }
        return dp[1][n];
    }
}