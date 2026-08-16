//IOrderRepository.java(custom interface that extends from JpaRepository interface)
package com.eshwar.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.eshwar.entity.Order;

public interface IOrderRepository extends JpaRepository<Order,Integer>
{

}
