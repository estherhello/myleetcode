/*
	原题描述：
	In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
	You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number and column number of the wanted reshaped matrix, respectively.
	The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
	If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

	Example 1:
	Input: 
	nums = 
	[[1,2],
	 [3,4]]
	r = 1, c = 4
	Output: 
	[[1,2,3,4]]
	Explanation:
	The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.

	Example 2:
	Input: 
	nums = 
	[[1,2],
	 [3,4]]
	r = 2, c = 4
	Output: 
	[[1,2],
	 [3,4]]
	Explanation:
	There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
	Note:
	The height and width of the given matrix is in range [1, 100].
	The given r and c are all positive.

	解析：给一个m*n的矩阵，将它转换成r*c的输出，保证m*n = r*c
	难度：简单
*/

public class Solution{
	public int[][] matrixReshape(int[][] nums, int r,int c)
	{
		int[][] res = new int[r][c];//用来存放转换后的矩阵，所以初始为r行c列

		int a = 0;//新矩阵行标
		int b = 0;//新矩阵列标

		//判断矩阵为空或者不可转换（二维矩阵行=arr.length，列=arr[0].length）
		if(nums.length == 0 || r*c != nums.length*nums[0].length)
		{	
			return nums;
		}else{
			for(int i = 0;i < nums.length;i++)
			{
				for(int j = 0;j < nums[0].length;j++)
				{
					res[a][b] = nums[i][j];
					b++;
					//一行转换结束
					if(b == c)
					{
						a++;
						b = 0;
					}
				}
			}
			return res;
		}


	}
}

