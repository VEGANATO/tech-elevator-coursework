package com.techelevator.company;

public class Company {

	/*
	 * 
	 * The Company class has the following properties name numberOfEmployees
	 * revenue expenses companySize * profit **
	 */
	/*
	 * Please select an appropriate data type, and write a getter and setter for
	 * each property listed above. Note, some properties may or may not require
	 * both a getter and a setter.
	 * 
	 * Use the main method in PersonTest.java to verify the functionality of the
	 * Person class. (Please see notes in PersonTest.java for further
	 * instructions.)
	 * 
	 * companySize is derived (i.e. calculated), and does not need a setter. A
	 * company is "small" if less than 50 employees, "medium" if between 51 and
	 * 250 employees, "large" if greater than 250 employees.
	 ** 
	 * profit is derived (i.e. calculated), and does not need a setter. Profit
	 * equals revenue minus expenses.
	 * 
	 */

	//
	// Write your code below
	//

	private String name;
	private int numberOfEmployees;
	private double revenue;
	private double expenses;
	
	public Company() {
		name = "Working Title Inc.";
		numberOfEmployees = 0;
		revenue = 0.0;
		expenses = 0.0;
	}

	public Company(String name, int numberOfEmployees, double revenue, double expenses) {
		this.setName(name);
		this.setNumberOfEmployees(numberOfEmployees);
		this.setRevenue(revenue);
		this.setExpenses(expenses);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOFEmployees) {
		if (numberOFEmployees > 0) {
			this.numberOfEmployees = numberOFEmployees;
		}
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		if (revenue >= 0) {
			this.revenue = revenue;
		} else {
			System.out.println("Negative numbers not accepted!");
		}
	}

	public double getExpenses() {
		return expenses;
	}

	public void setExpenses(double expenses) {
		if (expenses >= 0) {
			this.expenses = expenses;
		} else {
			System.out.println("Negative numbers not accepted!");
		}
	}

	public String getCompanySize() {
		if (numberOfEmployees > 250) {
			return "large";
		} else if (numberOfEmployees > 50) {
			return "medium";
		}
		
		return "small";
	}

	public double getProfit() {
		return revenue - expenses;
	}

}
