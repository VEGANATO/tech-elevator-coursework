package com.techelevator.IceCreamStoreManagerSimulator;

import java.util.Scanner;

public class UserInterface {
	private Scanner input;
	private DisplayCase displayCase;
	private TipJar tipJar;
	
	public UserInterface() {
		input = new Scanner(System.in);
		displayCase = new DisplayCase();
		tipJar = new TipJar();
	}
	
	public void start() {
		System.out.println("<3 Ice Cream Store Manager Simulator <3");
		System.out.println("      +_+_+_+_+_+_+_+_+_+_+_+_+");
		System.out.println("");
		System.out.println("Enter a Manager name to start:");
		
		String managerName = input.nextLine();
		Manager manager = new Manager(managerName);
		this.gameLoop(manager);
		
	}
	
	public void gameLoop(Manager manager) {
		
		while (manager.getMoraleLevel() > 0 ) {
			printMenuOptions();
			String choice = input.nextLine().toUpperCase();
			
			if (choice.equals("M")) {
				System.out.println(manager);
			} else if (choice.equals("MA")) {
				IceCream madeIceCream = IceCream.makeIceCream(input);
				boolean iceCreamAdded = displayCase.addIceCreamToCase(madeIceCream);
				manager.adjustMorale(iceCreamAdded);
			} else if (choice.equals("H")) {
				System.out.println("No customers, as usual. Thank God...");
			} else if (choice.equals("C")) {
				displayCase.checkCase();
			} else if (choice.equals("T")) {
				System.out.println("How many burnouts are you bossing around tonight?");
				int numberOfCoWorkers = Integer.parseInt(input.nextLine());
				double currentTipShare = tipJar.calculateTipShare(numberOfCoWorkers);
				System.out.println("Your haul is $" + currentTipShare + ". Maybe enough to afford the gas to drive home...");
			} else if (choice.equals("S")) {
				manager.slackOff();
			}
		}
	}
	
	public static void printMenuOptions() {
		System.out.println("");
		System.out.println("Choose an option: ");
		System.out.println("(M)anager Stats");
		System.out.println("(Ma)ke Ice Cream");
		System.out.println("(H)elp Customers");
		System.out.println("(C)heck Inventory");
		System.out.println("Count (T)ip Jar");
		System.out.println("(S)lack Off");
	}

}
