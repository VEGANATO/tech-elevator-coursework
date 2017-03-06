package com.techelevator.dao;

import java.security.InvalidKeyException;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.techelevator.model.Campground;
import com.techelevator.model.Reservation;

public class JDBCReservationDAO implements ReservationDAO
{
	private JdbcTemplate db;
	
	private RowMapper<Reservation> mapRowToReservation = (row, pos) -> {
		Reservation r = new Reservation(row.getInt("site_id"), row.getString("name"),
				row.getDate("from_date").toLocalDate(), row.getDate("to_date").toLocalDate());
		r.setId(row.getInt("reservation_id"));
		r.setCreateDate(row.getDate("create_date").toLocalDate());
		return r;
	};
	
	public JDBCReservationDAO(DataSource dataSource)
	{
		this.db = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int createReservation(int siteId, String name, LocalDate fromDate, LocalDate toDate) throws IllegalArgumentException, InvalidKeyException
	{
		if (name == null || fromDate == null || toDate == null) throw new IllegalArgumentException("No parameter can be null");
		if (fromDate.isAfter(toDate)) throw new IllegalArgumentException("Start date cannot be after end date");
		
		try
		{
			return db.queryForObject("INSERT INTO reservation (site_id, name, from_date, to_date, create_date) "
					+ "VALUES (?,?,?,?,?) RETURNING reservation_id", Integer.class, siteId, name, fromDate, toDate, LocalDate.now());
		}
		catch (DataIntegrityViolationException e)
		{
			throw new InvalidKeyException("Site ID was not a valid site");
		}
	}

	@Override
	public List<Reservation> getReservationsByStartDateForCampground(Campground campground)
	{
		return db.query("SELECT * FROM reservation JOIN site ON reservation.site_id = site.site_id "
				+ "WHERE campground_id = ? AND from_date BETWEEN current_date AND current_date + INTERVAL '30 day'", mapRowToReservation, campground.getId());
	}

}
