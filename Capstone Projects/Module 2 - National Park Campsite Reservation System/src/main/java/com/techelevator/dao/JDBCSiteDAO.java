package com.techelevator.dao;

import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.techelevator.model.Site;

public class JDBCSiteDAO implements SiteDAO
{
	private JdbcTemplate db;
	
	private RowMapper<Site> mapRowToSite = (row, pos) -> {
		Site s = new Site(row.getInt("site_id"), row.getInt("site_number"), row.getInt("max_occupancy"),
				row.getInt("max_rv_length"), row.getBoolean("accessible"), row.getBoolean("utilities"));
		
		return s;
	};
	
	public JDBCSiteDAO(DataSource dataSource)
	{
		this.db = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Site> getSitesAvailableForDateRange(int campgroundID, LocalDate startDate, LocalDate endDate) throws IllegalArgumentException
	{
		if (startDate == null || endDate == null) throw new IllegalArgumentException("Date entered cannot be null");
		if (startDate.isAfter(endDate)) throw new IllegalArgumentException("Start date cannot be after end date");
		
		return db.query("SELECT DISTINCT ON (max_occupancy, accessible, max_rv_length, utilities) * FROM site "
				+ "WHERE campground_id = ? AND site_id NOT IN "
				+ "(SELECT DISTINCT site_id FROM reservation WHERE (from_date, to_date) OVERLAPS (?, ?))",
				mapRowToSite, campgroundID, startDate, endDate);
	}
}
