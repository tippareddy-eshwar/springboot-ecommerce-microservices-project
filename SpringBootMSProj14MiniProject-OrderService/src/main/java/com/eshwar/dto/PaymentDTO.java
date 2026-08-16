//PaymentDTO.java(DTO Class)
package com.eshwar.dto;
import lombok.Data;

@Data
public class PaymentDTO 
{
	    private Integer paymentId;
		
	    private Integer orderId;
		
	    private Double amount;
	    
	    private String paymentStatus;
	    
	    private String paymentMode;
}
