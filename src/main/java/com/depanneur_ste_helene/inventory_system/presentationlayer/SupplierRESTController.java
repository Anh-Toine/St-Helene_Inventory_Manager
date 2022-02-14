package com.depanneur_ste_helene.inventory_system.presentationlayer;

import com.depanneur_ste_helene.inventory_system.businesslayer.supplier.SupplierService;
import com.depanneur_ste_helene.inventory_system.datalayer.supplier.SupplierCreateDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.supplier.SupplierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierRESTController {
    @Autowired
    private final SupplierService SERVICE;

    public SupplierRESTController(SupplierService SERVICE) {
        this.SERVICE = SERVICE;
    }

    @CrossOrigin
    @GetMapping("/suppliers")
    public List<SupplierDTO> getAllSuppliers(){
        return SERVICE.getAllSuppliers();
    }

    @CrossOrigin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE,
                path = "/suppliers")
    public SupplierDTO createSupplier(@RequestBody SupplierCreateDTO supplier){
        return SERVICE.createSupplier(supplier);
    }

    @CrossOrigin
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/suppliers/{supplierId}")
    public SupplierDTO updateSupplier(@RequestBody SupplierDTO supplierDTO, @PathVariable(
            "supplierId") String supplierId){
        supplierDTO.setSupplierId(supplierId);
        return SERVICE.updateSupplier(supplierDTO);
    }

    @CrossOrigin
    @DeleteMapping("/suppliers/{supplierId}")
    public void deleteSupplier(@PathVariable("supplierId") String supplierId){
        SERVICE.deleteSupplier(supplierId);
    }
}
