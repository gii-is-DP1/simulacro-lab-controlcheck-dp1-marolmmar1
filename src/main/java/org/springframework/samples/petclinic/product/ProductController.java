package org.springframework.samples.petclinic.product;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
	private final ProductService prodService;
	
	@Autowired
	public ProductController(ProductService prodService) {
		this.prodService = prodService;
	}
	
	@GetMapping("/product/create")
	public String initCreationForm(Map<String, Object> model) {
		Product product = new Product();
		model.put("product", product);
		return "products/createOrUpdateProductForm";
	}
	
	@PostMapping("/product/create")
	public String processUpdateForm(@Valid Product product, BindingResult result, ModelMap model){
		if(result.hasErrors()){
			return "products/createOrUpdateProductForm";
		}
		else {
			this.prodService.save(product);
		}
		
		return "welcome";
	}
	
}
