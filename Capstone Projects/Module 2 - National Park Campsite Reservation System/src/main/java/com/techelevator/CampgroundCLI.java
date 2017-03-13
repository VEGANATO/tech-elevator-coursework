package com.techelevator;

import java.math.BigDecimal;
import java.security.InvalidKeyException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.dao.CampgroundDAO;
import com.techelevator.dao.JDBCCampgroundDAO;
import com.techelevator.dao.JDBCParkDAO;
import com.techelevator.dao.JDBCReservationDAO;
import com.techelevator.dao.JDBCSiteDAO;
import com.techelevator.dao.ParkDAO;
import com.techelevator.dao.ReservationDAO;
import com.techelevator.dao.SiteDAO;
import com.techelevator.model.Campground;
import com.techelevator.model.Park;
import com.techelevator.model.Reservation;
import com.techelevator.model.Site;
import com.techelevator.view.Menu;

public class CampgroundCLI {
	
	private static Scanner userInput = new Scanner(System.in);
	private Menu menu = new Menu(System.in, System.out);
	
	private ParkDAO parkData;
	private CampgroundDAO campData;
	private SiteDAO siteData;
	private ReservationDAO reserveData;
	
	private final static String VIEW_CAMPGROUNDS = "View Campgrounds";
	private final static String SEARCH_RESERVATIONS = "Search for Reservation";
	private final static String RETURN = "Return to Previous Screen";
	private final static String[] PARK_OPTIONS = { VIEW_CAMPGROUNDS, SEARCH_RESERVATIONS, RETURN };
	
	private final static String SEARCH_AVAILABLE_RESERVATION = "Search for Available Reservation";
	private final static String[] CAMP_OPTIONS = { SEARCH_AVAILABLE_RESERVATION, RETURN };

	public static void main(String[] args) throws SQLException
	{
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		
		CampgroundCLI application = new CampgroundCLI(dataSource);
		application.run();
		dataSource.close();
		userInput.close();
	}

	public CampgroundCLI(DataSource datasource)
	{
		parkData = new JDBCParkDAO(datasource);
		campData = new JDBCCampgroundDAO(datasource);
		siteData = new JDBCSiteDAO(datasource);
		reserveData = new JDBCReservationDAO(datasource);
	}
	
	public void run()
	{
		System.out.println(" $$$$$$\\                                                               $$$$$$\\   $$$$$$\\   $$$$$$\\   $$$$$$\\  ");
		System.out.println(" $$  __$$\\                                                             $$ ___$$\\ $$$ __$$\\ $$$ __$$\\ $$$ __$$\\ ");
		System.out.println(" $$ /  \\__| $$$$$$\\  $$$$$$\\$$$$\\   $$$$$$\\   $$$$$$\\   $$$$$$\\        \\_/   $$ |$$$$\\ $$ |$$$$\\ $$ |$$$$\\ $$ |");
		System.out.println(" $$ |       \\____$$\\ $$  _$$  _$$\\ $$  __$$\\ $$  __$$\\ $$  __$$\\         $$$$$ / $$\\$$\\$$ |$$\\$$\\$$ |$$\\$$\\$$ |");
		System.out.println(" $$ |       $$$$$$$ |$$ / $$ / $$ |$$ /  $$ |$$$$$$$$ |$$ |  \\__|        \\___$$\\ $$ \\$$$$ |$$ \\$$$$ |$$ \\$$$$ |");
		System.out.println(" $$ |  $$\\ $$  __$$ |$$ | $$ | $$ |$$ |  $$ |$$   ____|$$ |            $$\\   $$ |$$ |\\$$$ |$$ |\\$$$ |$$ |\\$$$ |");
		System.out.println(" \\$$$$$$  |\\$$$$$$$ |$$ | $$ | $$ |$$$$$$$  |\\$$$$$$$\\ $$ |            \\$$$$$$  |\\$$$$$$  /\\$$$$$$  /\\$$$$$$  /");
		System.out.println("  \\______/  \\_______|\\__| \\__| \\__|$$  ____/  \\_______|\\__|             \\______/  \\______/  \\______/  \\______/ ");
		System.out.println("                                   \\__|                                                                        ");
		
		while (true)
		{
			printMainMenu();
		}
	}
	
	private void printMainMenu()
	{
		printHeading("Select a Park for Further Details");
		List<Park> parkList = parkData.getAllParks();
		
		String[] parkNames = new String[parkList.size() + 1];
		int i = 0;
		for (Park p : parkList)
		{
			parkNames[i] = p.getName() + ", " + p.getLocation();
			i++;
		}
		parkNames[i] = "Quit";
		
		String choice = (String)menu.getChoiceFromOptions(parkNames);
		if (choice.equals("Quit")) System.exit(0);
		else
		{
			String[] parkNameAndState = choice.split(", ");
			printParkInfo(parkData.getParkByNameAndState(parkNameAndState[0], parkNameAndState[1]));
		}
	}
	
	private void printParkInfo(Park park)
	{
		while (true)
		{
			printHeading(park.getName() + " National Park");
			System.out.printf("%-16s %s%n", "Location:", park.getLocation());
			System.out.printf("%-16s %s%n","Established:", park.getDayEstablished().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
			System.out.printf("%-16s %,d sq km%n", "Area:", park.getArea());
			System.out.printf("%-16s %,d%n", "Annual Visitors:", park.getVisitors());
			System.out.println();
			System.out.println(park.getDescription());

			String choice = (String)menu.getChoiceFromOptions(PARK_OPTIONS);
			
			if (choice.equals(RETURN)) break;
			else if (choice.equals(VIEW_CAMPGROUNDS))
			{
				printCampgroundInfo(park);
			}
			else if (choice.equals(SEARCH_RESERVATIONS))
			{
				printReservationsForPark(park);
			}
		}
	}
	
	private void printReservationsForPark(Park park)
	{
		List<Campground> campList = campData.getCampgroundsByParkID(park.getId());
		
		printHeading("Reservations for Campgrounds in " +park.getName()+" for the next 30 days");
		
		for (Campground camp : campList) {
			System.out.println(camp.getName());
			
			List<Reservation> reserve = reserveData.getReservationsByStartDateForCampground(camp);
			for (Reservation res : reserve)
			{
				System.out.printf("%-6d %-32s %-10s %-10s%n", res.getSiteId(), res.getName(),
						res.getFromDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")), res.getCreateDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
			}
		}
	}
	
	private void printCampgroundInfo(Park park)
	{
		while (true)
		{
			List<Campground> campList = campData.getCampgroundsByParkID(park.getId());
			
			printHeading(park.getName() + " National Park Campgrounds");
			System.out.printf("%-32s %-10s %-10s %-8s%n", "Name", "Open", "Close", "Daily Fee");
			for (Campground camp : campList)
			{
				System.out.printf("%-32s %-10s %-10s $%-8s%n", camp.getName(), camp.getOpenFrom(), camp.getOpenTo(), camp.getDailyFee().toPlainString());
			}

			String choice = (String)menu.getChoiceFromOptions(CAMP_OPTIONS);
			
			if (choice.equals(RETURN)) break;
			else if (choice.equals(SEARCH_AVAILABLE_RESERVATION))
			{
				selectCampgroundForReservation(park);
				break;
			}
		}
	}
	
	private void selectCampgroundForReservation(Park park)
	{
		while (true)
		{
			List<Campground> campList = campData.getCampgroundsByParkID(park.getId());
			
			printHeading(park.getName() + " National Park Campgrounds");
			System.out.printf("%-2s %-32s %-10s %-10s %-8s", "", "Name", "Open", "Close", "Daily Fee");
			
			String[] campNames = new String[campList.size() + 1];
			int i = 0;
			for (Campground camp : campList)
			{
				campNames[i] = String.format("%-32s %-10s %-10s $%-8s", camp.getName(), camp.getOpenFrom(), camp.getOpenTo(), camp.getDailyFee().toPlainString());
				i++;
			}
			campNames[i] = "Cancel";

			int choice = menu.getIndexFromOptions(campNames);
			
			if (choice == campNames.length - 1) break;
			else
			{
				selectDatesForReservation(campList.get(choice));
				break;
			}
		}
	}
	
	private void selectDatesForReservation(Campground campground)
	{
		while (true)
		{
			LocalDate fromDate = promptForDate(true);
			LocalDate toDate = promptForDate(false);
			
			if (fromDate.isBefore(toDate))
			{
				if (fromDate.isAfter(LocalDate.now()))
				{
					if (campground.isOpenForDates(fromDate, toDate))
					{
						displayAvailableSites(campground, fromDate, toDate);
						break;
					}
					else System.out.println("Campsite is closed during selected period");
				}
				else System.out.println("Starting date must be after today");
			}
			else System.out.println("End date was before start date. Please try again");
		}
	}
	
	private void displayAvailableSites(Campground campground, LocalDate fromDate, LocalDate toDate)
	{
		while (true)
		{
			List<Site> availableSites = siteData.getSitesAvailableForDateRange(campground.getId(), fromDate, toDate);
			BigDecimal totalCost = campground.getDailyFee()
					.multiply(new BigDecimal(fromDate.until(toDate, ChronoUnit.DAYS) + 1));
			printHeading(campground.getName() + " - Available Configurations");
			System.out.printf("%-2s %-10s %-10s %-13s %-7s %-5s%n", "", "Max Occup.", "Accessible", "Max RV Length",
					"Utility", "Cost");
			String[] options = new String[availableSites.size() + 1];
			int i = 0;
			for (Site site : availableSites) {
				options[i] = String.format("%-10s %-10s %-13s %-7s $%-5s", site.getMaxOccupancy(),
						booleanToYesNo(site.isAccessible()), intToNAorNumber(site.getMaxRVLength()),
						booleanToYesNo(site.isUtilities()), totalCost.toPlainString());
				i++;
			}
			options[i] = "Cancel";
			
			int choice = menu.getIndexFromOptions(options);
			
			if (choice == options.length - 1) break;
			else
			{
				createReservation(availableSites.get(choice), fromDate, toDate);
				break;
			}
		}
	}
	
	private void createReservation(Site site, LocalDate fromDate, LocalDate toDate)
	{
		while(true)
		{
			String resName = getUserInput("Please enter a name for the reservation");
			int returnedId;
			
			try
			{
				returnedId = reserveData.createReservation(site.getId(), resName, fromDate, toDate);
				System.out.println("The reservation has been made and the confirmation id is " +returnedId);
			}
			catch (InvalidKeyException e)
			{
				System.out.println("Something went wrong when trying to create the reservation");
			}
			break;
		}
	}
	
	private LocalDate promptForDate(boolean arrival)
	{
		LocalDate input = null;
		
		while (input == null)
		{
			try
			{
				input = LocalDate.parse(getUserInput("What is the " + ((arrival) ? "arrival" : "departure") + " date? mm/dd/yyyy"),
						DateTimeFormatter.ofPattern("MM/dd/yyyy").withLocale(Locale.US));
			}
			catch (DateTimeParseException e)
			{
				System.out.println("Invalid date format. Please use formate mm/dd/yyyy");
			} 
		}
		return input;
	}
	
	private String booleanToYesNo(boolean input)
	{
		return (input) ? "Yes" : "No";
	}
	
	private String intToNAorNumber(int input)
	{
		return (input == 0) ? "N/A" : Integer.toString(input);
	}
	
	private void printHeading(String heading)
	{
		System.out.printf("%n%s%n", heading);
		for (int i = 0; i < heading.length(); i++) System.out.print('-');
		System.out.println();
	}
	
	private String getUserInput(String prompt)
	{
		System.out.print(prompt + " >>> ");
		return userInput.nextLine();
	}
}
