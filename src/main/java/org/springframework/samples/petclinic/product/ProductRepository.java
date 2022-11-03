package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	@Query("SELECT p FROM ProductType p")
    List<ProductType> findAllProductTypes();
	
	@Query("SELECT p FROM Product p")
	List<Product> findAll();   
    
    Optional<Product> findById(int id);
    
    @Query("SELECT p FROM ProductType p WHERE p.name = :name")
    ProductType findProductTypeByName(String name);
    
    Product findByName(String name);
    
    @Query("SELECT p FROM Product p WHERE p.price < :price")
    List<Product> findByPriceLessThan(double price);
    
}
