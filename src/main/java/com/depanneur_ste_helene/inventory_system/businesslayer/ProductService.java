package com.depanneur_ste_helene.inventory_system.businesslayer;

import com.depanneur_ste_helene.inventory_system.datalayer.Product;
import com.depanneur_ste_helene.inventory_system.datalayer.ProductDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProduct();

    ProductDTO createProduct(@RequestBody ProductDTO model);

    ProductDTO updateProduct(ProductDTO model);
}
