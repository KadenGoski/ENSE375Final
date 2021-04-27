package com.uregina.app;

import com.uregina.exceptions.*;

/**
 * 24 hour time
 * 
 */
public class Time24 
{
	int hours;   // 0:23
	int minutes; // 0:59
    /** 
	 * constructor to initial Time24 object
	 * @param hours 		hours of 24-hour time format (0:23)
	 * @param minutes	minutes of 24-hour time format (0:59)
	*/
	public Time24(int hours, int minutes) throws InvalidTimeException
    {
		if(hours<0||hours>=24) throw new InvalidTimeException();
		if(minutes<0||minutes>=60) throw new InvalidTimeException();
		this.hours=hours;
		this.minutes=minutes;
    }
	/**
	* returns the hours of 24-hour time format (0:23)
	*/
	public int getHours(){
		return this.hours;
	}
	/**
	* returns the minutes of 24-hour time format (0:59)
	*/
	public int getMinutes(){
		return this.minutes;
	}
	/**
	 * Convert time 12-hour to 24-hour
	 * @param  houra		hours in 12-hour time format (1:12)
	 * @param  minutea	minutes in 24-hour time format (0:59)
	 * @param  am_pm	enumerator with the value of am or pm
	 * @return 		An equavalent Time24 object
	 * 				a null for invalid input parameters
	 * 				No exception should be thrown
	 * @see 	https://www.freecodecamp.org/news/mathematics-converting-am-pm-to-24-hour-clock/
	 * @note	(12 am and 12 pm are special cases)
	 */
	public static Time24 toTime24(int hours, int minutes, AmPm am_pm)
	{
		Time24 time=null;
		//Todo : add your code here


		// End of your code
		return time;
	}
	/**
	 * subtract two times
	 * @param  t1	integer from 1:12
	 * @param  t2	integer fro 0:59
	 * @return 		the value of (t1-t2) in minutes
	 * 				it may be a negative value
	 */
	public static int subtract(Time24 t1, Time24 t2)
	{
		int dHour=t1.hours-t2.hours;
		int dMinute=t1.minutes-t2.minutes;
		return dHour*60+dMinute;
	}
	/**
	 * Convert Time24 object to string
	 * @param  None
	 * @return a string in the fromat HH:MM 
	*/
	public String toString()
	{
		return String.format("%2d:%2d",this.hours,this.minutes);
	}
}
