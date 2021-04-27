package com.uregina.app;

import com.uregina.exceptions.*;

/**
 * Flight : from depatureAirport (at depatureTime) to arrivalAirport (at arrivalTime)
 *
 */
public class Flight 
{
	private String depatureAirport;		//International Air Transport Association (IATA) code 
	private String arrivalAirport;		//International Air Transport Association (IATA) code
	private DateTime depatureTime;		//MM/DD/YYYY hh:mm am/pm
	private DateTime arrivalTime;		//MM/DD/YYYY hh:mm am/pm
	 /** 
	 * constructor to initial a Flight object
	 * @param depatureAirport 		Departure airport code (should be in IATA format)
	 * @param arrivalAirport		Arrival airport code (should be in IATA format)
	 * @param depatureTime 			Departure DateTime object (MM/DD/YYYY  hh:mm am/pm)
	 * @param arrivalTime			Arrival DateTime object (MM/DD/YYYY  hh:mm am/pm)
	*/
    public Flight(String depatureAirport, String arrivalAirport, DateTime depatureTime, DateTime arrivalTime)
    {
		this.depatureAirport=depatureAirport;
		this.arrivalAirport=arrivalAirport;
		this.depatureTime=depatureTime;
		this.arrivalTime=arrivalTime;
    }
	/**
	* returns the departure airport code (should be in IATA format)
	*/
	public String getDepatureAirport()
	{
		return depatureAirport;
	}
	/**
	* returns the arrival airport code (should be in IATA format)
	*/
	public String getArrivalAirport()
	{
		return arrivalAirport;
	}
	/**
	* returns the departure airport time 
	*/
	public DateTime getDepatureTime()
	{
		return depatureTime;
	}
	/**
	* returns the arrival airport time 
	*/
	public DateTime getArrivalTime()
	{
		return arrivalTime;
	}
	/**
	* calculates the Flight Time
	* @return 	the a Flight flying time in minutes 
	*				Throws MoreThanOneDayException if the two dates are not the same or a consequative days
	*				Throws NegativeTimeException   if the calculated time in minutes is negative
	*/
	public int calculateFlightTime() throws MoreThanOneDayException,NegativeTimeException
	{
		int minutes=DateTime.subtract(arrivalTime,depatureTime);
		if(minutes<0) throw new NegativeTimeException();
		return minutes;
	}
	/**
	* calculates the LayoverTime ( time of waiting in the airport between two flights
	* @param  firstFlight	First Flight
	* @param  nextFlight	next Flight
	* @return 	the layoverTime between the two flights in minutes 
	*				Throws MoreThanOneDayException if the two dates are not the same or a consequative days
	*				Throws NegativeTimeException   if the calculated time in minutes is negative
	*/
	public static int calculateLayoverTime(Flight firstFlight,Flight nextFlight) throws MoreThanOneDayException,NegativeTimeException
	{
		int minutes=DateTime.subtract(nextFlight.depatureTime,firstFlight.arrivalTime);
		if(minutes<0) throw new NegativeTimeException();
		return minutes;
	}
}
