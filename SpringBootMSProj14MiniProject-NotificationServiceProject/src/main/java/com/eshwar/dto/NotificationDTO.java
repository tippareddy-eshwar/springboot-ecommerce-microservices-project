//NotificationDTO.java(DTO Class)
package com.eshwar.dto;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO implements Serializable
{   
	
	    private static final long serialVersionUID = 1L;

	    @NotNull(message = "Notification ID is required")
	    @Schema(description = "Notification ID" , example = "1")
		private Integer notificationId;
		
	    @NotNull(message = "Order Id is required")
	    @Positive(message = "Order Id Must be Positive")
	    @Schema(description = "Order ID" , example = "5")
	    private Integer orderId;
	    
	    @NotBlank(message = "Message is required")
	    @Schema(description = "Message" , example="Order Placed Sucessfully")
	    private String message;
	    
	    @NotBlank(message = "Notification Type is required")
	    @Schema(description = "Notification Type" , example="EMAIL")
	    private String notificationType;

	    @NotBlank(message = "Status is required")
	    @Schema(description = "Status" , example = "SENT")
	    private String status;

}
