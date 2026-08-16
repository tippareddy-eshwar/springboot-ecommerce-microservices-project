//ProductClientService.java(Service Class)
package com.eshwar.service;
import org.springframework.stereotype.Service;
import com.eshwar.dto.ProductDTO;
import com.eshwar.exception.ProductNotFoundException;
import com.eshwar.exception.ProductServiceUnavailableException;
import com.eshwar.feign.ProductFeignClient;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductClientService
{
	
       private final ProductFeignClient productFeign;
       
       public  ProductClientService(ProductFeignClient productFeign)
       {
    	   this.productFeign=productFeign;
    	   log.debug("ProductClientService Class Parameterized Constructor is Executed...");
       }
	
	   @CircuitBreaker(name="productService",fallbackMethod="productFallBack")//This is a Resilience4j annotation.It tells to the  Spring Boot that Protect this method using the Circuit Breaker Design Pattern.
	   public ProductDTO getProductById(Integer productId) 
	   {
		    log.debug("ProductClientService Class getProductById(---) method is executed...");
		    
		    log.info("ProductClientService Class getProductById(---) method is returning ProductDTO Class Object");
		    return productFeign.getProductById(productId);
	   }
		
		
	   public ProductDTO productFallBack(Integer productId,Throwable e)
	   {
		   log.debug("ProductClientService Class productFallBack(---,---) method is executed...");
		   log.error("Actual Reason for Failing the Product Service is : "+e.getMessage());
		   
		   if(e instanceof FeignException.NotFound)
		   {
			   log.error("productFallBack(---,---) method of  ProductClientService is throwing ProductNotFoundException");
			   throw new ProductNotFoundException("Product Not Found With the Id : "+productId);
		   }
		   
		   log.error("productFallBack(---,---) method of  ProductClientService is throwing  ProductServiceUnavailableException");
		   throw new ProductServiceUnavailableException("Product Service is Not Avilable...");
		   
	   }
}
