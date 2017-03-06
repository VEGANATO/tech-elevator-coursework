package com.techelevator.swtch; // "swtch" misspelling intentional, "switch" is a Java keyword, and not allowed in package name.

/**
 * This class represents an on-off switch. It turns on. It turns off. And, you can even ask if it's on, or off.
 */
public class Switch {

	//
	// Add any properties, along with getters and/or setters, that may be needed to implements the class methods.
	//
	private boolean isOn;

	public Switch() {
		isOn = false;
	}
	
	/**
	 * Turns the switch on.
	 */
	public void turnOn() {
		isOn = true;
	}
	
	/**
	 * Turns the switch off.
	 */
	public void turnOff() {
		isOn = false;
	}
	
	/**
	 * @return true if the switch is currently on, otherwise false
	 */
	public boolean isOn() {
		return isOn;
	}
	
	/**
	 * @return true if the switch is currently off, otherwise false
	 */
	public boolean isOff() {
		return !isOn;
	}
	
}
