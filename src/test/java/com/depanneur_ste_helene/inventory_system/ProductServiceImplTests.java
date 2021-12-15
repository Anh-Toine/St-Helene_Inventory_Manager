package com.depanneur_ste_helene.inventory_system;

import com.depanneur_ste_helene.inventory_system.businesslayer.ProductService;
import com.depanneur_ste_helene.inventory_system.datalayer.Product;
import com.depanneur_ste_helene.inventory_system.datalayer.ProductRepository;
import com.depanneur_ste_helene.inventory_system.exceptions.InvalidInputException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
import java.util.Optional;
>>>>>>> c2686c4... This is my update branch

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

    Product productEntity = new Product(
            1,
            "Doritos",
            "Chips",
            1,
            2,
            0,
            1);

    @Test
    public void test_CreateProduct_valid(){
        Product model = new Product(1, "product1", "brand1", PRICE_VALID, QUANTITY_VALID,QUANTITY_SOLD_VALID,1);
        Product entity = new Product(1, "product1", "brand1", PRICE_VALID, QUANTITY_VALID,QUANTITY_SOLD_VALID,1);
        when(productRepository.save(any(Product.class))).thenReturn(entity);

        Product returnedProduct = productService.createProduct(model);

        assertThat(returnedProduct.getProductId()).isEqualTo(entity.getProductId());
    }
    @Test
    public void test_CreateProduct_not_valid(){
        Product model = new Product(1, "product1", "brand1", PRICE_INVALID, QUANTITY_INVALID,QUANTITY_SOLD_INVALID,1);
        when(productRepository.save(any(Product.class))).thenThrow(InvalidInputException.class);

        assertThrows(InvalidInputException.class, ()->{
            productService.createProduct(model);
        });
    }
    @Test
<<<<<<< HEAD
    public void test_GetAllProduct(){

        List<Product> products = productService.getAllProduct();

        when(productRepository.findAll())
                .thenReturn(products);

        assertEquals(productRepository.count(), products.size());
=======
    public void whenValidBarcodeUpdateVisit(){
        when(productRepository.findByBar_code(any())).thenReturn(Optional.ofNullable(productEntity));
        when(productRepository.save(any(Product.class))).thenReturn(productEntity);

        Product productFromService = productService.updateProduct(productEntity);

        assertEquals(productFromService.getBar_code(), productEntity.getBar_code());
        assertEquals(productFromService.getProduct_name(), productEntity.getProduct_name());
        assertEquals(productFromService.getBrand(), productEntity.getBrand());
        assertEquals(productFromService.getPrice(), productEntity.getPrice());
        assertEquals(productFromService.getQuantity(), productEntity.getQuantity());
<<<<<<< HEAD
        assertEquals(productFromService.getQuantity_sold(), productFromService.getQuantity_sold());
>>>>>>> c2686c4... This is my update branch
=======
        assertEquals(productFromService.getQuantity_sold(), productEntity.getQuantity_sold());
>>>>>>> d59a0e9... Fixed lombok and test
    }
}
