package com.depanneur_ste_helene.inventory_system.businesslayer;

import com.depanneur_ste_helene.inventory_system.datalayer.Product;
import com.depanneur_ste_helene.inventory_system.datalayer.ProductRepository;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import com.depanneur_ste_helene.inventory_system.exceptions.InvalidInputException;
=======

import java.util.List;

>>>>>>> 33602aa (Added base service for getAllProduct)
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product createProduct(Product model) {
        if(model.getPrice() < 0 || model.getQuantity() < 0 || model.getQuantity_sold() < 0){
            throw new InvalidInputException("Input not valid");
        }

        return productRepository.save(model);
    }

    public List<Product> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products;
    }
}
