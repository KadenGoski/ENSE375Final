package com.uregina.app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * App , creates a ticket and check its validity
 *
 */
public class App 
{
	/**
	 * The main program
	 * 		1. Creating a ticket
	 * 		2. Printing the ticket
	 * 		3. Get User restriction
	 * 		4. Checking the ticket
	 */
    public static void main( String[] args )
    {
		ArrayList<Flight> ticket= new ArrayList<Flight>();
		Scanner scan = new Scanner(System.in);
        System.out.println( "1. Creating a ticket" );
		String again="n";
		do
		{
			System.out.print( "\tEnter the departure airport code: " );
			String depatureAirport = scan.nextLine();
			System.out.print( "\tEnter the depature date (MM/DD/YYYY): " );	
			String temp = scan.nextLine();
			Date depatureDate= parseDate(temp);
			while(depatureDate==null)
			{
				System.out.print( "\t***Invalid Date***\n\tRe-enter the depature date (MM/DD/YYYY): " );	
				temp = scan.nextLine();
				depatureDate= parseDate(temp);
			}
			System.out.print( "\tEnter the Depature time (hh:mm am/pm): " );	
			temp = scan.nextLine();
			Time12 depatureTime= parseTime(temp);
			while(depatureTime==null)
			{
				System.out.print( "\t***Invalid time***\n\tRe-enter the depature time (hh:mm am/pm): " );	
				temp = scan.nextLine();
				depatureTime= parseTime(temp);
			}
			System.out.print("\t\n");
			System.out.print( "\tEnter the arrival airport code: " );
			String arrivalAirport = scan.nextLine();
			System.out.print( "\tEnter the arrival date (MM/DD/YYYY): " );	
			temp = scan.nextLine();
			Date arrivalDate= parseDate(temp);
			while(arrivalDate==null)
			{
				System.out.print( "\t***Invalid Date***\n\tRe-enter the arrival date (MM/DD/YYYY): " );	
				temp = scan.nextLine();
				arrivalDate= parseDate(temp);
			}
			System.out.print( "\tEnter the arrival time (hh:mm am/pm): " );	
			temp = scan.nextLine();
			Time12 arrivalTime= parseTime(temp);
			while(arrivalTime==null)
			{
				System.out.print( "\t***Invalid time***\n\tRe-enter the arrival time (hh:mm am/pm): " );	
				temp = scan.nextLine();
				arrivalTime= parseTime(temp);
			}
			System.out.print("\n\tAdd Another flight to the ticket ? (y for yes, others for no) : ");
			temp=scan.nextLine();
			again=temp.toLowerCase().trim();
			ticket.add(new Flight(depatureAirport, arrivalAirport,
				new DateTime(depatureDate,depatureTime),
				new DateTime(arrivalDate,arrivalTime)));
		}
		while(again.equals("y"));
		System.out.println( "2. Printing the ticket" );
		for(Flight f : ticket)
		{
			System.out.println( "\tFrom: "+f.getDepatureAirport()+" [ "+
				f.getDepatureTime()+"] to "+f.getArrivalAirport()+" [ "+
				f.getArrivalTime()+" ]");
		}
		System.out.println( "3. Get User restriction" );
		int maxFlightsCount=nextInt("maximum flights count");
		int maxFlightTime=nextInt("maximum flights time (in minutes)");
		int maxLayoverTime=nextInt("maximum layover time (in minutes)");
		System.out.print("\n\tHas a Schengen Visa? (y for yes, others for no) : ");
		String st=scan.nextLine();
		boolean hasSchengenVisa=st.toLowerCase().trim().equals("y");
		System.out.println( "4. Checking the ticket" );
		System.out.println( Ticket.checkTicket(ticket,maxFlightsCount,maxFlightTime
			,maxLayoverTime,hasSchengenVisa)? "\tValid":"\tInvalid" );
    }
	// prompt for to enter the value for the "name" until getting a valid integer
	public static int nextInt(String name)
	{
		int ret=-1;
		System.out.println("\tEnter "+name+" :");
		Scanner scan = new Scanner(System.in);
		String st=scan.nextLine();
		try{
			ret=Integer.parseInt(st);
		}
		catch(Exception e){ret=-1;}
		while(ret<0)
		{
			System.out.println("\t***Invalid value***\n\tRe-enter "+name+" :");
			st=scan.nextLine();
			try{
				ret=Integer.parseInt(st);
			}
			catch(Exception e){ret=-1;}
		}
		return ret;
		
	}
	// parse a string for a valid Date object, return null if failed
	public static Date parseDate(String date)
	{
		String [] splitted=date.split("/");
		if(splitted.length!=3)
			return null;
		int month,day,year;
		try
		{
			month=Integer.parseInt(splitted[0]);
			day=Integer.parseInt(splitted[1]);
			year=Integer.parseInt(splitted[2]);
		}
		catch(Exception e)
		{
			return null;
		}
		Date retDate=null;
		try{
			retDate=new Date(month,day,year);
		}
		catch (Exception e) {}
		return retDate;
	}
	// parse a string for a valid Time12 object, return null if failed
	public static Time12 parseTime(String time)
	{
		String [] splitted=time.split(":");
		if(splitted.length!=2)
			return null;
		int hours=0,minutes=0;
		try
		{
			hours=Integer.parseInt(splitted[0]);
		}
		catch(Exception e)
		{
			return null;
		}
		splitted=splitted[1].split(" ");
		AmPm am_pm=AmPm.am;
		int n=0;
		for (int i=0;i<splitted.length;i++)
		{
			if(splitted[i]!="")
			{
				if(n==0)
				{
					try
					{
						minutes=Integer.parseInt(splitted[i]);
					}
					catch(Exception e){	return null;}
				}
				else if( n==1)
				{
					String st=splitted[i].toLowerCase();
					if(st.equals("am")) am_pm=AmPm.am;
					else if(st.equals("pm")) am_pm=AmPm.pm;
					else return null;
				}
				else return null;
				n++;
			}
		}
		if(n!=2)
			return null;
		Time12 time12=null;
		try{
			time12=new Time12(hours,minutes,am_pm);
		}
		catch (Exception e) {}
		return time12;
	}
}