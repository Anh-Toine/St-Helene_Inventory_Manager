package com.depanneur_ste_helene.inventory_system.businesslayer;

import com.depanneur_ste_helene.inventory_system.datalayer.Product;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductService {
    Product createProduct(@RequestBody Product model);
}
