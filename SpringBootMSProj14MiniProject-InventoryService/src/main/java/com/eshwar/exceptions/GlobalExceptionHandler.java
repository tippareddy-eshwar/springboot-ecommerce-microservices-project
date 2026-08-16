//GlobalExceptionHandler.java
package com.eshwar.exceptions;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import lombok.extern.slf4j.Slf4j;
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler 
{
	@ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String,Object>>handlingProductNotFoundException(ProductNotFoundException exception)
    {
    	log.debug("GlobalExceptionHandler Class handlingProductNotFoundException(---) method is executed...");
    	//Creating the Map
    	Map<String,Object>map=new HashMap<>();
    	map.put("timestamp",LocalDateTime.now());
    	map.put("message",exception.getMessage());
    	map.put("status",HttpStatus.NOT_FOUND.value());
    	
    	log.info("GlobalExceptionHandler Class handlingProductNotFoundException(---) method is returning ResponseEntity<Map<String,Object>> Class Object");
    	//returning the ResponseEntity Class Object
    	return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<Map<String,Object>>handlingInsufficientStockException(InsufficientStockException exception)
    {
    	log.debug("GlobalExceptionHandler Class handlingInsufficientStockException(---) method is executed...");
    	//Creating the Map
    	Map<String,Object>map=new HashMap<>();
    	map.put("timestamp",LocalDateTime.now());
    	map.put("message",exception.getMessage());
    	map.put("status",HttpStatus.NOT_FOUND.value());
    	
    	log.info("GlobalExceptionHandler Class handlingInsufficientStockException(---) method is returning ResponseEntity<Map<String,Object>> Class Object");
    	//returning the ResponseEntity Class Object
    	return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
    }
}
