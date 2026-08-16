//PaymentController.java(Rest Controller Class)
package com.eshwar.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eshwar.dto.PaymentDTO;
import com.eshwar.service.IPaymentServiceManagement;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/payments-api")//Global Path (or) Global Request Path
@Tag(name = "Payment Controller", description = "Rest APIs For  Payment Service")
@Slf4j
public class PaymentController 
{
	
     private final  IPaymentServiceManagement service;
     
     public PaymentController(IPaymentServiceManagement service)
     {
    	 log.debug("PaymentController Class Parameterized Constructor is Executed...");
    	 this.service=service;
     }
	 
	 @PostMapping("/pay")//Method Path (or) Method Request Path
	 @Operation(summary ="Make Payment" ,description = "Processes a payment for the specified order")
	 @ApiResponses({
			  @ApiResponse(responseCode="201",
					         description = "Payment Done Sucessfully"
					  ),
			  @ApiResponse(responseCode="400",
			               description = "Validation Failed"
					  ),
			  @ApiResponse(responseCode = "500",
			             description = "Internal Server Error"
					  )
			  })
	 public ResponseEntity<String>makePayment(@Valid @RequestBody PaymentDTO paymentDTO)
	 {
		 log.debug("PaymentController Class makePayment(---) method is executed...");
		 
		 log.info("PaymentController Class makePayment(---) method is returning ResponseEntity<String>");
		 //returning the ResponseEntity Class Object
		 return new ResponseEntity<String>(service.makePayment(paymentDTO),HttpStatus.CREATED);
	 }
	 
	 @GetMapping("/get/{paymentId}")//Method Path (or) Method Request Path
	 @Operation(summary = "Get Payment By Id", description = "Returns Payment details for the specified Payment ID")
	 @ApiResponses({
		    @ApiResponse(responseCode = "200",
		        description = "Payment Retrieved Successfully"
		    ),
		    @ApiResponse(responseCode = "404",
		        description = "Payment Not Found for the specified Payment ID"
		    ),
		    @ApiResponse(responseCode = "500",
		        description = "Internal Server Error"
		    )
		})
	 public ResponseEntity<PaymentDTO>getPaymentById(@Parameter(description = "Payment ID", example = "6")@PathVariable Integer paymentId)
	 {
		 log.debug("PaymentController Class getPaymentById(---) method is executed...");
		 
		 log.info("PaymentController Class getPaymentById(---) method is returning ResponseEntity<Payment>");
		 //returning the ResponseEntity Class Object
		 return new ResponseEntity<PaymentDTO>(service.getPaymentById(paymentId),HttpStatus.OK);
	 }
	 
	 @GetMapping("/all")//Method Path (or) Method Request Path
	 @Operation(summary = "Get All Payments", description = "Returns the list of all available Payments")
	 @ApiResponses({
		    @ApiResponse(responseCode = "200",
		                 description = "Payments Retrieved Successfully"
		    ),
		    @ApiResponse(responseCode = "500",
		                 description = "Internal Server Error"
		    )
		})
	 public ResponseEntity<List<PaymentDTO>>getAllPayments()
	 {
		 log.debug("PaymentController Class getAllPayments() method is executed...");
		 
		 log.info("PaymentController Class getAllPayments() method is returning ResponseEntity<List<Payment>>");
		 //returning the ResponseEntity Class Object
		 return new ResponseEntity<List<PaymentDTO>>(service.getAllPayments(),HttpStatus.OK);
	 }
	 
	 
}
