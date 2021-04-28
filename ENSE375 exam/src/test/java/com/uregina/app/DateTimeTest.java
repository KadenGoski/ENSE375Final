//Kaden Goski 200392031
// ENSE 375 Final 
//April 27, 2021

package com.uregina.app;

import static org.junit.Assert.assertTrue;

import com.uregina.exceptions.InvalidDateException;
import com.uregina.exceptions.InvalidTimeException;
import com.uregina.exceptions.MoreThanOneDayException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;



import org.junit.Test;

/**
 *Test for the DateTime class / subtract() function.
 */

public class DateTimeTest 
{
  //3 tests for subtract() function as white box testing results showed.

  //Expected result is -9999
  //Null input on D1 or D2.
    @Test
    public void nullInput()
    {
    try {
        AmPm am_pm = AmPm.pm;
        Date date1 = new Date(10,3,2021);
        Time12 time1 = new Time12(10,20,am_pm);
        DateTime d1 = new DateTime(date1,time1);
    
        
    assertEquals(DateTime.subtract(d1, null), -9999);

    } catch (InvalidDateException | InvalidTimeException | MoreThanOneDayException e) {
    }
    }

 //Expected result is 1010
  //Less than one day apart.
  @Test
  public void lessThanOneDay()
  {
  try {
      AmPm am_pm = AmPm.pm;

      Date date1 = new Date(10,3,2021);
      Time12 time1 = new Time12(10,20,am_pm);
      DateTime d1 = new DateTime(date1,time1);
    
      am_pm = AmPm.am;
      Date date2 = new Date (10,4,2021);
      Time12 time2 = new Time12(10,20,am_pm);
      DateTime d2 = new DateTime(date2,time2);

      assertEquals(DateTime.subtract(d1, d2), 720);

  } catch (InvalidDateException | InvalidTimeException | MoreThanOneDayException e) {
  }
  }

//Expected result is to throw the exception
  //More than one day apart.
  @Test
  public void throwsMoreThanOneDay()
  {
  try {
      AmPm am_pm = AmPm.pm;

      Date date1 = new Date(10,5,2020);
      Time12 time1 = new Time12(10,20,am_pm);
      DateTime d1 = new DateTime(date1,time1);
    
      am_pm = AmPm.am;
      Date date2 = new Date (10,10,2020);
      Time12 time2 = new Time12(10,20,am_pm);
      DateTime d2 = new DateTime(date2,time2);

    //Don't have access to assertThrows with the given JUnit version it seems so I used a try/catch block.
     try {
         DateTime.subtract(d1, d2);
         //if we get here the exception didnt go off. Fail.
         assertFalse(true);
     }
     catch (MoreThanOneDayException e)
     {

     }
  

    }catch (InvalidDateException | InvalidTimeException  e) {
  }}}




    

    