package com.uregina.exceptions;
import java.io.*;
/**
 * Hello world!
 *
 */
public class NegativeTimeException extends Exception{
    public NegativeTimeException(){
		super("Time in minutes is negative");
	}
}