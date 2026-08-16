// PaymentClientService.java(Service Class)
package com.eshwar.service;
import org.springframework.stereotype.Service;
import com.eshwar.dto.PaymentDTO;
import com.eshwar.exception.PaymentServiceUnavailableException;
import com.eshwar.feign.PaymentFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaymentClientService
{

	 
	   private final PaymentFeignClient paymentFeign;
	 
	   public  PaymentClientService(PaymentFeignClient paymentFeign)
	   {
		   this.paymentFeign=paymentFeign;
		   log.debug("PaymentClientService Class Parameterized Constructor is Executed...");
	   }
	 
	   @CircuitBreaker(name="paymentService",fallbackMethod="paymentFallBack")
	   public String makePayment(PaymentDTO  payment)
	   {
		   log.debug("OrderServiceManagementImpl Class   makePayment(---,---) method is executed...");
		   
		   log.info("OrderServiceManagementImpl Class   makePayment(---,---) method is returning String");
		   return paymentFeign.makePayment(payment);
	   }
	   
	   public String paymentFallBack(PaymentDTO  payment,Throwable e)
	   {
		    log.info("OrderServiceManagementImpl Class paymentFallBack(---,---) method is executed...");
		    log.error("Actual Reason for Failing the Payment Service is : "+e.getMessage());
		    
		    log.info("OrderServiceManagementImpl Class paymentFallBack(---,---) method is returning String");
		    throw new PaymentServiceUnavailableException("Payment Service is Not Avilable...");
	   }
	    
}
