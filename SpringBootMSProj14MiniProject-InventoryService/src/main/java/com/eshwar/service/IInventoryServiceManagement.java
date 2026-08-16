//IInventoryServiceManagement.java
package com.eshwar.service;
import com.eshwar.dto.InventoryDTO;
public interface IInventoryServiceManagement 
{
   public String addStock(InventoryDTO inventoryDTO);
   public InventoryDTO getInventoryByProductId(Integer productId);
   public String reduceStock(Integer productId,Integer quantity);
   public Boolean isStockAvilable(Integer productId,Integer quantity);
}
