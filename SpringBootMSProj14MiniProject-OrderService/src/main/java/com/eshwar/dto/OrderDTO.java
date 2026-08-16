//OrderDTO .java(DTO Class)
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
public class OrderDTO 
{
   
	   @NotNull(message = "Order ID is required")
	   @Schema(description = "Unique Order ID", example = "5")
	   private Integer orderId;
	   
	   @NotBlank(message = "Customer Name is required")
	   @Schema(description = "Customer Name", example = "Eshwar")
	   private String  customerName;
	   
	   @NotNull(message = "Product Id is required")
	   @Positive(message = "Product Id must be positive")
	   @Schema(description = "Unique Product ID", example = "3")
	   private Integer productId;
	   
	   @NotNull(message = "Product Quantity is required")
	   @Positive(message = "Product Quantity must be positive")
	   @Schema(description = "Product Quantity", example = "10")
	   private Integer productQuantity;
	   
	   @NotNull(message = "Total Price is required")
	   @Positive(message = "Total Price must be positive")
	   @Schema(description = "Total Price", example = "75000")
	   private Double totalPrice;
	   
	   @NotBlank(message = "Order Status is required")
	   @Schema(description = "Order Status", example = "Confirmed")
	   private String orderStatus;
}
