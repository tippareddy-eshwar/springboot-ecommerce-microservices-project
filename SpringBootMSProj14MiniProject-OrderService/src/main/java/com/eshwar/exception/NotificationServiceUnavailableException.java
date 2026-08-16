//NotificationServiceUnavailableException.java(custom exception class)
package com.eshwar.exception;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SuppressWarnings("serial")
public class NotificationServiceUnavailableException extends RuntimeException
{
    public NotificationServiceUnavailableException(String message)
    {
    	super(message);
    	log.debug("NotificationServiceUnavailableException Class Parameterized Constructor is executed...");
    }
}
