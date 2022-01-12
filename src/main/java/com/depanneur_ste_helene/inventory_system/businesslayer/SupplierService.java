package com.depanneur_ste_helene.inventory_system.businesslayer;

import com.depanneur_ste_helene.inventory_system.datalayer.SupplierDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SupplierService {

    List<SupplierDTO> getAllSuppliers();

}
