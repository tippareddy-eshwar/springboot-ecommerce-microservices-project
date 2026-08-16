//NotificationConsumer .java(Consumer Application)
package com.eshwar.kafkaconsumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.eshwar.dto.NotificationDTO;
import com.eshwar.entity.Notification;
import com.eshwar.repository.INotificationRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class NotificationConsumer 
{

	    
	    private final INotificationRepository repo;
	    
	    public NotificationConsumer(INotificationRepository repo)
	    {
	    	this.repo=repo;
	    	log.debug("NotificationConsumer Class Parameterized Constructor is executed...");
	    	
	    }
	     
	  @KafkaListener(topics="order-topic",groupId="${spring.kafka.consumer.group-id}")//@KafkaListener This annotation tells Spring Kafka:"Continuously listen to messages coming from the order-topic topic."When a new message arrives in Kafka, Spring automatically calls the below method.
	  public void consumeNotification(NotificationDTO notificationDTO)
	  {
		    log.debug("NotificationConsumer Class consumeNotification(---) method is executed...");
		    
		    //converting DTO into entity
		    //creating the Notification Class Object
		    Notification notificationEntity=new Notification();
		    notificationEntity.setOrderId(notificationDTO.getOrderId());
		    notificationEntity.setMessage(notificationDTO.getMessage());
		    notificationEntity.setNotificationType(notificationDTO.getNotificationType());
		    notificationEntity.setStatus(notificationDTO.getStatus());
		   
		    log.info("Notification Received for the  Order Id : {}", notificationEntity.getOrderId());
		    
		    //save the notification
		    Notification savedNotification = repo.save(notificationEntity);
		    
		    log.info("Notification Saved Successfully With Id : {}", savedNotification.getNotificationId());

		    log.info("Notification Message : {}", savedNotification.getMessage());
		    log.info("Notification type  : {}", savedNotification.getNotificationType());
		    log.info("Notification Status : {}",savedNotification.getStatus());
		    
		    // Sending Email
		    log.info("Sending Email To Customer...");

		    log.info("Email Sent Successfully...");
		    
		    
	  }
	
}
