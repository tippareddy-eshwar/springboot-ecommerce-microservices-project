//InsufficientQuantityException.java(Custom Exception Class)
package com.eshwar.exception;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SuppressWarnings("serial")
public class InsufficientQuantityException extends RuntimeException
{
    public InsufficientQuantityException(String message)
    {
    	super(message);
    	log.debug("InsufficientQuantityException Class Parametrized Constructor is Executed...");
    	
    }
}
