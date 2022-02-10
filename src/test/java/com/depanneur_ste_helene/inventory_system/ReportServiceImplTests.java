package com.depanneur_ste_helene.inventory_system;

import com.depanneur_ste_helene.inventory_system.businesslayer.report.ReportService;
import com.depanneur_ste_helene.inventory_system.datalayer.product.Product;
import com.depanneur_ste_helene.inventory_system.datalayer.product.ProductRepository;
import com.depanneur_ste_helene.inventory_system.datalayer.report.ValueReport;
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
public class ReportServiceImplTests {

    @Autowired
    ReportService reportService;

    @MockBean
    ProductRepository productRepository;

    @DisplayName("Get Value Report Valid")
    @Test
    public void test_GetValueReport_valid(){

        List<Product> products = new ArrayList<>();

        products.add(new Product(1,"1", "product1", "brand1", 10, 100,0,"1"));
        products.add(new Product(2,"2", "product2", "brand2", 15, 200,0,"1"));
        products.add(new Product(3,"3", "product3", "brand3", 20, 300,0,"1"));

        when(productRepository.findAll())
                .thenReturn(products);

        ValueReport valueReport = reportService.getInventoryValue();

        assertEquals(valueReport.getDate(), java.time.LocalDate.now());
        assertEquals(valueReport.getValue(),10000);
    }

    @DisplayName("Get Value Report Not Valid")
    @Test
    public void test_GetValueReport_not_valid(){

        List<Product> entityProducts = new ArrayList<>();

        entityProducts.add(new Product(1,"1", "product1", "brand1", 10, 100,0,"1"));
        entityProducts.add(new Product(2,"2", "product2", "brand2", 15, 200,0,"1"));
        entityProducts.add(new Product(3,"3", "product3", "brand3", 20, 300,0,"1"));

        List<Product> testProducts = new ArrayList<>();

        testProducts.add(new Product(1,"1", "product1", "brand1", 10, 100,0,"1"));
        testProducts.add(new Product(2,"2", "product2", "brand2", 15, 200,0,"1"));
        testProducts.add(new Product(3,"3", "product3", "brand3", 20, 100,0,"1"));

        double product1 = testProducts.get(0).getPrice() * testProducts.get(0).getQuantity();
        double product2 = testProducts.get(1).getPrice() * testProducts.get(1).getQuantity();
        double product3 = testProducts.get(2).getPrice() * testProducts.get(2).getQuantity();

        double total = product1 + product2 + product3;

        when(productRepository.findAll())
                .thenReturn(entityProducts);

        ValueReport valueReport = reportService.getInventoryValue();

        assertEquals(valueReport.getDate(), java.time.LocalDate.now());
        assertNotEquals(valueReport.getValue(),total);
    }
}
