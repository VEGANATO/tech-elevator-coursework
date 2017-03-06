package com.techelevator;

public class Exercises {
	
	public static void main (String[] args) {
		//--------------------------------------------------
		// Homework Assignment
		HomeworkAssignment newAssignment = new HomeworkAssignment();
		
		newAssignment.setSubmitter("Brian");
		newAssignment.setPossibleMarks(100);
		newAssignment.setTotalMarks(101);
		System.out.println(newAssignment.getLetterGrade());
		System.out.println("--------------------------------------");
		System.out.println("");
		
		//--------------------------------------------------
		// Fruit Tree
		FruitTree testTree = new FruitTree("Mango", 12);
		System.out.println(testTree);
		System.out.println("");
		
		testTree.pickFruit(4);
		testTree.pickFruit(4);
		testTree.pickFruit(4);
		testTree.pickFruit(2);
		System.out.println("");
		
		System.out.println("----------------------");
		System.out.println("");
		
		//--------------------------------------------------
		// Employee
		Employee joeSchmo = new Employee();
		System.out.println(joeSchmo);
		System.out.println("");
		
		joeSchmo.raiseSalary(50);
		System.out.println(joeSchmo);
		joeSchmo.raiseSalary(0);
		System.out.println(joeSchmo);
		joeSchmo.raiseSalary(-1);
		System.out.println(joeSchmo);
		System.out.println("");
		System.out.println("-----------------------");
		System.out.println("");
		
		
		
		//--------------------------------------------------
		// Airplane
		Airplane testAirplane = new Airplane(15, 70);
		System.out.println(testAirplane);
		System.out.println("");
		
		testAirplane.reserveSeats(true, 10);
		System.out.println(testAirplane);
		testAirplane.reserveSeats(false, 50);
		System.out.println(testAirplane);
		testAirplane.reserveSeats(true, 10);
		System.out.println(testAirplane);
		System.out.println("");
		System.out.println("-------------------------------------");
		
		
		//--------------------------------------------------
		// SmartPhone
		SmartPhone testPhone = new SmartPhone("6145555555");
		System.out.println(testPhone);
		SmartPhone testPhone2 = new SmartPhone("345");
		System.out.println(testPhone2);
		System.out.println("");
		
		testPhone.answer();
		testPhone.answer();
		testPhone.hangUp();
		testPhone.answer();
		testPhone.hangUp();
		testPhone.hangUp();
		System.out.println("");
		
		testPhone.call("6145556666");
		testPhone.call("6145556667");
		testPhone.hangUp();
		testPhone.call("6145556667");
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("");
		
		//--------------------------------------------------
		// Television
		
		Television testTV = new Television();
		System.out.println(testTV);
		System.out.println("");
		
		testTV.turnOn();
		System.out.println(testTV);
		System.out.println("");
		
		testTV.changeChannel(99);
		testTV.changeChannel(34);
		testTV.changeChannel(101);
		System.out.println(testTV);
		System.out.println("");
		
		testTV.lowerVolume();
		testTV.lowerVolume();
		testTV.lowerVolume();
		System.out.println("");
		
		for (int i = 0; i < 11; i++) {
			testTV.raiseVolume();
		}
		System.out.println("");
		
		testTV.turnOff();
		System.out.println("-------------------------------------");
	
		//--------------------------------------------------
		// Elevator Test
		
		Elevator testElevator = new Elevator(100);
		System.out.println(testElevator);
		System.out.println("");
		
		testElevator.goUp(80);
		System.out.println(testElevator);
		System.out.println("");
		
		testElevator.goDown(70);
		System.out.println(testElevator);
		System.out.println("");
		
		testElevator.goDown(30);
		System.out.println(testElevator);
		System.out.println("");
		
		testElevator.goDown(-1);
		System.out.println(testElevator);
		System.out.println("");
	}

}
