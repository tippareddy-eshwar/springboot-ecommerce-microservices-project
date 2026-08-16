//InsufficientStockException.java(Custom Exception Class)
package com.eshwar.exceptions;
import lombok.extern.slf4j.Slf4j;
@SuppressWarnings("serial")
@Slf4j
public class InsufficientStockException extends RuntimeException
{
   public InsufficientStockException(String message)
   {
	   super(message);
	   log.debug("InsufficientStockException Class Parameterized Constructor is executed...");
   }
}
