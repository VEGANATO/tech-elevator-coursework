package com.techelevator;

public class FruitTree {
	private String fruitType;
	private int piecesOfFruitLeft;

	public FruitTree(String fruitType, int piecesOfFruitLeft) {
		this.setFruitType(fruitType);
		this.setPiecesOfFruitLeft(piecesOfFruitLeft);
	}

	@Override
	public String toString() {
		return "This " + fruitType + " tree has " + piecesOfFruitLeft + " pieces of fruit left!";
	}

	public String getFruitType() {
		return fruitType;
	}

	public void setFruitType(String fruitType) {
		if (fruitType != null && !fruitType.isEmpty()) {
			this.fruitType = fruitType;
		}
	}

	public int getPiecesOfFruitLeft() {
		return piecesOfFruitLeft;
	}

	public void setPiecesOfFruitLeft(int piecesOfFruitLeft) {
		if (piecesOfFruitLeft >= 0) {
			this.piecesOfFruitLeft = piecesOfFruitLeft;
		}
	}

	public boolean pickFruit(int numberOfPieces) {
		if (piecesOfFruitLeft >= numberOfPieces) {
			piecesOfFruitLeft -= numberOfPieces;
			System.out.println("You picked " + numberOfPieces + " pieces of fruit. Yum!");
			return true;
		} else {
			System.out.println("All out of fruit, sorry bud!");
			return false;
		}
	}

}
