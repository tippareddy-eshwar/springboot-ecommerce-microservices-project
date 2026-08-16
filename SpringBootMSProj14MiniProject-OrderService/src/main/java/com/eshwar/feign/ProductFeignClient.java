// ProductFeignClient.java
package com.eshwar.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eshwar.dto.ProductDTO;

@FeignClient(name="PRODUCT-SERVICE")//this annotation tells to the spring boot that this service(Order Service) wants to communicate with the PRODUCT-SERVICE 
public interface ProductFeignClient
{
   @GetMapping("/products-api/get/{productId}")//method path (or) method request path
   public ProductDTO getProductById(@PathVariable Integer productId);
}  
