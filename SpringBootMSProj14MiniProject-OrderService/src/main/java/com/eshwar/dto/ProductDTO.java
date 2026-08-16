//ProductDTO.java(DTO class for Product Response,Because Order Service calls Product Service)
package com.eshwar.dto;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString

public class ProductDTO 
{
	   private Integer productId;
	   
	   @NonNull
	   private String productName;
	   
	   @NonNull
	   private Double productPrice;
	   
	   @NonNull
	   private Integer productQuantity;
}
