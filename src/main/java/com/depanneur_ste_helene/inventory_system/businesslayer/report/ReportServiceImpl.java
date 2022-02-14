package com.depanneur_ste_helene.inventory_system.businesslayer.report;

import com.depanneur_ste_helene.inventory_system.businesslayer.product.ProductMapper;
import com.depanneur_ste_helene.inventory_system.datalayer.product.Product;
import com.depanneur_ste_helene.inventory_system.datalayer.product.ProductDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.product.ProductRepository;
import com.depanneur_ste_helene.inventory_system.datalayer.report.BestSellingReport;
import com.depanneur_ste_helene.inventory_system.datalayer.report.ValueReport;
import com.depanneur_ste_helene.inventory_system.datalayer.report.WorstSellingReport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ReportServiceImpl(ProductRepository productRepository, ProductMapper productMapper){
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ValueReport getInventoryValue(){

        double inventoryValue = 0;
        List<Product> productList = productRepository.findAll();

        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i).getPrice() > 0){
                inventoryValue += productList.get(i).getPrice() * productList.get(i).getQuantity();
            }
        }

        ValueReport valueReport = new ValueReport(
                java.time.LocalDate.now(),
                Math.round(inventoryValue * 100.0) / 100.0);

        return valueReport;
    }

    public BestSellingReport getBestSelling(){

        List<Product> productList = productRepository.findAll();
        productList.sort(Comparator.comparing(Product::getQuantitySold).reversed());

        List<ProductDTO> bestSellingProduct = new ArrayList<>();

        if(productList.size() >= 50){
            for(int i = 0; i < 50; i++){
                bestSellingProduct.add(productMapper.entityToModel(productList.get(i)));
            }
        }
        else{
            bestSellingProduct.addAll(productMapper.entityListToModelList(productList));
        }

        BestSellingReport bestSellingReport = new BestSellingReport(
                java.time.LocalDate.now(),
                bestSellingProduct
        );

        return bestSellingReport;
    }

    public WorstSellingReport getWorstSelling() {

        List<Product> productList = productRepository.findAll();
        List<ProductDTO> worstSellingProduct = new ArrayList<>();

        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i).getQuantity() != 0 &&
                    productList.get(i).getQuantitySold() == 0){
                worstSellingProduct.add(productMapper.entityToModel(productList.get(i)));
            }
        }

        WorstSellingReport worstSellingReport = new WorstSellingReport(
                java.time.LocalDate.now(),
                worstSellingProduct
        );

        return worstSellingReport;
    }
}
