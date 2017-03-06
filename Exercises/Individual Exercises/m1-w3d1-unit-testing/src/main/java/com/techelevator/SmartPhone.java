package com.techelevator;

public class SmartPhone {

    private String phoneNumber;
    private String carrier;
    private String operatingSystem;
    private boolean onCall;
    private int batteryCharge = 100;

    /**
     * Creates a new smart phone 
     * @param phoneNumber
     * @param carrier
     */
    public SmartPhone(String phoneNumber, String carrier)
    {
        this.phoneNumber = phoneNumber;
        this.carrier = carrier;
    }

    /**
     * 10-digit phone number
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;            
    }
    
	public void setPhoneNumber(String phoneNumber) {
		if (phoneNumber.length() == 10) {
			this.phoneNumber = phoneNumber;
		}
	}

    /**
     * Phone carrier
     * @return carrier
     */
    public String getCarrier() {
        return carrier;            
    }

    /**
     * Phone OS
     * @return operatingSystem
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * Phone OS
     * @param operatingSystem 
     */
    public void setOperatingSystem(String operatingSystem){
    	this.operatingSystem = operatingSystem;
    }

    /**
     * Battery charge value from 0 to 100 
     * @return batteryCharge
     */
    public int getBatteryCharge() {
        return batteryCharge;            
    }

    /**
     * On Call status
     * @return onCall
     */
    public boolean isOnCall() {
        return onCall;            
    }

    /**
     * 
     * @param phoneNumberToCall places a phone call<
     * @param numberOfMinutesToTalk 1 minute drains 1% of battery
     * @return True if the call could be placed, false otherwise
     */
	public boolean call(String phoneNumberToCall, int numberOfMinutesToTalk) {
		if (!onCall && (batteryCharge >= numberOfMinutesToTalk)) {
			onCall = true;
			batteryCharge -= numberOfMinutesToTalk;
			return true;
		}

		return false;
	}
 
    /**
     * Answer the phone. OnCall will be set to true. Battery juice is free when you answer the phone 
     */
	public void answerPhone() {
		if (!onCall && batteryCharge > 0) {
			onCall = true;
		}
	}

    /**
     * Hangs up the phone. OnCall will be set to false. 
     */
	public void hangUp() {
		if (onCall) {
			onCall = false;
		}
	}

    /**
     * Recharges the battery from wherever it is at back to 100 
     */
    public void rechargeBattery()
    {
        batteryCharge = 100;
    }

}
