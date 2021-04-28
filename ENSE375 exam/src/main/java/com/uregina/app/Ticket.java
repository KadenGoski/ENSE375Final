package com.uregina.app;

import com.uregina.exceptions.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Class Ticket, a List of Flights in ordered sequences
 *
 */
public class Ticket
{
	
	private static final String [] SchengenAirportsCode = new String[] { "VIE","BRU","PRG","CPH","TLL","HEL","CDG","FRA","MUC","ATH","BUD","KEF","CIA","RIX","VNO","LUX","MLA","AMS","OSL","WAW","LIS","LJU","KSC","MAD","ARN","BRN"};
	/**
	 * The function checks the validity of a ticket
	 * It checks
	 *		1. airports code are in IATA format (any three uppercases letters)
	 *		2. maximum flights Count >= number of flights in the ticket
	 *		3. maximum flight time >= Total flight times ( sum of flight time of each flight)
	 *		4. maximum layover time >= Total layover times ( sum of layover time between each consequative flight)
	 *		5. no flight between two airports in the Schengen area unless the passenger has a valid Schengen Visa
	 *		6. no cyclic trip
	 *		7. The sequence of flights in correct ( the arrival airport of a flight is the departure airport of the next flight)
	 * 		8. any other logical constraints 
	 * @param	ticket				List of ordered sequences of flights
	 * @param	maxFlightsCount		Maximum number of flights in the ticket
	 * @param	maxFlightTime		Maximum allowable total flight times in minutes
	 * @param	maxLayoverTime		Maximum allowable total layover times in minutes
	 * @param	hasSchengenVisa		to indicate if the passenger has a valid Schengen Visa or not
	 * @return	true if the ticket is valid, false otherwise
	 * useful functions that you may use
	 * 		(class: Flight , method: getArrivalAirport)
	 * 		(class: Flight , method: getDepatureAirport)
	 * 		(class: Flight , method: calculateFlightTime)
	 * 		(class: Flight , method: calculateLayoverTime)
	 * 		(class: ticket , method: hasCyclicTrip)
	*/
	public static boolean checkTicket( ArrayList<Flight> ticket, int maxFlightsCount, int maxFlightTime, int maxLayoverTime, boolean hasSchengenVisa)
	{
		
		//Todo: add your code here
		try {
		int flightsCount = 0;
		int flightTime = 0;
		int layoverTime = 0;
		boolean arrivalCodeSchengen = false;
		boolean departureCodeSchengen = false;

		//check for valid inputs.
		if (ticket == null || (maxFlightsCount <= 0 || maxFlightTime <= 0 || maxLayoverTime < 0))
		{
			//return false right away if there is invalid input.
			return false;
		}

		//6. no cyclic trip
		if (hasCyclicTrip(ticket))
		{
			return false;
		}


       //check airport codes of ticket(s)
	   for (Flight flight : ticket )
		{
		
			String arrivalCode = flight.getArrivalAirport();
			String departureCode = flight.getDepatureAirport();
			
			


			//1. airports code are in IATA format (any three uppercases letters)
			//length of codes cant be bigger than 3 otherwise invalid.
			if ((arrivalCode.length() > 3 || departureCode.length() > 3) || (arrivalCode.length() < 3 || departureCode.length() < 3)  )
			{
				return false;
			}

			//check airport codes.
			for (int i = 0; i < 3; i++)
			{
				char test = arrivalCode.charAt(i);
				int asciiChar = (int)test;
			    //If char value is greater than this or smaller than. That means the code has something invalid in it.
				if (asciiChar >= 90 || asciiChar <= 65)
				{
                  return false;
				}
			}

			


			//check to ensure that the flights aren't between Schengen area without a visa.
			for (int i = 0; i < SchengenAirportsCode.length; i++ )
			{
				if (arrivalCode == SchengenAirportsCode[i])
				{
					arrivalCodeSchengen = true;
				}
				if (departureCode  == SchengenAirportsCode[i])
				{
					departureCodeSchengen = true;
				}
			}

			//if both flags are true that means the flight was between two Schengen Airports. Check for visa.
			//reset flags.
			if (arrivalCodeSchengen == true && departureCodeSchengen == true && (!hasSchengenVisa))
			{
				return false;
			}

			arrivalCodeSchengen = false;
			departureCodeSchengen = false;

			//increment flight time, layover time and flights count.
			flightsCount++;
			flightTime = flightTime + flight.calculateFlightTime();

			//if we have a next flight...add to layover time and check if the sequence is correct.
			if (ticket.size() > flightsCount)
			{
			if(ticket.get(flightsCount) != null)
			{
            layoverTime = layoverTime + Flight.calculateLayoverTime(flight,ticket.get(flightsCount));
			
			//7. The sequence of flights in correct ( the arrival airport of a flight is the departure airport of the next flight) 
			
			if (arrivalCode != ticket.get(flightsCount-1).getDepatureAirport())
			{
				//sequence is bad.
				return false;
			}
		}
			}
		}


		//*	2. maximum flights Count >= number of flights in the ticket
		//*	3. maximum flight time >= Total flight times ( sum of flight time of each flight)
		// 4. maximum layover time >= Total layover times ( sum of layover time between each consequative flight)
		if (flightTime > maxFlightTime || layoverTime > maxLayoverTime || flightsCount > maxFlightsCount)
		{
			return false;
		}

		//end of your code
		return true;
	}
	catch (MoreThanOneDayException | NegativeTimeException e)
	{}
	return true;
	}
		/**
	 * The function checks if the ticket has a cyclic trip
	 * (that is, no passenger can arrive at the same airport more than once within the same ticket)
	 * @param	ticket				List of ordered sequences of flights
	 * @return	true if the ticket has a cyclic trip, false otherwise
	 * usefeul functions that you may use
	 * 		(class: Flight , method: getArrivalAirport)
	 * 		(class: Flight , method: getDepatureAirport)
	*/
	public static boolean hasCyclicTrip(ArrayList<Flight> ticket)
	{
		//Todo : add your code here
		

		//Todo : end of your code
		return false;
	}
}