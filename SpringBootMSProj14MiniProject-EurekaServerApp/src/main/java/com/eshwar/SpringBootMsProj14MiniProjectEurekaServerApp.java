//SpringBootMsProj14MiniProjectEurekaServerApp.java(Client Application)
package com.eshwar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@SpringBootApplication
@EnableEurekaServer
public class SpringBootMsProj14MiniProjectEurekaServerApp
{

	public static void main(String[] args) 
	{
		//bootstrapping the IOC Container
		SpringApplication.run(SpringBootMsProj14MiniProjectEurekaServerApp.class, args);
	}

}
