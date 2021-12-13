package com.depanneur_ste_helene.inventory_system.businesslayer;

import com.depanneur_ste_helene.inventory_system.datalayer.Product;
import com.depanneur_ste_helene.inventory_system.datalayer.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.depanneur_ste_helene.inventory_system.exceptions.InvalidInputException;
@Service
public class ProductServiceImpl implements ProductService{
    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product model) {
        if(model.getPrice() < 0 || model.getQuantity() < 0 || model.getQuantity_sold() < 0){
            throw new InvalidInputException("Input not valid");
        }
        LOG.debug("createProduct: product with id {} saved",model.getProductId());
        return productRepository.save(model);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.findById(id).ifPresent(p -> productRepository.delete(p));
        LOG.debug("deleteProduct: product with id {} deleted",id);
    }
}
