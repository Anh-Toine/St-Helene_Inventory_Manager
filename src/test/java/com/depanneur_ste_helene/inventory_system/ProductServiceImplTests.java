package com.depanneur_ste_helene.inventory_system;

import com.depanneur_ste_helene.inventory_system.businesslayer.ProductService;
import com.depanneur_ste_helene.inventory_system.datalayer.Product;
import com.depanneur_ste_helene.inventory_system.datalayer.ProductRepository;
import com.depanneur_ste_helene.inventory_system.exceptions.InvalidInputException;
import jdk.jfr.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

    @DisplayName("Create product valid")
    @Test
    public void test_CreateProduct_valid(){
        // Arrange
        Product model = new Product(1, "product1", "brand1", PRICE_VALID, QUANTITY_VALID,QUANTITY_SOLD_VALID,1);
        Product entity = new Product(1, "product1", "brand1", PRICE_VALID, QUANTITY_VALID,QUANTITY_SOLD_VALID,1);
        when(productRepository.save(any(Product.class))).thenReturn(entity);

        // Act
        Product returnedProduct = productService.createProduct(model);

        // Assert
        assertThat(returnedProduct.getProductId()).isEqualTo(entity.getProductId());
    }

    @DisplayName("Create product invalid")
    @Test
    public void test_CreateProduct_not_valid(){
        // Arrange
        Product model = new Product(1, "product1", "brand1", PRICE_INVALID, QUANTITY_INVALID,QUANTITY_SOLD_INVALID,1);
        when(productRepository.save(any(Product.class))).thenThrow(InvalidInputException.class);

        // Assert
        assertThrows(InvalidInputException.class, ()->{
            productService.createProduct(model);
        });
    }

    @DisplayName("Delete product valid")
    @Test
    public void test_DeleteProduct_valid(){
        // Arrange

        Product entity = new Product(1, "product1", "brand1", PRICE_VALID, QUANTITY_VALID,
                QUANTITY_SOLD_VALID,1);
        // Act
        productRepository.deleteProduct(entity.getBar_code());

        // Assert
        verify(productRepository, never()).delete(entity);
    }


}
