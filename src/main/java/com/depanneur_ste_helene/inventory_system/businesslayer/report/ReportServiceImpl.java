package com.depanneur_ste_helene.inventory_system.businesslayer.report;

import com.depanneur_ste_helene.inventory_system.datalayer.product.Product;
import com.depanneur_ste_helene.inventory_system.datalayer.product.ProductRepository;
import com.depanneur_ste_helene.inventory_system.datalayer.report.ValueReport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService{

    private final ProductRepository productRepository;

    public ReportServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ValueReport getInventoryValue(){

        double inventoryValue = 0;
        List<Product> productList = productRepository.findAll();

        for(int i = 0; i < productList.size(); i++){
            if(productList.get(i).getPrice() > 0){
                inventoryValue += productList.get(i).getPrice() * productList.get(i).getQuantity();
            }
        }

        ValueReport valueReport = new ValueReport(java.time.LocalDate.now(),
                Math.round(inventoryValue * 100.0) / 100.0);

        return valueReport;
    }
}
