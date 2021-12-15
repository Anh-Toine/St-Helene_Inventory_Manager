package com.depanneur_ste_helene.inventory_system;

import com.depanneur_ste_helene.inventory_system.businesslayer.ProductService;
import com.depanneur_ste_helene.inventory_system.datalayer.Product;
import com.depanneur_ste_helene.inventory_system.datalayer.ProductDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.ProductRepository;
import com.depanneur_ste_helene.inventory_system.exceptions.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProductServiceImplTests {

    @MockBean
    ProductRepository productRepository;

    @Autowired
    ProductService productService;



    private final int PRICE_VALID = 1;
    private final int PRICE_INVALID = -1;

    private final int QUANTITY_VALID = 1;
    private final int QUANTITY_INVALID = -1;

    private final int QUANTITY_SOLD_VALID = 1;
    private final int QUANTITY_SOLD_INVALID = -1;

    @Test
    public void test_CreateProduct_valid(){
        ProductDTO model = new ProductDTO(1, "product1", "brand1", PRICE_VALID, QUANTITY_VALID,QUANTITY_SOLD_VALID,1);
        Product entity = new Product(1,1, "product1", "brand1", PRICE_VALID, QUANTITY_VALID,QUANTITY_SOLD_VALID,1);
        when(productRepository.save(any(Product.class))).thenReturn(entity);

        ProductDTO returnedProduct = productService.createProduct(model);

        assertThat(returnedProduct.getBarCode()).isEqualTo(entity.getBarCode());
    }
    @Test
    public void test_CreateProduct_not_valid(){
        ProductDTO model = new ProductDTO(1, "product1", "brand1", PRICE_INVALID, QUANTITY_INVALID,QUANTITY_SOLD_INVALID,1);
        when(productRepository.save(any(Product.class))).thenThrow(InvalidInputException.class);

        assertThrows(InvalidInputException.class, ()->{
            productService.createProduct(model);
        });
    }

    @DisplayName("Delete product valid")
    @Test
    public void test_DeleteProduct_valid(){
        // Arrange

        Product entity = new Product(1,1, "product1", "brand1", PRICE_VALID, QUANTITY_VALID,
                QUANTITY_SOLD_VALID,1);
        // Act
        productService.deleteProduct(entity.getBarCode());

        // Assert
        verify(productRepository, never()).delete(entity);
    }
    @Test
    public void test_GetAllProduct(){

        List<Product> products = new ArrayList<>();

        products.add(new Product(1,1, "product1", "brand1", PRICE_VALID, QUANTITY_VALID,QUANTITY_SOLD_VALID,1));
        products.add(new Product(2,2, "product2", "brand2", PRICE_VALID, QUANTITY_VALID,QUANTITY_SOLD_VALID,1));
        products.add(new Product(3,3, "product3", "brand3", PRICE_VALID, QUANTITY_VALID,QUANTITY_SOLD_VALID,1));

        when(productRepository.findAll())
                .thenReturn(products);

        List<ProductDTO> productModels = productService.getAllProduct();

        assertEquals(productModels.size(), 3);
    }
}
