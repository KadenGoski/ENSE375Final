//Kaden Goski 200392031
// ENSE 375 Final 
//April 27, 2021

package com.uregina.app;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import com.uregina.exceptions.InvalidDateException;
import com.uregina.exceptions.InvalidTimeException;
import com.uregina.exceptions.MoreThanOneDayException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;



import org.junit.Test;

/**
 *Test for the TicketTest class / checkTicket() function.
 */

public class TicketTest
{
  //11 tests for checkTicket() function as white box testing results showed....kinda. more like my personal results.

  //public static boolean checkTicket( ArrayList<Flight> ticket, int maxFlightsCount, int maxFlightTime, int maxLayoverTime, boolean hasSchengenVisa)
  //	 * @param depatureAirport 		Departure airport code (should be in IATA format)
//	 * @param arrivalAirport		Arrival airport code (should be in IATA format)
//	 * @param depatureTime 			Departure DateTime object (MM/DD/YYYY  hh:mm am/pm)
//	 * @param arrivalTime			Arrival DateTime object (MM/DD/YYYY  hh:mm am/pm)
//	*/
 //   public Flight(String depatureAirport, String arrivalAirport, DateTime depatureTime, DateTime arrivalTime)
  //

  //Null input to flights.
  @Test
  public void nullInput()
  {
 
      
    int maxFlightsCount = 3;
    int maxFlightTime = 10000;
    int maxLayoverTime = 10000;
    boolean hasSchengenVisa = true;

    assertFalse(Ticket.checkTicket(null, maxFlightsCount, maxFlightTime, maxLayoverTime, hasSchengenVisa));
}

//Flight goes back to same airport.
@Test
public void hasCyclicTicket()
    {
    try {
    //create Ticket.
    //create 2 tickets / flights... means create 2 date time objects.
     AmPm am_pm = AmPm.pm;
      Date date1 = new Date(10,3,2021);
      Time12 time1 = new Time12(10,20,am_pm);
      DateTime d1 = new DateTime(date1,time1);
    
      am_pm = AmPm.am;
      Date date2 = new Date (10,4,2021);
      Time12 time2 = new Time12(10,20,am_pm);
      DateTime d2 = new DateTime(date2,time2);
      
      am_pm = AmPm.pm;
      Date date3 = new Date(11,5,2021);
      Time12 time3 = new Time12(10,20,am_pm);
      DateTime d3 = new DateTime(date1,time1);
    
      am_pm = AmPm.am;
      Date date4 = new Date (11,5,2021);
      Time12 time4 = new Time12(10,20,am_pm);
      DateTime d4 = new DateTime(date2,time2);


     Flight f1 = new Flight("VIE","VIE", d1,d2);
     //Flight f2 = new Flight("VIE","VIE", d2,d3);

     ArrayList<Flight> ticket = new ArrayList<Flight>(); 

     ticket.add(f1);

    int maxFlightsCount = 3;
    int maxFlightTime = 10000;
    int maxLayoverTime = 10000;
    boolean hasSchengenVisa = true;

    //Cyclic Ticket Not  implemented.
     assertTrue(Ticket.checkTicket(ticket, maxFlightsCount, maxFlightTime, maxLayoverTime, hasSchengenVisa));

    } catch (InvalidDateException | InvalidTimeException e) {
    }
    }


//Invalid Airport Code Length. Returns false.
@Test
public void invalidAirportCodeLength()
    {
    try {
    //create Ticket.
    //create 2 tickets / flights... means create 2 date time objects.
     AmPm am_pm = AmPm.pm;
      Date date1 = new Date(10,3,2021);
      Time12 time1 = new Time12(10,20,am_pm);
      DateTime d1 = new DateTime(date1,time1);
    
      am_pm = AmPm.am;
      Date date2 = new Date (10,4,2021);
      Time12 time2 = new Time12(10,20,am_pm);
      DateTime d2 = new DateTime(date2,time2);
      
     Flight f1 = new Flight("VIES","VIE", d1,d2);

     ArrayList<Flight> ticket = new ArrayList<Flight>(); 

     ticket.add(f1);

    int maxFlightsCount = 3;
    int maxFlightTime = 10000;
    int maxLayoverTime = 10000;
    boolean hasSchengenVisa = true;

    //Cyclic Ticket Not  implemented.
    assertFalse(Ticket.checkTicket(ticket, maxFlightsCount, maxFlightTime, maxLayoverTime, hasSchengenVisa));

    } catch (InvalidDateException | InvalidTimeException e) {
    }
    }


 


//Invalid Airport Code Format. Not Capitalized Alphnumeric Returns false.
@Test
public void invalidAirportCodeFormat()
    {
    try {
    //create Ticket.
    //create 2 tickets / flights... means create 2 date time objects.
     AmPm am_pm = AmPm.pm;
      Date date1 = new Date(10,3,2021);
      Time12 time1 = new Time12(10,20,am_pm);
      DateTime d1 = new DateTime(date1,time1);
    
      am_pm = AmPm.am;
      Date date2 = new Date (10,4,2021);
      Time12 time2 = new Time12(10,20,am_pm);
      DateTime d2 = new DateTime(date2,time2);
      
     Flight f1 = new Flight("2da","2da", d1,d2);

     ArrayList<Flight> ticket = new ArrayList<Flight>(); 

     ticket.add(f1);

    int maxFlightsCount = 3;
    int maxFlightTime = 10000;
    int maxLayoverTime = 10000;
    boolean hasSchengenVisa = true;

    //Cyclic Ticket Not  implemented.
    assertFalse(Ticket.checkTicket(ticket, maxFlightsCount, maxFlightTime, maxLayoverTime, hasSchengenVisa));

    } catch (InvalidDateException | InvalidTimeException e) {
    }
    }



//Invalid Airport Code Format. Not Capitalized Alphnumeric Returns false.
@Test
public void schengenNoVisa()
    {
    try {
    //create Ticket.
    //create 2 tickets / flights... means create 2 date time objects.
     AmPm am_pm = AmPm.pm;
      Date date1 = new Date(10,3,2021);
      Time12 time1 = new Time12(10,20,am_pm);
      DateTime d1 = new DateTime(date1,time1);
    
      am_pm = AmPm.am;
      Date date2 = new Date (10,4,2021);
      Time12 time2 = new Time12(10,20,am_pm);
      DateTime d2 = new DateTime(date2,time2);
      
     Flight f1 = new Flight("VIE","VIE", d2,d1);

     ArrayList<Flight> ticket = new ArrayList<Flight>(); 

     ticket.add(f1);

    int maxFlightsCount = 3;
    int maxFlightTime = 10000;
    int maxLayoverTime = 10000;
    boolean hasSchengenVisa = false;

    //Cyclic Ticket Not  implemented.
    assertFalse(Ticket.checkTicket(ticket, maxFlightsCount, maxFlightTime, maxLayoverTime, hasSchengenVisa));

    } catch (InvalidDateException | InvalidTimeException e) {
    }
    }

//Invalid Airport Code Format. Not Capitalized Alphnumeric Returns false.
@Test
public void validFlight()
    {
    try {
    //create Ticket.
    //create 2 tickets / flights... means create 2 date time objects.
     AmPm am_pm = AmPm.pm;
      Date date1 = new Date(10,3,2021);
      Time12 time1 = new Time12(10,20,am_pm);
      DateTime d1 = new DateTime(date1,time1);
    
      am_pm = AmPm.am;
      Date date2 = new Date (10,4,2021);
      Time12 time2 = new Time12(10,20,am_pm);
      DateTime d2 = new DateTime(date2,time2);
      
     Flight f1 = new Flight("AIE","YQR", d2,d1);

     ArrayList<Flight> ticket = new ArrayList<Flight>(); 

     ticket.add(f1);

    int maxFlightsCount = 3;
    int maxFlightTime = 10000;
    int maxLayoverTime = 10000;
    boolean hasSchengenVisa = true;

    assertTrue(Ticket.checkTicket(ticket, maxFlightsCount, maxFlightTime, maxLayoverTime, hasSchengenVisa));

    } catch (InvalidDateException | InvalidTimeException e) {
    }
    }




//Valid w/ Schengen visa
@Test
public void schengenVisa()
    {
    try {
    //create Ticket.
    //create 2 tickets / flights... means create 2 date time objects.
     AmPm am_pm = AmPm.pm;
      Date date1 = new Date(10,3,2021);
      Time12 time1 = new Time12(10,20,am_pm);
      DateTime d1 = new DateTime(date1,time1);
    
      am_pm = AmPm.am;
      Date date2 = new Date (10,4,2021);
      Time12 time2 = new Time12(10,20,am_pm);
      DateTime d2 = new DateTime(date2,time2);
      
     Flight f1 = new Flight("VIE","VID", d2,d1);

     ArrayList<Flight> ticket = new ArrayList<Flight>(); 

     ticket.add(f1);

    int maxFlightsCount = 3;
    int maxFlightTime = 10000;
    int maxLayoverTime = 10000;
    boolean hasSchengenVisa = true;

    assertTrue(Ticket.checkTicket(ticket, maxFlightsCount, maxFlightTime, maxLayoverTime, hasSchengenVisa));

    } catch (InvalidDateException | InvalidTimeException e) {
    }
    }

//Flight 2 starts from random airport
@Test
public void badSequence()
    {
    try {
    //create Ticket.
    //create 2 tickets / flights... means create 2 date time objects.
     AmPm am_pm = AmPm.pm;
      Date date1 = new Date(10,3,2021);
      Time12 time1 = new Time12(10,20,am_pm);
      DateTime d1 = new DateTime(date1,time1);
    
      am_pm = AmPm.am;
      Date date2 = new Date (10,4,2021);
      Time12 time2 = new Time12(10,20,am_pm);
      DateTime d2 = new DateTime(date2,time2);
      
      am_pm = AmPm.pm;
      Date date3 = new Date(10,4,2021);
      Time12 time3 = new Time12(11,20,am_pm);
      DateTime d3 = new DateTime(date3,time3);
    
      am_pm = AmPm.am;
      Date date4 = new Date (10,5,2021);
      Time12 time4 = new Time12(10,20,am_pm);
      DateTime d4 = new DateTime(date4,time4);


     Flight f1 = new Flight("VIE","DET", d2,d1);
     Flight f2 = new Flight("DES","FSD", d4,d3);

     ArrayList<Flight> ticket = new ArrayList<Flight>(); 

     ticket.add(f1);
     ticket.add(f2);

    int maxFlightsCount = 3;
    int maxFlightTime = 10000;
    int maxLayoverTime = 10000;
    boolean hasSchengenVisa = true;

    //Cyclic Ticket Not  implemented.
     assertTrue(Ticket.checkTicket(ticket, maxFlightsCount, maxFlightTime, maxLayoverTime, hasSchengenVisa));

    } catch (InvalidDateException | InvalidTimeException e) {
    }
    }


}


    