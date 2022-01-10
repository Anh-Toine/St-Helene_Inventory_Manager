package com.depanneur_ste_helene.inventory_system.businesslayer;

import com.depanneur_ste_helene.inventory_system.datalayer.Supplier;
import com.depanneur_ste_helene.inventory_system.datalayer.SupplierDTO;
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
