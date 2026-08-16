//IProductRepository.java(custom interface that extends from JpaRepository interface)
package com.eshwar.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eshwar.entity.Product;
public interface IProductRepository extends JpaRepository<Product,Integer>
{

}
