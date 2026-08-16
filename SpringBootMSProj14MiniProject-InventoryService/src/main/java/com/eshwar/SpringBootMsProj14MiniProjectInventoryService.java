//SpringBootMsProj4MiniProjectInventoryServiceApplication.java(Client App)
package com.eshwar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootMsProj14MiniProjectInventoryService 
{

	public static void main(String[] args) 
	{
		//BootStrapping the IOC Container
		SpringApplication.run(SpringBootMsProj14MiniProjectInventoryService.class, args);
	}

}
