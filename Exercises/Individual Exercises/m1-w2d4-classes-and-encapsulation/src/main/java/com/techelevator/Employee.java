package com.techelevator;

public class Employee {
	private String employeeId;
	private String name;
	private String department;
	private int annualSalary;

	public Employee() {
		employeeId = "000001";
		name = "Joe Schmo";
		department = "Paperpushing";
		annualSalary = 16000;
	}

	public Employee(String employeeId, String name, String department, int annualSalary) {
		this.setEmployeeId(employeeId);
		this.setName(name);
		this.setDepartment(department);
		this.setAnnualSalary(annualSalary);
	}
	
	@Override
	public String toString() {
		return "Name: " + name + ", Annual Salary: " + annualSalary;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		if (employeeId != null && !employeeId.isEmpty()) {
			this.employeeId = employeeId;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		if (department != null && !department.isEmpty()) {
			this.department = department;
		}
	}

	public int getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(int annualSalary) {
		if (annualSalary >= 0) {
			this.annualSalary = annualSalary;
		}
	}

	public void raiseSalary(int percent) {
		if (percent > 0) {
			double raisePercent = (double) percent / 100;
			int raiseInDollars = (int) (annualSalary * raisePercent);
			annualSalary += raiseInDollars;
			System.out.println(
					"You're a real go-getter, " + name + ". We're raising your salary " + percent + " percent!");
		} else {
			System.out.println("Sorry, " + name + ". No budget for raises this year.");
		}
	}
}
