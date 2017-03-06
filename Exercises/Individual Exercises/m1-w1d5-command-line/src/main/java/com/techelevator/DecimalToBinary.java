package com.techelevator;

import java.util.Scanner;

/*
Write a command line program which prompts the user for a series of decimal integer values  
and displays each decimal value as itself and its binary equivalent

$ DecimalToBinary 

Please enter in a series of decimal values (separated by spaces): 460 8218 1 31313 987654321

460 in binary is 111001100
8218 in binary is 10000000011010
1 in binary is 1
31313 in binary is 111101001010001
987654321 in binary is 111010110111100110100010110001
*/
public class DecimalToBinary {

	public static void main(String[] args) {
		// My first attempt at the assignment

		// Scanner input = new Scanner(System.in);
		//
		// System.out.println("Please enter in a series of decimal values
		// (separated by spaces): ");
		//
		// String[] decimalNumbersAsStrings = input.nextLine().split(" ");
		//
		// int[] decimalNumbersAsInts = new int[decimalNumbersAsStrings.length];
		//
		// for (int i = 0; i < decimalNumbersAsStrings.length; i++) {
		// decimalNumbersAsInts[i] =
		// Integer.parseInt(decimalNumbersAsStrings[i]);
		// }
		//
		// for (int i = 0; i < decimalNumbersAsInts.length; i++) {
		// System.out.println(decimalNumbersAsInts[i] + " in binary is " +
		// Integer.toBinaryString(decimalNumbersAsInts[i]));
		// }

		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("***Binary Trans1at0r***");
			System.out.println("");
			System.out.println("What would you like to translate?");
			System.out.println("");
			System.out.println("1) Decimal to Binary");
			System.out.println("2) Binary to Decimal");

			String optionChoice = input.nextLine();

			if (optionChoice.equals("1")) {

				System.out.println("Please enter in a series of decimal values (separated by spaces): ");
				String decimalValues = input.nextLine();
				System.out.println();

				DecimalToBinary.decimalToBinary(decimalValues);

			} else if (optionChoice.equals("2")) {
				System.out.println("Please enter in a series of binary values (separated by spaces): ");
				String binaryNumber = input.nextLine();

				DecimalToBinary.binaryToDecimal(binaryNumber);
			}
		}
	}

	public static void decimalToBinary(String decimalValues) {

		int[] decimalNumbersArray = DecimalToBinary.covertToIntArray(decimalValues);

		for (int decimalNumber : decimalNumbersArray) {
			int decimalNumberAtStart = decimalNumber;
			int pow2 = 1;
			String binaryString = "";

			while (pow2 <= decimalNumber) {
				pow2 *= 2;
			}

			while (pow2 > 0) {
				if (pow2 > decimalNumber) {
					binaryString += "0";
				} else {
					binaryString += "1";
					decimalNumber -= pow2;
				}

				pow2 /= 2;
			}

			System.out.println(decimalNumberAtStart + " in binary is " + binaryString);
		}
		System.out.println();
	}

	public static void binaryToDecimal(String binaryValues) {

		String[] binaryValuesStrArr = binaryValues.split(" ");

		for (String binaryNumber : binaryValuesStrArr) {

			char[] binaryDigits = binaryNumber.toCharArray();
			int pow2 = 1;
			int decimalNumber = 0;

			for (int i = binaryDigits.length - 1; i >= 0; i--) {
				if (binaryDigits[i] == '1') {
					decimalNumber += pow2;
				}

				pow2 *= 2;
			}

			System.out.println(binaryNumber + " in decimal is " + decimalNumber);
		}
		System.out.println();
	}

	public static int[] covertToIntArray(String numbersToConvert) {
		String[] decimalNumbersAsStrings = numbersToConvert.split(" ");

		int[] decimalNumbersAsInts = new int[decimalNumbersAsStrings.length];

		for (int i = 0; i < decimalNumbersAsStrings.length; i++) {
			decimalNumbersAsInts[i] = Integer.parseInt(decimalNumbersAsStrings[i]);
		}

		return decimalNumbersAsInts;
	}
}
