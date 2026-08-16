//SpringBootMsProj14MiniProjectSpringCloudApiGatewayProjApplication.java
package com.eshwar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootMsProj14MiniProjectSpringCloudAPIGatewayProj 
{

	public static void main(String[] args) 
	{
		//boot strapping the IOC container
		SpringApplication.run(SpringBootMsProj14MiniProjectSpringCloudAPIGatewayProj.class, args);
	}

}
