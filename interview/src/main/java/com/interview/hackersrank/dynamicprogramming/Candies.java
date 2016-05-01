package com.interview.hackersrank.dynamicprogramming;

import java.util.Scanner;

public class Candies
{
	public static void main(String[] args)
	{
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */

		Scanner scanner = new Scanner(System.in);

		int arrLength = scanner.nextInt();
		int[] ratings = new int[arrLength];

		for (int i = 0; i < arrLength; i++)
		{
			ratings[i] = scanner.nextInt();
		}

		int[] candiesGiven = new int[arrLength];
		for (int i = 0; i < arrLength; i++)
		{
			candiesGiven[i] = 1;
		}

		for (int i = 1; i < candiesGiven.length; i++)
		{
			if (ratings[i - 1] < ratings[i])
			{
				candiesGiven[i] = candiesGiven[i - 1] + 1;
			}
		}

		for (int i = candiesGiven.length - 2; i >= 0; i--)
		{
			if (ratings[i] > ratings[i + 1])
			{
				if (candiesGiven[i] <= candiesGiven[i + 1])
				{
					candiesGiven[i] = candiesGiven[i + 1] + 1;
				}
			}
		}

		long totalCandies = 0;
		for (int i = 0; i < candiesGiven.length; i++)
		{
			totalCandies += candiesGiven[i];
		}

		System.out.println(totalCandies);
	}
}
