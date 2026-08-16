//InventoryServiceUnavailableException .java(custom exception class)
package com.eshwar.exception;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SuppressWarnings("serial")
public class InventoryServiceUnavailableException extends RuntimeException
{
   public InventoryServiceUnavailableException(String message)
   {
	   super(message);
	   log.debug("InventoryServiceUnavailableException Class Parameterized Constructor is executed...");
   }
}
