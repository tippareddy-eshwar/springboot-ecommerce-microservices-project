//InventoryClientService.java(Service Class)
package com.eshwar.service;
import org.springframework.stereotype.Service;
import com.eshwar.dto.InventoryDTO;
import com.eshwar.exception.InventoryServiceUnavailableException;
import com.eshwar.exception.InventoryUpdateException;
import com.eshwar.feign.InventoryFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InventoryClientService
{
	   
	    private final InventoryFeignClient inventoryFeign;
	    
	    public InventoryClientService(InventoryFeignClient inventoryFeign)
	    {
	    	this.inventoryFeign=inventoryFeign;
	    	log.debug("InventoryClientService Class Parameterized Constructor is executed...");
	    }
	   
	   @CircuitBreaker(name="inventoryService",fallbackMethod="inventoryFallBack")
	   public  InventoryDTO getInventory(Integer productId)
	   {
		   log.debug("OrderServiceManagementImpl Class getInventory(---) method is executed...");
		   
		   log.info("OrderServiceManagementImpl Class getInventory(---) method is returning InventoryDTO Class Object");
		   return inventoryFeign.getInventory(productId);
	   }
	   
	   public InventoryDTO inventoryFallBack(Integer productId,Throwable e)
	   {
		   log.debug("OrderServiceManagementImpl Class inventoryFallBack(---,---) method is executed...");
		   log.error("Actual Reason for Failing the Inventory Service is : "+e.getMessage());
		   
		   log.info("OrderServiceManagementImpl Class inventoryFallBack(---,---) method is returning  InventoryDTO Class Object");
		   throw new InventoryServiceUnavailableException("Inventory Service is Not Avilable...");
	   }
	   
	   @CircuitBreaker(name="inventoryService",fallbackMethod="inventoryUpdateFallback")
	   public String reduceStock(Integer productId,Integer productQuantity)
	   {
		   log.debug("OrderServiceManagementImpl Class reduceStock(---,---) method is executed...");
		   
		   log.info("OrderServiceManagementImpl Class reduceStock(---,---) method is returning String");
		   return inventoryFeign.reduceStock(productId, productQuantity);
	   }
	   
	   public String inventoryUpdateFallback(Integer productId,Integer productQuantity,Throwable e)
	   {
		   log.debug("OrderServiceManagementImpl Class  inventoryUpdateFallback(---,---) method is executed...");
		   log.error("Actual Reason for Failing the Inventory Service is : "+e.getMessage());
		   
		   log.info("OrderServiceManagementImpl Class  inventoryUpdateFallback(---,---) method is returning String");
		   throw new InventoryUpdateException("Unable To Reduce Inventory...");
	   }
	   
	   
}
