package com.depanneur_ste_helene.inventory_system.businesslayer;

import com.depanneur_ste_helene.inventory_system.datalayer.Product;
import com.depanneur_ste_helene.inventory_system.datalayer.ProductDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.depanneur_ste_helene.inventory_system.exceptions.InvalidInputException;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepository productRepository;

    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper mapper){
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    public ProductDTO createProduct(ProductDTO model) {
        if(model.getPrice() < 0 || model.getQuantity() < 0 || model.getQuantitySold() < 0){
            throw new InvalidInputException("Input not valid");
        }

        Product entity = mapper.modelToEntity(model);
        Product newEntity = productRepository.save(entity);
        LOG.debug("createProduct: product with id {} saved",newEntity.getProductId());
        return mapper.entityToModel(newEntity);
    }

    @Override
    public void deleteProduct(int barCode) {
//        productRepository.findById(barCode).ifPresent(p -> productRepository.delete(p));
        productRepository.findProductByBarCode(barCode).ifPresent(p -> productRepository.delete(p));
        LOG.debug("deleteProduct: product with bar code {} deleted",barCode);
    }
    public List<ProductDTO> getAllProduct() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> models = mapper.entityListToModelList(products);
        return models;
    }
}
