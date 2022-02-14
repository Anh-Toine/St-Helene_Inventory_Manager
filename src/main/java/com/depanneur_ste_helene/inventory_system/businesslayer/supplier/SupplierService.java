package com.depanneur_ste_helene.inventory_system.businesslayer.supplier;

import com.depanneur_ste_helene.inventory_system.datalayer.supplier.SupplierCreateDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.supplier.SupplierDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SupplierService {

    List<SupplierDTO> getAllSuppliers();

    SupplierDTO createSupplier(@RequestBody SupplierCreateDTO model);

    SupplierDTO updateSupplier(SupplierDTO model);

    void deleteSupplier(String supplierName);
}
