package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{
	
	private final ProductService prodService;
	
	@Autowired
	public ProductTypeFormatter(ProductService prodService) {
		this.prodService = prodService;
	}
	
    @Override
    public String print(ProductType prodType, Locale locale) {
        // TODO Auto-generated method stub
        return prodType.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        Collection<ProductType> findProductTypes = this.prodService.getAllProductTypes();
        for(ProductType type : findProductTypes) {
        	if(type.getName().equals(text)) {
        		return type;
        	}
        }
        throw new ParseException("type not found: " + text, 0);
    }
    
}
