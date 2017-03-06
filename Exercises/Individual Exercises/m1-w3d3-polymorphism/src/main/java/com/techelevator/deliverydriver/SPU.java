package com.techelevator.deliverydriver;

public class SPU implements DeliveryDriver{
	private int distanceInMiles;
	private int weightInOunces;
	private int mailClass;
	
	public SPU(int distanceInMiles, int weightInOunces, int mailClass) {
		this.distanceInMiles = distanceInMiles;
		this.weightInOunces = weightInOunces;
		// For mailClass field: 1 for next day, 2 for two-day business, 3 for four-day ground
		this.mailClass = mailClass;
	}
	
	public String toString() {
		String formattedRate = String.format( "$%.2f", calculateRate(distanceInMiles, weightInOunces));
		String mailClassType = "SPU ";
		
		if (mailClass == 1) {
			mailClassType += "(next-day)";
		} else if (mailClass == 2) {
			mailClassType += "(2-day business)";
		} else {
			mailClassType += "(4-day ground)";
		}
		
		return String.format("%1$-31s %2$s", mailClassType, formattedRate);
	}

	public int getDistanceInMiles() {
		return distanceInMiles;
	}

	public int getWeightInOunces() {
		return weightInOunces;
	}

	public int getMailClass() {
		return mailClass;
	}

	public double calculateRate(int distanceInMiles, int weightInOunces) {
		double rate = 0.0;
		double weightInPounds = (double) weightInOunces / 16;
		
		if (mailClass == 1) {
			rate = 0.075;
		} else if (mailClass == 2) {
			rate = 0.050;
		} else {
			rate = 0.0050;
		}
		
		return weightInPounds * rate * distanceInMiles;
	}
}
