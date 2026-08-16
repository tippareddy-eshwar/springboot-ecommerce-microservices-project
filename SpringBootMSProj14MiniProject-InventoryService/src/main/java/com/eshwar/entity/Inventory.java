//Inventory.java(Entity Class)
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
@Table(name="INVENTORY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory
{
  
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   //considering  inventoryId as the primary key
   private Integer inventoryId;
   
   @Column(nullable = false,unique = true)
   //productId links InventoryService with Product Service ,Very important for communication between services.
   private Integer productId;
   
   @Column(nullable = false)
   //Maintains current stock
   private Integer avilableQuantity;
}
