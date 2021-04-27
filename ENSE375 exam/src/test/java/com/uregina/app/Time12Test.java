package com.uregina.app;

import static org.junit.Assert.assertTrue;

import com.uregina.exceptions.InvalidTimeException;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *Test for the Time12 class / subtract() function.
 */

public class Time12Test 
{
  //4 tests for subtract() function as white box testing results showed.

    
  
  //One of input objects are null/invalid.
    @Test
    public void invalidTimeReturnNull()
    {
    try {
      AmPm am_pm = AmPm.am;
      Time12 t1;
   
        t1 = new Time12(12,12,am_pm);
   
    assertEquals(Time12.subtract(t1, null),-9999);

    } catch (InvalidTimeException e) {}
    }


    //5h,14 minutes AM and 3h, 10 minutes AM.
    //T1 > T2 positive integer output.
    @Test
    public void positiveIntegerOutput()
    {
        try {
            AmPm am_pm = AmPm.am;
            Time12 t1;
            Time12 t2;
              t1 = new Time12(5,14,am_pm);
              t2 = new Time12(3,10,am_pm);
          assertEquals(Time12.subtract(t1,t2), 124);
        }catch (InvalidTimeException e) {}
    }

    //Test Case Negative Integer Output
    //T1 < T2 negative integer output.
    //3h,10 minutes AM and 5h, 14 minutes AM
    @Test
    public void negativeIntegerOutput()
    {
        try {
            AmPm am_pm = AmPm.am;
            Time12 t1;
            Time12 t2;
              t1 = new Time12(3,10,am_pm);
              t2 = new Time12(5,14,am_pm);
          assertEquals(Time12.subtract(t1,t2), -124);
        }catch (InvalidTimeException e) {}
    }

    //Test Case Zero Output
   //T1 < T2 negative integer output.
   //5h 14 minutes PM and 5h 14 minutes PM.
   @Test
   public void zeroOutput()
   {
       try {
           AmPm am_pm = AmPm.pm;
           Time12 t1;
           Time12 t2;
             t1 = new Time12(5,14,am_pm);
             t2 = new Time12(5,14,am_pm);
         assertEquals(Time12.subtract(t1,t2), 0);
       }catch (InvalidTimeException e) {}
   }








    
    }
    