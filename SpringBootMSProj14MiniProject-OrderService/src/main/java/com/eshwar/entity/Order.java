//Order.java(Entity Class)
package com.eshwar.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="ORDERS")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class Order
{
	
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer orderId;
   
   @Column(length=30,nullable = false)
   private String  customerName;
   
   @Column(nullable = false)
   private Integer productId;
   
   @Column(nullable = false)
   private Integer productQuantity;
   
   @Column(nullable = false)
   private Double totalPrice;
   
   @Column(length=20,nullable = false)
   private String orderStatus;
   
   
}
