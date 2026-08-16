//IInventoryRepository.java(custom interface that extends from JpaRepositoryInterface)
package com.eshwar.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.eshwar.entity.Inventory;
public interface IInventoryRepository extends JpaRepository<Inventory,Integer>
{
	//custom finder method ,Spring Data JPA automatically creates SQL query based on method name.
   Optional<Inventory>findByProductId(Integer productId);
}
