//InventoryDTO .java(DTO Class)
package com.eshwar.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDTO 
{

	@NotNull(message = "iNVENTORY Id is required")
	@Schema(description = "Unique Inventory ID", example = "1")
	private Integer inventoryId;
	   
	@NotNull(message = "Product Id is required") 
	@Positive(message = "Product Id must be greater than zero")
	@Schema(description = "Product ID",example = "3")
	private Integer productId;
	   
	@NotNull(message = "Avilable Quantity is required") 
	@Positive(message="AvilableQuantity Must be greater than Zero")
	@Schema(description = "Available Quantity",example = "15")
	private Integer avilableQuantity;
	
}
