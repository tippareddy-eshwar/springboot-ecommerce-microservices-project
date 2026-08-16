//NotificationClientService .java(service class)
package com.eshwar.service;
import org.springframework.stereotype.Service;
import com.eshwar.dto.NotificationDTO;
import com.eshwar.feign.NotificationFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NotificationClientService 
{
    
       
       private final NotificationFeignClient notificationFeign;
       
       //Constructor Injection
       public NotificationClientService(NotificationFeignClient notificationFeign)
       {
    	   this.notificationFeign=notificationFeign;
    	   log.debug("NotificationClientService Class Parameterized Constructor is Executed...");
       }
    
       @CircuitBreaker(name="notificationService",fallbackMethod="notificationFallBack")
	   public String sendNotification(NotificationDTO DTO)
	   {
		   log.debug("OrderServiceManagementImpl Class sendNotification(---,---) method is executed...");
		   
		   log.info("OrderServiceManagementImpl Class sendNotification(---,---) method is returning String");
		   return notificationFeign.sendNotification(DTO);
	   }
	   
	   public String notificationFallBack(NotificationDTO DTO,Throwable e)
	   {
		   log.debug("OrderServiceManagementImpl Class sendNotification(---,---) method is executed...");
		   log.info("Notification Service Down...");
		   log.error("Actual Reason for Failing the Notification Service is : "+e.getMessage());
		   
		   log.info("OrderServiceManagementImpl Class sendNotification(---,---) method is returning String");
		   return "Notification could not be sent, but Order was placed successfully...";
	   }
    
}
