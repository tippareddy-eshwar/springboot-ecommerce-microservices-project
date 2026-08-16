//NotificationFeignClient .java
package com.eshwar.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.eshwar.dto.NotificationDTO;

@FeignClient(name="NOTIFICATION-SERVICE")//this annotation tells to the spring boot that this service(Order Service) wants to communicate with the NOTIFICATION-SERVICE 
public interface NotificationFeignClient 
{
	@PostMapping("/notifications-api/sendNotification")//method path (or) method request path
    public String sendNotification(@RequestBody NotificationDTO DTO);
}
