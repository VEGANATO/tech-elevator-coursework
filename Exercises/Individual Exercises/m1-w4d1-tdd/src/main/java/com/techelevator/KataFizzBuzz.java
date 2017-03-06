package com.techelevator;

public class KataFizzBuzz {
	
	public KataFizzBuzz() {
		
	}
	
	public String fizzBuzz(int positiveInteger) {
		
		
		if (positiveInteger % 5 == 0 &&
			positiveInteger % 3 == 0) {
			return "FizzBuzz";
		} else if (positiveInteger % 5 == 0) {
			return "Buzz";
		} else if (positiveInteger % 3 == 0) {
			return "Fizz";
		} else {
			return Integer.toString(positiveInteger);
		}
	}
	
}
