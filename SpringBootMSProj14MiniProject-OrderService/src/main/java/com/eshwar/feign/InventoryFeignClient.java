//InventoryFeignClient.java
package com.eshwar.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.eshwar.dto.InventoryDTO;

@FeignClient(name = "INVENTORY-SERVICE")//this annotation tells to the spring boot that this service(Order Service) wants to communicate with the INVENTORY-SERVICE 
public interface InventoryFeignClient
{
   @GetMapping("/inventory-api/get/{productId}")//method path (or) method request path
   public InventoryDTO getInventory(@PathVariable Integer productId);
   
   
   @PutMapping("/inventory-api/reduce/{productId}/{quantity}")//method path (or) method request path
   public String reduceStock(@PathVariable Integer productId,@PathVariable Integer quantity);
}
