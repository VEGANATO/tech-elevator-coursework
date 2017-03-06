package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {
		
		try (Scanner userInput = new Scanner(System.in)) {
			System.out.println("Destination for FizzBuzz.txt?");
			String filePath = userInput.nextLine();
			
			writeFileFizzBuzzTo300(filePath);
		}
	}
	
	private static void writeFileFizzBuzzTo300(String filePath) {
		File fizzBuzzFile = new File(filePath + "/FizzBuzz.txt");
		
		try (PrintWriter fileOutput = new PrintWriter(fizzBuzzFile)) {
			for (int i = 1; i < 301; i++) {
				if (i % 5 == 0 &&
					i % 3 == 0) {
					fileOutput.println("FizzBuzz");
				} else if (i % 5 == 0 ||
						   containsA5(i)) {
					fileOutput.println("Buzz");
				} else if (i % 3 == 0 ||
						   containsA3(i)) {
					fileOutput.println("Fizz");
				} else {
					fileOutput.println(i);
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private static boolean containsA5(int number) {
		String numberAsString = Integer.toString(number);
		
		if (numberAsString.contains("5")) {
			return true;
		}
		return false;
	}
	
	private static boolean containsA3(int number) {
		String numberAsString = Integer.toString(number);
		
		if (numberAsString.contains("3")) {
			return true;
		}
		return false;
	}

}
