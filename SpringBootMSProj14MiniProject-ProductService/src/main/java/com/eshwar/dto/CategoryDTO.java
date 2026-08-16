//CategoryDTO.java(DTO Class)
package com.eshwar.dto;
import java.util.List;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO 
{
	
	 @NotNull(message = "Category Id is required")
	 @Schema(description = "Unique Category Id", example = "1")
     private Integer categoryId;
	
     @NotBlank(message ="Category name is required")
     @Schema(description = "Category Name", example = "Electronics")
     private String categoryName;
	
     //When we are validating CategoryDTO, also validate every ProductDTO inside the products list.
     @Valid
     private List<ProductDTO>products;
}
