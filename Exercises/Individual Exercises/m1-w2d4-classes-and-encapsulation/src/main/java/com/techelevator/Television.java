package com.techelevator;

public class Television {
	private boolean isOn;
	private int selectedChannel;
	private int currentVolume;
	
	public Television() {
		isOn = false;
		selectedChannel = 0;
		currentVolume = 0;
	}
	
	@Override
	public String toString() {
		return "TV on? " + isOn + ", Channel: " + selectedChannel + ", Volume: " + currentVolume;
	}

	public boolean isOn() {
		return isOn;
	}

	public void turnOn() {
		if (!isOn) {
			isOn = true;
			selectedChannel = 3;
			currentVolume = 2;
			System.out.println("Welcome back!");
		}
	}
	
	public void turnOff() {
		if (isOn) {
			isOn = false;
			System.out.println("Goodbye!");
		}
	}

	public int getSelectedChannel() {
		return selectedChannel;
	}

	public void changeChannel(int newChannel) {
		if (newChannel > 0 && newChannel < 100) {
			selectedChannel = newChannel;
			System.out.println("Now watching channel " + selectedChannel);
		} else {
			System.out.println("Channel not found. Better call your cable provider and upgrade!");
		}
		
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

	public void raiseVolume() {
		if (currentVolume < 10) {
			currentVolume++;
			System.out.println("A little bit louder now!");
		} else {
			System.out.println("Probably time to start considering a hearing aid.");
		}
	}
	
	public void lowerVolume() {
		if (currentVolume > 0) {
			currentVolume--;
			System.out.println("A little bit softer now...");
		} else {
			System.out.println("Sorry, this is as quiet as it gets.");
		}
	}

}
