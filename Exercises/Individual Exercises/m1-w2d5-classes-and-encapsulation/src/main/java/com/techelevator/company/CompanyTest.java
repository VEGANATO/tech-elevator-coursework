package com.techelevator.company;

public class CompanyTest {

	public static void main(String[] args) {
		
		// write code here that verifies the functionality of the Company class
		
		boolean allTestsPassed = true;
		
		// Company 1
		
		Company testCompany = new Company("ConglomoCorp", 600, 2000000.00, 1500000.00);
		
		if(!testCompany.getName().equals("ConglomoCorp")) {
			allTestsPassed = false;
			System.out.println("Company name should be ConglomoCorp, is: " + testCompany.getName());
		}
		if(testCompany.getNumberOfEmployees() != 600) {
			allTestsPassed = false;
			System.out.println("Number of employees should be 600, is: " + testCompany.getNumberOfEmployees());
		}
		if(testCompany.getRevenue() != 2000000.00) {
			allTestsPassed = false;
			System.out.println("Revenue should be 2000000.00, is: " + testCompany.getRevenue());
		}
		if(testCompany.getExpenses() != 1500000.00) {
			allTestsPassed = false;
			System.out.println("Expenses should be 1500000.00, is: " + testCompany.getExpenses());
		}
		if(!testCompany.getCompanySize().equals("large")) {
			allTestsPassed = false;
			System.out.println("Company size should be large, is: " + testCompany.getCompanySize());
		}
		if(testCompany.getProfit() != 500000.00) {
			allTestsPassed = false;
			System.out.println("Revenue should be 500000.00, is: " + testCompany.getProfit());
		}
		
		// Testing setNumberOfEmployees(), setName(), getCompanySize()
		
		testCompany.setNumberOfEmployees(49);
		testCompany.setName("Plucky Start-Up, LLC");
		
		if(testCompany.getNumberOfEmployees() != 49) {
			allTestsPassed = false;
			System.out.println("Number of employees should be 49, is: " + testCompany.getNumberOfEmployees());
		}
		if(!testCompany.getCompanySize().equals("small")) {
			allTestsPassed = false;
			System.out.println("Company size should be small, is: " + testCompany.getCompanySize());
		}
		if(!testCompany.getName().equals("Plucky Start-Up, LLC")) {
			allTestsPassed = false;
			System.out.println("Company name should be Plucky Start-Up, LLC, is: " + testCompany.getName());
		}
		
		testCompany.setNumberOfEmployees(132);

		if (testCompany.getNumberOfEmployees() != 132) {
			allTestsPassed = false;
			System.out.println("Number of employees should be 132, is: " + testCompany.getNumberOfEmployees());
		}
		if (!testCompany.getCompanySize().equals("medium")) {
			allTestsPassed = false;
			System.out.println("Company size should be medium, is: " + testCompany.getCompanySize());
		}
		
		// Testing setRevenue(), setExpenses(), getProfit()
		
		testCompany.setRevenue(200000.00);
		testCompany.setExpenses(150000.00);
		
		if(testCompany.getRevenue() != 200000.00) {
			allTestsPassed = false;
			System.out.println("Revenue should be 200000.00, is: " + testCompany.getRevenue());
		}
		if(testCompany.getExpenses() != 150000.00) {
			allTestsPassed = false;
			System.out.println("Expenses should be 150000.00, is: " + testCompany.getExpenses());
		}
		if(testCompany.getProfit() != 50000.00) {
			allTestsPassed = false;
			System.out.println("Revenue should be 50000.00, is: " + testCompany.getProfit());
		}
		
		testCompany.setRevenue(-200000.00);
		testCompany.setExpenses(-1000000.00);
		
		if(testCompany.getRevenue() != 200000.00) {
			allTestsPassed = false;
			System.out.println("Revenue should be 200000.00, is: " + testCompany.getRevenue());
		}
		if(testCompany.getExpenses() != 150000.00) {
			allTestsPassed = false;
			System.out.println("Expenses should be 150000.00, is: " + testCompany.getExpenses());
		}
		if(testCompany.getProfit() != 50000.00) {
			allTestsPassed = false;
			System.out.println("Revenue should be 50000.00, is: " + testCompany.getProfit());
		}
		
		// Testing after adding no-args constructor, additional setter methods
		
		Company defaultCompany = new Company();
		
		if(!defaultCompany.getName().equals("Working Title Inc.")) {
			allTestsPassed = false;
			System.out.println("Company name should be Working Title Inc., is: " + testCompany.getName());
		}
		if(defaultCompany.getNumberOfEmployees() != 0) {
			allTestsPassed = false;
			System.out.println("Number of employees should be 0, is: " + testCompany.getNumberOfEmployees());
		}
		if(defaultCompany.getRevenue() != 0.0) {
			allTestsPassed = false;
			System.out.println("Revenue should be 0.0, is: " + testCompany.getRevenue());
		}
		if(defaultCompany.getExpenses() != 0.0) {
			allTestsPassed = false;
			System.out.println("Expenses should be 0.0, is: " + testCompany.getExpenses());
		}
		if(!defaultCompany.getCompanySize().equals("small")) {
			allTestsPassed = false;
			System.out.println("Company size should be small, is: " + testCompany.getCompanySize());
		}
		if(defaultCompany.getProfit() != 0.0) {
			allTestsPassed = false;
			System.out.println("Revenue should be 0.0, is: " + testCompany.getProfit());
		}
		
		defaultCompany.setName(null);
		
		if(!defaultCompany.getName().equals("Working Title Inc.")) {
			allTestsPassed = false;
			System.out.println("Company name should be Working Title Inc., is: " + testCompany.getName());
		}
		
		defaultCompany.setName("");
		
		if(!defaultCompany.getName().equals("Working Title Inc.")) {
			allTestsPassed = false;
			System.out.println("Company name should be Working Title Inc., is: " + testCompany.getName());
		}
		
		
		if (allTestsPassed) {
			System.out.println("ALL TESTS PASSED!");
		}
		
	}

}
