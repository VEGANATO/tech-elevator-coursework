package com.techelevator.model;

import java.math.BigDecimal;
import java.text.DateFormatSymbols;
import java.time.LocalDate;

public class Campground
{
	private int id, openFrom, openTo;
	private String name;
	private BigDecimal dailyFee;
	
	private static String[] monthNames = new DateFormatSymbols().getMonths();
	
	public Campground(int id, String name, int openFrom, int openTo, BigDecimal dailyFee)
	{
		this.id = id;
		this.name = name;
		this.openFrom = openFrom;
		this.openTo = openTo;
		this.dailyFee = dailyFee;
	}
	
	public boolean isOpenForDates(LocalDate startDate, LocalDate endDate)
	{
		return ((isYearRound() || startDate.getYear() == endDate.getYear()) &&
				(startDate.getMonthValue() >= openFrom && endDate.getMonthValue() <= openTo));
	}
	
	private boolean isYearRound()
	{
		return (openFrom == 1 && openTo == 12); 
	}
	
	public int getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getOpenFrom()
	{
		return monthNames[openFrom - 1];
	}
	public String getOpenTo()
	{
		return monthNames[openTo - 1];
	}
	public BigDecimal getDailyFee()
	{
		return dailyFee;
	}
}
