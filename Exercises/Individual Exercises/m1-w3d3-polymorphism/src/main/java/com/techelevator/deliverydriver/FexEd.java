package com.techelevator.deliverydriver;

public class FexEd implements DeliveryDriver {
	private int distanceInMiles;
	private int weightInOunces;
	
	public FexEd(int distanceInMiles, int weightInOunces) {
		this.distanceInMiles = distanceInMiles;
		this.weightInOunces = weightInOunces;
	}
	
	public String toString() {
		String formattedRate = String.format( "$%.2f", calculateRate(distanceInMiles, weightInOunces));
		return String.format("%1$-31s %2$s", "FexEd", formattedRate);
	}

	public int getDistanceInMiles() {
		return distanceInMiles;
	}

	public int getWeightInOunces() {
		return weightInOunces;
	}
	
	public double calculateRate(int distanceInMiles, int weightInOunces) {
		double rate = 20.00;
		
		if (distanceInMiles > 500) {
			rate += 5.00;
		}
		
		if (weightInOunces > 48) {
			rate+= 3.00;
		}
		
		return rate;
	}
}
