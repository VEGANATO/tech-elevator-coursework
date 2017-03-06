package com.techelevator.IceCreamStoreManagerSimulator;

public class TipJar {
	private double totalTips;
	
	public TipJar() {
		totalTips = 0.00;
	}
	
	public double getTotalTips() {
		return totalTips;
	}
	
	public double calculateTipShare(int numberOfCoworkers) {
		return totalTips / (numberOfCoworkers + 1);
	}
}
