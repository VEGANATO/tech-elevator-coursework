package com.techelevator.view;

import java.beans.FeatureDescriptor;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import com.techelevator.DollarAmount;
import com.techelevator.Inventory;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > -1 && selectedOption <= options.length) {
				choice = options[selectedOption];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since
			// choice will be null
		}
		if (choice == null) {
			out.println("\n*** " + userInput + " is not a valid option ***\n");
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 1; i < options.length; i++) {
			int optionNum = i;

			out.println(optionNum + ") " + options[i]);
		}

		out.print("\nPlease choose an option >>> ");
		out.flush();

	}

	public Integer getDollarAmountFromUser() {
		Object choice = null;

		while (choice == null) {
			out.println("Please insert $1, $2, $5, $10, or $20");
			out.println("ex $1 = 1, ex $2 = 2, ex $5 = 5, ex $10 = 10, or ex $20 = 20");
			out.flush();
			String userInput = in.nextLine();
			try {
				// int userDollarInput = Integer.valueOf(userInput);
				if (DollarAmount.isValidDollar(userInput)) {
					Integer feedMoneyInput = Integer.parseInt(userInput);
					choice = feedMoneyInput;
				} else {
					out.println("\n*** " + userInput + " is not a valid option ***\n");
					out.flush();
				}

			} catch (NumberFormatException e) {
				// eat the exception, an error message will be displayed below
				// since
				// choice will be null
			}
		}

		return (Integer) choice;
	}

	public String getSlotKey(String slotKeyChoice) {
		Object choice = null;

		while (choice == null) {
			out.println("Please enter product slot");
			out.flush();
			String userInput = in.nextLine();
			try {
				if (Inventory.isValidProductSlotKey(userInput)) {
					choice = userInput;
				} else if (choice == null) {
					out.println("\n*** " + userInput + " is not a valid option ***\n");
					out.flush();
				}
			} catch (NumberFormatException e) {
				// eat the exception, an error message will be displayed below
				// since
				// choice will be null
			}

		}
		return (String) choice;
	}

}
