package com.techelevator.person;

import junit.framework.Test;

public class PersonTest {

	public static void main(String[] args) {
		
		// write code here that verifies the functionality of the Person class
		
		boolean allTestsPassed = true;
		
		Person testPerson = new Person("Gotamin", "Spades", 53);
		
		if (!testPerson.getFirstName().equals("Gotamin")) {
			allTestsPassed = false;
			System.out.println("First name should be Gotamin, is: " + testPerson.getFirstName());
		}
		if (!testPerson.getLastName().equals("Spades")) {
			allTestsPassed = false;
			System.out.println("First name should be Spades, is: " + testPerson.getLastName());
		}
		if (testPerson.getAge() != 53) {
			allTestsPassed = false;
			System.out.println("Age should be 53, is: " + testPerson.getAge());
		}
		if (!testPerson.fullName().equals("Gotamin Spades")) {
			allTestsPassed = false;
			System.out.println("Full name should be Gotamin Spades, is: " + testPerson.fullName());
		}
		if (!testPerson.isAdult()){
			allTestsPassed = false;
			System.out.println("isAdult() should return true, is: " + testPerson.isAdult());
		}
		
		Person testPerson2 = new Person("Baronald", "McObumpa", 17);
		
		if (!testPerson2.getFirstName().equals("Baronald")) {
			allTestsPassed = false;
			System.out.println("First name should be Baronald, is: " + testPerson.getFirstName());
		}
		if (!testPerson2.getLastName().equals("McObumpa")) {
			allTestsPassed = false;
			System.out.println("First name should be McObumpa, is: " + testPerson.getLastName());
		}
		if (testPerson2.getAge() != 17) {
			allTestsPassed = false;
			System.out.println("Age should be 17, is: " + testPerson.getAge());
		}
		if (!testPerson2.fullName().equals("Baronald McObumpa")) {
			allTestsPassed = false;
			System.out.println("Full name should be Baronald McObumpa, is: " + testPerson.fullName());
		}
		if (testPerson2.isAdult()){
			allTestsPassed = false;
			System.out.println("isAdult() should return false, is: " + testPerson.isAdult());
		}
		
		testPerson2.setFirstName("Tough");
		testPerson2.setLastName("Juice");
		testPerson2.setAge(42);
		
		if (!testPerson2.getFirstName().equals("Tough")) {
			allTestsPassed = false;
			System.out.println("First name should be Tough, is: " + testPerson.getFirstName());
		}
		if (!testPerson2.getLastName().equals("Juice")) {
			allTestsPassed = false;
			System.out.println("First name should be Juice, is: " + testPerson.getLastName());
		}
		if (testPerson2.getAge() != 42) {
			allTestsPassed = false;
			System.out.println("Age should be 42, is: " + testPerson.getAge());
		}
		if (!testPerson2.fullName().equals("Tough Juice")) {
			allTestsPassed = false;
			System.out.println("Full name should be Tought Juice, is: " + testPerson.fullName());
		}
		if (!testPerson2.isAdult()){
			allTestsPassed = false;
			System.out.println("isAdult() should return true, is: " + testPerson.isAdult());
		}
		
		if (allTestsPassed) {
			System.out.println("ALL TESTS PASSED!");
		}
		
	}

}
