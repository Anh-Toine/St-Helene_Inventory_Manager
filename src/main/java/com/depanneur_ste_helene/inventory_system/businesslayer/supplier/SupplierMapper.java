package com.depanneur_ste_helene.inventory_system.businesslayer.supplier;

import com.depanneur_ste_helene.inventory_system.datalayer.supplier.Supplier;
import com.depanneur_ste_helene.inventory_system.datalayer.supplier.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    SupplierDTO entityToModel(Supplier entity);
    List<SupplierDTO> entityListToModelList(List<Supplier> entities);

    @Mapping(target = "supplierId", ignore = true)
    Supplier modelToEntity(SupplierDTO model);
}
