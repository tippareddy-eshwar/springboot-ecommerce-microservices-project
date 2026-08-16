//GlobalExceptionHandler .java (Global Exception Handler Class)
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
	@ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<Map<String,Object>>handlingPaymentNotFoundException(PaymentNotFoundException exception)
    {
    	
    	log.debug("GlobalExceptionHandler Class handlingPaymentNotFoundException(---) method is executed...");
    	//Creating the Map
    	Map<String,Object> map=new HashMap<>();
    	map.put("timestamp",LocalDateTime.now());
    	map.put("message",exception.getMessage());
    	map.put("status",HttpStatus.NOT_FOUND.value());
    	
    	log.info("GlobalExceptionHandler Class handlingPaymentNotFoundException(---) method is returning ResponseEntity<Map<String,Object>>");
    	//returning the ResponseEntity Class Object
    	return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
    }
}
