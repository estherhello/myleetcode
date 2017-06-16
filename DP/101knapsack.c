#include<stdio.h>
int c[10][100];
/*
http://blog.sina.com.cn/s/blog_6dcd26b301013810.html
http://blog.csdn.net/mu399/article/details/7722810
背包九讲之一
*/

int knapsack(int n, int m)
{
	int i,j,w[10],p[10];
	for(i = 1;i < n+1;i++)
	{
		scanf("\n%d %d",&w[i],&p[i]);
	}

	for(i = 0;i < 10;i++)
	{
		for(j = 0;j < 100;j++)
		{
			c[i][j] = 0;
		}
	}

	for(i = 1;i < n+1;i++)
	{
		for(j = 1;j < m+1;j++)
		{
			if(w[i] < j)
			{
				if(p[i]+c[i-1][j-w[i]] > c[i-1][j])
				{
					c[i][j] = p[i]+c[i-1][j-w[i]];
				}else{
					c[i][j] = c[i-1][j];
				}
			}else{
				c[i][j] = c[i-1][j];
			}
		}
	}

	return c[n][m];
}

void main()
{
	int n,m,i,j;
	printf("请输入物品个数和背包承重：");
	scanf("%d %d",&n,&m);
	printf("请依次输入物品的重量和价值：");
	printf("%d",knapsack(n,m));
	printf("\n");
	for(i = 0;i < 10;i++)
	{
		for(j = 0;j < 15;j++)
		{
			printf("%d  ",c[i][j]);
			if(j == 14)
				printf("\n");
		}
	}

	system("pause");
}
