//Payment.java(Entity Class)
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
@Table(name="PAYMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
	
	@Column(nullable=false)
    private Integer orderId;

    @Column(nullable=false)
    private Double amount;
    

    @Column(length=20,nullable=false)
    private String paymentStatus;
    
    @Column(length=20,nullable=false)
    private String paymentMode;
}
