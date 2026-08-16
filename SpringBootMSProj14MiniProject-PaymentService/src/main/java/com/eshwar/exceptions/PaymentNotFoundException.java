//PaymentNotFoundException.java(Custom Exception Class)
package com.eshwar.exceptions;
import lombok.extern.slf4j.Slf4j;
@SuppressWarnings("serial")
@Slf4j
public class PaymentNotFoundException extends RuntimeException
{
    public PaymentNotFoundException(String message)
    {
    	  super(message);
    	  log.debug("PaymentNotFoundException Class Parameterized Constructor is executed...");
    }
}
