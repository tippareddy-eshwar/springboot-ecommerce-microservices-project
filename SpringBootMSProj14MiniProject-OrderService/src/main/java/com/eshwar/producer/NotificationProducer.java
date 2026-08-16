//NotificationProducer.java(Kafka Producer)
package com.eshwar.producer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import com.eshwar.dto.NotificationDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NotificationProducer 
{
	
	@Value("${app.topic.name}")
	private String topicName;

	
	//helps to store the message in the kafka topic
	private final KafkaTemplate<String,NotificationDTO> template;
	
	//Constructor Injection
	public NotificationProducer(KafkaTemplate<String,NotificationDTO> template)
	{
		log.debug("NotificationProducer Class Parameterized Constructor is Executed...");
		this.template=template;
	}
	
	public void sendNotification(NotificationDTO notificationDTO)
	{
		log.debug("NotificationProducer Class sendNotification(---) method is executed...");
		//Spring Kafka sends the notification object to the Kafka Topic:
		template.send(topicName, notificationDTO);
	}

}
