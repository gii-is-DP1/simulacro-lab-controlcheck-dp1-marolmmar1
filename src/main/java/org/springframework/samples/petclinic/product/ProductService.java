package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
	private ProductRepository prodRepo;
	
	@Autowired
	public ProductService(ProductRepository prodRepo) {
		this.prodRepo = prodRepo;
	}
	
	public List<Product> getAllProducts(){
        return this.prodRepo.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return this.prodRepo.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return this.prodRepo.findProductTypeByName(typeName);
    }

    public Product save(Product p){
        return null;       
    }
    
    public List<ProductType> findAllProductTypes(){
    	return this.prodRepo.findAllProductTypes();
    }
 

    
}
