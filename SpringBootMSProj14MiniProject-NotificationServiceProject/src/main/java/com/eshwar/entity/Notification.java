//Notification .java(Entity Class)
package com.eshwar.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="NOTIFICATIONS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notification 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationId;
	
	@Column(nullable = false)
    private Integer orderId;
	
	@Column(length=30,nullable = false)
    private String message;
	
	@Column(length=30,nullable = false)
    private String notificationType;

	@Column(length=30,nullable = false)
    private String status;
}
