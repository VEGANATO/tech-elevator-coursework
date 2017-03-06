package com.techelevator.vehicle;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main (String[] args) {
		List<Vehicle> vehicleToll = new ArrayList<Vehicle>();
		
		Car carNoTrailer = new Car(100, false);
		Car carWithTrailer = new Car(75, true);
		Tank tank = new Tank(240);
		Truck truck = new Truck(150, 8);
		
		
		vehicleToll.add(carNoTrailer);
		vehicleToll.add(carWithTrailer);
		vehicleToll.add(tank);
		vehicleToll.add(truck);
		
		System.out.println("Vehicle          Distance Traveled      Toll $");
		System.out.println("----------------------------------------------");
		
		for (Vehicle vehicle : vehicleToll) {
			System.out.println(vehicle);
		}
	}
}
