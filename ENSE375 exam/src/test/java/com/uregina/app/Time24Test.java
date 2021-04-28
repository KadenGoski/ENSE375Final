//Kaden Goski 200392031
// ENSE 375 Final 
//April 27, 2021

package com.uregina.app;

import static org.junit.Assert.assertTrue;

import com.uregina.exceptions.InvalidTimeException;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *Test for the Time24 class / toTime24() function.
 */

public class Time24Test 
{
  //5 tests for toTime24() function as white box testing results showed.

    //Input is not in valid 12 hour format.
    // Path 1->9

    @Test
    public void invalidInputReturnNull()
    {
        AmPm am_pm = AmPm.am;
        try{    
        assertEquals( Time24.toTime24(23, 72, am_pm), null );
        }
        catch (InvalidTimeException e)
        {
          
        }

      }

         //Valid time in PM, noon.
        //In this case 12pm. should return "12:02".
        //Path 1 -> 2 -> 3 -> 5 -> 9
        @Test
        public void PMTimeNoonValid()
        {
          try{   
            AmPm am_pm = AmPm.pm;            
            Time24 time = Time24.toTime24(12, 02, am_pm);     
            assertEquals( time.toString() , "12:02" );
          }
          //Needed due to constructor throwing the exception. Wont actually occur though.
          catch (InvalidTimeException e){}      
         }
        
        
         //Valid time in PM, not noon.
        //In this case 4pm. should return "16:02".
        //Path 1 -> 2 -> 3 -> 6 -> 9
        @Test
        public void PMTime4Valid()
        {
          try{   
            AmPm am_pm = AmPm.pm;            
            Time24 time = Time24.toTime24(4, 02, am_pm);     
            assertEquals( time.toString() , "16:02" );
          }
          //Needed due to constructor throwing the exception. Wont actually occur though.
          catch (InvalidTimeException e){}      
         }
         
        //Valid time in AM,  noon.
        //In this case 6am. should return "06:02".
        //Path 1 -> 2 -> 3 -> 7 -> 9
        @Test
        public void AMTimeNoonValid()
        {
          try{   
            AmPm am_pm = AmPm.am;            
            Time24 time = Time24.toTime24(12, 02, am_pm);     
            assertEquals( time.toString() , "00:02" );
          }
          //Needed due to constructor throwing the exception. Wont actually occur though due to code handling the null case before calling constructor to initialize values..
          catch (InvalidTimeException e){}      
         }

        //Valid time in AM,  not noon.
        //In this case 6am. should return "06:02".
        //Path 1 -> 2 -> 3 -> 8 -> 9
        @Test
        public void AMTime6Valid()
        {
          try{   
            AmPm am_pm = AmPm.am;            
            Time24 time = Time24.toTime24(6, 02, am_pm);     
            assertEquals( time.toString() , "06:02" );
          }
          //Needed due to constructor throwing the exception. Wont actually occur though due to code handling the null case before calling constructor to initialize values..
          catch (InvalidTimeException e){}      
         }


    
    }
    

