//NotificationController.java(Rest Controller Class)
package com.eshwar.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eshwar.dto.NotificationDTO;
import com.eshwar.service.INotificationServiceManagement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/notifications-api")//Global Path (or) Global Request Path
@Tag(name = "Notification Controller" , description = "Rest APIs For Notification Service")
@Slf4j
public class NotificationController 
{
	
    private final INotificationServiceManagement service;
    
    public NotificationController(INotificationServiceManagement service)
    {
    	this.service=service;
    	log.debug("NotificationController Class Parameterized Constructor is executed...");
    }
	
	@PostMapping("/sendNotification")//Method Path (or) Method Request Path
	@Operation(summary = "Send Notification" , description = "This API is used to send a notification to the user.")
	@ApiResponses({
		 @ApiResponse(responseCode = "201" ,
				      description = "Notification Sent Sucessfully"
				     ),
		 @ApiResponse(responseCode = "400" ,
	      description = "Invalid Request Data"
	                 ),
		 @ApiResponse(responseCode = "500" ,
	      description = "Internal Server Error"
	     ),
		 
	})
	public ResponseEntity<String>sendNotification(@Valid @RequestBody NotificationDTO notificationDTO)
	{
		log.debug("NotificationController Class sendNotification(---) method is executed...");
		
		log.info("NotificationController Class sendNotification(---) method is returning ResponseEntity<String>");
		//returning the ResponseEntity Class Object
		return new ResponseEntity<String>(service.sendNotification(notificationDTO),HttpStatus.CREATED);
	}
}
