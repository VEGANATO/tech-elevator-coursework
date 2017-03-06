package com.techelevator;

import java.util.concurrent.TimeUnit;

public class Elevator {
	private int shaftNumber;
	private int currentLevel;
	private int numberOfLevels;
	private boolean doorOpen;
	private boolean isMoving;

	public Elevator(int totalNumberOfFloors) {
		shaftNumber = 0;
		currentLevel = 0;
		numberOfLevels = totalNumberOfFloors;
		doorOpen = false;
		isMoving = false;
	}

	@Override
	public String toString() {
		return "Number of Levels: " + numberOfLevels + ", Current Level: " + currentLevel + ", Door Open? " + doorOpen
				+ ", Moving? " + isMoving;
	}

	public boolean changeCurrentLevel(int newLevel) {
		if (!doorOpen) {
			if (newLevel > -1 && newLevel < numberOfLevels) {
				currentLevel = newLevel;
			}
		}

		return (currentLevel == newLevel);
	}

	public void openDoor() {
		if (!isMoving) {
			doorOpen = true;
		}
	}

	public void closeDoor() {
		doorOpen = false;
	}

	public boolean goUp(int desiredFloor) {
		if (!isMoving && desiredFloor > currentLevel) {
			openDoor();
			closeDoor();
			if (changeCurrentLevel(desiredFloor)) {
				System.out.println("Going up...");
				System.out.println("You have arrived at level " + desiredFloor + ".");
				openDoor();
			} else {
				System.out.println("Try choosing a different level.");
			}
		} else {
			System.out.println("The elevator cannot go up at this time. Guess your taking the stairs!");
		}

		closeDoor();
		return (currentLevel == desiredFloor);
	}

	public boolean goDown(int desiredFloor) {
		if (!isMoving && desiredFloor < currentLevel) {
			openDoor();
			closeDoor();
			int floorDifference = currentLevel - desiredFloor;
			if (changeCurrentLevel(desiredFloor)) {
				System.out.println("Going down...");
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("You have arrived at level " + desiredFloor);
				openDoor();
			} else {
				System.out.println("Try choosing a different level.");
			}
		} else {
			System.out.println("The elevator cannot go up at this time. Guess your taking the stairs!");
		}

		closeDoor();
		return (currentLevel == desiredFloor);
	}

}
