//CategoryNotFoundException.java(Custom Exception Class)
package com.eshwar.exceptionhandling;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SuppressWarnings("serial")
public class CategoryNotFoundException extends RuntimeException
{
   public  CategoryNotFoundException(String message)
   {
	   super(message);
	   log.debug("CategoryNotFoundException Class Parameterized Constructor is Executed...");
   }
}
