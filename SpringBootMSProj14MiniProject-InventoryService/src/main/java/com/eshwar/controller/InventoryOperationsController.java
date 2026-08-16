//InventoryOperationsController.java(RestController Class)
package com.eshwar.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eshwar.dto.InventoryDTO;
import com.eshwar.service.IInventoryServiceManagement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/inventory-api")//Global Path (or) Global Request Path
@Tag(name = "Inventory Controller", description = "Rest APIs For Inventory Service")
@Slf4j
public class InventoryOperationsController
{
	 
	 private final IInventoryServiceManagement service;
	 
	 //Constructor Injection
	 public InventoryOperationsController(IInventoryServiceManagement service)
	 {
		 log.debug("InventoryOperationsController Class Parameterized Constructor is Executed...");
		 this.service=service;
	 }
	
	 @PostMapping("/add")//Method Path (or) Method Request Path
	 @Operation(summary = "Add Stock",description = "Adds a new Stock in the database")
	 @ApiResponses({
		 @ApiResponse(responseCode="201",
		              description = "Stock Added Sucessfully"
		     ),
  @ApiResponse(responseCode="400",
               description = "Validation Failed"
		  ),
  @ApiResponse(responseCode = "404",
              description = "Inventory Not Found for the specified Product ID"
		  ),
  @ApiResponse(responseCode = "500",
               description = "Internal Server Error"
		  )
	 })
     public ResponseEntity<String>addStock(@Valid @RequestBody InventoryDTO inventoryDTO)
     {
    	 log.debug("InventoryOperationsController Class addStock(---) method is executed...");
    	 
    	 log.info("InventoryOperationsController Class addStock(---) method is returning ResponseEntity<String> Class Object...");
    	 //returning the  ResponseEntity Class Object
    	 return new ResponseEntity<String>(service.addStock(inventoryDTO),HttpStatus.CREATED);
     }
	 
	 
	 @GetMapping("/get/{productId}")//Method Path (or) Method Request Path
	 @Operation(summary = "Get Stock By Product Id",description = "Returns Stock details for the specified Product ID")
	 @ApiResponses({
	        @ApiResponse(responseCode = "200",
	        		      description = "Inventory Retrieved Successfully"
	        		),
	        @ApiResponse(responseCode = "404",
     		         description = "Inventory Not Found for the specified Product ID"
	        		),
	        
	        @ApiResponse(responseCode = "500",
         description = "Internal Server Error"
                      )
	        })
     public ResponseEntity<InventoryDTO>getInventory(@Parameter(description = "Product ID", example ="3") @PathVariable Integer productId)
     {
    	 log.debug("InventoryOperationsController Class getInventory(---) method is executed...");
    	 
    	 log.info("InventoryOperationsController Class getInventory(---) method is returning ResponseEntity<Inventory> Class Object...");
    	 //returning the  ResponseEntity Class Object
    	 return new ResponseEntity<InventoryDTO>(service.getInventoryByProductId(productId),HttpStatus.OK);
     }
	 
	 @PutMapping("/reduce/{productId}/{quantity}")//Method Path (or) Method Request Path
	 @Operation(summary = "Reduce Stock",description = "Reduces the available stock for the specified Product ID by the given quantity")
	 @ApiResponses({
		    @ApiResponse(responseCode = "200",
		                 description = "Stock Reduced Successfully"
		    ),
		    @ApiResponse(responseCode = "404",
		                 description = "Inventory Not Found for the specified Product ID"
		    ),
		    @ApiResponse(responseCode = "409",
		                 description = "Insufficient Stock Available"
		    ),
		    @ApiResponse(responseCode = "500",
		        description = "Internal Server Error"
		    )
		})
     public ResponseEntity<String>reduceStock(@Parameter(description = "Product ID", example = "4") @PathVariable Integer productId,@Parameter(description = "Product Quantity", example = "10") @PathVariable Integer quantity)
     {
    	 log.debug("InventoryOperationsController Class reduceStock(---,---) method is executed...");
    	 
    	 log.info("InventoryOperationsController Class reduceStock(---,---) method is returning ResponseEntity<String> Class Object...");
    	 //returning the  ResponseEntity Class Object
    	 return new ResponseEntity<String>(service.reduceStock(productId, quantity),HttpStatus.OK);
     }
	 
	 
	 @GetMapping("/check/{productId}/{quantity}")//Method Path (or) Method Request Path
	 @Operation(summary = "Check Stock",description = "Checks whether the requested quantity is available for the specified Product ID")
	 @ApiResponses({
		    @ApiResponse(responseCode = "200",
		                description = "Stock Availability Checked Successfully"
		    ),
		    @ApiResponse(responseCode = "404",
		                 description = "Inventory Not Found for the specified Product ID"
		    ),
		    @ApiResponse(responseCode = "500",
		                 description = "Internal Server Error"
		    )
		})
     public ResponseEntity<Boolean>checkStock(@Parameter(description = "Product ID", example = "3") @PathVariable Integer productId,@Parameter(description = "Product Quantity", example = "8")@PathVariable Integer quantity)
     {
    	 log.debug("InventoryOperationsController Class checkStock(---,---) method is executed...");
    	 
    	 log.info("InventoryOperationsController Class checkStock(---,---) method is returning ResponseEntity<Boolean> Class Object...");
    	 //returning the  ResponseEntity Class Object
    	 return new ResponseEntity<Boolean>(service.isStockAvilable(productId, quantity),HttpStatus.OK);
     }
	 
}
