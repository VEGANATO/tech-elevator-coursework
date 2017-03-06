package com.techelevator.deliverydriver;

public class PostalService implements DeliveryDriver {
	private int distanceInMiles;
	private int weightInOunces;
	private int mailClass;
	
	

	public PostalService(int distanceInMiles, int weightInOunces, int mailClass) {
		this.distanceInMiles = distanceInMiles;
		this.weightInOunces = weightInOunces;
		this.mailClass = mailClass;
	}
	
	//return String.format("%1$-31s %2$s", mailClassType, formattedRate);
	
	public String toString() {
		String formattedRate = String.format("$%.2f", calculateRate(distanceInMiles, weightInOunces));
		String formattedMailClass = "Postal Service (" + this.mailClass;
		
		if (mailClass == 1) {
			formattedMailClass += "st Class)";
		} else if (mailClass == 2) {
			formattedMailClass += "nd Class)";
		} else {
			formattedMailClass += "rd Class)";
		}
		
		return String.format("%1$-31s %2$s", formattedMailClass, formattedRate);
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

	

	@Override
	public double calculateRate(int distanceInMiles, int weightInOunces) {
		double ratePerMile = 0.0;
		
		if (mailClass < 3) {
			ratePerMile = firstAndSecondClassRatePerMile(mailClass, weightInOunces);
		} else {
			ratePerMile = thirdClassRatePerMile(weightInOunces);
		}
		
		return (double) ratePerMile * distanceInMiles;
	}


	public double firstAndSecondClassRatePerMile(int mailClass, int weightInOunces) {
		double ratePerMile = 0.0;

		if (weightInOunces <= 15) {
			if (weightInOunces <= 2) {
				ratePerMile = 0.035;
			} else if (weightInOunces <= 8) {
				ratePerMile = 0.040;
			} else {
				ratePerMile = 0.047;
			}
		} else {
			if (weightInOunces < 64) {
				ratePerMile = 0.195;
			} else if (weightInOunces < 143) {
				ratePerMile = 0.450;
			} else {
				ratePerMile = 0.500;
			}
		}
		
		if (mailClass == 2) {
			ratePerMile *= 0.1;
		}
		
		return ratePerMile;
	}
	
	public double thirdClassRatePerMile(int weightInOunces) {
		double ratePerMile = 0.0;

		if (weightInOunces <= 15) {
			if (weightInOunces <= 2) {
				ratePerMile = 0.0020;
			} else if (weightInOunces <= 8) {
				ratePerMile = 0.0022;
			} else {
				ratePerMile = 0.0024;
			}
		} else {
			if (weightInOunces < 64) {
				ratePerMile = 0.0150;
			} else if (weightInOunces < 143) {
				ratePerMile = 0.0160;
			} else {
				ratePerMile = 0.0170;
			}
		}
		
		return ratePerMile;
	}
}
