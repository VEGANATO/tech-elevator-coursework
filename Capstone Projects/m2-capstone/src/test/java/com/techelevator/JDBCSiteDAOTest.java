package com.techelevator;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.techelevator.dao.JDBCSiteDAO;
import com.techelevator.dao.SiteDAO;

public class JDBCSiteDAOTest extends DAOIntegrationTest
{
	private SiteDAO siteDAO;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		siteDAO = new JDBCSiteDAO(getDataSource());
	}
	
	@Test
	public void testSitesAvailable()
	{
		Assert.assertFalse(siteDAO.getSitesAvailableForDateRange(1, LocalDate.parse("2017-01-10"), LocalDate.parse("2017-01-20")).isEmpty());
	}
	
	@Test
	public void testSitesAvailableReturnsEmptyListIfInvalidCampgroundId()
	{
		Assert.assertTrue(siteDAO.getSitesAvailableForDateRange(-1, LocalDate.parse("2017-01-10"), LocalDate.parse("2017-01-20")).isEmpty());
	}
	
	@Test
	public void testSitesAvailableFailsOnNullDates()
	{
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Date entered cannot be null");
		siteDAO.getSitesAvailableForDateRange(1, null, LocalDate.parse("2017-01-20"));
		siteDAO.getSitesAvailableForDateRange(1, LocalDate.parse("2017-01-10"), null);
		siteDAO.getSitesAvailableForDateRange(1, null, null);
	}
	
	@Test
	public void testSitesAvailableFailsOnEndBeforeStartDate()
	{
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Start date cannot be after end date");
		siteDAO.getSitesAvailableForDateRange(1, LocalDate.parse("2017-01-20"), LocalDate.parse("2017-01-10"));
	}
}
