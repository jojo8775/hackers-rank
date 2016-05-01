package com.interview.hackersrank.dynamicprogramming;

import java.util.Scanner;

public class StockMaximise
{
	/**
	 *Algo:
	 *1. Find the max profit day
	 *2. Buy all shares till that day and sell it on the max profit day 
	 *3. If the max profit day is not the end of day then repeat it from current max index to last element.  
	 */
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
        int testCount = scanner.nextInt();
        
        for(int x=0; x<testCount; x++){
            int numberOfDays = scanner.nextInt();
            int[] rates = new int[numberOfDays];
           
            for(int j=0; j<numberOfDays; j++){
                rates[j] = scanner.nextInt();
            }
            
            long profit = 0;
            
            int currentMax = rates[numberOfDays-1];
            
            for(int i=numberOfDays-2; i>=0; i--){
            	//if there is a better day than current max then making it current max
                if(rates[i] > currentMax){
                    currentMax = rates[i];
                }
                //Buy on all other days and sell it on the current max day
                else{
                    profit += currentMax - rates[i];
                }
            }
            
            System.out.println(profit);
        }
	}
}
