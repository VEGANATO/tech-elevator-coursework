package com.techelevator.calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		
		boolean allTestsPassed = true;
		
		/*** Result is initialized to zero by the no-arg constructor ***/
		Calculator calculator = new Calculator();
		if(calculator.getResult() != 0) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The result should start at zero when a Calculator is created using the no-arg constructor.");
		}
		
		/*** Result is initialized to parameter value when constructor parameter is provided ***/
		calculator = new Calculator(3);
		if(calculator.getResult() != 3) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The result should have started at 3, but it is "+calculator.getResult());
		}
		
		/*** Reset should set the result to zero ***/
		calculator.reset();
		if(calculator.getResult() != 0) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The result should be zero after the calculator is reset, but it is "+calculator.getResult());
		}
		
		/*** Add should add the supplied parameter to the running result and return the new result ***/
		int result = calculator.add(1);
		if(result != 1) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The returned result should be 1 after adding 1 but it was "+result);
		}
		result = calculator.add(3);
		if(result != 4) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The returned result should be 4 after adding 1 and 3 but it was "+result);
		}
		
		if(calculator.getResult() != 4) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The running result should be 4 after adding 1 and 3 but it is "+result);
		}
		
		result = calculator.subtract(2);
		if (result != 2) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The returned result should be 2 after subtracting 2 but it is "+result);
		}
		
		result = calculator.subtract(3);
		if (result != -1) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The returned result should be -1 after subtracting 3 but it is "+result);
		}
		
		if(calculator.getResult() != -1) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The running result should be -1 after subtracting 3 but it is "+result);
		}
		
		calculator.reset();
		
		result = calculator.multiply(5);
		if (result != 0) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The returned result should be 0 after multiplying 0 by 5 but it is "+result);
		}
		
		calculator.add(1);
		result = calculator.multiply(5);
		if (result != 5) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The returned result should be 5 after multiplying 1 by 5 but it is "+result);
		}
		
		result = calculator.multiply(4);
		if (result != 20) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The returned result should be 20 after multiplying 5 by 4 but it is "+result);
		}
		
		if(calculator.getResult() != 20) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The running result should be 20 after multiplying 5 by 4 but it is "+result);
		}
		
		calculator = new Calculator(2);
		result = calculator.power(2);
		if (result != 4) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The returned result should be 4 after raising 2 by 2 but it is "+result);
		}
		
		result = calculator.power(-2);
		if (result != 16) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The returned result should be 16 after raising 4 by 2 but it is "+result);
		}
		
		if(calculator.getResult() != 16) {
			allTestsPassed = false;
			System.out.println("Test FAILED: The running result should be 16 after raising 4 by 2 but it is "+result);
		}
		/******************************************************************
		 * ADD MORE TESTS FOR THE REST OF THE FUNCTIONALITY OF Calculator *
		 ******************************************************************/
				
		if(allTestsPassed) {
			System.out.println("All tests PASSED!");
		}

	}

}
