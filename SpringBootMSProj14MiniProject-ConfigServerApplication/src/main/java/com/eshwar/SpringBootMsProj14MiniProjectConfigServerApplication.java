//SpringBootMsProj14MiniProjectConfigServerApplication.java(Client App)
package com.eshwar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
@SpringBootApplication
@EnableConfigServer
public class SpringBootMsProj14MiniProjectConfigServerApplication 
{

	public static void main(String[] args)
	{
		//BootStrapping the IOC Container
		SpringApplication.run(SpringBootMsProj14MiniProjectConfigServerApplication.class, args);
	}

}
