package com.techelevator;

import java.security.InvalidKeyException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.dao.JDBCReservationDAO;
import com.techelevator.dao.ReservationDAO;
import com.techelevator.model.Campground;
import com.techelevator.model.Reservation;

public class JDBCReservationDAOTest extends DAOIntegrationTest
{
	private JdbcTemplate db;
	private ReservationDAO resDAO;
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Before
	public void setup() {
		db = new JdbcTemplate(getDataSource());
		resDAO = new JDBCReservationDAO(getDataSource());
	}
	
	private void clearReservations()
	{
		db.update("DELETE FROM reservation");
	}
	
	@Test
	public void testGetAndCreateReservations() throws InvalidKeyException
	{
		clearReservations();
		
		LocalDate start = LocalDate.now().plus(10, ChronoUnit.DAYS);
		LocalDate end = start.plus(10, ChronoUnit.DAYS);
		Reservation res = new Reservation(1, "Tom", start, end);
		resDAO.createReservation(res.getSiteId(), res.getName(), res.getFromDate(), res.getToDate());
		
		Campground camp = new Campground(1, null, 0, 0, null); // Only the ID is needed to look up reservations
		Reservation returnedRes = resDAO.getReservationsByStartDateForCampground(camp).get(0);
		Assert.assertEquals(1, returnedRes.getSiteId());
		Assert.assertEquals("Tom", returnedRes.getName());
		Assert.assertEquals(start, returnedRes.getFromDate());
		Assert.assertEquals(end, returnedRes.getToDate());
	}
	
	@Test
	public void testGetReservationsFailsOnNullInput()
	{
		exception.expect(NullPointerException.class);
		resDAO.getReservationsByStartDateForCampground(null);
	}
	
	@Test
	public void testGetReservationsReturnsEmptyListOnNoReservations() throws InvalidKeyException
	{
		clearReservations();
		
		LocalDate start = LocalDate.now().plus(10, ChronoUnit.DAYS);
		LocalDate end = start.plus(10, ChronoUnit.DAYS);
		Reservation res = new Reservation(1, "Tom", start, end);
		resDAO.createReservation(res.getSiteId(), res.getName(), res.getFromDate(), res.getToDate());
		
		Campground camp = new Campground(2, null, 0, 0, null); // Reservation was made under ID 1
		Assert.assertEquals(0, resDAO.getReservationsByStartDateForCampground(camp).size());
	}
	
	@Test
	public void testCreateReservationFailsOnNullInput() throws InvalidKeyException
	{
		clearReservations();
		
		LocalDate start = LocalDate.now().plus(10, ChronoUnit.DAYS);
		LocalDate end = start.plus(10, ChronoUnit.DAYS);
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("No parameter can be null");
		resDAO.createReservation(1, null, start, end);
		resDAO.createReservation(1, "Tom", null, end);
		resDAO.createReservation(1, "Tom", start, null);
	}
	
	@Test
	public void testCreateReservationFailsIfStartAfterEndDate() throws InvalidKeyException
	{
		clearReservations();
		
		LocalDate end = LocalDate.now().plus(10, ChronoUnit.DAYS);
		LocalDate start = end.plus(10, ChronoUnit.DAYS);
		
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Start date cannot be after end date");
		resDAO.createReservation(1, "Tom", start, end);
	}
	
	@Test
	public void testCreateReservationFailsIfSiteIdNotPresent()
	{
		clearReservations();
		
		LocalDate start = LocalDate.now().plus(10, ChronoUnit.DAYS);
		LocalDate end = start.plus(10, ChronoUnit.DAYS);
		
		try
		{
			resDAO.createReservation(-1, "Tom", start, end);
			Assert.fail(); // This should never be called
		}
		catch (InvalidKeyException e)
		{
			// We want it to throw an exception, then keep going
			// JUnit Expected Exception was not working for a non-Runtime Exception
		}
	}
}
