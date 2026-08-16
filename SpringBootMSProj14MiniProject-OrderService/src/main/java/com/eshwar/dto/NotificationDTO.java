// NotificationDTO.java(DTO Class)
package com.eshwar.dto;
import java.io.Serializable;
import lombok.Data;

@SuppressWarnings("serial")
@Data
public class NotificationDTO implements Serializable
{
	
	    private Integer notificationId;
		
	    private Integer orderId;
		
	    private String message;
		
	    private String notificationType;

	    private String status;
	  
}
