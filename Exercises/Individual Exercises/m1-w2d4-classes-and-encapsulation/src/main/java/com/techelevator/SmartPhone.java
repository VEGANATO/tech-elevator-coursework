package com.techelevator;

public class SmartPhone {
	private String phoneNumber;
	private String carrier;
	private String operatingSystem;
	private int batteryCharge;
	private boolean onCall;
	

	public SmartPhone(String phoneNumber) {
		this.setPhoneNumber(phoneNumber);
		carrier = "Metro PCS";
		operatingSystem = "Windows XP";
		batteryCharge = 5;
		onCall = false;
	}
	
	@Override
	public String toString() {
		return "Phone number: " + phoneNumber + ", On Call? " + onCall;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		if (carrier != null && !carrier.isEmpty()) {
			this.carrier = carrier;
		}
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		if (operatingSystem != null && !operatingSystem.isEmpty()) {
			this.operatingSystem = operatingSystem;
		}
	}

	public int getBatteryCharge() {
		return batteryCharge;
	}

	public void setBatteryCharge(int batteryCharge) {
		if (batteryCharge >= 0) {
			this.batteryCharge = batteryCharge;
		}
	}

	public boolean isOnCall() {
		return onCall;
	}

	public void setOnCall(boolean onCall) {
		this.onCall = onCall;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public boolean checkPhoneNumber(String phoneNumber) {
		if (phoneNumber != null && !phoneNumber.isEmpty()) {
			if (phoneNumber.length() == 10) {
				return true;
			}
		}
		
		System.out.println(phoneNumber + " is not a valid phone number.");
		return false;
	}

	public void setPhoneNumber(String phoneNumber) {
		if (checkPhoneNumber(phoneNumber)) {
				this.phoneNumber = phoneNumber;
				System.out.println(phoneNumber + " is now active.");
			}
	}
	
	public boolean call(String phoneNumberToCall) {
		if (!onCall) {
			if (checkPhoneNumber(phoneNumberToCall)) {
				onCall = true;
				System.out.println("Calling " + phoneNumberToCall + "....");
				return true;
			}
		} else {
			System.out.println("Call cannot be completed until you have hung up the line.");
		}
		
		return false;
	}

	public void answer() {
		if (!onCall) {
			onCall = true;
			System.out.println("This better be important...");
		} else {
			System.out.println("I got someone on the other line...They can wait.");
		}
	}
	
	public void hangUp() {
		if (onCall) {
			onCall = false;
			System.out.println("Phone call hung up.");
		} else {
			System.out.println("Can't hang up unless your on the line, champ.");
		}
	}

}
