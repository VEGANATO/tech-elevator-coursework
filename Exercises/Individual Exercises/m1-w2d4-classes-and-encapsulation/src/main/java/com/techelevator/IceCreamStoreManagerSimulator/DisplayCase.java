package com.techelevator.IceCreamStoreManagerSimulator;

import java.util.Map;
import java.util.HashMap;

public class DisplayCase {
	private Map<String, IceCream> displayCase;
	private int capacity;
	
	public DisplayCase() {
		displayCase = new HashMap<String, IceCream>();
		capacity = 4;
	}
	
	public boolean addIceCreamToCase(IceCream iceCream) {
		if (displayCase.containsKey(iceCream.getFlavor())) {
			System.out.println("No room for the flavor, brah. Guess you'll have to leave it on the back table to melt.");
			return false;
		} else {
			if (displayCase.size() < capacity) {
				displayCase.put(iceCream.getFlavor(), iceCream);
				System.out.println(iceCream.getFlavor() + " has been added to the case!");
				return true;
			} else {
				System.out.println("No room in the case, brah. Guess you'll have to leave it on the back table to melt.");
				return false;
			}
		}
	}
	
	public void checkCase() {
		for (String flavor : displayCase.keySet()) {
			System.out.println(displayCase.get(flavor));
		}
	}

}
