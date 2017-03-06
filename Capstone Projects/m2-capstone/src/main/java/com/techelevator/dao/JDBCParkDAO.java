package com.techelevator.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.techelevator.model.Park;

public class JDBCParkDAO implements ParkDAO
{
	private JdbcTemplate db;
	
	private RowMapper<Park> mapRowToPark = (row, pos) -> {
		Park p = new Park(row.getInt("park_id"), row.getInt("area"), row.getInt("visitors"), row.getString("name"),
				row.getString("location"), row.getString("description"), row.getDate("establish_date").toLocalDate());
		
		return p;
	};
	
	public JDBCParkDAO(DataSource dataSource)
	{
		this.db = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Park> getAllParks()
	{
		return db.query("SELECT * FROM park", mapRowToPark);
	}

	@Override
	public Park getParkByNameAndState(String parkName, String state)
	{
		try {
			return db.queryForObject("SELECT * FROM park WHERE name = ? AND location = ?", mapRowToPark, parkName, state);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}
}
