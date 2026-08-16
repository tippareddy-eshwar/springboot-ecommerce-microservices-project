//ProductDTO.java(DTO Class)
package com.eshwar.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO 
{
	
	   @NotNull(message="Product Id is required")
	   @Schema(description = "Unique Product ID",example = "3")
	   private Integer productId;
	   
	   @NotBlank(message = "Product Name is required")
	   @Schema(description = "Product Name", example = "Mobile")
	   private String productName;
	   
	   @NotNull(message="Product Price is required")
	   @Positive(message="Product Price Must be Greater than Zero")
	   @Schema(description = "Product Price", example = "50000")
	   private Double productPrice;
	   
	   @NotNull(message="Product Quantity is required")
	   @Positive(message = "Product Quantity Must be Greater than Zero")
	   @Schema(description = "Product Quantity", example = "10")
	   private Integer productQuantity;
	   
	   
	    @NotNull(message = "Category ID is required")
	    @Positive(message = "Category ID must be greater than zero")
	    @Schema(description = "Unique Category Id", example = "1")
	    private Integer categoryId;
}
