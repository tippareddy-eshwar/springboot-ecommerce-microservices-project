//PaymentServiceUnavailableException.java(Custom Exception Class)
package com.eshwar.exception;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SuppressWarnings("serial")
public class PaymentServiceUnavailableException extends RuntimeException
{
   public PaymentServiceUnavailableException(String message)
   {
	   super(message);
	   log.debug("PaymentServiceUnavailableException Class Parameterized Constructor is executed...");
   }
}
