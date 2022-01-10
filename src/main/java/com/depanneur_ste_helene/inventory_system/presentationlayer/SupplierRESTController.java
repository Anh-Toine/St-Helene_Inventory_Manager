package com.depanneur_ste_helene.inventory_system.presentationlayer;

import com.depanneur_ste_helene.inventory_system.businesslayer.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/products/{productId}/suppliers")
@RestController
public class SupplierRESTController {
    @Autowired
    private final SupplierService SERVICE;

    public SupplierRESTController(SupplierService SERVICE) {
        this.SERVICE = SERVICE;
    }

    @CrossOrigin
    @GetMapping("/suppliers")
}
