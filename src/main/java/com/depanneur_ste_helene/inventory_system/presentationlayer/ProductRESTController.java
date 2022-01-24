package com.depanneur_ste_helene.inventory_system.presentationlayer;

import com.depanneur_ste_helene.inventory_system.businesslayer.product.ProductService;
import com.depanneur_ste_helene.inventory_system.datalayer.product.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRESTController {
    @Autowired
    private final ProductService SERVICE;

    ProductRESTController(ProductService service){
        this.SERVICE = service;
    }

    @CrossOrigin
    @GetMapping("/products")
    public List<ProductDTO> getAllProduct(){
        return SERVICE.getAllProduct();
    }

    @CrossOrigin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE,
                path = "/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO createProduct(@RequestBody ProductDTO product){
        return SERVICE.createProduct(product);
    }

    @CrossOrigin
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE,
                path = "/products/{barCode}")
    public ProductDTO update(@RequestBody ProductDTO productDTO, @PathVariable("barCode") String barCode){
        productDTO.setBarCode(barCode);
        return SERVICE.updateProduct(productDTO);
    }

    @CrossOrigin
    @DeleteMapping(path = "/products/{barCode}")
    public void deleteProduct(@PathVariable("barCode") String barCode){
        SERVICE.deleteProduct(barCode);
    }
}
