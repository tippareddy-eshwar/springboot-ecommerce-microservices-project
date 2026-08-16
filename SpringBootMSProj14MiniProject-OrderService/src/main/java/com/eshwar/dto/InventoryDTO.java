//InventoryDTO .java(Inventory DTO Class)
package com.eshwar.dto;
import lombok.Data;
import lombok.NonNull;

@Data
public class InventoryDTO 
{
	
	 @NonNull
	 private Integer inventoryId;
	  
	 @NonNull
	 private Integer productId;
	   
	 @NonNull
	 private Integer avilableQuantity;
}
