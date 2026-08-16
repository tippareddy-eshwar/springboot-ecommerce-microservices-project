// InventoryServiceManagementImpl.java(implemented class for the IInventoryServiceManagement interface)
package com.eshwar.service;
import org.springframework.stereotype.Service;
import com.eshwar.dto.InventoryDTO;
import com.eshwar.entity.Inventory;
import com.eshwar.exceptions.InsufficientStockException;
import com.eshwar.exceptions.ProductNotFoundException;
import com.eshwar.repository.IInventoryRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InventoryServiceManagementImpl implements IInventoryServiceManagement
{
	
    
	private final IInventoryRepository repo;
	
	//Constructor Injection
	public InventoryServiceManagementImpl(IInventoryRepository repo)
	{
		log.debug("InventoryServiceManagementImpl Class Parameterized Constructor is Executed...");
		this.repo=repo;
	}
    
	@Override
	public String addStock(InventoryDTO inventoryDTO) 
	{
		log.debug("InventoryServiceManagementImpl Class addStock(---) method is executed...");
		
		//finding existing inventory by using productId
		Inventory inventory=repo.findByProductId(inventoryDTO.getProductId()).orElseGet(()->
		       {
		    	    //DTO->Entity
		   		    Inventory newInventory=new Inventory();
		   		    newInventory.setProductId(inventoryDTO.getProductId());
		 		    newInventory.setAvilableQuantity(0);
		 		    return newInventory;
		       });
			
		  // Adding new stock to existing stock
	   inventory.setAvilableQuantity(inventory.getAvilableQuantity()+ inventoryDTO.getAvilableQuantity());
		
		//calling save(---) method of CrudRepository Interface
	     repo.save(inventory);
		log.info("InventoryServiceManagementImpl Class addStock(---) method is returning String");
		return "Stock Added Sucessfully";
		
	}

	@Override
	public InventoryDTO getInventoryByProductId(Integer productId) 
	{
		log.debug("InventoryServiceManagementImpl Class getInventoryByProductId(---) method is executed...");
		
		
		 //Entity
		Inventory inventory = repo.findByProductId(productId).orElseThrow(()->new ProductNotFoundException("Product Not Found With the Id : "+productId));
		 
		//Entity->DTO
		InventoryDTO inventoryDTO=new InventoryDTO();
		inventoryDTO.setInventoryId(inventory.getInventoryId());
		inventoryDTO.setProductId(inventory.getProductId());
		inventoryDTO.setAvilableQuantity(inventory.getAvilableQuantity());
		
		log.info("InventoryServiceManagementImpl Class getInventoryByProductId(---) method is returning InventoryDTO Class Object");
		return inventoryDTO;
	}
   
	
	@Override
	public String reduceStock(Integer productId, Integer quantity) 
	{
		log.debug("InventoryServiceManagementImpl Class reduceStock(---,---) method is executed...");
		 // finding Inventory by using productId
		Inventory inventory2 = repo.findByProductId(productId).orElseThrow(()->new ProductNotFoundException("Product Not Found With the Id : "+productId));
		
		//Checking Avilable Stock
		if(inventory2.getAvilableQuantity()<quantity)
		{
			log.error("InventoryServiceManagementImpl Class reduceStock(---,---) method is throwing InsufficientStockException(---)");
			throw new InsufficientStockException("InsufficientStock...");
		}
		
		//Reducing the stock
		
		inventory2.setAvilableQuantity(inventory2.getAvilableQuantity()-quantity);
		
		//saving the updated inventory
		repo.save(inventory2);
		
		log.info("InventoryServiceManagementImpl Class reduceStock(---,---) method is returning String");
		return "Stock Updated Sucessfully";
	}

	@Override
	public Boolean isStockAvilable(Integer productId, Integer quantity) 
	{
		log.debug("InventoryServiceManagementImpl Class isStockAvilable(---,---) method is executed...");
		
		//Repository ->Entity
		Inventory inventory= repo.findByProductId(productId).orElseThrow(()->new ProductNotFoundException("Product Not Found With the Id : "+productId));
		
		log.info("InventoryServiceManagementImpl Class isStockAvilable(---,---) method is returning Boolean");
		return inventory.getAvilableQuantity()>=quantity;
	}

}
