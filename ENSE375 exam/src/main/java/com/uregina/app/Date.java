package com.uregina.app;

import com.uregina.exceptions.*;

/**
 * a date in the format MM/DD/YYYY
 *
 */
public class Date
{
	int month;  //1:12
	int day;	//1:{28,29,30,31}
	int year;	//1812:2212
	/** 
	 * constructor to initial Date object
	 * @param month 		month of a Date (1:12)
	 * @param day			day of a Date (1:{28,29,30,31}) , the final value depends on the month and the year
	 * @param year			year of a Date (1812:2212)
	*/
    public Date(int month, int day,	int year) throws InvalidDateException
	{
		if(day<1||month<1||month>12||year<1812||year>2212){
			throw new InvalidDateException();
		}
		boolean month31Days=((month%2==1) && (month<8))||((month%2==0) && (month>=8));
		boolean month30Days=((month%2==0) && (month<8)&&(month!=2))||((month%2==1) && (month>=8));
		boolean leapYear= (year%400==0)||(year%4==0&&year%100!=0);
		if( (month30Days && day>30) || (month31Days && day>31) || 
			(!month30Days && !month31Days && ( (leapYear && day>29)|| (!leapYear && day>28)) ) ){ // for feb.
				throw new InvalidDateException();
		}
		this.year=year;
		this.day=day;
		this.month=month;
	}
	/**
	 * Convert a Date object to string
	 * @param  None
	 * @return a string in the fromat MM/DD/YYYY
	*/
	public String toString(){
		return String.format("%2d/%2d/%4d",month,day,year);
	}
	/**
	* returns the day of a Date (1:{28,29,30,31})
	*/
	int getDay() { return day;}
	/**
	* returns the month of a Date (1:12)
	*/
	int getMonth() { return month;}
	/**
	* returns the year of a Date (1812:2212)
	*/
	int getYear() { return year;}
	/** 
	 * calculates the nextdate of the calling object
	 * @param 	None
	 * @return  A Date object that represents the next Date of the objets who calls the functions
	*/
	public Date nextDate()
	{
		boolean month31Days=false;
		boolean month30Days=false;
		if((month%2==1) && (month<8)){
			month31Days=true;
		}
		else if((month%2==0) && (month>=8)){
			month31Days=true;
		}
		else if( (month%2==0) && (month<8) &&(month!=2))
		{
			month30Days=true;
		}
		else if(( month%2==1) && (month>=8))
		{
			month30Days=true;
		}
		boolean leapYear=false;
		if(year%400==0){
			leapYear=true;
		}
		else if(year%4==0&&year%100!=0){
			leapYear=true;
		}
		int d =day+1;
		int m =month;
		int y =year;
		if( (d==31 && month30Days) || (d==32 && month31Days) ||
			( !month30Days && !month31Days &&( (d==30 && leapYear) ||  (d==29 && !leapYear)) ) ){  //end of the month
				d=1;
				m++;
		}
		if(m==13) // end of year;
		{
			m=1;
			y++;
		}
		Date date=null;
		try
		{
			date =  new Date(m,d,y);
		}
		catch(Exception e){}
		return date;
	}
	/**
	 * checks if two Date objects are equal
	 * @param 	d1 a Date object
	 * @param 	d2 a Date object
	 * @return	true if d1==d2, false otherwise
	*/
	public static boolean equal(Date d1,Date d2)
	{
		return (d1.day==d2.day && d1.month == d2.month && d1.year == d2.year);
	}
	/**
	 * checks if a Date is before another one
	 * @param 	d1 a Date object
	 * @param 	d2 a Date object
	 * @return	true if d1<d2, false otherwise
	*/
	public static boolean lessThan(Date d1,Date d2)
	{
		//Todo: Add your code here
		
		return false;
	}
}
