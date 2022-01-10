package com.depanneur_ste_helene.inventory_system.businesslayer;

import com.depanneur_ste_helene.inventory_system.datalayer.Supplier;
import com.depanneur_ste_helene.inventory_system.datalayer.SupplierDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.SupplierRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService{
    private SupplierRespository supplierRespository;
    private SupplierMapper supplierMapper;

    @Override
    public List<SupplierDTO> getAllSuppliers() {
       List<Supplier> suppliers = supplierRespository.findAll();
       List<SupplierDTO> models = supplierMapper.entityListToModelList(suppliers);
       return models;
    }
}
