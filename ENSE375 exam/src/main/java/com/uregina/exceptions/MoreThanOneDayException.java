package com.uregina.exceptions;
import java.io.*;
/**
 * Hello world!
 *
 */
public class MoreThanOneDayException extends Exception{
    public MoreThanOneDayException(){
		super("Date difference is more than 1");
	}
}