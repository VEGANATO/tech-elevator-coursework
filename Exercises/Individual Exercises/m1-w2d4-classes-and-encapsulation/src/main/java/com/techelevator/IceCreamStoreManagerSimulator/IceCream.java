package com.techelevator.IceCreamStoreManagerSimulator;

import java.util.Scanner;

public class IceCream {
	private String flavor;
	private int iceCreamQuality; // 1-10
	private int percentOfPanFilled; // For now, percentage of pan filled will use integers 1-100 as value
	
	public IceCream(String flavor, int factor) {
		this.flavor = flavor;
		this.iceCreamQuality = calculateIceCreamQuality(factor);
		percentOfPanFilled = calculatePercentOfPanFilled(factor);
	}
	
	@Override
	public String toString() {
		return "Flavor: " + flavor + " | Quality [1-10]: " + iceCreamQuality + " | Percent Left [1-10]: " + percentOfPanFilled;
	}
	
	public String getFlavor() {
		return flavor;
	}
	
	public static int calculateIceCreamQuality(int factor) {
		if (factor > 0 && factor < 10) {
			return factor;
		} else {
			return 4;
		}
	}
	
	public static int calculatePercentOfPanFilled(int factor) {
		if (factor > 0 && factor < 10) {
			return factor * 10;
		} else {
			return 60;
		}
	}
	
	public static IceCream makeIceCream(Scanner input) {
		System.out.println("Choose a flavor: ");
		System.out.println("(S)weet Cream");
		System.out.println("(C)ake Batter");
		System.out.println("(P)istachio");
		System.out.println("Sugar-(F)ree Sweet Cream");
		
		String choice = input.nextLine().toUpperCase();
		
		if (choice.equals("S")) {
			return makeSweetCream(input);
		} else if (choice.equals("C")) {
			return makeCakeBatter(input);
		} else if (choice.equals("P")) {
			return makePistachio(input);
		} else if (choice.equals("F")) {
			return makeSugarFreeSweetCream(input);
		}
		
		return new IceCream("Sweet Cream", 5);
	}
	
	public static IceCream makeSweetCream(Scanner input) {
		System.out.println("Sweet Cream it is. How motivated are you feeling today, scale from 1-10?");
		Integer motivation = Integer.parseInt(input.nextLine());
		
		System.out.println("Making ice cream...");
		return new IceCream("Sweet Cream", motivation);
	}
	
	public static IceCream makeCakeBatter(Scanner input) {
		System.out.println("Cake Batter it is. How motivated are you feeling today, scale from 1-10?");
		Integer motivation = Integer.parseInt(input.nextLine());
		
		System.out.println("Making ice cream...");
		return new IceCream("Cake Batter", motivation);
	}
	
	public static IceCream makePistachio(Scanner input) {
		System.out.println("Pistachio it is. How motivated are you feeling today, scale from 1-10?");
		Integer motivation = Integer.parseInt(input.nextLine());
		
		System.out.println("Making ice cream...");
		return new IceCream("Pistachio", motivation);
	}
	
	public static IceCream makeSugarFreeSweetCream(Scanner input) {
		System.out.println("Sugar-Free Sweet Cream, great. This is gonna suck...");
		Integer motivation = Integer.parseInt(input.nextLine());
		
		System.out.println("Making ice cream...");
		// because sfsc always sucks
		return new IceCream("Sugar-Free Sweet Cream", 3);
	}

}
