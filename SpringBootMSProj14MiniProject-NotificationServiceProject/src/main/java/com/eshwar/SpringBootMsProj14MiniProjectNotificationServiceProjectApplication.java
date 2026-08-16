//SpringBootMsProj14MiniProjectNotificationServiceProjectApplication.java(Client Application)
package com.eshwar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableDiscoveryClient
@EnableKafka//It tells Spring Boot taht "Scan for methods annotated with @KafkaListener and create Kafka listener containers for them."

public class SpringBootMsProj14MiniProjectNotificationServiceProjectApplication 
{

	public static void main(String[] args) 
	{
		//BootStrapping the IOC Container
		SpringApplication.run(SpringBootMsProj14MiniProjectNotificationServiceProjectApplication.class, args);
	}

}
