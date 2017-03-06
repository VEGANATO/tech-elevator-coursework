package com.techelevator.product;

public class ProductTest {

	public static void main(String[] args) {
		
		// write code here that verifies the functionality of your Product class
		
		boolean allTestsPassed = true;
		
		Product testProduct = new Product("Widgemadoo 5000", 19.99, 16);
		
		if (!testProduct.getName().equals("Widgemadoo 5000")) {
			allTestsPassed = false;
			System.out.println("Name should be Widgemadoo 5000, is: " + testProduct.getName());
		}
		if (testProduct.getPrice() != 19.99) {
			allTestsPassed = false;
			System.out.println("Price should be 19.99, is: " + testProduct.getPrice());
		}
		if (testProduct.getWeightInOunces() != 16) {
			allTestsPassed = false;
			System.out.println("weightInOunces should be 16, is: " + testProduct.getWeightInOunces());
		}
		
		testProduct.setName("iPersonality");
		testProduct.setPrice(999.99);
		testProduct.setWeightInOunces(8);
		
		
		if (!testProduct.getName().equals("iPersonality")) {
			allTestsPassed = false;
			System.out.println("Name should be iPersonality, is: " + testProduct.getName());
		}
		if (testProduct.getPrice() != 999.99) {
			allTestsPassed = false;
			System.out.println("Price should be 999.99, is: " + testProduct.getPrice());
		}
		if (testProduct.getWeightInOunces() != 8) {
			allTestsPassed = false;
			System.out.println("weightInOunces should be 8, is: " + testProduct.getWeightInOunces());
		}
		
		Product testProduct2 = new Product("697987897", -1232121, -1232132);
		
		if (allTestsPassed) {
			System.out.println("ALL TESTS PASSED!");
		}
	}

}
