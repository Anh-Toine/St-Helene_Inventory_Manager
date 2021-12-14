package com.depanneur_ste_helene.inventory_system.presentationlayer;

import com.depanneur_ste_helene.inventory_system.businesslayer.ProductService;
import com.depanneur_ste_helene.inventory_system.datalayer.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
public class ProductRESTController {
    @Autowired
    private final ProductService SERVICE;

    ProductRESTController(ProductService service){
        this.SERVICE = service;
    }

    @CrossOrigin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE,
                path = "/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product){
        return SERVICE.createProduct(product);
    }

    @CrossOrigin
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/product/{barcode}")
    public Product update(@RequestBody Product product, @PathVariable("barcode") int barcode){
        product.setBar_code(barcode);
        log.info("Updating product {}", product);
        return SERVICE.updateProduct(product);
    }
}
