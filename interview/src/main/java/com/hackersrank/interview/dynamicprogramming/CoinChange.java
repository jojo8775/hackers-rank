package com.hackersrank.interview.dynamicprogramming;

import java.util.Scanner;

public class CoinChange
{
	public static void main(String[] args)
	{
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scanner = new Scanner(System.in);

		int sum = scanner.nextInt();
		int arrLength = scanner.nextInt();

		int[] coins = new int[arrLength];
		for (int i = 0; i < arrLength; i++)
		{
			coins[i] = scanner.nextInt();
		}

		long[][] board = new long[arrLength][sum + 1];

		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				if (j == 0)
				{
					board[i][j] = 1;
				}
				else if (j < coins[i])
				{
					if (i > 0)
					{
						board[i][j] = board[i - 1][j];
					}
				}
				else
				{
					if (i > 0)
					{
						board[i][j] = board[i - 1][j] + board[i][j - coins[i]];
					}
					else
					{
						board[i][j] = board[i][j - coins[i]];
					}
				}
			}
		}

		System.out.println(board[arrLength - 1][sum]);
	}
}
