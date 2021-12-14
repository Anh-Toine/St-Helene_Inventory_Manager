package com.depanneur_ste_helene.inventory_system.businesslayer;

import com.depanneur_ste_helene.inventory_system.datalayer.Product;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    Product createProduct(@RequestBody Product model);
//    List<Product> findProductByBarCode(int barCode);
    void deleteProduct(int barCode);
}
