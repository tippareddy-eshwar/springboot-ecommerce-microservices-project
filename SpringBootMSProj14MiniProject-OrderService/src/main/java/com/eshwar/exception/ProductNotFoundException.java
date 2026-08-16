//ProductNotFoundException .java(Custom Exception Class)
package com.eshwar.exception;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SuppressWarnings("serial")
public class ProductNotFoundException extends RuntimeException
{
    public ProductNotFoundException(String message)
    {
    	super(message);
    	log.debug("ProductNotFoundException Class Parameterized Constructor is Executed...");
    }
}
