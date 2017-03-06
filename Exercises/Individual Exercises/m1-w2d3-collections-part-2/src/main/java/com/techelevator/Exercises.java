package com.techelevator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Exercises {

	/*
	 * Dictionary/Map Exercises
	 */

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 * 
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "herd".
	 * 
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 * 
	 * Rhino -> Crash Giraffe -> Tower Elephant -> Herd Lion -> Pride Crow ->
	 * Murder Pigeon -> Kit Flamingo -> Pat Deer -> Herd Dog -> Pack Crocodile
	 * -> Float
	 *
	 * animalGroupName("giraffe") → "Tower" animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * 
	 */
	public String animalGroupName(String animalName) {
		Map<String, String> groupNames = new HashMap<String, String>();

		groupNames.put("rhino", "Crash");
		groupNames.put("giraffe", "Tower");
		groupNames.put("elephant", "Herd");
		groupNames.put("lion", "Pride");
		groupNames.put("crow", "Murder");
		groupNames.put("pigeon", "Kit");
		groupNames.put("flamingo", "Pat");
		groupNames.put("deer", "Herd");
		groupNames.put("dog", "Pack");
		groupNames.put("crocodile", "Float");

		if (animalName == null || animalName.isEmpty()) {
			return "unknown";
		} else {
			String animalNameLowerCase = animalName.toLowerCase();

			if (groupNames.containsKey(animalNameLowerCase)) {
				return groupNames.get(animalNameLowerCase);
			} else {
				return "unknown";
			}
		}
	}

	/*
	 * Given an String item number (a.k.a. SKU), return the discount percentage
	 * if the item is on sale. If the item is not on sale, return 0.00.
	 * 
	 * If the item number is empty or null, return 0.00.
	 * 
	 * "KITCHEN4001" -> 0.20 "GARAGE1070" -> 0.15 "LIVINGROOM" -> 0.10
	 * "KITCHEN6073" -> 0.40 "BEDROOM3434" -> 0.60 "BATH0073" -> 0.15
	 * 
	 * The item number should be case insensitive so "kitchen4001",
	 * "Kitchen4001", and "KITCHEN4001" should all return 0.20.
	 * 
	 * isItOnSale("kitchen4001") → 0.20 isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15 isItOnSale("dungeon9999") → 0.00
	 * 
	 */
	public Double isItOnSale(String itemNumber) {
		Map<String, Double> itemDiscountMap = new HashMap<String, Double>();

		itemDiscountMap.put("kitchen4001", 0.20);
		itemDiscountMap.put("garage1070", 0.15);
		itemDiscountMap.put("livingroom", 0.10);
		itemDiscountMap.put("kitchen6073", 0.40);
		itemDiscountMap.put("bedroom3434", 0.60);
		itemDiscountMap.put("bath0073", 0.15);

		String itemNumberLowerCase = itemNumber.toLowerCase();

		if (itemDiscountMap.containsKey(itemNumberLowerCase)) {
			return itemDiscountMap.get(itemNumberLowerCase);
		}

		return 0.00;
	}

	/*
	 * Modify and return the given map as follows: if "Peter" has more than 0
	 * money, transfer half of it to "Paul", but only if Paul has less than
	 * $10s.
	 * 
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ...
	 * $1=100, ... $10=1000, ...
	 * 
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul":
	 * 1099} robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000,
	 * "Paul": 30000}
	 * 
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		Integer peterMoney = peterPaul.get("Peter");
		Integer paulMoney = peterPaul.get("Paul");

		if (paulMoney < 1000 && peterMoney > 0) {
			Integer halfOfPeterMoney = peterMoney / 2;
			peterMoney -= halfOfPeterMoney;
			paulMoney += halfOfPeterMoney;

			peterPaul.put("Peter", peterMoney);
			peterPaul.put("Paul", paulMoney);
		}

		return peterPaul;
	}

	/*
	 * Modify and return the given map as follows: if "Peter" has $50 or more,
	 * AND "Paul" has $100 or more, then create a new "PeterPaulPartnership"
	 * worth a combined contribution of a quarter of each partner's current
	 * worth.
	 * 
	 * peterPaulPartnership({"Peter": 5000, "Paul": 10000}) → {"Peter": 3750,
	 * "Paul": 7500, "PeterPaulPartnership": 3750}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter":
	 * 3333, "Paul": 1234567890}
	 * 
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) {
		Integer peterMoney = peterPaul.get("Peter");
		Integer paulMoney = peterPaul.get("Paul");

		if (peterMoney > 4999 && paulMoney > 9999) {
			Integer peterContribution = peterMoney / 4;
			Integer paulContribution = paulMoney / 4;

			peterPaul.put("Peter", peterMoney - peterContribution);
			peterPaul.put("Paul", paulMoney - paulContribution);
			peterPaul.put("PeterPaulPartnership", peterContribution + paulContribution);
		}

		return peterPaul;
	}

	/*
	 * Given an array of non-empty strings, return a Map<String, String> where
	 * for every different string in the array, there is a key of its first
	 * character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g":
	 * "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) {
		Map<String, String> beginEndMap = new HashMap<String, String>();

		for (String word : words) {
			String firstChar = word.substring(0, 1);
			String lastChar = word.substring(word.length() - 1);

			beginEndMap.put(firstChar, lastChar);
		}

		return beginEndMap;
	}

	/*
	 * Given an array of strings, return a Map<String, Integer> with a key for
	 * each different string, with the value the number of times that string
	 * appears in the array.
	 * 
	 * ** A CLASSIC **
	 * 
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {} wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 * 
	 */
	public Map<String, Integer> wordCount(String[] words) {
		Map<String, Integer> wordCountMap = new HashMap<String, Integer>();

		for (int i = 0; i < words.length; i++) {
			if (wordCountMap.containsKey(words[i])) {
				Integer countPlus1 = wordCountMap.get(words[i]) + 1;
				wordCountMap.put(words[i], countPlus1);
			} else {
				wordCountMap.put(words[i], 1);
			}
		}

		return wordCountMap;
	}

//		Map<String, Integer> wordCountMap = new HashMap<String, Integer>();
//
//		for (String word : words) {
//			if (!wordCountMap.containsKey(word)) {
//				Integer wordCount = 0;
//				int wordIndex = Arrays.asList(words).indexOf(word);
//
//				// could leave i as 0 and increment, but would iterate through
//				// entire array for every word
//				for (int i = wordIndex; i < words.length; i++) {
//					if (words[i].equals(word)) {
//						wordCount++;
//					}
//				}
//
//				wordCountMap.put(word, wordCount);
//			}
//		}
//
//		return wordCountMap;
//	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key
	 * for each int, with the value the number of times that int appears in the
	 * array.
	 * 
	 * ** The lesser known cousin of the the classic wordCount **
	 * 
	 * integerCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 1, 44: 1, 55:
	 * 1, 63: 3, 77: 1, 99:2} integerCount([107, 33, 107, 33, 33, 33, 106, 107])
	 * → {33: 4, 106: 1, 107: 3} integerCount([]) → {}
	 * 
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		Map<Integer, Integer> integerCountMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < ints.length; i++) {
			if (integerCountMap.containsKey(ints[i])) {
				Integer countPlus1 = integerCountMap.get(ints[i]) + 1;
				integerCountMap.put(ints[i], countPlus1);
			} else {
				integerCountMap.put(ints[i], 1);
			}
		}

		return integerCountMap;

		// for (Integer integer : ints) {
		// if (!integerCountMap.containsKey(integer)) {
		// Integer integerCount = 0;
		//
		// for (int i = 0; i < ints.length; i++) {
		// if (ints[i] == integer) {
		// integerCount++;
		// }
		// }
		//
		// integerCountMap.put(integer, integerCount);
		// }
		// }
		//
		// return integerCountMap;

		// for (Integer integer : ints) {
		// integerCountMap.put(integer, 0);
		// }
		//
		// for (Integer integer : integerCountMap.keySet()) {
		// if (integerCountMap.containsKey(integer)) {
		// Integer integerCount = 0;
		//
		// for (int i = 0; i < ints.length; i++) {
		// if (ints[i] == integer) {
		// integerCount++;
		// }
		// }
		//
		// integerCountMap.put(integer, integerCount);
		// }
		// }
	}

	/*
	 * Given an array of strings, return a Map<String, Boolean> where each
	 * different string is a key and value is true only if that string appears 2
	 * or more times in the array.
	 * 
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a":
	 * true} wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a":
	 * false} wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 * 
	 */
	public Map<String, Boolean> wordMultiple(String[] words) {
		Map<String, Boolean> wordMultipleMap = new HashMap<String, Boolean>();

		for (int i = 0; i < words.length; i++) {
			if (wordMultipleMap.containsKey(words[i])) {
				wordMultipleMap.put(words[i], true);
			} else {
				wordMultipleMap.put(words[i], false);
			}
		}
		
		return wordMultipleMap;
		
		//int wordIndex = Arrays.asList(words).indexOf(word);
		
//		for (String word : words) {
//			if (!wordMultipleMap.containsKey(word)) {
//				int wordCount = 0;
//
//				for (int i = 0; i < words.length; i++) {
//					if (word.equals(words[i])) {
//						wordCount++;
//					}
//				}
//
//				boolean twoOrMore = wordCount > 1;
//
//				wordMultipleMap.put(word, twoOrMore);
//			}
//		}
//
//		return wordMultipleMap;
	}

	/*
	 * Given two maps, Map<String, Integer>, merge the two into a new map,
	 * Map<String, Integer> where keys in Map2, and their Integer values, are
	 * added to the Integer values of matching keys in Map1. Return the new map.
	 * 
	 * Unmatched keys and their Integer values in Map2 are simply added to Map1.
	 * 
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11,
	 * "SKU4": 5}) → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 * 
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse,
			Map<String, Integer> remoteWarehouse) {
		Map<String, Integer> consolidatedMap = new HashMap<String, Integer>();

		for (String item : mainWarehouse.keySet()) {
			// if remoteWarehouse shares key with mainWarehouse, add remote
			// inventory to main, remove item from remote
			if (remoteWarehouse.containsKey(item)) {
				Integer mainAmount = mainWarehouse.get(item);
				Integer remoteAmount = remoteWarehouse.get(item);
				consolidatedMap.put(item, mainAmount + remoteAmount);
				remoteWarehouse.remove(item);
			} else {
				consolidatedMap.put(item, mainWarehouse.get(item));
			}
		}

		// if remote has unique keys, add key+value to main
		if (!remoteWarehouse.isEmpty()) {
			for (String item : remoteWarehouse.keySet()) {
				consolidatedMap.put(item, remoteWarehouse.get(item));
				remoteWarehouse.remove(item);
			}
		}

		return consolidatedMap;
	}

	/*
	 * Just when you thought it was safe to get back in the water ---
	 * last2Revisited!!!!
	 * 
	 * Given an array of strings, for each string, the count of the number of
	 * times that a substring length 2 appears in the string and also as the
	 * last 2 chars of the string, so "hixxxhi" yields 1.
	 * 
	 * We don't count the end substring, but the substring may overlap a prior
	 * position by one. For instance, "xxxx" has a count of 2, one pair at
	 * position 0, and the second at position 1. The third pair at position 2 is
	 * the end substring, which we don't count.
	 * 
	 * Return Map<String, Integer>, where the key is string from the array, and
	 * its last2 count.
	 * 
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1,
	 * "xaxxaxaxx": 1, "axxxaaxx": 2}
	 * 
	 */
	public Map<String, Integer> last2Revisted(String[] words) {
		Map<String, Integer> stringLast2Count = new HashMap<String, Integer>();

		for (String word : words) {
			Integer last2Count = last2Count(word);
			stringLast2Count.put(word, last2Count);
		}

		return stringLast2Count;
	}

	public static Integer last2Count(String word) {
		Integer count = 0;
		String last2 = word.substring(word.length() - 2);

		for (int i = 0; i < word.length() - 2; i++) {
			if (word.substring(i, i + 2).equals(last2)) {
				count++;
			}
		}

		return count;
	}
}
