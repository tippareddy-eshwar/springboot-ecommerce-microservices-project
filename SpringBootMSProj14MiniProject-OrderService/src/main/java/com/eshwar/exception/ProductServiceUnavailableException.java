//ProductServiceUnavailableException.java(custom exception class)
package com.eshwar.exception;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SuppressWarnings("serial")
public class ProductServiceUnavailableException extends RuntimeException
{
   public  ProductServiceUnavailableException(String message)
   {
	   super(message);
	   log.debug("ProductServiceUnavailableException Class Parameterized Constructor is executed...");
   }
}
