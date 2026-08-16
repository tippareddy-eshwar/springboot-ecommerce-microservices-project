//PaymentFeignClient.java
package com.eshwar.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.eshwar.dto.PaymentDTO;

@FeignClient(name="PAYMENT-SERVICE")//this annotation tells to the spring boot that this service(Order Service) wants to communicate with the PAYMENT-SERVICE 
public interface PaymentFeignClient 
{
	@GetMapping("/payments-api/pay")//method path (or) method request path
    public String makePayment(@RequestBody PaymentDTO payment);
}
