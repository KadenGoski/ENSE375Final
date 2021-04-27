package com.uregina.app;

import static org.junit.Assert.assertTrue;

import com.uregina.exceptions.InvalidDateException;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 *Test for the Date class / lessThan() function.
 */

public class DateTest 
{
  //6 tests for lessThan() function as black box testing results showed.

  //Valid Case returns true.
  //D1 < D2
    @Test
    public void validLessThan()
    {
    try {
        Date d1 = new Date(1,2,1999);
        Date d2 = new Date(1,2,2020);
        
    assertTrue(Date.lessThan(d1, d2));

    } catch (InvalidDateException e) {}
    }

  //Returns false.
  //A2, B2 = Valid, A2.year > B2.year
  @Test
  public void falseYearGreater()
  {
  try {
      Date d1 = new Date(1,2,1999);
      Date d2 = new Date(1,2,1998);
      
  assertFalse(Date.lessThan(d1, d2));

  } catch (InvalidDateException e) {}
  }

  //Returns false.
  //A3. year == B3.year && A3.month > B3.month
  @Test
  public void falseYearSameMonthGreater()
  {
  try {
      Date d1 = new Date(4,1,2000);
      Date d2 = new Date(3,1,2000);
      
  assertFalse(Date.lessThan(d1, d2));

  } catch (InvalidDateException e) {}
  }


  //Returns false
  //A4. year == B4.year && A4.month == B4.month && A4.day > B4.day
  @Test
  public void falseYearMonthSameDayGreater()
  {
  try {
      Date d1 = new Date(4,2,2000);
      Date d2 = new Date(4,1,2000);
      
  assertFalse(Date.lessThan(d1, d2));

  } catch (InvalidDateException e) {}
  }

  //Returns false
  // A5 == A6
  @Test
  public void sameDateFalse()
  {
  try {
      Date d1 = new Date(4,2,2000);
      Date d2 = new Date(4,2,2000);
      
  assertFalse(Date.lessThan(d1, d2));

  } catch (InvalidDateException e) {}
  }



  //Returns false
  // Null date
  @Test
  public void nullDate()
  {
  try {
      Date d1 = new Date(4,2,2000);      
  assertFalse(Date.lessThan(d1, null));
  } catch (InvalidDateException e) {}
  }



    
    }
    