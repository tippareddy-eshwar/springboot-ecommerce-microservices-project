//PaymentDTO.java(DTO Class)
package com.eshwar.dto;
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
public class PaymentDTO
{
	
	@NotNull(message ="PaymenT ID is required")
	@Schema(description = "Order ID", example="5")
    private Integer paymentId;
	
	@NotNull(message = "Order Id is required")
	@Positive(message = "Order Id Must be greater than zero")
	@Schema(description = "Order ID", example="5")
    private Integer orderId;
	
	@NotNull(message="Amount is required")
	@Positive(message = "Amount Must be greater than zero")
	@Schema(description = "Amount", example="75000")
    private Double amount;
    
    @NotBlank(message = "PaymentStatus is required")
    @Schema(description = "Payment Status", example="Sucess")
    private String paymentStatus;
    
    @NotBlank(message = "PaymentMode is required")
    @Schema(description = "Payment Mode", example="UPI")
    private String paymentMode;
}
