package com.depanneur_ste_helene.inventory_system;

import com.depanneur_ste_helene.inventory_system.businesslayer.report.ReportService;
import com.depanneur_ste_helene.inventory_system.datalayer.product.Product;
import com.depanneur_ste_helene.inventory_system.datalayer.product.ProductRepository;
import com.depanneur_ste_helene.inventory_system.datalayer.report.BestSellingReport;
import com.depanneur_ste_helene.inventory_system.datalayer.report.ValueReport;
import com.depanneur_ste_helene.inventory_system.datalayer.report.WorstSellingReport;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

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

        assertEquals(java.time.LocalDate.now(), valueReport.getDate());
        assertEquals(10000, valueReport.getValue());
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

        assertEquals(java.time.LocalDate.now(), valueReport.getDate());
        assertNotEquals(total, valueReport.getValue());
    }

    @DisplayName("Get Value Report No Product")
    @Test
    public void test_GetValueReport_NoProduct(){

        List<Product> products = new ArrayList<>();

        when(productRepository.findAll())
                .thenReturn(products);

        ValueReport valueReport = reportService.getInventoryValue();

        assertEquals(java.time.LocalDate.now(), valueReport.getDate());
        assertEquals(0, valueReport.getValue());
    }

    @DisplayName("Get best selling less than 50 product")
    @Test
    public void test_GetBestSelling_less_than50Product_valid(){

        List<Product> entityProducts = new ArrayList<>();

        entityProducts.add(new Product(1,"1", "product1", "brand1", 10, 100,150,"1"));
        entityProducts.add(new Product(2,"2", "product2", "brand2", 15, 200,100,"1"));
        entityProducts.add(new Product(3,"3", "product3", "brand3", 20, 300, 200,"1"));

        when(productRepository.findAll())
                .thenReturn(entityProducts);

        BestSellingReport bestSellingReport = reportService.getBestSelling();

        assertEquals(java.time.LocalDate.now(), bestSellingReport.getDate());
        assertEquals("3", bestSellingReport.getProductDTOS().get(0).getBarCode());
        assertEquals("2", bestSellingReport.getProductDTOS().get(2).getBarCode());
    }

    @DisplayName("Get best selling less than 50 product not valid")
    @Test
    public void test_GetBestSelling_less_than50Product_not_valid(){

        List<Product> entityProducts = new ArrayList<>();

        entityProducts.add(new Product(1,"1", "product1", "brand1", 10, 100,150,"1"));
        entityProducts.add(new Product(2,"2", "product2", "brand2", 15, 200,100,"1"));
        entityProducts.add(new Product(3,"3", "product3", "brand3", 20, 300, 200,"1"));

        when(productRepository.findAll())
                .thenReturn(entityProducts);

        BestSellingReport bestSellingReport = reportService.getBestSelling();

        assertEquals(java.time.LocalDate.now(), bestSellingReport.getDate());
        assertNotEquals("1", bestSellingReport.getProductDTOS().get(0).getBarCode());
        assertNotEquals("3", bestSellingReport.getProductDTOS().get(2).getBarCode());
    }

    @DisplayName("Get best selling 50 product valid")
    @Test
    public void test_GetBestSelling_50Product_valid(){

        List<Product> entityProducts = new ArrayList<>();

        for(int i = 0; i < 50; i++){
            entityProducts.add(
                    new Product(
                            i,
                            "code" + i,
                            "product" + i,
                            "brand" + i,
                            i,
                            i * 2,
                            i * 2,
                            "category" + i));
        }

        when(productRepository.findAll())
                .thenReturn(entityProducts);

        BestSellingReport bestSellingReport = reportService.getBestSelling();

        assertEquals(java.time.LocalDate.now(), bestSellingReport.getDate());
        assertEquals("code49", bestSellingReport.getProductDTOS().get(0).getBarCode());
        assertEquals("code0", bestSellingReport.getProductDTOS().get(49).getBarCode());
    }

    @DisplayName("Get best selling 50 product not valid")
    @Test
    public void test_GetBestSelling_50Product_not_valid(){

        List<Product> entityProducts = new ArrayList<>();

        for(int i = 0; i < 50; i++){
            entityProducts.add(
                    new Product(
                            i,
                            "code" + i,
                            "product" + i,
                            "brand" + i,
                            i,
                            i * 2,
                            i * 2,
                            "category" + i));
        }

        when(productRepository.findAll())
                .thenReturn(entityProducts);

        BestSellingReport bestSellingReport = reportService.getBestSelling();

        assertEquals(java.time.LocalDate.now(), bestSellingReport.getDate());
        assertNotEquals("code0", bestSellingReport.getProductDTOS().get(0).getBarCode());
        assertNotEquals("code49", bestSellingReport.getProductDTOS().get(49).getBarCode());
    }

    @DisplayName("Get worst selling product valid")
    @Test
    public void test_GetWorstSelling_Product_valid(){

        List<Product> entityProducts = new ArrayList<>();

        entityProducts.add(new Product(1,"1", "product1", "brand1", 10, 100,150,"1"));
        entityProducts.add(new Product(2,"2", "product2", "brand2", 15, 200,0,"1"));
        entityProducts.add(new Product(3,"3", "product3", "brand3", 20, 300, 200,"1"));
        entityProducts.add(new Product(4,"4", "product4", "brand4", 20, 300, 0,"1"));
        entityProducts.add(new Product(5,"5", "product5", "brand5", 20, 300, 100,"1"));

        when(productRepository.findAll())
                .thenReturn(entityProducts);

        WorstSellingReport worstSellingReport = reportService.getWorstSelling();

        assertEquals(java.time.LocalDate.now(), worstSellingReport.getDate());
        assertEquals(2, worstSellingReport.getProductDTOS().size());
    }

    @DisplayName("Get worst selling product not valid")
    @Test
    public void test_GetWorstSelling_Product_not_valid(){

        List<Product> entityProducts = new ArrayList<>();

        entityProducts.add(new Product(1,"1", "product1", "brand1", 10, 100,150,"1"));
        entityProducts.add(new Product(2,"2", "product2", "brand2", 15, 200,0,"1"));
        entityProducts.add(new Product(3,"3", "product3", "brand3", 20, 300, 200,"1"));
        entityProducts.add(new Product(4,"4", "product4", "brand4", 20, 300, 0,"1"));
        entityProducts.add(new Product(5,"5", "product5", "brand5", 20, 300, 100,"1"));

        when(productRepository.findAll())
                .thenReturn(entityProducts);

        WorstSellingReport worstSellingReport = reportService.getWorstSelling();

        assertEquals(java.time.LocalDate.now(), worstSellingReport.getDate());
        assertNotEquals(3, worstSellingReport.getProductDTOS().size());
    }

    @DisplayName("Reset quantity sold")
    @Test
    public void test_resetQuantitySold(){
        List<Product> entityProducts = new ArrayList<>();

        entityProducts.add(new Product(1,"1", "product1", "brand1", 10, 100,150,"1"));
        entityProducts.add(new Product(2,"2", "product2", "brand2", 15, 200,100,"1"));
        entityProducts.add(new Product(3,"3", "product3", "brand3", 20, 300, 200,"1"));

        when(productRepository.findAll())
                .thenReturn(entityProducts);

        reportService.endOfMonthQtySoldReset();

        assertEquals(0,entityProducts.get(0).getQuantitySold());
        assertEquals(0,entityProducts.get(1).getQuantitySold());
        assertEquals(0,entityProducts.get(2).getQuantitySold());
    }
}
