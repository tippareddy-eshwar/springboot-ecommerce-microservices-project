//OrderNotFoundException.java(Custom Exception Class)
package com.eshwar.exception;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SuppressWarnings("serial")
public class OrderNotFoundException extends RuntimeException
{
    public OrderNotFoundException(String message)
    {
    	super(message);
    	log.debug("OrderNotFoundException Class Parameterized Constructor is Execute...");
    }
}
