package com.techelevator;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.dao.JDBCCampgroundDAO;
import com.techelevator.model.Campground;

public class JDBCCampgroundDAOIntegrationTest extends DAOIntegrationTest
{
	private JDBCCampgroundDAO campDao;
	
	@Before
	public void setup() {
		campDao = new JDBCCampgroundDAO(getDataSource());
	}
	
	@Test
	public void getCampgroundsByParkIDReturnsListWhenGivenValidParkID() {
		// assuming at least one park in database
		List<Campground> testReturnList = campDao.getCampgroundsByParkID(1);
		
		Assert.assertNotEquals(0, testReturnList.size());
	}
	
	@Test
	public void getCampgroundsByParkIDReturnsEmptyListWhenGivenInvalidParkID() {
		// assuming at least one park in database
		List<Campground> testReturnList = campDao.getCampgroundsByParkID(-1);
		
		Assert.assertEquals(0, testReturnList.size());
	}
}
