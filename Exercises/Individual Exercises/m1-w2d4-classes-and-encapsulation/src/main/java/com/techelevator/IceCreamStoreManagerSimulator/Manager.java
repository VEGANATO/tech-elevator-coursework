package com.techelevator.IceCreamStoreManagerSimulator;

public class Manager {
	private String name;
	private int moraleLevel; // 0-10
	private double totalTips;
	// private int rank;

	public Manager(String name) {
		this.name = name;
		moraleLevel = 5;
		totalTips = 0.00;
	}

	@Override
	public String toString() {
		return "<3 Current Manager: " + name + " | Tips: " + totalTips + " | Morale [0-10]: " + moraleLevel + " <3";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoraleLevel() {
		return moraleLevel;
	}

	public void setMoraleLevel(int moraleLevel) {
		int moraleLevelBefore = this.moraleLevel;

		if (moraleLevel > -1 && moraleLevel <= 10)
			this.moraleLevel = moraleLevel;

		if (this.moraleLevel > moraleLevelBefore) {
			System.out.println("Morale increased by " + (this.moraleLevel - moraleLevelBefore) + "!");
		} else if (this.moraleLevel < moraleLevelBefore) {
			System.out.println("Morale decreased by " + (moraleLevelBefore - this.moraleLevel) + "!");
		}
	}

	public void adjustMorale(boolean success) {
		if (success) {
			System.out.println("Maybe today will be a good day...");
			setMoraleLevel(moraleLevel + 1);
		} else {
			System.out.println("How much more of my soul can this job suck out?");
			setMoraleLevel(moraleLevel - 1);
		}
	}

	public double getTotalTips() {
		return totalTips;
	}

	public void setTotalTips(double totalTips) {
		this.totalTips = totalTips;
	}

	public void slackOff() {
		System.out.println("Working hard, or hardly working? I prefer the later...");
		setMoraleLevel(moraleLevel + 1);
	}

}
