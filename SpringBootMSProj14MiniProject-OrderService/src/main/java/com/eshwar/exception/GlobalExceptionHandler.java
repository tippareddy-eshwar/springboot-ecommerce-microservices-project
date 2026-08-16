//GlobalExceptionHandler .java
package com.eshwar.exception;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
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
	     
	     log.info("GlobalExceptionHandler Class handlingProductNotFoundException(---) method is returning ResponseEntity<Map<String,Object>>");
	     //returning the ResponseEntity Class Object
	     return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
   }
   
   
   @ExceptionHandler(InsufficientQuantityException.class)
   public ResponseEntity<Map<String,Object>>handlingInsufficientQuantityException(InsufficientQuantityException exception)
   {
	     log.debug("GlobalExceptionHandler Class handlingInsufficientQuantityException(---) method is executed...");
	     //Creating the Map
	     Map<String,Object>map=new HashMap<>();
	     map.put("timestamp",LocalDateTime.now());
	     map.put("message",exception.getMessage());
	     map.put("status",HttpStatus.NOT_FOUND.value());
	     
	     log.info("GlobalExceptionHandler Class handlingInsufficientQuantityException(---) method is returning ResponseEntity<Map<String,Object>>");
	     //returning the ResponseEntity Class Object
	     return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
   }
   
   
   @ExceptionHandler(OrderNotFoundException.class)
   public ResponseEntity<Map<String,Object>>handlingOrderNotFoundException(OrderNotFoundException exception)
   {
	     log.debug("GlobalExceptionHandler Class handlingOrderNotFoundException(---) method is executed...");
	     //Creating the Map
	     Map<String,Object>map=new HashMap<>();
	     map.put("timestamp",LocalDateTime.now());
	     map.put("message",exception.getMessage());
	     map.put("status",HttpStatus.NOT_FOUND.value());
	     
	     log.info("GlobalExceptionHandler Class handlingOrderNotFoundException(---) method is returning ResponseEntity<Map<String,Object>>");
	     //returning the ResponseEntity Class Object
	     return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(InventoryServiceUnavailableException.class)
   public ResponseEntity<Map<String,Object>>handlingInventoryServiceUnavailableException(InventoryServiceUnavailableException exception)
   {
	     log.debug("GlobalExceptionHandler Class handlingInventoryServiceUnavailableException(---) method is executed...");
	     //Creating the Map
	     Map<String,Object>map=new HashMap<>();
	     map.put("timestamp",LocalDateTime.now());
	     map.put("message",exception.getMessage());
	     map.put("status",HttpStatus.NOT_FOUND.value());
	     
	     log.info("GlobalExceptionHandler Class handlingInventoryServiceUnavailableException(---) method is returning ResponseEntity<Map<String,Object>>");
	     //returning the ResponseEntity Class Object
	     return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(PaymentServiceUnavailableException.class)
   public ResponseEntity<Map<String,Object>>handlingPaymentServiceUnavailableException(PaymentServiceUnavailableException exception)
   {
	     log.debug("GlobalExceptionHandler Class handlingPaymentServiceUnavailableException(---) method is executed...");
	     //Creating the Map
	     Map<String,Object>map=new HashMap<>();
	     map.put("timestamp",LocalDateTime.now());
	     map.put("message",exception.getMessage());
	     map.put("status",HttpStatus.NOT_FOUND.value());
	     
	     log.info("GlobalExceptionHandler Class handlingPaymentServiceUnavailableException(---) method is returning ResponseEntity<Map<String,Object>>");
	     //returning the ResponseEntity Class Object
	     return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(InventoryUpdateException.class)
   public ResponseEntity<Map<String,Object>>handlingInventoryUpdateException(InventoryUpdateException exception)
   {
	     log.debug("GlobalExceptionHandler Class handlingInventoryUpdateException(---) method is executed...");
	     //Creating the Map
	     Map<String,Object>map=new HashMap<>();
	     map.put("timestamp",LocalDateTime.now());
	     map.put("message",exception.getMessage());
	     map.put("status",HttpStatus.NOT_FOUND.value());
	     
	     log.info("GlobalExceptionHandler Class handlingInventoryUpdateException(---) method is returning  ResponseEntity<Map<String,Object>>");
	     //returning the ResponseEntity Class Object
	     return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(NotificationServiceUnavailableException.class)
   public ResponseEntity<Map<String,Object>>handlingNotificationServiceUnavailableException(NotificationServiceUnavailableException exception)
   {
	     log.debug("GlobalExceptionHandler Class handlingNotificationServiceUnavailableException(---) method is executed...");
	     //Creating the Map
	     Map<String,Object>map=new HashMap<>();
	     map.put("timestamp",LocalDateTime.now());
	     map.put("message",exception.getMessage());
	     map.put("status",HttpStatus.NOT_FOUND.value());
	     
	     log.info("GlobalExceptionHandler Class handlingNotificationServiceUnavailableException(---) method is returning ResponseEntity<Map<String,Object>>");
	     //returning the ResponseEntity Class Object
	     return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
   }
   
   
   @ExceptionHandler(ProductServiceUnavailableException.class)
   public ResponseEntity<Map<String,Object>>handlingProductServiceUnavailableException(ProductServiceUnavailableException exception)
   {
	     log.debug("GlobalExceptionHandler Class handlingProductServiceUnavailableException(---) method is executed...");
	     //Creating the Map
	     Map<String,Object>map=new HashMap<>();
	     map.put("timestamp",LocalDateTime.now());
	     map.put("message",exception.getMessage());
	     map.put("status",HttpStatus.NOT_FOUND.value());
	     
	     log.info("GlobalExceptionHandler Class handlingProductServiceUnavailableException(---) method is returning  ResponseEntity<Map<String,Object>>");
	     //returning the ResponseEntity Class Object
	     return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
   }
}
