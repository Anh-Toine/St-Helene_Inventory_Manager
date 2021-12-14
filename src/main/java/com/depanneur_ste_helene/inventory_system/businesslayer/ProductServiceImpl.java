package com.depanneur_ste_helene.inventory_system.businesslayer;

import com.depanneur_ste_helene.inventory_system.datalayer.Product;
import com.depanneur_ste_helene.inventory_system.datalayer.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.depanneur_ste_helene.inventory_system.exceptions.InvalidInputException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product createProduct(Product model) {
        if(model.getPrice() < 0 || model.getQuantity() < 0 || model.getQuantity_sold() < 0){
            throw new InvalidInputException("Input not valid");
        }
        LOG.debug("createProduct: product with id {} saved",model.getProductId());
        return productRepository.save(model);
    }


    @Override
    public void deleteProduct(int barCode) {
//        productRepository.findById(barCode).ifPresent(p -> productRepository.delete(p));
        Optional<Product> optionalProduct = productRepository.findProductByBarCode(barCode);
        if(optionalProduct.isPresent()) {
                productRepository.deleteProduct(barCode);
        }
        LOG.debug("deleteProduct: product with bar code {} deleted",barCode);
    }

    public List<Product> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products;
    }
}
