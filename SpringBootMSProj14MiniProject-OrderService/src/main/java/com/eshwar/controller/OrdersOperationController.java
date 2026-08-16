//OrdersOperationController.java(Rest Controller)
package com.eshwar.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eshwar.dto.OrderDTO;
import com.eshwar.service.IOrderServiceManagement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/orders-api")//Global Path (or) Global Request Path
@Tag(name = "Order Controller" , description = "Rest APIs For Order Service")
public class OrdersOperationController
{
	 
     private final IOrderServiceManagement service;
     
     public  OrdersOperationController(IOrderServiceManagement service)
     {
    	 log.debug("OrdersOperationController Class Parameterized Constructor is Executed...");
    	 this.service=service;
    	 
     }
	 
	 @PostMapping("/place")//Method Path (or) Method Request Path
	 @Operation(summary = "Place Order", description = "This API is used to place a new order")
	 @ApiResponses({
		 @ApiResponse(responseCode = "201" ,
				      description = "Order placed successfully") ,
		 @ApiResponse(responseCode = "400" ,
	                  description = "Invalid Order Details") ,
		 @ApiResponse(responseCode = "500" ,
	                  description = "Internal Server Error")
		 
	 })
	 public ResponseEntity<String>placeOrder(@Valid @RequestBody OrderDTO orderDTO)
	 {
		 log.debug("OrdersOperationController Class placeOrder(---) method is executed...");
		 
		 log.info("OrdersOperationController Class placeOrder(---) method is returning ResponseEntity<String>");
		 //returning the ResponseEntity Class Object
		 return new ResponseEntity<String>(service.placeOrder(orderDTO),HttpStatus.CREATED);
	 }
	 
	 @GetMapping("/get")//Method Path (or) Method Request Path
	 @Operation(summary = "Get All Orders", description = "This API is used to retrieve all available orders")
	 @ApiResponses({
		 @ApiResponse(responseCode = "200" ,
				      description = "Orders retrieved successfully") ,
		 @ApiResponse(responseCode = "404" ,
	                  description = "No Orders Found") ,
		 @ApiResponse(responseCode = "500" ,
	                  description = "Internal Server Error")
		 
	 })
	 public ResponseEntity<List<OrderDTO>>getAllOrders()
	 {
		 log.debug("OrdersOperationController Class getAllOrders() method is executed...");
		 
		 log.info("OrdersOperationController Class getAllOrders() method is returning  ResponseEntity<List<Order>>");
		 //returning the ResponseEntity Class Object
		 return new ResponseEntity<List<OrderDTO>>(service.getAllOrders(),HttpStatus.OK);
	 }
	 
	 @GetMapping("/getById/{id}")//Method Path (or) Method Request Path
	 @Operation(summary = "Get Order By ID", description = "This API is used to retrieve an order based on the given order ID")
	 @ApiResponses({
		 @ApiResponse(responseCode = "200" ,
				      description = "Order retrieved successfully") ,
		 @ApiResponse(responseCode = "404" ,
	                  description = "Order Not Found") ,
		 @ApiResponse(responseCode = "500" ,
	                  description = "Internal Server Error")
		 
	 })
	 public ResponseEntity<String>getOrderById(@Parameter(description = "Order ID" , example = "5") @PathVariable Integer id)
	 {
		 log.debug("OrdersOperationController Class getOrderById(---) method is executed...");
		 
		 log.info("OrdersOperationController Class getOrderById(---) method is returning ResponseEntity<String>");
		 //returning the ResponseEntity Class Object
		 return new ResponseEntity<String>(service.getOrderById(id).toString(),HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/delete/{id}")//Method Path (or) Method Request Path
	 @Operation(summary = "Delete Order By ID", description = "This API is used to delete an order based on the given order ID.")
	 @ApiResponses({
		 @ApiResponse(responseCode = "200" ,
				      description = "Order deleted successfully") ,
		 @ApiResponse(responseCode = "404" ,
	                  description = "Order Not Found") ,
		 @ApiResponse(responseCode = "500" ,
	                  description = "Internal Server Error")
		 
	 })
	 public ResponseEntity<String>deleteOrderById(@Parameter(description = "Order ID" ,example = "5") @PathVariable Integer id)
	 {
		 log.debug("OrdersOperationController Class getOrderById(---) method is executed...");
		 
		 log.info("OrdersOperationController Class getOrderById(---) method is returning  ResponseEntity<String>");
		 //returning the ResponseEntity Class Object
		 return new ResponseEntity<String>(service.deleteOrderById(id),HttpStatus.OK);
	 }
}
