package com.depanneur_ste_helene.inventory_system.businesslayer;

import com.depanneur_ste_helene.inventory_system.datalayer.Product;
import com.depanneur_ste_helene.inventory_system.datalayer.ProductDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.ProductRepository;
import com.depanneur_ste_helene.inventory_system.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import com.depanneur_ste_helene.inventory_system.exceptions.InvalidInputException;

import java.util.List;

import java.util.Optional;
import java.util.UUID;


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

    public Product updateProduct(Product product){
        Optional<Product> entity = productRepository.findByBar_code(product.getBar_code());
        product.setBar_code(entity.get().getBar_code());

        return productRepository.save(product);
    }
}


