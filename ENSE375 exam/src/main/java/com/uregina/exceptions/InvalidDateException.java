package com.uregina.exceptions;
import java.io.*;
/**
 * Hello world!
 *
 */
public class InvalidDateException extends Exception{
    public InvalidDateException(){
		super("Invalid Date");
	}
}