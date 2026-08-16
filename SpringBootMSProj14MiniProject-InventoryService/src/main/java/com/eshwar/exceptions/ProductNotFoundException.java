//ProductNotFoundException.java(Custom Exception Class)
package com.eshwar.exceptions;
import lombok.extern.slf4j.Slf4j;
@SuppressWarnings("serial")
@Slf4j
public class ProductNotFoundException extends RuntimeException
{
   public ProductNotFoundException(String message)
   {
	   super(message);
	   log.debug("ProductNotFoundException Class Parameterized Constructor is executed...");
   }
}
