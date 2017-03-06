package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.ZipError;

public class Inventory {

	private Map<String, Product> inventoryMap;

	public Inventory() {
		this.inventoryMap = new HashMap<String, Product>();
	}

	public Product getProductBySlotKey(String slotKey) {
		return inventoryMap.get(slotKey);
	}

	public void stockInventory() {
		try {
			File inventoryInput = getInventoryFile("vendingmachine.csv");
			try (Scanner inventoryReader = new Scanner(inventoryInput)) {
				while (inventoryReader.hasNextLine()) {
					String productInfoFromFile = inventoryReader.nextLine();
					Product currentProduct = getAttributes(productInfoFromFile);
					inventoryMap.put(currentProduct.getSlot(), currentProduct);
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
	
	public int getInventorySize() {
		return inventoryMap.size();
	}

	public Product getAttributes(String inventoryFileLine) {
		String[] attributes = inventoryFileLine.split("\\|");
		double priceAsDouble = Double.parseDouble(attributes[2]);

		int price = (int) (priceAsDouble * 100);
		return new Product(attributes[0], attributes[1], new DollarAmount(price), 5);

	}

	private static File getInventoryFile(String filePath) throws IOException {
		File inventoryFile = new File(filePath);

		if (!inventoryFile.exists()) {
			throw new FileNotFoundException("Inventory file :" + filePath + "does not exist!");
		}

		if (!inventoryFile.isFile()) {
			throw new IOException("Inventory file :" + filePath + "exists, but is not a file!");
		}

		return inventoryFile;
	}

	public void displayInventory() {
		String formattedLogLine = String.format("%1$-5s %2$-25s %3$-10s %4$-20s", "Slot", "Product", "Price",
				"Quantity");
		System.out.println(formattedLogLine);

		List<String> keys = new ArrayList<String>();
		keys.addAll(inventoryMap.keySet());
		Collections.sort(keys);

		for (String slot : keys) {
			Product currentProduct = inventoryMap.get(slot);
			System.out.println(currentProduct);
		}
	}

	public static boolean isValidProductSlotKey(String slotKey) {
		if (slotKey.length() < 2) {
			return false;
		}

		String[] slotKeySplit = slotKey.split("");
		boolean firstKeySpot = slotKeySplit[0].equalsIgnoreCase("A") || slotKeySplit[0].equalsIgnoreCase("B")
				|| slotKeySplit[0].equalsIgnoreCase("C") || slotKeySplit[0].equalsIgnoreCase("D");
		boolean secondKeySpot = slotKeySplit[1].equals("1") || slotKeySplit[1].equals("2")
				|| slotKeySplit[1].equals("3") || slotKeySplit[1].equals("4");

		return firstKeySpot && secondKeySpot;
	}

	public DollarAmount selectProductBySlot(String productSelection, DollarAmount currentBalance) {
		Product selectedProduct = inventoryMap.get(productSelection);

		DollarAmount selectedProductPrice = selectedProduct.getPrice();
		if (currentBalance.isGreaterThanOrEqualTo(selectedProductPrice)) {
			selectedProduct.decreaseQuantity();
			System.out.println("Please enjoy your " + selectedProduct.getName() + "." + " There are "
					+ selectedProduct.getQuantity() + " left to purchase.");
			return new DollarAmount(
					(currentBalance.getTotalAmountInCents() - selectedProduct.getPrice().getTotalAmountInCents()));

		} else {
			System.out.println("Please insert additional American dollars");
			return new DollarAmount(currentBalance.getTotalAmountInCents());
		}
	}

	public boolean selectedProductInStock(String slotKey) {
		Product selectedProduct = inventoryMap.get(slotKey);
		return selectedProduct.getQuantity() > 0;
	}

	public void printSalesReport(File technicianSalesReport) {
		try (PrintWriter technicianSalesReportWriter = new PrintWriter(
				new FileOutputStream(technicianSalesReport, true))) {
			
			String technicianSalesReportHeader = String.format("%1$-25s %2$-15s %3$-15s", "Product Name",
					"Quantity Sold", "Gross Sales");
			technicianSalesReportWriter.println(technicianSalesReportHeader);
			
			DollarAmount totalGrossSales = DollarAmount.ZERO_DOLLARS;
			for (Product product : inventoryMap.values()) {
				
				String productName = product.getName();
				int productQuantitySold = 5 - product.getQuantity();
				DollarAmount productGrossSales = new DollarAmount(
						product.getPrice().getTotalAmountInCents() * productQuantitySold);
				String formattedTechnicianSalesLine = String.format("%1$-25s %2$-15s %3$-15s", productName,
						productQuantitySold, productGrossSales);

				technicianSalesReportWriter.println();
				technicianSalesReportWriter.println(formattedTechnicianSalesLine);
				technicianSalesReportWriter.flush();
				totalGrossSales = totalGrossSales.plus(productGrossSales);
			}
			
			technicianSalesReportWriter.println();
			technicianSalesReportWriter.println("Total Gross Sales : " + totalGrossSales);
			technicianSalesReportWriter.flush();
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			System.exit(1);
		}

	}

}
