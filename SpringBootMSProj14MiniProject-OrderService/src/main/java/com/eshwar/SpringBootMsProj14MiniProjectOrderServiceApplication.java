//SpringBootMsProj14MiniProjectOrderServiceApplication.java(Client Application)
package com.eshwar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SpringBootMsProj14MiniProjectOrderServiceApplication 
{

	public static void main(String[] args) 
	{
		//Bootstrapping the IOC Container
		SpringApplication.run(SpringBootMsProj14MiniProjectOrderServiceApplication.class, args);
	}

}
