package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		try (Scanner userInput = new Scanner(System.in)) {
			System.out.print("Enter Search Term >>> ");
			String searchTerm = userInput.nextLine();

			System.out.print("Enter File Path >>> ");
			String filePath = userInput.nextLine();

			System.out.print("Do you want the search to be case-sensitive? (y or n) >>> ");

			String yOrN = userInput.nextLine();

			boolean isCaseSensitive = false;

			if (yOrN.equalsIgnoreCase("y")) {
				isCaseSensitive = true;
			}

			try {
				File searchFile = getSearchFile(filePath);
				try (Scanner fileInput = new Scanner(searchFile)) {
					int lineNumber = 1;
					while (fileInput.hasNextLine()) {
						String line = fileInput.nextLine();

						if (isCaseSensitive) {
							if (line.contains(searchTerm)) {
								System.out.println(lineNumber + ") " + line);
							}
						} else {
							if (line.toUpperCase().contains(searchTerm.toUpperCase())) {
								System.out.println(lineNumber + ") " + line);
							}
						}

						lineNumber++;
					}
				}
			} catch (FileNotFoundException ex) {
				System.out.println(ex.getMessage());
				System.exit(1);
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
				System.exit(1);
			}
		}

	}

	private static File getSearchFile(String filePath) throws IOException {
		File searchFile = new File(filePath);

		if (!searchFile.exists()) {
			throw new FileNotFoundException("Search file: " + filePath + " does not exist.");
		}

		if (!searchFile.isFile()) {
			throw new IOException("Search file: " + filePath + " exists but is not a file.");
		}

		return searchFile;
	}

}
