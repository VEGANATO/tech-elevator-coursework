package com.techelevator.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.techelevator.model.Campground;

public class JDBCCampgroundDAO implements CampgroundDAO
{
	private JdbcTemplate db;
	
	private RowMapper<Campground> mapRowToCampground = (row, pos) -> {
		Campground c = new Campground(row.getInt("campground_id"), row.getString("name"), Integer.parseInt(row.getString("open_from_mm")),
				Integer.parseInt(row.getString("open_to_mm")), row.getBigDecimal("daily_fee"));
		
		return c;
	};
	
	public JDBCCampgroundDAO(DataSource dataSource)
	{
		this.db = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Campground> getCampgroundsByParkID(int parkID)
	{
		return db.query("SELECT * FROM campground WHERE park_id = ?", mapRowToCampground, parkID);
	}

}
