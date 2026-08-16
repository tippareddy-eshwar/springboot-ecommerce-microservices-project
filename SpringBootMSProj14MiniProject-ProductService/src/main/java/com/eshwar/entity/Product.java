//Product.java(child class)
package com.eshwar.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Data
@Table(name="PRODUCTS")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(exclude ="category")//While generating the toString() method, DO NOT include the category field
public class Product 
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer productId;
   
   @Column(length=30,nullable=false)
   private String productName;
   
   @Column(nullable=false)
   private Double productPrice;
   
   @Column(nullable=false)
   private Integer productQuantity;
   
   //HAS-A Property
   @ManyToOne
   @JsonBackReference
   @JoinColumn(name="category_id",nullable=false)
   private Category category;
}
