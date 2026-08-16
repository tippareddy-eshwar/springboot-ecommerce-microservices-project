//IPaymentRepository.java(custom interface that extends from JpaRepository interface)
package com.eshwar.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eshwar.entity.Payment;

public interface IPaymentRepository extends JpaRepository<Payment,Integer>
{

}
