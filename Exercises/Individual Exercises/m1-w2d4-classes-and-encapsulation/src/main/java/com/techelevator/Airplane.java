package com.techelevator;

public class Airplane {
	private String planeNumber;
	private int bookedFirstClassSeats;
	private int totalFirstClassSeats;
	private int bookedCoachSeats;
	private int totalCoachSeats;
	
	public Airplane(int totalFirstClassSeats, int totalCoachSeats) {
		planeNumber = "000001";
		bookedCoachSeats = 0;
		this.totalFirstClassSeats = totalFirstClassSeats;
		bookedCoachSeats = 0;
		this.totalCoachSeats = totalCoachSeats;
	}
	
	@Override
	public String toString() {
		return "Plane Number: " + planeNumber + ", Available First Class Seats: " + availableFirstClassSeats() + ", Available Coach Seats: " + availableCoachSeats();
	}
	
	public int availableFirstClassSeats() {
		return totalFirstClassSeats - bookedFirstClassSeats;
	}
	
	public int availableCoachSeats() {
		return totalCoachSeats - bookedCoachSeats;
	}
	
	public boolean reserveSeats(boolean firstClass, int totalNumberOfSeats) {
		if (firstClass) {
			if (availableFirstClassSeats() >= totalNumberOfSeats) {
				bookedFirstClassSeats += totalNumberOfSeats;
				System.out.println("Reservation for " + totalNumberOfSeats + " First Class seats completed!");
				return true;
			}
		} else {
			if (availableCoachSeats() >= totalNumberOfSeats) {
				bookedCoachSeats += totalNumberOfSeats;
				System.out.println("Reservation for " + totalNumberOfSeats + " Coach seats completed!");
				return true;
			}
		}
		
		System.out.println("Your reservation could not be completed at this time. Please try again, or call our help line for assistance.");
		return false;
	}

}
