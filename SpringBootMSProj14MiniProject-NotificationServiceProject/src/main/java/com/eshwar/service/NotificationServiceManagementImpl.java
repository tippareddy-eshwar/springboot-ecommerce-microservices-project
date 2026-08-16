// NotificationServiceManagementImpl.java(implemented class for the INotificationServiceManagementinterface)
package com.eshwar.service;
import org.springframework.stereotype.Service;
import com.eshwar.dto.NotificationDTO;
import com.eshwar.entity.Notification;
import com.eshwar.repository.INotificationRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationServiceManagementImpl implements INotificationServiceManagement
{
	
	
	private final INotificationRepository repo;
	
	//Constructor Injection
	public NotificationServiceManagementImpl(INotificationRepository repo) 
	{
		log.debug("NotificationServiceManagementImpl Class Parameterized Constructor is Executed...");
		this.repo=repo;
	}

	@Override
	public String sendNotification(NotificationDTO notificationDTO) 
	{
		
		log.debug("NotificationServiceManagementImpl Class sendNotification(---) method is executed...");
		//DTO->Entity
		Notification notification=new Notification();
		notification.setOrderId(notificationDTO.getOrderId());
		notification.setMessage(notificationDTO.getMessage());
		notification.setNotificationType(notificationDTO.getNotificationType());
		notification.setStatus(notificationDTO.getStatus());
		
		//saving the notification
		Notification savedNotification = repo.save(notification);
		log.info("NotificationServiceManagementImpl Class sendNotification(---) method is returning String");
		return "Notification Sent Sucessfully to "+ savedNotification.getNotificationId() +" Notification Id";
	}

}
