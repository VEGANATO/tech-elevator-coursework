package com.techelevator;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.dao.JDBCParkDAO;
import com.techelevator.model.Park;

public class JDBCParkDAOIntegrationTest extends DAOIntegrationTest {
	
	private JDBCParkDAO parkDao;
	
	@Before
	public void setup() {
		parkDao = new JDBCParkDAO(getDataSource());
	}
	
	@Test
	public void getAllParksReturnsListGreaterThanZero() {
		// assumes at least one park in the database
		List<Park> testList = parkDao.getAllParks();
		
		Assert.assertNotEquals(0, testList.size());
	}
	
	@Test
	public void getParkByNameAndStateReturnsCorrectPark() {
		// assumes at least one park in the database
		List<Park> testParkList = parkDao.getAllParks();
		Park testParkFromList = testParkList.get(0);
		
		String parkName = testParkFromList.getName();
		String parkLocation = testParkFromList.getLocation();
		
		Park testPark = parkDao.getParkByNameAndState(parkName, parkLocation);
		
		Assert.assertEquals(parkName, testPark.getName());
		Assert.assertEquals(parkLocation, testPark.getLocation());
	}
	
	@Test
	public void getParkByNameAndStateReturnsNoParkWhenNameIsNotFound() {
		List<Park> testParkList = parkDao.getAllParks();
		Park testParkFromList = testParkList.get(0);
		
		String parkLocation = testParkFromList.getLocation();
		
		Park testPark = parkDao.getParkByNameAndState("Not A Park Name", parkLocation);
		
		Assert.assertNull(testPark);

	}
	
	@Test
	public void getParkByNameAndStateReturnsNoParkWhenLocationIsNotFound() {
		List<Park> testParkList = parkDao.getAllParks();
		Park testParkFromList = testParkList.get(0);
		
		String parkName = testParkFromList.getName();
		
		Park testPark = parkDao.getParkByNameAndState(parkName, "Not A Park Location");

		Assert.assertNull(testPark);
	}

	@Test
	public void getParkByNameAndStateReturnsNullWhenNameAndLocationIsNull() {
		Park testPark = parkDao.getParkByNameAndState(null, null);

		Assert.assertNull(testPark);
	}
}
