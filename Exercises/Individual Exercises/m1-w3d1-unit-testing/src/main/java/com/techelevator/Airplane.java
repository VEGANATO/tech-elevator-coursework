package com.techelevator;

public class Airplane {

	private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats = 0;
    private int totalCoachSeats;
    private int bookedCoachSeats = 0;

    /**
     * Creates a new airplane 
     * @param totalFirstClassSeats Total number of first class seats that can be booked
     * @param totalCoachSeats Total number of coach seats that can be booked
     */
    public Airplane(int totalFirstClassSeats, int totalCoachSeats) {
        this.setTotalFirstClassSeats(totalFirstClassSeats);
        this.setTotalCoachSeats(totalCoachSeats);         
    }

    /**
     * 6-Character Plane Number 
     * @return planeNumber
     */
    public String getPlaneNumber() {
        return planeNumber;            
    }
    
    public void setPlaneNumber(String planeNumber) {
    	if (planeNumber != null &&
    		!planeNumber.isEmpty() &&
    		planeNumber.length() == 6) {
    		this.planeNumber = planeNumber;
    	}
    			
    }

    /**
     * Number of already booked first class seats 
     * @return bookedFirstClassSeats
     */
    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;            
    }
    

    /**
     * Available number of first class seats 
     * @return availableFirstClassSeats
     */
    public int getAvailableFirstClassSeats() {
        return totalFirstClassSeats - bookedFirstClassSeats;
    }

    /**
     * Total number of first class seats 
     * @return totalFirstClassSeats
     */
    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }
    
    public void setTotalFirstClassSeats(int totalFirstClassSeats) {
    	if (totalFirstClassSeats > -1) {
    		this.totalFirstClassSeats = totalFirstClassSeats;
    	}
    }

    /**
     * Number of already booked coach seats 
     * @return bookedCoachSeats
     */
    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    /**
     * Available number of coach seats 
     * @return availableCoachSeats
     */
    public int getAvailableCoachSeats() {
        return totalCoachSeats - bookedCoachSeats;
    }

    /**
     * Total number of coach seats 
     * @return totalCoachSeats
     */
    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }
    
    public void setTotalCoachSeats(int totalCoachSeats) {
    	if (totalCoachSeats > -1) {
    		this.totalCoachSeats = totalCoachSeats;
    	}
    }

    /**
     * Reserves a first class or coach seat. Algorithm checks for reservation possiblity before making reservation. 
     * @param firstClass True if the reservation is for first class, false for coach
     * @param totalNumberOfSeats Total number of seats to reserve
     * @return True if reservation was successful, false otherwise
     */
	public boolean reserve(boolean firstClass, int totalNumberOfSeats) {
		if (firstClass) {
			if (totalNumberOfSeats <= getAvailableFirstClassSeats()) {
				bookedFirstClassSeats += totalNumberOfSeats;
				return true;
			}
		} else {
			if (totalNumberOfSeats <= getAvailableCoachSeats()) {
				bookedCoachSeats += totalNumberOfSeats;
				return true;
			}
		}
		
		return false;
	}

}
