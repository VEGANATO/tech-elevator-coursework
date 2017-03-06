package com.techelevator.deliverydriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		List<DeliveryDriver> distributionHub = new ArrayList<DeliveryDriver>();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter the weight of the package: ");
		int weightInOunces = Integer.parseInt(input.nextLine());
		
		System.out.println("(P)ounds or (O)unces?");
		String poundsOrOunces = input.nextLine();

		
		if (poundsOrOunces.equals("P")) {
			weightInOunces = convertPoundsToOunces(weightInOunces);
		} 
		
		System.out.println("What distance will it be traveling to? ");
		int distanceInMiles = Integer.parseInt(input.nextLine());
		
		distributionHub.add(new PostalService(distanceInMiles, weightInOunces, 1));
		distributionHub.add(new PostalService(distanceInMiles, weightInOunces, 2));
		distributionHub.add(new PostalService(distanceInMiles, weightInOunces, 3));
		distributionHub.add(new FexEd(distanceInMiles, weightInOunces));
		distributionHub.add(new SPU(distanceInMiles, weightInOunces, 1));
		distributionHub.add(new SPU(distanceInMiles, weightInOunces, 2));
		distributionHub.add(new SPU(distanceInMiles, weightInOunces, 3));
		
		System.out.println("");
		System.out.println("Delivery Method                 $ cost");
		System.out.println("--------------------------------------");
		
		for (DeliveryDriver driver : distributionHub) {
			System.out.println(driver);
		}
	}
	
	public static int convertPoundsToOunces(int weightInPounds) {
		return weightInPounds * 16;
	}
	
}
