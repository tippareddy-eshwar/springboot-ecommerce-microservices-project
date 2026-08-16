//SpringBootMsProj14MiniProjectPaymentServiceApplication.java
package com.eshwar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootMsProj14MiniProjectPaymentServiceApplication 
{

	public static void main(String[] args)
	{
		//Bootstrapping the IOC Container
		SpringApplication.run(SpringBootMsProj14MiniProjectPaymentServiceApplication.class, args);
	}

}
