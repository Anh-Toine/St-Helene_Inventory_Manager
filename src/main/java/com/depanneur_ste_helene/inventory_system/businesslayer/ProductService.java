package com.depanneur_ste_helene.inventory_system.businesslayer;

import com.depanneur_ste_helene.inventory_system.datalayer.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    Product createProduct(@RequestBody Product model);

    Product updateProduct(Product product);

}
