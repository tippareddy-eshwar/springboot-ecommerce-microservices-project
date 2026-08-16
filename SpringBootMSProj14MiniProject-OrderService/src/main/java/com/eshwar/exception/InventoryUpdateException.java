//InventoryUpdateException.java(custom exception class)
package com.eshwar.exception;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SuppressWarnings("serial")
public class InventoryUpdateException extends RuntimeException
{
	   public InventoryUpdateException(String message)
	    {
	        super(message);
	        log.debug("InventoryUpdateException Class Parameterized Constructor is executed...");
	    }
	}


