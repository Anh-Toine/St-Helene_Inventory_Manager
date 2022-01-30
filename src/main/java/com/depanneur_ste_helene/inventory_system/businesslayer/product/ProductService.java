package com.depanneur_ste_helene.inventory_system.businesslayer.product;

import com.depanneur_ste_helene.inventory_system.datalayer.product.ProductDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProduct();

    ProductDTO createProduct(@RequestBody ProductDTO model);

    ProductDTO updateProduct(ProductDTO model);

    void deleteProduct(String barCode);
}
