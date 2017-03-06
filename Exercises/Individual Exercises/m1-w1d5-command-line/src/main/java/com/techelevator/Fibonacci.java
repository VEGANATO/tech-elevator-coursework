
package com.techelevator;

import java.util.Scanner;
import java.util.ArrayList;

/*
 The Fibonacci numbers are the integers in the following sequence:  
	0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
 By definition, the first two numbers in the Fibonacci sequence are 0 and 1, and each subsequent number is the sum of the previous two.
 
Write a command line program which prompts the user for an integer value and display the Fibonacci sequence leading up to that number.

  
 $ java Fiboncci
 
Please enter the Fibonacci number: 25
 
 0, 1, 1, 2, 3, 5, 8, 13, 21
 */
public class Fibonacci {

	public static void main(String[] args) {
		
		// First attempt at solution using ArrayList

//		Scanner input = new Scanner(System.in);
//		ArrayList<Integer> fibonacciList = new ArrayList<Integer>();
//		int initialSum = 0;
//
//		fibonacciList.add(0);
//		fibonacciList.add(1);
//
//		System.out.println("Please enter the Fibonacci number: ");
//
//		int upperBoundNum = Integer.parseInt(input.nextLine());
//
//		for (int i = 1; initialSum < upperBoundNum; i++) {
//			initialSum = fibonacciList.get(i) + fibonacciList.get(i - 1);
//
//			if (initialSum < upperBoundNum) {
//				fibonacciList.add(initialSum);
//			}
//		}
//
//		for (int i = 0; i < fibonacciList.size(); i++) {
//			if (i < fibonacciList.size() - 1) {
//				System.out.print(fibonacciList.get(i) + ", ");
//			} else {
//				System.out.print(fibonacciList.get(i));
//			}
//		}

		Scanner input = new Scanner(System.in);
		int sum = 0;
		int firstNum = 0;
		int secondNum = 1;
		String sequenceToUpperBound = "0, 1";

		System.out.println("Please enter the Fibonacci number: ");

		int upperBoundNum = input.nextInt();

		System.out.print(sequenceToUpperBound);
		while (sum < upperBoundNum) {
			sum = firstNum + secondNum;

			if (sum < upperBoundNum) {
				System.out.print(", " + sum);
				firstNum = secondNum;
				secondNum = sum;
				
			}
		}

		System.out.println();
	}
}
