package com.depanneur_ste_helene.inventory_system.datalayer.report;

import com.depanneur_ste_helene.inventory_system.datalayer.product.ProductDTO;

import java.time.LocalDate;
import java.util.List;

public class WorstSellingReport {
    LocalDate date;
    List<ProductDTO> productDTOS;

    public WorstSellingReport(LocalDate date, List<ProductDTO> productDTOS) {
        this.date = date;
        this.productDTOS = productDTOS;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<ProductDTO> getProductDTOS() {
        return productDTOS;
    }

    public void setProductDTOS(List<ProductDTO> productDTOS) {
        this.productDTOS = productDTOS;
    }
}
